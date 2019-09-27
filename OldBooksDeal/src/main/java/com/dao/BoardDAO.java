package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.commons.util.pagingMaker;
import com.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate template;
	public List<BoardDTO> listAll(pagingMaker pm) {
		List<BoardDTO> list = template.selectList("mpBoard.listAll",pm);
		return list;
	}

	public int totalBoardCnt() {
		int totalBoardCnt = template.selectOne("mpBoard.totalBoardCnt");
		return totalBoardCnt;
	}

	public void boardWrite(BoardDTO acceptData) {
		template.insert("mpBoard.boardWrite", acceptData);
	}

	public BoardDTO boardRetrieve(int no) {
		template.update("mpBoard.viewUpdate", no);
		BoardDTO bDTO = template.selectOne("mpBoard.boardRetrieve", no);
		return bDTO;
	}

	public void boardWriteUpdate(BoardDTO acceptData) {
		template.insert("mpBoard.boardWriteUpdate", acceptData);
	}

	public void boardRetrieveDelete(int no) {
		template.delete("mpBoard.boardRetrieveDelete", no);
	}

	public List<BoardDTO> schBoardList(pagingMaker pm, Map<String, String> schMap) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pm", pm);
		map.put("schType", schMap.get("schType"));
		map.put("schWord", schMap.get("schWord"));
		List<BoardDTO> list = template.selectList("mpBoard.schBoardList",map);
		return list;
	}

	public List<BoardDTO> typeBoardList(pagingMaker pagingMaker, String type) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pm", pagingMaker);
		map.put("type", type);
		List<BoardDTO> list = template.selectList("mpBoard.typeBoardList",map);
		return list;
	}
}
