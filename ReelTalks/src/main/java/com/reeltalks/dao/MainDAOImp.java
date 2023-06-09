package com.reeltalks.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.reeltalks.dto.BoxOfficeDBDTO;
import com.reeltalks.dto.BoxOfficeDTO;
import com.reeltalks.dto.HotMovieDTO;
import com.reeltalks.dto.HotPostDTO;

@Repository
public class MainDAOImp implements MainDAO {

//	// 박스 오피스 데이터 받아오기
	@Override
	public List<BoxOfficeDTO> selectBoxOffice(SqlSessionTemplate session) {
//		
//		
		List<BoxOfficeDBDTO> receive_list  = session.selectList("MainMapper.selectBoxOffice");
//		
//		// 받아 오기 성공
		for (BoxOfficeDBDTO dto : receive_list) {
			// 배우 미상
			if (dto.getActor_Nm() == null) {
				dto.setActor_Nm("미상");
			}
			// 카테고리 미상
			if (dto.getCategory_Id() == null) {
				dto.setCategory_Id("미상");
			}
		}
		
		
		// 받아온 데이터를 보내줄 데이터로 변경 배우, 카테고리 : String => List<String>으로 변경
		List<BoxOfficeDTO> send_list = new ArrayList<BoxOfficeDTO>();
		
		for (int i = 0; i < receive_list.size(); i++) { // for start
			// 받은 정보가 담긴 dto
			BoxOfficeDBDTO receive_dto = receive_list.get(i);
			// 보낼 정보가 담기는 dto
			BoxOfficeDTO send_dto = new BoxOfficeDTO();
	
			// 카테고리 String으로 받은 것을 List<String>으로 보내주기
			
			// 카테고리 및 배우를 /로 나누어 List로 넘기기
			List<String> category_temp = Arrays.asList(receive_dto.getCategory_Id().split("/"));
			List<String> actor_temp = Arrays.asList(receive_dto.getActor_Nm().split("/"));
			
			// 카테고리_id 및 배우를 를 담을 List 생성
			List<String> category_id = new ArrayList<String>();
			List<String> actor_nm = new ArrayList<String>();
			
			// 카테고리 3개 넣기
			for (int j = 0; j < (category_temp.size() < 3 ? category_temp.size() : 3 ) ; j++) {
				category_id.add(category_temp.get(j));
			}
			// 배우이름 3개 넣기
			for (int j = 0; j < (actor_temp.size() < 3 ? actor_temp.size() : 3 ); j++) {
				actor_nm.add(actor_temp.get(j));
			}
			
			// 카테고리 및 배우가 3개 담긴 list를 send_dto에 담기
			send_dto.setCategory_Id_list(category_id);
			send_dto.setActor_Nm_list(actor_nm);
			
			// 나머지 데이터 담기
			send_dto.setTitle(receive_dto.getTitle());
//			 프론트엔드에서 영화 게시판 이동용 movie_id 필요로 추가
			send_dto.setMovie_id(receive_dto.getImageLink());
			send_dto.setImageLink("http://reeltalk.p-e.kr/images/" 
					+ receive_dto.getImageLink()+".png");
			send_dto.setDirector_Nm(receive_dto.getDirector_Nm());
			
			// 날짜 데이터 변경 2023-01-04 00:00:00 ⇒ 2023-01-04
			DateTimeFormatter formatter_long = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			DateTimeFormatter formatter_short = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			// 개봉일 저장
			String dateStr = receive_dto.getRelease_Date();
			// 개봉일이 0000-00-00일 경우 현재 시간으로 데이터 넣기
			if (dateStr == null) {
				
				LocalDateTime currentTime = LocalDateTime.now();
				dateStr = currentTime.format(formatter_long);
			}
			
			LocalDate date = LocalDate.parse(dateStr, formatter_long);
			String releaseDate = date.format(formatter_short);
			
			send_dto.setRelease_Date(releaseDate);
			
			// send_list에 send_dto 추가
			send_list.add(send_dto);
			
		} // for end
			
		return send_list;

	}

	@Override
	public List<HotMovieDTO> selectHotMoive(SqlSessionTemplate session, int day) {

		// 영화Id, 영화 제목을 게시물 수 상위 5개 받아오기
		List<HotMovieDTO> list  = session.selectList("MainMapper.selectHotMovie", day);
		
		return list;
	}

	@Override
	public List<HotPostDTO> selectHotPost(SqlSessionTemplate session, int day) {
		
		// 영화Id, 게시물Id, 게시물 제목, 댓글 수 상위 5개 받오기
		List<HotPostDTO> list = session.selectList("MainMapper.selectHotPost", day);
		
		return list;
	}


}
