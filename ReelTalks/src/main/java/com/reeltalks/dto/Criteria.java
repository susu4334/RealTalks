package com.reeltalks.dto;

public class Criteria {
	// 특정 페이지 조회를 위한 클래스

	private int startIdx;
	private int endIdx;
	
	
	
	public Criteria() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Criteria(int startIdx, int endIdx) {
		super();
		this.startIdx = startIdx;
		this.endIdx = endIdx;
	}


	public int getStartIdx() {
		return startIdx;
	}


	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}


	public int getEndIdx() {
		return endIdx;
	}


	public void setEndIdx(int endIdx) {
		this.endIdx = endIdx;
	}


	@Override
	public String toString() {
		return "Criteria [startIdx=" + startIdx + ", endIdx=" + endIdx + "]";
	}
	
	
	
}
