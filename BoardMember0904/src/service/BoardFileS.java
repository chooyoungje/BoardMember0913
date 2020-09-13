package service;

import javax.servlet.http.HttpServletRequest;

import dao.BoardDAO;

public class BoardFileS {

	public void boardFilename(HttpServletRequest request) {
		BoardDAO bdao = new BoardDAO();
		int bnumber=Integer.parseInt(request.getParameter("bnumber"));
		bdao.dbconnection();
		String bfile=bdao.BoardFileName(bnumber);
		bdao.dbClose();
		
		
	}

}
