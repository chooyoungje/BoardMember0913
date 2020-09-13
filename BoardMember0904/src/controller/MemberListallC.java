package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberListallS;

@WebServlet("/memberlistall")
public class MemberListallC extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberListallC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberListallS mlsvc = new MemberListallS();
		List<MemberDTO> mlist = mlsvc.memberlistAll();
		request.setAttribute("mlist", mlist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("memberlistall.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
}

}
