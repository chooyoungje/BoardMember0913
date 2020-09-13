package service;

import javax.servlet.http.HttpServletRequest;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardViewS {

	public BoardDTO boardView(HttpServletRequest request) {
		BoardDAO bdao = new BoardDAO();
		int bnumber=Integer.parseInt(request.getParameter("bnumber"));
		bdao.dbconnection();
		bdao.BoardHits(bnumber);
		BoardDTO bdto = bdao.BoardView(bnumber);
		bdao.dbClose();
		return bdto;
	}

}
