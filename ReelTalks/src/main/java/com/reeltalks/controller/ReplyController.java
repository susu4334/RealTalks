package com.reeltalks.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reeltalks.dto.ReplyDTO;
import com.reeltalks.service.ReplyService;

@RestController
public class ReplyController {
	@Autowired
	ReplyService service;
	
	// 하나만 댓글조회 (비동기처리)
	@GetMapping("/movie/{movie_id}/post/{post_id}/reply/{reply_id}")
	public ReplyDTO reply_check(@PathVariable("movie_id") String movie_id,@PathVariable("post_id") String post_id, @PathVariable("reply_id") String reply_id) {
		ReplyDTO dto = service.reply_select(Integer.parseInt(reply_id));
		return dto;
	}
	
	
	// 댓글조회(비동기처리)
	@GetMapping("/movie/{movie_id}/post/{post_id}/reply")
	public List<ReplyDTO> reply_check_list(@PathVariable("movie_id") String movie_id,@PathVariable("post_id") String post_id) {
		List<ReplyDTO> list = service.reply_select_list(Integer.parseInt(post_id));
		System.out.println(list);
		
		return list;
	}
	
	//등록(비동기처리)
	@PostMapping("/movie/{movie_id}/post/{post_id}/reply")
	public void reply_insert(
			@PathVariable("movie_id") String movie_id,
			@PathVariable("post_id") String post_id,
			String user_id, String content, String parent_reply_id) {
		
		ReplyDTO dto = new ReplyDTO();
		dto.setMovie_id(movie_id);
		dto.setPost_id(Integer.parseInt(post_id));
		dto.setUser_id(user_id);
		dto.setReply_contents(content);
		dto.setCreate_at(LocalDateTime.now());
		dto.setUpdate_at(LocalDateTime.now());
		
		if (parent_reply_id == "" || parent_reply_id == null) {
			// 대댓글일때
			System.out.println("대댓글 아이디가 들어오지 않았음");
			dto.setDepth(1);
		} else {
			System.out.println("대댓글 아이디가 들어왔음");
			dto.setParent_reply_id(Integer.parseInt(parent_reply_id));
			dto.setDepth(2);
			
			System.out.println(dto);
		}
		service.reply_insert(dto);
	}
	
	// 수정(비동기처리)
	@PutMapping("/movie/{movie_id}/post/{post_id}/reply/{reply_id}")
	public void reply_update(
			@PathVariable("movie_id") String movie_id,
			@PathVariable("post_id") String post_id,
			@PathVariable("reply_id") String reply_id,
			String user_id, String content) {
		
		if (reply_id != null) {
			System.out.println("reply_id 값이 들어옴!");
			ReplyDTO dto = service.reply_select(Integer.parseInt(reply_id));
			dto.setReply_contents(content);
			dto.setUpdate_at(LocalDateTime.now());
			System.out.println(dto);
			
			service.reply_update(dto);
		}
	}
	
	//삭제(비동기처리)
	@DeleteMapping("/movie/{movie_id}/post/{post_id}/reply/{reply_id}")
	public void reply_delete(
			@PathVariable("movie_id") String movie_id,
			@PathVariable("post_id") String post_id,
			@PathVariable("reply_id") String reply_id) {
		
		if (reply_id != null) {
			System.out.println("reply_id 값이 들어옴!");
			service.reply_delete(reply_id);
		}
	}
	
}
