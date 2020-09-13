package service;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDAO;

public class MemberDeleteS {

	public int memberDelete(HttpServletRequest request) {
		MemberDAO mdao = new MemberDAO();
		String mid = request.getParameter("mid");
		mdao.dbconnection();
		int result = mdao.MemberDelete(mid);
		mdao.dbClose();
		return result;
	}

}
