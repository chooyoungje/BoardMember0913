package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardViewS;

@WebServlet("/boardview")
public class BoardViewC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardViewC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardViewS vsvc = new BoardViewS();
		BoardDTO bdto = vsvc.boardView(request);
		request.setAttribute("bview", bdto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("boardview.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
