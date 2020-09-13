package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardWriteS {

	public int boardWrite(HttpServletRequest request) throws IOException {
		String savepath ="D:\\source\\servlet\\BoardMember0904\\WebContent\\UploadFile";
		MultipartRequest multi = new MultipartRequest(
				request,
				savepath,
				10*1024*1024,
				//10¸Þ°¡
				"UTF-8",
				new DefaultFileRenamePolicy());
		BoardDAO bdao = new BoardDAO();
		BoardDTO bdto = new BoardDTO();
		HttpSession session =request.getSession();
		String loginid =(String)session.getAttribute("loginid");
		bdto.setBwriter(loginid);
		bdto.setBtitle(multi.getParameter("btitle"));
		bdto.setBcontents(multi.getParameter("bcontents"));
		bdto.setBfile(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		bdao.dbconnection();
		int result=bdao.BoardWrite(bdto);
		bdao.dbClose();
		return result;
	}

}
