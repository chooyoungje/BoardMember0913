package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberViewS;

@WebServlet("/memberviewpopup")
public class MemberViewPopupC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberViewPopupC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberViewS msvc =new MemberViewS();
		MemberDTO mdto = msvc.memberView(request);
		request.setAttribute("mdto", mdto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("popup.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
