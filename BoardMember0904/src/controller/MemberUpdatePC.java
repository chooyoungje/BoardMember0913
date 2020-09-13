package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberUpdatePS;

@WebServlet("/memberupdateprocess")
public class MemberUpdatePC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdatePC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberUpdatePS msvc =new MemberUpdatePS();
		int result = msvc.memberupdateS(request);
		if(result==1) 
			{response.sendRedirect("boardlistall");
			}
		else 
			{response.sendRedirect("boardupdatefail.jsp");
			}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
