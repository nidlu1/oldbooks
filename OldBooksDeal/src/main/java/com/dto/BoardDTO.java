package com.dto;

import org.apache.ibatis.type.Alias;

@Alias(value = "BoardDTO")
public class BoardDTO {	
	private int no;
	private int group_no;
	private int group_order;
	private int depth;
	private String type;
	private String title;
	private String content;
	private int good;
	private int views;
	private String writedate;
	private String id;
	private String username;
	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDTO(int no, int group_no, int group_order, int depth, String type, String title, String content,
			int good, int views, String writedate, String id, String username) {
		super();
		this.no = no;
		this.group_no = group_no;
		this.group_order = group_order;
		this.depth = depth;
		this.type = type;
		this.title = title;
		this.content = content;
		this.good = good;
		this.views = views;
		this.writedate = writedate;
		this.id = id;
		this.username = username;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
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
		return "BoardDTO [no=" + no + ", group_no=" + group_no + ", group_order=" + group_order + ", depth=" + depth
				+ ", type=" + type + ", title=" + title + ", content=" + content + ", good=" + good + ", views=" + views
				+ ", writedate=" + writedate + ", id=" + id + ", username=" + username + "]";
	}
	
}
