package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.commons.util.SessionUtil;
import com.commons.util.pagingMaker;
import com.dto.BoardDTO;
import com.dto.ComentDTO;
import com.dto.GoodDTO;
import com.dto.PageBoardDTO;
import com.service.BoardService;
import com.service.ComentService;
import com.service.GoodService;

@Controller
public class BoardController
{
	@Autowired
	BoardService bService;
	
	@Autowired
	ComentService cService;
	
	@Autowired
	GoodService gSevice;
	

	@RequestMapping(value = "/boardUI/{page}")
	public String boardUI(HttpSession session,
							@PathVariable("page") String page,
							RedirectAttributes rda)
	{
		int curPage = Integer.parseInt(page);
		int totalBoard = bService.totalBoardCnt();	
		pagingMaker pagingMaker = new pagingMaker(curPage, 5, totalBoard, 5);
		
		List<BoardDTO> boardlistAll = bService.listAll(pagingMaker);
		
		SessionUtil su = new SessionUtil();
		su.setAttribute("boardList", boardlistAll, session);
		
		rda.addFlashAttribute("startPage", pagingMaker.getStartPage());
		rda.addFlashAttribute("endPage", pagingMaker.getEndPage());
		rda.addFlashAttribute("curPage", pagingMaker.getCurPage());
		rda.addFlashAttribute("perPage", pagingMaker.getPerPage());
		rda.addFlashAttribute("perPageCnt", pagingMaker.getPerPageCnt());
		rda.addFlashAttribute("prev", pagingMaker.isPrev());
		rda.addFlashAttribute("next", pagingMaker.isNext());
		
		return "redirect:../boardUI";
	}
	
	
	@RequestMapping(value = "/logCheckboardWrite")
	public String boardWrite(HttpSession session, BoardDTO acceptData,
			RedirectAttributes rda)
	{
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("YY-MM-dd");
		String writedate = f.format(d);
		acceptData.setWritedate(writedate);
		
		bService.boardWrite(acceptData);
		return "redirect:boardUI/1";
	}
	
	@RequestMapping(value = "/boardRetrieve/{boardNo}")
	public String boardRetrieve(@PathVariable("boardNo") int no,
								RedirectAttributes rea,
								HttpSession session)
	{
		BoardDTO bDTO = new BoardDTO();
		bDTO = bService.boardRetrieve(no);
		
		List<ComentDTO> cList  = cService.cAllList(no);
		List<GoodDTO> gList = gSevice.gListAll(no);
		SessionUtil su = new SessionUtil();
		su.setAttribute("boardRetrieve", bDTO, session);
		su.setAttribute("comentList", cList, session);
		//su.setAttribute("goodList", gList, session);
		return "redirect:../boardRetrieveUI";
	}
	
	@RequestMapping(value = "/logCheckboardWriteUpdate")
	public String boardWriteUpdate(HttpSession session, BoardDTO acceptData,
			RedirectAttributes rda)
	{
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("YY-MM-dd");
		String writedate = f.format(d);
		acceptData.setWritedate(writedate);
		bService.boardWriteUpdate(acceptData);
		return "redirect:boardUI/1";
	}
	
	@RequestMapping(value = "/boardRetrieveDelete/{bno}")
	public String boardRetrieveDelete(@PathVariable String bno)
	{
		int no = Integer.parseInt(bno);
		bService.boardRetrieveDelete(no);
		return "redirect:../boardUI/1"; //다시불러오기
	}
	
	@RequestMapping(value = "schBoardUI/{page}")
	public String schBoardUI(HttpSession session,
								@PathVariable("page") String page,
								RedirectAttributes rda,
								@RequestParam Map<String,String> schMap)
	{
		
		
		int curPage = Integer.parseInt(page);
		int totalBoard = bService.totalBoardCnt();	
		pagingMaker pagingMaker = new pagingMaker(curPage, 5, totalBoard, 5);
		
		List<BoardDTO> boardlistAll = bService.schBoardList(pagingMaker, schMap);
		
		SessionUtil su = new SessionUtil();

		su.setAttribute("boardSchList", boardlistAll, session);
		su.setAttribute("schWord", schMap.get("schWord"), session);
		
		rda.addFlashAttribute("startPage", pagingMaker.getStartPage());
		rda.addFlashAttribute("endPage", pagingMaker.getEndPage());
		rda.addFlashAttribute("curPage", pagingMaker.getCurPage());
		rda.addFlashAttribute("perPage", pagingMaker.getPerPage());
		rda.addFlashAttribute("perPageCnt", pagingMaker.getPerPageCnt());
		rda.addFlashAttribute("prev", pagingMaker.isPrev());
		rda.addFlashAttribute("next", pagingMaker.isNext());

		return "redirect:../boardSch";
	}
	
}
