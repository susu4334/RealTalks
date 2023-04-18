package com.reeltalks.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reeltalks.dao.MemberDAO;
import com.reeltalks.dto.UserDTO;

@Service
public class UserService {
	@Autowired
	MemberDAO dao;
	@Autowired
	SqlSessionTemplate session;
	
	public int insert(UserDTO dto) {
		return dao.insert(session, dto);
	}
	
	public UserDTO user_id_check(String user_id) {
		UserDTO dto = dao.user_id_check(session, user_id);
		return dto;
	}
	
	public UserDTO user_name_check(String user_name) {
		UserDTO dto = dao.user_name_check(session, user_name);
		return dto;
	}
	
}
