package service;

import java.util.List;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListAllS {

	public List<BoardDTO> boardlistAll() {
		BoardDAO bdao= new BoardDAO();
		bdao.dbconnection();		
		List<BoardDTO> blist = bdao.BoardListAll();
		bdao.dbClose();
		return blist;
	}

}
