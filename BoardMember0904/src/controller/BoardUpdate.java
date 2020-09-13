package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardUpdateS;

@WebServlet("/boardupdate")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdate() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardUpdateS bsvc = new BoardUpdateS();
		BoardDTO bdto = bsvc.boardUpdate(request);
		request.setAttribute("bupdate", bdto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("boardupdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
