package service;

import javax.servlet.http.HttpServletRequest;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardUpdateS {

	public BoardDTO boardUpdate(HttpServletRequest request) {
		BoardDAO bdao = new BoardDAO();
		int bnumber=Integer.parseInt(request.getParameter("bnumber"));
		bdao.dbconnection();
		BoardDTO bdto = bdao.BoardView(bnumber);
		bdao.dbClose();
		return bdto;
	}

	
	
}
