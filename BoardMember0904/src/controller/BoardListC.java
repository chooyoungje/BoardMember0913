package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BoardDTO;
import service.BoardListS;

@WebServlet("/boardlist")
public class BoardListC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListC() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String mid= (String) session.getAttribute("loginid");
			BoardListS bsvc= new BoardListS();
			List<BoardDTO> blist = bsvc.boardList(mid);
			int result=bsvc.boardCount(mid);
			if(blist!=null)
				{request.setAttribute("blist", blist);
				 request.setAttribute("bcount", result);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("mypage.jsp");
				 dispatcher.forward(request, response);
				}
			else
				{response.sendRedirect("memberlogin.jsp");
				}
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
