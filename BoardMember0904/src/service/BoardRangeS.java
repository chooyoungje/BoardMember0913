package service;

import java.util.List;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardRangeS {

	public List<BoardDTO> boardlistRange() {
		BoardDAO bdao= new BoardDAO();
		bdao.dbconnection();		
		List<BoardDTO> blist = bdao.BoardListRange();
		bdao.dbClose();
		return blist;
	}

}
