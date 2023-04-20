package com.example.dto;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

@Alias("Category")
public class Category {
	private String category_id;
	private int category_no;
	private LocalDateTime create_at;
	private LocalDateTime update_at;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String category_id, int category_no, LocalDateTime create_at, LocalDateTime update_at) {
		super();
		this.category_id = category_id;
		this.category_no = category_no;
		this.create_at = create_at;
		this.update_at = update_at;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public LocalDateTime getCreate_at() {
		return create_at;
	}
	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = create_at;
	}
	public LocalDateTime getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(LocalDateTime update_at) {
		this.update_at = update_at;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category_no=" + category_no + ", create_at=" + create_at
				+ ", update_at=" + update_at + "]";
	}
	
	
	
	
}
