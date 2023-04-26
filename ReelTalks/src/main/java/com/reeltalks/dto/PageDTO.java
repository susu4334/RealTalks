package com.reeltalks.dto;

import java.util.List;

public class PageDTO {
	
//	private List<MovieJoinDTO> list;
//	private int curPage;	//현재 볼 페이지 번호
//	private int totalPage;
	
	private List<MovieJoinDTO> list;	//현재페이지에 들어갈 레코드를 perPage만큼 저장
	private int curPage;	//현재 볼 페이지 번호
	private int perPage=8;	//한 페이지에 보여질 목록 수
	private int totalCount;	//전체 레코드 갯수
	private int totalPage;
	
	
	public PageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PageDTO(List<MovieJoinDTO> list, int curPage, int perPage, int totalCount, int totalPage) {
		super();
		this.list = list;
		this.curPage = curPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}


	public List<MovieJoinDTO> getList() {
		return list;
	}


	public void setList(List<MovieJoinDTO> list) {
		this.list = list;
	}


	public int getCurPage() {
		return curPage;
	}


	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}


	public int getPerPage() {
		return perPage;
	}


	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	@Override
	public String toString() {
		return "PageDTO [list=" + list + ", curPage=" + curPage + ", perPage=" + perPage + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + "]";
	}



	
}
