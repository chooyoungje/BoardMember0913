package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardWriteS;

@WebServlet("/boardwrite")
public class BoardWriteC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardWriteS wsvc = new BoardWriteS();
		int result=wsvc.boardWrite(request);
		if(result==1)
			{response.sendRedirect("boardlistall");
			}
		else
			{response.sendRedirect("boardwrite.jsp");
			}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
}