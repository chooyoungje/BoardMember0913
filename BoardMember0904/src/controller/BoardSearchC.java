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
import service.BoardSearchS;

@WebServlet("/boardsearch")
public class BoardSearchC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardSearchS ssvc = new BoardSearchS();
		List<BoardDTO> blist = ssvc.boardSearch(request);
		request.setAttribute("bsearch", blist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("boardsearch.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
