package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberUpdateS {

	public MemberDTO memberUpdate(HttpServletRequest request) {
		MemberDAO mdao = new MemberDAO();
		HttpSession session = request.getSession();
		String mid= (String) session.getAttribute("loginid");
		mdao.dbconnection();
		MemberDTO mdto = mdao.MemberUpdate(mid);
		mdao.dbClose();
		return mdto;
	}

}
