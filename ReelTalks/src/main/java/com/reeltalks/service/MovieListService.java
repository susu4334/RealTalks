package com.reeltalks.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reeltalks.dao.MovieListDAO;
import com.reeltalks.dto.Category;
import com.reeltalks.dto.Criteria;
import com.reeltalks.dto.Movie;

import com.reeltalks.dto.MovieJoinDTO;
import com.reeltalks.dto.PageDTO;

@Service
public class MovieListService {

	@Autowired
	MovieListDAO dao;
	@Autowired
	SqlSessionTemplate session;

	public List<Movie> selectMainList() {
		// TODO Auto-generated method stub
		List<Movie> list = dao.selectMainList(session);
		return list;
	}


	

	public List<Category> selectCategory() {
		// TODO Auto-generated method stub
		List<Category> clist = dao.selectCategory(session);

		return clist;
	}
	



	public PageDTO categoryList(String category_id, int curPage) {
		
		int perPage = 8;
		int totalCount = dao.totalCount(session, category_id);

		int totalPage = (int) Math.ceil((double) totalCount / (double) perPage);

		if (totalPage == 0) {
			totalPage = 1;
		}

		int startIdx = ((curPage - 1) * perPage);
		int endIdx = curPage * perPage;

		if (curPage == totalPage) {

			endIdx = startIdx + (totalCount % perPage);

		}

		Criteria cri = new Criteria();
		cri.setStartIdx(startIdx);
		cri.setEndIdx(endIdx);

		List<MovieJoinDTO> joinList = dao.joinList(session, category_id, cri);

		PageDTO pageDTO = new PageDTO();
		pageDTO.setTotalPage(totalPage);
		pageDTO.setCurPage(curPage);
		pageDTO.setList(joinList);

		return pageDTO;
	}

	public PageDTO maincategoryList(int curPage) {
		// TODO Auto-generated method stub
		int perPage = 8;
		int maintotalCount = dao.maintotalCount(session);
		
		int totalPage = (int) Math.ceil((double) maintotalCount / (double) perPage);
		if (totalPage == 0) {
			totalPage = 1;
		}
		
		int startIdx = ((curPage - 1) * perPage);

		int endIdx = curPage * perPage;

		if (curPage == totalPage) {

			endIdx = startIdx + (maintotalCount % perPage);

		}
		
		Criteria cri = new Criteria();
		cri.setStartIdx(startIdx);
		cri.setEndIdx(endIdx);

		List<MovieJoinDTO> mainjoinList = dao.mainjoinList(session, cri);

		PageDTO pageDTO = new PageDTO();
		pageDTO.setTotalPage(totalPage);
		pageDTO.setCurPage(curPage);
		pageDTO.setList(mainjoinList);

		return pageDTO;
	}

	
	
	public PageDTO etccategoryList(int curPage) {
		int perPage = 8;
		int etctotalCount = dao.etctotalCount(session);
		
		
		int totalPage = (int) Math.ceil((double) etctotalCount / (double) perPage);
		if (totalPage == 0) {
			totalPage = 1;
		}
		
		int startIdx = ((curPage - 1) * perPage);

		int endIdx = curPage * perPage;

		if (curPage == totalPage) {

			endIdx = startIdx + (etctotalCount % perPage);
		}
		
		Criteria cri = new Criteria();
		cri.setStartIdx(startIdx);
		cri.setEndIdx(endIdx);

		List<MovieJoinDTO> etcjoinList = dao.etcjoinList(session, cri);

		PageDTO pageDTO = new PageDTO();
		pageDTO.setTotalPage(totalPage);
		pageDTO.setCurPage(curPage);
		pageDTO.setList(etcjoinList);

		return pageDTO;
	}




}
