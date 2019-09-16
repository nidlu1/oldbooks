package com.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias(value = "ComentDTO")
public class ComentDTO {
	private int comentno;
	private int board_no;
	private String username;
	private int group_no;
	private int group_order;
	private int depth;
	private String content;
	private int goods;
	private Date writeday;
	public ComentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ComentDTO(int comentno, int board_no, String username, int group_no, int group_order, int depth,
			String content, int goods, Date writeday) {
		super();
		this.comentno = comentno;
		this.board_no = board_no;
		this.username = username;
		this.group_no = group_no;
		this.group_order = group_order;
		this.depth = depth;
		this.content = content;
		this.goods = goods;
		this.writeday = writeday;
	}
	public int getComentno() {
		return comentno;
	}
	public void setComentno(int comentno) {
		this.comentno = comentno;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getGroup_no() {
		return group_no;
	}
	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}
	public int getGroup_order() {
		return group_order;
	}
	public void setGroup_order(int group_order) {
		this.group_order = group_order;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}

	public Date getWriteday() {
		return writeday;
	}

	public void setWriteday(Date writeday) {
		this.writeday = writeday;
	}
	@Override
	public String toString() {
		return "ComentDTO [comentno=" + comentno + ", board_no=" + board_no + ", username=" + username + ", group_no="
				+ group_no + ", group_order=" + group_order + ", depth=" + depth + ", content=" + content + ", goods="
				+ goods + "]";
	}
	
	
}
