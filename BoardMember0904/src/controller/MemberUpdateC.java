package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberUpdateS;

@WebServlet("/memberupdate")
public class MemberUpdateC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberUpdateS msvc = new MemberUpdateS();
		MemberDTO mdto =msvc.memberUpdate(request);
		request.setAttribute("mdto", mdto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("memberupdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
}

}
