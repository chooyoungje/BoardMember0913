package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberDeleteS;

/**
 * Servlet implementation class MemberDeleteC
 */
@WebServlet("/memberdelete")
public class MemberDeleteC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDeleteC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDeleteS dsvc = new MemberDeleteS();
		int result = dsvc.memberDelete(request);
		if(result==1)
			{response.sendRedirect("boardlistall");
			}
		else
			{response.sendRedirect("memberdeletefail.jsp");
			}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
}
