package com.login.dao;

import com.board.util.*;
import com.login.vo.*;
import com.sun.corba.se.impl.ior.GenericTaggedComponent;

import java.sql.*;

public class MemberDAO {

	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	static public MemberDAO getInstance() {
		return instance;
	}

	public int userCheck(String id, String pw) {
		
		System.out.println("함수에 값이 잘 넘어왔는지 확인");
		System.out.println(id);
		System.out.println(pw);
		
		int result = -1;
		String sql = "select user_pw from user_info where user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			System.out.println(pstmt);
			//pstmt.setString(1, vo.getlName());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("user_pw") != null && rs.getString("user_pw").equals(pw)) {
					result = 1;
				} else {
					result = 0;
				}
			}else {
				result = -1;
			}
			
		} catch (Exception e) {

		} finally {
			DBManager.close(conn, pstmt,rs);
		}
		return result;
	}
	
	public MemberVO getMember(String userid) {
		
		MemberVO vo = null;
		
		String sql="";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
		}catch(Exception e) {
			
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		
		return vo;
		
	}
	
	public int confirmID(String userid) {
		
		System.out.println("confirmID dao");
		int result=-1;
		String sql ="select user_id from user_info where user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  userid);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}else {
				result = -1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt,rs);
		}
		
		return result;
	}
	
	public int insertMember(MemberVO vo) {
		
		int result = 0;
		String sql ="insert into values (?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  vo.getUname());
			pstmt.setString(2,  vo.getUid());
			pstmt.setString(3, vo.getUpw());
			pstmt.setString(4, vo.getUemail());
			pstmt.setString(5,  vo.getUmobile());
			pstmt.setInt(6,  vo.getAdmin());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return result;
	}
	
	

}
