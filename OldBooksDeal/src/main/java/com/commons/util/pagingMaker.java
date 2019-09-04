package com.commons.util;

public class pagingMaker {
	// 임의로 정할 수 있는 변수
	int curPage; //현재 페이지 
	int pageCnt; //페이지당 보여줄 게시판 수
	
	int perPageCnt; // 한번에 보여줄 페이지 수 
	
	// 함수로 정해야하는 변수

	int totalBoard; // 게시판 수:
	int perPage; // 총 페이지 수: totalBoard/pageCnt  if(totalBoard%pageCnt!=0) + 1
	
	int startPage; // 페이지시작:
	int endPage; // 페이지 끝:
	boolean prev; // 이전값
	boolean next; //다음값
	
	public pagingMaker(int curPage, int pageCnt, int totalBoard, int perPageCnt) {
		super();
		this.curPage = curPage;
		this.pageCnt = pageCnt;
		this.totalBoard = totalBoard;
		this.perPage = totalBoard/pageCnt;
		if(totalBoard%pageCnt!=0) perPage++;
		this.perPageCnt = perPageCnt;
		this.startPage = (curPage-1)/perPageCnt;
		startPage *=perPageCnt;
		startPage +=1;
		this.endPage = startPage+perPageCnt-1;
		if(endPage>=perPage) endPage=perPage;
		prev = startPage > 1;
		next = endPage < perPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public int getPerPageCnt() {
		return perPageCnt;
	}

	public int getTotalBoard() {
		return totalBoard;
	}

	public int getPerPage() {
		return perPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}


	
	
}
