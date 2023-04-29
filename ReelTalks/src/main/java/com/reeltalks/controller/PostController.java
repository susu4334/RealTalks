package com.reeltalks.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reeltalks.dto.PostJoin;
import com.reeltalks.dto.Tb_Post;
import com.reeltalks.service.MovieService;
import com.reeltalks.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	PostService service;
	@Autowired
	MovieService service_movie;
	//게시물 리스트 조회
	@GetMapping("/movie/{movie_id}/post")
	public List<PostJoin> selectList(@PathVariable("movie_id") String movie_id) {
		
		List<Tb_Post> list = service.selectList(movie_id);
		
		List<PostJoin> listPostResult = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			
			Tb_Post p = list.get(i);
			
			String movie_title=service.movieTitle(movie_id);//movie_title 가져오기
			String user_id=p.getUser_id(); 
			String user_name=service.userName(user_id);//user_name 가져오기 
			
			PostJoin post = new PostJoin(p.getPost_id(),p.getMovie_id(),p.getUser_id(),
					p.getPost_title(),p.getContent(),p.getStar_rate(),p.getView_count(),
					p.getComment_count(),p.getCreate_at(),p.getUpdate_at(),movie_title,
					user_name);
			
			listPostResult.add(post);
		}
		
		return listPostResult;
	}
	  
	//게시물 상세조회 
	 @GetMapping("/movie/{movie_id}/post/{post_id}")
	 public PostJoin selectOne(@PathVariable("movie_id") String movie_id,
			 @PathVariable("post_id") int post_id) {
		service.updateView(post_id);//조회수 증가
		
		String movie_title=service.movieTitle(movie_id);//movie_title 가져오기
		
		Tb_Post p=service.selectOne(post_id);//Tb_post 가져오기
				
		String user_id=p.getUser_id(); //user_id 가져오기
		String user_name=service.userName(user_id);//user_name 가져오기 
	
		PostJoin post=new PostJoin(p.getPost_id(),p.getMovie_id(),p.getUser_id(),
				p.getPost_title(),p.getContent(),p.getStar_rate(),p.getView_count(),
				p.getComment_count(),p.getCreate_at(),p.getUpdate_at(),movie_title,
				user_name);

		return post;
	
	}
	 
	//게시물 등록
	@PostMapping("/movie/{movieid}/post")
	public String addPost(
			@PathVariable("movieid")String movie_id,Tb_Post post) {
		
		if(post.getPost_title().isEmpty()|| post.getContent().isEmpty()) {
			throw new RuntimeException("제목과 내용을 모두 입력해주세요.");
			}  //프론트쪽에서 예외처리됨
		
		post.setMovie_id(movie_id);
		post.setCreate_at(LocalDateTime.now());
		post.setUpdate_at(LocalDateTime.now());
		
		int num=service.addPost(post);//게시물 등록
				
		service_movie.movie_star_rate_calculator(movie_id);
				
		return null;
	}
	
	
	//게시물 수정 
	@PutMapping("/movie/{movieid}/post/{postid}")
	public String updatePost(Tb_Post post) {
		
		if(post.getPost_title().isEmpty()|| post.getContent().isEmpty()) {
			throw new RuntimeException("제목과 내용을 모두 입력해주세요.");
			} //프론트쪽에서 예외처리됨

		post.setUpdate_at(LocalDateTime.now());//수정시간 업데이트
		
		int num=service.updatePost(post);
		
		service_movie.movie_star_rate_calculator(post.getMovie_id());
		
		return null;
		}
	
	
	//게시물 삭제 
	@DeleteMapping("/movie/{movieid}/post/{postid}")
	public String deletePost(@PathVariable("postid") int post_id) {
		
		Tb_Post p = service.selectOne(post_id);
		
		int num=service.deletePost(post_id);
		
		service_movie.movie_star_rate_calculator(p.getMovie_id());
		
		return null;
	}
    
}
