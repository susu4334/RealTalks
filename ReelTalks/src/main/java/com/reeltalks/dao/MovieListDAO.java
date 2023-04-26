package com.reeltalks.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.reeltalks.dto.Category;
import com.reeltalks.dto.Criteria;
import com.reeltalks.dto.Movie;
import com.reeltalks.dto.MovieJoinDTO;
import com.reeltalks.dto.PageDTO;

@Repository
public class MovieListDAO {

	public List<Movie> selectMainList(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		List<Movie> list = session.selectList("MovieDTOMapper.selectMainList");

		return list;
	}

	public List<Category> selectCategory(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		List<Category> clist = session.selectList("MovieDTOMapper.selectCategory");
		return clist;
	}
	
	
	
	
	public int totalCount(SqlSessionTemplate session, String category_id) {
		int n = session.selectOne("MovieDTOMapper.totalCount", category_id);
		return n;
	}

	public List<MovieJoinDTO> joinList(SqlSessionTemplate session, String category_id, Criteria cri) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("category_id", category_id);
		map.put("startIdx", cri.getStartIdx());
		map.put("endIdx", cri.getEndIdx());

		System.out.println("해당 카테고리를 선택한 DAO");
		List<MovieJoinDTO> joinList = session.selectList("MovieDTOMapper.pageSelect", map);
		System.out.println("joinList: " + joinList);


		// 앞 문자열에 #추가(sql 문에서는 맨앞에 추가 안되어있음)
		for (int i = 0; i < joinList.size(); i++) {

			String data = joinList.get(i).getCategory_id();

			joinList.get(i).setCategory_id("#" + data);

		}

		return joinList;
	}

	public int maintotalCount(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		int n = session.selectOne("MovieDTOMapper.maintotalCount");
		return n;
	}

	public List<MovieJoinDTO> mainjoinList(SqlSessionTemplate session, Criteria cri) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("startIdx", cri.getStartIdx());
		map.put("endIdx", cri.getEndIdx());

		System.out.println("Movie 카테고리를 선택한 DAO");
		List<MovieJoinDTO> moviejoinList = session.selectList("MovieDTOMapper.allSelect", map);
		System.out.println("moviejoinList: " + moviejoinList);

		// 앞 문자열에 #추가(sql 문에서는 맨앞에 추가 안되어있음)
		for (int i = 0; i < moviejoinList.size(); i++) {

			String data = moviejoinList.get(i).getCategory_id();

			moviejoinList.get(i).setCategory_id("#" + data);

		}

		return moviejoinList;
	}

	public int etctotalCount(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		int n = session.selectOne("MovieDTOMapper.etctotalCount");
		return n;
	}

	public List<MovieJoinDTO> etcjoinList(SqlSessionTemplate session, Criteria cri) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("startIdx", cri.getStartIdx());
		map.put("endIdx", cri.getEndIdx());

		System.out.println("etc 카테고리를 선택한 DAO");
		List<MovieJoinDTO> etcjoinList = session.selectList("MovieDTOMapper.etcSelect", map);
		System.out.println("etcjoinList: " + etcjoinList);

		// 앞 문자열에 #추가(sql 문에서는 맨앞에 추가 안되어있음)
		for (int i = 0; i < etcjoinList.size(); i++) {

			String data = etcjoinList.get(i).getCategory_id();

			etcjoinList.get(i).setCategory_id("#" + data);

		}

		return etcjoinList;
	}

}
