package com.reeltalks.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.reeltalks.dto.AwesomeDTO;

@Repository
public class AwesomeDAO {

	public int insert(SqlSessionTemplate session, AwesomeDTO dto) {
		return session.insert("AwesomeMapper.insert", dto);
	}

	public List<AwesomeDTO> selectList(SqlSessionTemplate session) {
		List<AwesomeDTO> list = session.selectList("AwesomeMapper.selectList");
		return list;
	}

}
