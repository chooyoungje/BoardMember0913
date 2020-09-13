package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MeberLoginS;

@WebServlet("/memberlogin")
public class MemberLoginC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MeberLoginS lsvc = new MeberLoginS();
		String mid=request.getParameter("mid");
		int result = lsvc.memberLogin(request);
		if(result==1)
			{HttpSession session = request.getSession();
			 session.setAttribute("loginid", mid);
			 response.sendRedirect("boardlistall");
			}
		else
			{response.sendRedirect("memberloginfail.jsp");
			}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
}
}
