package dao;

import java.sql.*;
import java.util.*;

import db.DBConnection;
import dto.MemberDTO;

public class MemberDAO {

	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public void dbClose() {
		try {con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
      public void rsClose() {
		try {rs.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void pstmtClose() {
		try {pstmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dbconnection() {
		con=DBConnection.getConnection();
	}
	public int MemberJoin(MemberDTO mdto) {
		String sql="INSERT INTO MEMBER1(MID,MPASSWORD,MNAME,MBIRTH,MEMAIL,MADDRESS,MPHONE,MPHOTO)"
				+ "VALUES(?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,?,?)";
		int result=0;
		try {pstmt=con.prepareStatement(sql);
			 pstmt.setString(1, mdto.getMid());
			 pstmt.setString(2, mdto.getMpassword());
			 pstmt.setString(3, mdto.getMname());
			 pstmt.setString(4, mdto.getMbirth());
			 pstmt.setString(5, mdto.getMemail());
			 pstmt.setString(6, mdto.getMaddress());
			 pstmt.setString(7, mdto.getMphone());
			 pstmt.setString(8, mdto.getMphoto());
			 result=pstmt.executeUpdate();
			} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {pstmtClose();
				}
		
		return result;
	}
	public int MemberLogIn(String mid, String mpassword) {
		String sql="SELECT * FROM MEMBER1 WHERE MID=? AND MPASSWORD=?";
		int result=0;
		try {pstmt=con.prepareStatement(sql);
			 pstmt.setString(1,mid);
			 pstmt.setString(2,mpassword);
			 rs=pstmt.executeQuery();
			 if(rs.next())
			 	{result=1;
			 	}
			 else 
			 	{result=0;
			 	}
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {pstmtClose();
				 rsClose();
				 }
		return result;
	}
	public MemberDTO MemberView(String mid) {
		String sql="SELECT * FROM MEMBER1 WHERE MID=?";
		MemberDTO mdto =new MemberDTO();
		try {pstmt=con.prepareStatement(sql);
			 pstmt.setString(1,mid);
			 rs=pstmt.executeQuery();
			 if(rs.next())
			 	{mdto.setMid(rs.getString("MID"));
			  	 mdto.setMpassword(rs.getString("MPASSWORD"));
			 	 mdto.setMname(rs.getString("MNAME"));
			 	 mdto.setMbirth(rs.getString("MBIRTH"));
			 	 mdto.setMemail(rs.getString("MEMAIL"));
			 	 mdto.setMaddress(rs.getString("MADDRESS"));
			 	 mdto.setMphone(rs.getString("MPHONE"));
			 	 mdto.setMphoto(rs.getString("MPHOTO"));
			 	}
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {pstmtClose();
				 rsClose();
				 }
		return mdto;
	}
	public List<MemberDTO> MemberListAll() {
		String sql="SELECT * FROM MEMBER1";
		List<MemberDTO> mlist = new ArrayList<MemberDTO>();
		MemberDTO mdto =null;
		try {pstmt=con.prepareStatement(sql);
			 rs=pstmt.executeQuery();
			 while(rs.next())
			 	{mdto = new MemberDTO();
				 mdto.setMid(rs.getString("MID"));
				 mdto.setMpassword(rs.getString("MPASSWORD"));
				 mdto.setMname(rs.getString("MNAME"));
				 mdto.setMbirth(rs.getString("MBIRTH"));
				 mdto.setMemail(rs.getString("MEMAIL"));
				 mdto.setMaddress(rs.getString("MADDRESS"));
				 mdto.setMphone(rs.getString("MPHONE"));
				 mdto.setMphoto(rs.getString("MPHOTO"));
				 mlist.add(mdto);
			 	}
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {pstmtClose();
				 rsClose();
		 		}
		return mlist;
	}
	public int MemberDelete(String mid) {
		String sql= "DELETE FROM MEMBER1 WHERE MID=?";
		int result=0;
		try {pstmt=con.prepareStatement(sql);
			 pstmt.setString(1, mid);
			 result=pstmt.executeUpdate();
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {pstmtClose();
				}
		return result;
	}
	public MemberDTO MemberUpdate(String mid) {
		String sql="SELECT * FROM MEMBER1 WHERE MID=?";
		MemberDTO mdto =null;
		try {pstmt=con.prepareStatement(sql);
			 pstmt.setString(1, mid);
			 rs=pstmt.executeQuery();
			 while(rs.next())
			 	{mdto = new MemberDTO();;
				 mdto.setMid(rs.getString("MID"));
				 mdto.setMpassword(rs.getString("MPASSWORD"));
				 mdto.setMname(rs.getString("MNAME"));
				 mdto.setMbirth(rs.getString("MBIRTH"));
				 mdto.setMemail(rs.getString("MEMAIL"));
				 mdto.setMaddress(rs.getString("MADDRESS"));
				 mdto.setMphone(rs.getString("MPHONE"));
				 mdto.setMphoto(rs.getString("MPHOTO"));
			 	}
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {pstmtClose();
				 rsClose();
		 		}
		return mdto;
	}
	public int MemberUpdateProcess(MemberDTO mdto) {
		String sql="UPDATE MEMBER1 SET MPASSWORD=?,MNAME=?,MBIRTH=?,MEMAIL=?,MADDRESS=?,MPHONE=?,MPHOTO=? WHERE MID=?";
		int result=0;
		try {pstmt=con.prepareStatement(sql);
			 pstmt.setString(1, mdto.getMpassword());
			 pstmt.setString(2, mdto.getMname());
			 pstmt.setString(3, mdto.getMbirth());
			 pstmt.setString(4, mdto.getMemail());
			 pstmt.setString(5, mdto.getMaddress());
			 pstmt.setString(6, mdto.getMphone());
			 pstmt.setString(7, mdto.getMphoto());
			 pstmt.setString(8, mdto.getMid());
			 result=pstmt.executeUpdate();
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {pstmtClose();
				}
		return result;
	}
	

}
