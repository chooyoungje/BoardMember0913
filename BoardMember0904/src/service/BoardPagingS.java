package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.PageDTO;

public class BoardPagingS {
	/*
	 * 상수선언
	 * 상수 : 바뀌지 않는 값이며 현재 클래스내에서 고정값으로 사용이 가능함
	 * 		상수에 담긴 값은 변환 불가능
	 * PAGE_LIMIT : 한 페이지에 보여줄 글 갯수
	 * BLOCK_LIMIT : 한 화면상에 노출될 페이지 갯수
	 * 1~5,6~10
	 * final : 값을 바꿀수 없음
	 */
	
	private static final int PAGE_LIMIT=3;
	private static final int BLOCK_LIMIT=5;
	public List<BoardDTO> boardList(HttpServletRequest request, HttpServletResponse response) {
		int page = 1;
		//처음엔 담겨오는 "page"값이 없음
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbconnection();
		int startRow = (page-1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT; 		
		List<BoardDTO> boardList = bDAO.boardListPaging(startRow, endRow);
		bDAO.dbClose();
		return boardList;
	}
	
	public PageDTO paging(HttpServletRequest request, HttpServletResponse response) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbconnection();
		int listCount = bDAO.listCount();
		bDAO.dbClose();
		int maxPage = (int)(Math.ceil((double)listCount/PAGE_LIMIT)); 
		int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;
		
		if (endPage > maxPage) {
			endPage = maxPage;
		}
		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		return paging;
	}
}
