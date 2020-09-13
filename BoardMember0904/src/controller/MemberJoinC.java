package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberJoinS;

@WebServlet("/memberjoin")
public class MemberJoinC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberJoinC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberJoinS jsvc = new MemberJoinS();
		int result=jsvc.memberJoion(request);
		if(result==1)
			{response.sendRedirect("memberlogin.jsp");
			}
		else
			{response.sendRedirect("memberjoin.jsp");
			}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
}
