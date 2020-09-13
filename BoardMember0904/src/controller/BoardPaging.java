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
import dto.PageDTO;
import service.BoardPagingS;

@WebServlet("/boardlistpaging")
public class BoardPaging extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardPaging() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardPagingS psvc = new BoardPagingS();
		List<BoardDTO> boardList = psvc.boardList(request, response);
		//클릭한 페이지에 필요한 글만 가져오기 위한 메소드 호출
		
    	PageDTO paging = psvc.paging(request, response);
    	// 페이지 번호와 관련된 정보 등을 결정하기 위한 메소드 호출
    	
    	request.setAttribute("boardList", boardList);
    	request.setAttribute("paging", paging);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("boardlistpage.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
