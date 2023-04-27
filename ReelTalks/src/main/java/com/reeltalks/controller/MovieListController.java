package com.reeltalks.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reeltalks.dto.Category;
import com.reeltalks.dto.Criteria;

import com.reeltalks.dto.MovieJoinDTO;
import com.reeltalks.dto.PageDTO;
import com.reeltalks.service.MovieListService;
import com.reeltalks.service.MovieService;

@Controller
public class MovieListController {

	@Autowired
	MovieListService service;

	// @PathVariable 사용
	@ResponseBody
	@GetMapping("/movieList")
	public List<MovieJoinDTO> movieList(@RequestParam("category_id") String category_id,
			@RequestParam(value = "curPage", defaultValue = "1") int curPage) {

		System.out.println(category_id + "\t" + curPage);
		System.out.println("movieList.jsp 불러오기");

		PageDTO pageDTO = new PageDTO();

		System.out.println(category_id);

		switch (category_id) {
		case "action":
			category_id = "액션";
			pageDTO = service.categoryList(category_id, curPage);
			System.out.println(pageDTO);
			System.out.println("Main전체페이지: " + pageDTO.getTotalPage());

			// 위에서 액션이 있는지 먼저 찾고 난후 category_id의 값을 영어로 바꿔야 하기 때문에 마지막에 선언한다.
			System.out.println("바뀐 값: " + category_id);
			break;

		case "drama":
			category_id = "드라마";
			pageDTO = service.categoryList(category_id, curPage);
			System.out.println(pageDTO);
			System.out.println("Main전체페이지: " + pageDTO.getTotalPage());
			break;
			
		case "romance":
			category_id = "멜로/로맨스";
			pageDTO = service.categoryList(category_id, curPage);
			System.out.println(pageDTO);
			System.out.println("Main전체페이지: " + pageDTO.getTotalPage());
			break;
			
		case "comedy":
			category_id = "코메디";
			pageDTO = service.categoryList(category_id, curPage);
			System.out.println(pageDTO);
			System.out.println("comedy전체페이지: " + pageDTO.getTotalPage());
			break;
			
		case "ani":
			category_id = "애니메이션";
			pageDTO = service.categoryList(category_id, curPage);
			System.out.println(pageDTO);
			System.out.println("ani전체페이지: " + pageDTO.getTotalPage());
			break;
			
		case "horror":
			category_id = "공포";
			pageDTO = service.categoryList(category_id, curPage);
			System.out.println(pageDTO);
			System.out.println("horror전체페이지: " + pageDTO.getTotalPage());
			break;
			
		case "sf":
			category_id = "SF";
			pageDTO = service.categoryList(category_id, curPage);
			System.out.println(pageDTO);
			System.out.println("SF전체페이지: " + pageDTO.getTotalPage());
			break;
			
		case "fantasy":
			category_id = "판타지";
			pageDTO = service.categoryList(category_id, curPage);
			System.out.println(pageDTO);
			System.out.println("fantasy전체페이지: " + pageDTO.getTotalPage());
			break;
			
		case "movie":
			System.out.println("movie선택");
			pageDTO = service.maincategoryList(curPage);
			System.out.println("movie전체페이지: " + pageDTO.getTotalPage());
			break;
			
		case "etc":
			System.out.println("etc선택");
			pageDTO = service.etccategoryList(curPage);
			System.out.println("etc전체페이지: " + pageDTO.getTotalPage());
			break;
		
		default:
			pageDTO = service.categoryList(category_id, curPage);
			System.out.println(pageDTO);
			System.out.println("Main전체페이지: " + pageDTO.getTotalPage());

		}


		System.out.println(pageDTO.getList());
		return pageDTO.getList();
	}


}
