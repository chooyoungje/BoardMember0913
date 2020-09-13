package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListS {

	public List<BoardDTO> boardList(String mid) {
		BoardDAO bdao= new BoardDAO();
		bdao.dbconnection();		
		List<BoardDTO> blist = bdao.BoardList(mid);
		bdao.dbClose();
		return blist;
	}
	
	public int boardCount(String mid) {
		BoardDAO bdao =new BoardDAO();
		bdao.dbconnection();
		int result= bdao.BoardCount(mid);
		bdao.dbClose();
		return result;
	}

}
