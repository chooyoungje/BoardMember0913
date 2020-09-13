package service;

import java.util.List;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberListallS {

	public List<MemberDTO> memberlistAll() {
		MemberDAO mdao = new MemberDAO();
		mdao.dbconnection();
		List<MemberDTO> mlist = mdao.MemberListAll();
		mdao.dbClose();
		return mlist;
	}

}
