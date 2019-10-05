package com.dto;

import org.apache.ibatis.type.Alias;

@Alias(value = "ProductComentDTO")
public class ProductComentDTO {	
	private int pcomentno;
	private int group_no;
	private int group_order;
	private int depth;
	private String content;
	private String writeday;
	private String id;
	private String username;
	public ProductComentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductComentDTO(int pcomentno, int group_no, int group_order, int depth, String content, String writeday,
			String id, String username) {
		super();
		this.pcomentno = pcomentno;
		this.group_no = group_no;
		this.group_order = group_order;
		this.depth = depth;
		this.content = content;
		this.writeday = writeday;
		this.id = id;
		this.username = username;
	}
	public int getPcomentno() {
		return pcomentno;
	}
	public void setPcomentno(int pcomentno) {
		this.pcomentno = pcomentno;
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
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "ProductComentDTO [pcomentno=" + pcomentno + ", group_no=" + group_no + ", group_order=" + group_order
				+ ", depth=" + depth + ", content=" + content + ", writeday=" + writeday + ", id=" + id + ", username="
				+ username + "]";
	}
	
	
}
