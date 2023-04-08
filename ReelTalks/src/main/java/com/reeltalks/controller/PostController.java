package com.reeltalks.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reeltalks.dto.Tb_Post;
import com.reeltalks.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	PostService service;
	
	/*
	 * @GetMapping("/movie") // @ResponseBody public String main() { // String
	 * userName=service.userName("userid1"); return "main"; }
	 */
	 
	
	//게시물 상세조회 
	 @GetMapping("/movie/{movieid}/post")
	 @ResponseBody
	 public String selectOne(@PathVariable("movieid") String movie_id,
		int post_id,Model m) {
		 
		System.out.println("post_id"+post_id);
		
		String movie_title=service.movieTitle(movie_id);//movie_title 가져오기
		System.out.println(movie_title);
		
		Tb_Post post=service.selectOne(post_id);//Tb_post 가져오기
		System.out.println("게시물 상세조회"+post);
		
		String user_id=post.getUser_id(); 
		String user_name=service.userName(user_id);//user_name 가져오기 
		System.out.println(user_name);
		
		service.updateView(post_id);//조회수 증가 
		
		m.addAttribute("movie_title", movie_title);
		m.addAttribute("user_name", user_name);
		m.addAttribute("Tb_Post", post);
		return "/board/post/"+movie_id+"/"+post_id;
	}
	 
	
	 
	//게시물 등록
	@PostMapping("/movie/{movieid}/post")
//	@ResponseBody
	public String addPost(
			@PathVariable("movieid")String movie_id,Tb_Post post) {
		System.out.println(post);
		
		Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
		
		post.setMovie_id(movie_id);
		post.setCreate_at(timestamp.toLocalDateTime());
		post.setUpdate_at(timestamp.toLocalDateTime());
		
		int num=service.addPost(post);//게시물 등록
		System.out.println("addPost num : "+num);
		
		int addPost_id=service.addPostSelect(post.getUser_id());//등록된 게시물 번호 조회
		System.out.println("addPost_id : "+addPost_id);
		
		
		//return "post";
		return "redirect:../{movieid}/post?post_id="+addPost_id;
	}
	
	
	
	//게시물 수정 
	@PutMapping("/movie/{movieid}/post/{postid}")
 //   @ResponseBody
	public String updatePost(@PathVariable("postid")String post_id,Tb_Post post) {
		
		Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
		int post_id1=Integer.parseInt(post_id);

		post.setUpdate_at(timestamp.toLocalDateTime());
		
		int num=service.updatePost(post);
		System.out.println("update : "+num);
		return "redirect:../{movieid}/post?post_id="+post_id;
		}
	
	
	//게시물 삭제 
	@DeleteMapping("/movie/{movieid}/post/{postid}")
//	@ResponseBody
	public String deletePost(@PathVariable("postid") String post_id) {
		
		int num=service.deletePost(post_id);
		System.out.println("delete : "+num);
		return "redirect:api/movie";
	}
    
}
