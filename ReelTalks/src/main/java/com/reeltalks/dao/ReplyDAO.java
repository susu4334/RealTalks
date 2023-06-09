package com.reeltalks.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.reeltalks.dto.ReplyDTO;
import com.reeltalks.dto.ReplyWithNameDTO;

@Repository
public class ReplyDAO {

	public int reply_count(SqlSessionTemplate session, int post_id) {
		return session.selectOne("ReplyMapper.reply_count", post_id);
	}
	
	public ReplyDTO reply_select(SqlSessionTemplate session, int reply_id) {
		ReplyDTO dto = session.selectOne("ReplyMapper.reply_select", reply_id);
		return dto;
	}
	
	public List<ReplyWithNameDTO> reply_select_list(SqlSessionTemplate session, int post_id) {
		List<ReplyWithNameDTO> list = session.selectList("ReplyMapper.reply_select_list", post_id);
		return list;
	}

	public int reply_insert(SqlSessionTemplate session, ReplyDTO dto) {
		return session.insert("ReplyMapper.reply_insert", dto);
	}
	
	public void reply_update(SqlSessionTemplate session, ReplyDTO dto) {
		session.update("ReplyMapper.reply_update", dto);
	}

	public int reply_delete(SqlSessionTemplate session, String reply_id) {
		return session.update("ReplyMapper.reply_delete", reply_id);
	}
	
	public List<ReplyDTO> select_reReply(SqlSessionTemplate session, int reply_id) {
		List<ReplyDTO> list = session.selectList("ReplyMapper.select_reReply", reply_id);
		return list;
	}
}
