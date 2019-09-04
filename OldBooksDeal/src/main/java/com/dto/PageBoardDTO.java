package com.dto;

import java.util.List;


public class PageBoardDTO {
	private int perPage; // dao클래스, selectList의 인자 new RowBounds의 2번째 인자
	private int totalRecord; //전체페이지
	private int curPage; // 현재 페이지
	private int totalPage; // 총 페이지 갯수
	private List<BoardDTO> list; //페이지에 보여줄 데이터
	
	private int pageCnt; // 한번에 보여줄 페이지 갯수. 임의값으로 5를 부여	
	private int startPage; // 시작페이지. 1,6,11,16,21...값을 자동적으로 가짐
	private int endPage; //  끝페이지. 5,10,15,20,25... 값을 자동적으로 가짐
	
	private int prev; // 이전페이지로 가는 버튼. 현재페이지보다 pageCnt만큼 작음
	private int next; // 다음페이지로 가는 버튼. 현재페이지보다 pageCnt만큼 큼
	public PageBoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBoardDTO(int perPage, int totalRecord, int curPage, int totalPage, List<BoardDTO> list, int pageCnt,
			int startPage, int endPage, int prev, int next) {
		super();
		this.perPage = perPage;
		this.totalRecord = totalRecord;
		this.curPage = curPage;
		this.totalPage = totalPage;
		this.list = list;
		this.pageCnt = pageCnt;
		this.startPage = startPage;
		this.endPage = endPage;
		this.prev = prev;
		this.next = next;
	}
	
	
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<BoardDTO> getList() {
		return list;
	}
	public void setList(List<BoardDTO> list) {
		this.list = list;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "PageBoardDTO [perPage=" + perPage + ", totalRecord=" + totalRecord + ", curPage=" + curPage
				+ ", totalPage=" + totalPage + ", list=" + list + ", pageCnt=" + pageCnt + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + "]";
	}
	
	
}
