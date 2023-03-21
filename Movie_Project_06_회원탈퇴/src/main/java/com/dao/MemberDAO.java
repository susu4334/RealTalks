package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {

	public int memberAdd(SqlSession session, MemberDTO dto) {
		// TODO Auto-generated method stub

		int n = session.insert("MemberMapper.memberAdd", dto);

		return n;
	}

	public int idCheck(SqlSession session, String id) {
		int n = session.selectOne("MemberMapper.idCheck", id);

		return n;
	}

	public MemberDTO login(SqlSession session, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		MemberDTO dto = session.selectOne("MemberMapper.login", map);

		return dto;
	}

	public MemberDTO mypage(SqlSession session, String userid) {
		// TODO Auto-generated method stub
		MemberDTO dto = session.selectOne("MemberMapper.mypage", userid);

		return dto;
	}

	public int memberUpdate(SqlSession session, MemberDTO dto2) {
		int n = session.update("MemberMapper.memberUpdate", dto2);

		return n;
	}

	public int memberDelete(SqlSession session, MemberDTO dto2) {
		int n = session.delete("MemberMapper.memberDelete", dto2);
		return n;
	}

}
