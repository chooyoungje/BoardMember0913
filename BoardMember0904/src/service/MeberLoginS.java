package service;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDAO;

public class MeberLoginS {

	public int memberLogin(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		String mpassword= request.getParameter("mpassword");
		MemberDAO mdao = new MemberDAO();
		mdao.dbconnection();
		int result=mdao.MemberLogIn(mid,mpassword);
		mdao.dbClose();
		return result;
	}

}
