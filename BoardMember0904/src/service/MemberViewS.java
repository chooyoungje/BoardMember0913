package service;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberViewS {

	public MemberDTO memberView(HttpServletRequest request) {
		MemberDAO mdao= new MemberDAO();
		String mid=request.getParameter("mid");
		mdao.dbconnection();
		MemberDTO mdto = mdao.MemberView(mid);
		mdao.dbClose();
		return mdto;
	}

}
