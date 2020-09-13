package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardSearchS {

	public List<BoardDTO> boardSearch(HttpServletRequest request) {
		BoardDAO bdao = new BoardDAO();
		String bsearch = request.getParameter("bsearch");
		bdao.dbconnection();
		List<BoardDTO> blist = bdao.BoardSearch(bsearch);
		bdao.dbClose();
		return blist;
	}

}
