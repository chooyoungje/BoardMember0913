package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardRangeS;

@WebServlet("/boardrange")
public class BoardRangeC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardRangeC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardRangeS bsvc = new BoardRangeS();
		List<BoardDTO> blist = bsvc.boardlistRange();
		request.setAttribute("blistrange", blist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("boardlistrange.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
