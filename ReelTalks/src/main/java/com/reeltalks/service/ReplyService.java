package com.reeltalks.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reeltalks.dao.ReplyDAO;
import com.reeltalks.dto.ReplyDTO;

@Service
public class ReplyService {
	@Autowired
	ReplyDAO dao;
	@Autowired
	SqlSessionTemplate session;
	
	public ReplyDTO reply_select(int reply_id) {
		ReplyDTO dto = dao.reply_select(session, reply_id);
		return dto;
	}
	
	public List<ReplyDTO> reply_select_list(int post_id) {
		List<ReplyDTO> list = dao.reply_select_list(session, post_id);
		return list;
	}

	public void reply_insert(ReplyDTO dto) {
		dao.reply_insert(session, dto);
	}
	
	public void reply_update(ReplyDTO dto) {
		dao.reply_update(session, dto);
	}

	public void reply_delete(String reply_id) {
		dao.reply_delete(session, reply_id);
	}
}
