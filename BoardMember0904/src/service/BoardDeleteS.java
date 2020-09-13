package service;

import javax.servlet.http.HttpServletRequest;

import dao.BoardDAO;

public class BoardDeleteS {

	public int boardDelete(HttpServletRequest request) {
		BoardDAO bdao =new BoardDAO();
		int bnumber=Integer.parseInt(request.getParameter("bnumber"));
		bdao.dbconnection();
		int result=bdao.BoardDelete(bnumber);
		bdao.dbClose();
		return result;
	}

}
