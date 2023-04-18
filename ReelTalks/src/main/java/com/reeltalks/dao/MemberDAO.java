package com.reeltalks.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.reeltalks.dto.UserDTO;

@Repository
public class MemberDAO {

	public int insert(SqlSessionTemplate session, UserDTO dto) {
		return session.insert("MemberMapper.insert", dto);
	}

	public UserDTO user_id_check(SqlSessionTemplate session, String user_id) {
		UserDTO dto = session.selectOne("MemberMapper.user_id_check", user_id);
		return dto;
	}

	public UserDTO user_name_check(SqlSessionTemplate session, String user_name) {
		UserDTO dto = session.selectOne("MemberMapper.user_name_check", user_name);
		return dto;
	}
}
