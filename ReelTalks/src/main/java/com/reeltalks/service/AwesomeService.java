package com.reeltalks.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reeltalks.dao.AwesomeDAO;
import com.reeltalks.dto.AwesomeDTO;

@Service
public class AwesomeService {
	@Autowired
	AwesomeDAO dao;
	@Autowired
	SqlSessionTemplate session;
	
	public int insert(AwesomeDTO dto) {
		return dao.insert(session, dto);
	}
	
	public List<AwesomeDTO> selectList() {
		List<AwesomeDTO> list = dao.selectList(session);
		return list;
	}
}
