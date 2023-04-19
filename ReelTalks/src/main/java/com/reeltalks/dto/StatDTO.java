package com.reeltalks.dto;

public class StatDTO {
	private String stat_name;
	private int stat_count;

	public StatDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatDTO(String stat_name, int stat_count) {
		super();
		this.stat_name = stat_name;
		this.stat_count = stat_count;
	}

	public String getStat_name() {
		return stat_name;
	}

	public void setStat_name(String stat_name) {
		this.stat_name = stat_name;
	}

	public int getStat_count() {
		return stat_count;
	}

	public void setStat_count(int stat_count) {
		this.stat_count = stat_count;
	}

	@Override
	public String toString() {
		return "StatDTO [stat_name=" + stat_name + ", stat_count=" + stat_count + "]";
	}

}
