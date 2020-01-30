package com.board.dao;

import com.board.vo.*;
import com.board.util.*;

import java.sql.*;
import java.util.*;

public class BoardDAO {

//	private BoardDAO() {
//		
//	}
//	
//	private static BoardDAO instance = new BoardDAO();
//	public static BoardDAO getInstance() {
//		return instance;
//	}
	
	//public List<BoardVO> selectAllBoards() throws SQLException{
	public List<BoardVO> selectAllBoards(){
		
		String sql = "select * from info_table2";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

		while(rs.next()) {
			BoardVO vo = new BoardVO();
			
			vo.setSeq(rs.getInt("seq"));
			vo.setlName(rs.getString("linux_name"));
			vo.setlIp(rs.getString("linux_ip"));
			vo.setPmAddr(rs.getString("pc_macaddr"));
			vo.setFname(rs.getString("fname"));
			vo.setRegDate(rs.getString("create_dt"));
			
			list.add(vo);
			//System.out.println(list);
		}
		System.out.println(list);
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBManager.close(conn,stmt,rs);
	}
	
	return list;
	
	}
	
	public void insertBoard(BoardVO vo) {
		String sql="";
		sql="insert into info_table2(linux_name, linux_ip, pc_macaddr, fname) values(?,?,?,?)";
		//sql="insert into info_table2(linux_name, linux_ip, pc_macaddr, create_dt) values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getlName());
			pstmt.setString(2, vo.getlIp());
			pstmt.setString(3, vo.getPmAddr());
			pstmt.setString(4, vo.getFname()); 
			//pstmt.setString(4, vo.getRegDate());
			
			pstmt.executeUpdate();		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public BoardVO selectOneBoard(int seq) {
		String sql="select * from info_table2 where seq=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		try {
			conn = DBManager.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,seq);
			//pstmt.setInt(1, Integer.parseInt(seq));
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo = new BoardVO();
				
				vo.setSeq(rs.getInt("seq"));
				vo.setlName(rs.getString("linux_name"));
				vo.setlIp(rs.getString("linux_ip"));
				vo.setPmAddr(rs.getString("pc_macaddr"));
				vo.setFname(rs.getString("fname"));

			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		
		return vo;
	}
	
	public void updateBoard(BoardVO vo) {
		
		String sql="update info_table2 set linux_name=?, linux_ip=?, pc_macaddr=? where seq=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			 conn = DBManager.getConnect();
	         pstmt = conn.prepareStatement(sql);
	         //pstmt.setInt(1, Integer.parseInt(seq));
	         
	         pstmt.setString(1, vo.getlName());
			 pstmt.setString(2, vo.getlIp());
			 pstmt.setString(3, vo.getPmAddr());
			 pstmt.setInt(4, vo.getSeq());
	        
			 System.out.println("update�� ���");
			 System.out.println(pstmt);
			 pstmt.executeUpdate();

	         
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void deleteBoard(BoardVO vo) {
		
		String sql = "delete from info_table2 where seq=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSeq());
			
			System.out.println("���� SQL ���� ���");
			System.out.println(pstmt);
			
			pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt);
		}
	}
	
	//public int getBoardCnt(BoardVO vo) {
	public int getBoardCnt() { 
		
		String sql = "SELECT COUNT(*) FROM info_table2;";
		int boardListcnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardListcnt = rs.getInt(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return boardListcnt;
		
	}
	
	public List<BoardVO> getBoardListWithPaging(int pageNum) {
		
		String BOARD_LIST_WITH_PAGING 
		= " SELECT * FROM (SELECT @NO := @NO +1 AS ROWNUM, info_table2.* FROM ( SELECT * FROM info_table2) info_table2, ( SELECT @NO := 0) B) C WHERE C.ROWNUM BETWEEN ? AND ?";
	
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			 conn = DBManager.getConnect();
	         pstmt = conn.prepareStatement(BOARD_LIST_WITH_PAGING);
	         pstmt.setInt(1,  pageNum);
	         pstmt.setInt(2,  pageNum+4);
			 
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	        	 
	        	BoardVO voa = new BoardVO();
	 			voa.setSeq(rs.getInt("seq"));
	 			voa.setlName(rs.getString("linux_name"));
	 			voa.setlIp(rs.getString("linux_ip"));
	 			voa.setPmAddr(rs.getString("pc_macaddr"));
	 			voa.setFname(rs.getString("fname"));
	 			voa.setRegDate(rs.getString("create_dt"));
	 			
	 			boardList.add(voa);
	        	 
	         }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt);
		}
		
		return boardList;
		
		
	}
	
	

}
