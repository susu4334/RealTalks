package com.reeltalks.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reeltalks.dto.ReplyDTO;
import com.reeltalks.dto.ReplyWithNameDTO;
import com.reeltalks.service.PostService;
import com.reeltalks.service.ReplyService;

@RestController
public class ReplyController {
	@Autowired
	ReplyService service;
	@Autowired
	PostService service_post;
	
	// 댓글 카운트 조회 (비동기처리 - 미)
	@GetMapping("/movie/reply_count_test/{post_id}")
	public int reply_count(@PathVariable("post_id") String post_id) {
		
		int reply_count = service.reply_count(Integer.parseInt(post_id));
		return reply_count;
	}
	
	
	// 하나만 댓글조회 (비동기처리)
	@GetMapping("/movie/{movie_id}/post/{post_id}/reply/{reply_id}")
	public ReplyDTO reply_check(@PathVariable("movie_id") String movie_id,@PathVariable("post_id") String post_id, @PathVariable("reply_id") String reply_id) {
		ReplyDTO dto = service.reply_select(Integer.parseInt(reply_id));
		return dto;
	}
	
	// 댓글조회(비동기처리)
	@GetMapping("/movie/{movie_id}/post/{post_id}/reply")
	public List<ReplyWithNameDTO> reply_check_list(@PathVariable("movie_id") String movie_id,@PathVariable("post_id") String post_id) {
		List<ReplyWithNameDTO> list = service.reply_select_list(Integer.parseInt(post_id));
		
		List<ReplyWithNameDTO> list_depth1 = new ArrayList<>();
		List<ReplyWithNameDTO> list_depth2 = new ArrayList<>(); // <== 역순으로 세우자 느린날짜가 제일 앞에오게 최신글이 끝으로

		for (int i = 0; i < list.size(); i++) {
			// depth1과 depth2로 나누기
			if(list.get(i).getDepth() == 1) {
				list_depth1.add(list.get(i));
			} else if (list.get(i).getDepth() == 2) {
				list_depth2.add(list.get(i));
			}
		}
		Collections.reverse(list_depth2);	// list 순서 뒤집기, 제일앞에온것은 제일 업데이트 날짜 느린값
		
		// depth2에서 하나씩 꺼내와서 메인에다가 넣기
		for (int i = 0; i < list_depth2.size(); i++) {			
			int p_id = list_depth2.get(i).getParent_reply_id();
			
			for (int j = 0; j < list_depth1.size(); j++) {
				int id = list_depth1.get(j).getReply_id();
				if (id == p_id) {
					// depth2의 parent_reply_id 와 depth1의 reply_id가 일치한다면
					list_depth1.add(j+1, list_depth2.get(i)); // j번째위치에 add하기
					break;	// 넣었으니 탈출
				}
			}
		}
		
		return list_depth1;
	}
	
	//등록(비동기처리)
	@PostMapping("/movie/{movie_id}/post/{post_id}/reply")
	public void reply_insert(
			@PathVariable("movie_id") String movie_id,
			@PathVariable("post_id") String post_id,
			String user_id, String reply_content, String parent_reply_id) {
		
		ReplyDTO dto = new ReplyDTO();
		dto.setMovie_id(movie_id.toUpperCase());
		dto.setPost_id(Integer.parseInt(post_id));
		dto.setUser_id(user_id);
		dto.setReply_contents(reply_content);
		dto.setCreate_at(LocalDateTime.now());
		dto.setUpdate_at(LocalDateTime.now());
		
		if (parent_reply_id == "" || parent_reply_id == null) {
			// 대댓글일때
			dto.setDepth(1);
		} else {
			// 댓글일때
			dto.setParent_reply_id(Integer.parseInt(parent_reply_id));
			dto.setDepth(2);
			
		}
		int result = service.reply_insert(dto);
		
		if (result == 1) {
			// 등록할때 포스트 db의 댓글 수 증가
			service_post.count_add(Integer.parseInt(post_id));
		}
		
	}
	
	// 수정(비동기처리)
	@PutMapping("/movie/{movie_id}/post/{post_id}/reply/{reply_id}")
	public void reply_update(
			@PathVariable("movie_id") String movie_id,
			@PathVariable("post_id") String post_id,
			@PathVariable("reply_id") String reply_id,
			String user_id, String reply_content) {
		
		if (reply_id != null) {
			//reply_id 가 들어왔을때
			ReplyDTO dto = service.reply_select(Integer.parseInt(reply_id));
			dto.setReply_contents(reply_content);
			dto.setUpdate_at(LocalDateTime.now());
			
			service.reply_update(dto);
		}
	}
	
	//삭제(비동기처리)
	@RequestMapping("/movie/{movie_id}/post/{post_id}/reply/{reply_id}")
	public String reply_delete(
			@PathVariable("movie_id") String movie_id,
			@PathVariable("post_id") String post_id,
			@PathVariable("reply_id") String reply_id) {
		
		int result = 0;
		
		if (reply_id != null) {
			//reply_id가 들어왔을때
			
			ReplyDTO dto = service.reply_select(Integer.parseInt(reply_id));
			if (dto.getDepth() == 1) {
				// 해당 id의 대댓글을 전부 셀렉트
				List<ReplyDTO> list = service.select_reReply(Integer.parseInt(reply_id));
				if (list.size() == 0) {
					//대댓글이 없을때 삭제해도됨
					result = service.reply_delete(reply_id);
					if (result == 1) {
						// 삭제할때 포스트 db의 댓글 수 감소
						service_post.count_delete(Integer.parseInt(post_id));
					}
					return "true";
				} else {
					//대댓글이 있을때 삭제하면안됨
					return "false";
				}
				// 아니면 한번에 if문 sql문에 쓰기
			} else if (dto.getDepth() == 2) {
				// 대댓글일때는 묻고따지지도 않고 그냥 삭제
				result = service.reply_delete(reply_id);
				if (result == 1) {
					// 삭제할때 포스트 db의 댓글 수 감소
					service_post.count_delete(Integer.parseInt(post_id));
				}
				return "true";
			}
			
		}
		return "false";
		
	}
	
}
