package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberJoinS {

	public int memberJoion(HttpServletRequest request) throws IOException {
		
		String savepath ="D:\\source\\servlet\\BoardMember0904\\WebContent\\UploadPhoto";
		MultipartRequest multi = new MultipartRequest(
				request,
				savepath,
				10*1024*1024,
				//10¸Þ°¡
				"UTF-8",
				new DefaultFileRenamePolicy());
		String mid = multi.getParameter("mid");
		String mpassword= multi.getParameter("mpassword");
		String mname= multi.getParameter("mname");
		String mbirth= multi.getParameter("mbirth"); 
		String memail = multi.getParameter("memail");
		String maddress= multi.getParameter("maddress");
		String mphone= multi.getParameter("mphone");
		String mphoto= multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = new MemberDTO();
		mdto.setMid(mid);
		mdto.setMpassword(mpassword);
		mdto.setMname(mname);
		mdto.setMbirth(mbirth);
		mdto.setMemail(memail);
		mdto.setMaddress(maddress);
		mdto.setMphone(mphone);
		mdto.setMphoto(mphoto);
		mdao.dbconnection();
		int result= mdao.MemberJoin(mdto);
		mdao.dbClose();
		return result;
	}
}