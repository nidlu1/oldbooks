package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commons.util.pagingMaker;
import com.dao.BoardDAO;
import com.dto.BoardDTO;

@Service
public class BoardService {
	@Autowired
	BoardDAO dao;
	
	public List<BoardDTO> listAll(pagingMaker pm) {
		List<BoardDTO> list = dao.listAll(pm);
		return list;
	}

	public int totalBoardCnt() {
		int totalBoardCnt = dao.totalBoardCnt();
		return totalBoardCnt;
	}

	public void boardWrite(BoardDTO acceptData) {
		dao.boardWrite(acceptData);
	}
	
	@Transactional
	public BoardDTO boardRetrieve(int no) {
		BoardDTO bDTO = dao.boardRetrieve(no);
		return bDTO;
	}

	public void boardWriteUpdate(BoardDTO acceptData) {
		dao.boardWriteUpdate(acceptData);
	}

	public void boardRetrieveDelete(int no) {
		dao.boardRetrieveDelete(no);
	}

	public List<BoardDTO> schBoardList(pagingMaker pm, Map<String, String> schMap) {
		List<BoardDTO> list = dao.schBoardList(pm,schMap);
		return list;
	}

}
