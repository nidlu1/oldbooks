package com.dto;

import org.apache.ibatis.type.Alias;

@Alias(value = "GoodDTO")
public class GoodDTO {
	private int good_no;
	private char idCheck;
	private String users_id;
	private int board_no;
	private int goods;
	public GoodDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoodDTO(int good_no, char idCheck, String users_id, int board_no, int goods) {
		super();
		this.good_no = good_no;
		this.idCheck = idCheck;
		this.users_id = users_id;
		this.board_no = board_no;
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "GoodDTO [good_no=" + good_no + ", idCheck=" + idCheck + ", users_id=" + users_id + ", board_no="
				+ board_no + ", goods=" + goods + "]";
	}
	public int getGood_no() {
		return good_no;
	}
	public void setGood_no(int good_no) {
		this.good_no = good_no;
	}
	public char getIdCheck() {
		return idCheck;
	}
	public void setIdCheck(char idCheck) {
		this.idCheck = idCheck;
	}
	public String getUsers_id() {
		return users_id;
	}
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	
	
}
