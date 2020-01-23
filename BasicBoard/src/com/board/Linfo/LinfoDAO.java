package com.board.Linfo;


import java.sql.*;
import java.util.*;

public class LinfoDAO {
	
	public Connection dbConn() {
		
		Connection conn = null;
		
		try {
			//mysql jdbc driver 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//DB연결 문자열
			String url = "jdbc:mysql://182.162.89.92:3306/logon?characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "namusoft";
			String pwd = "namu1234";
			
			//db접속
			conn = DriverManager.getConnection(url,id,pwd);
			System.out.println("DB접속 성공");
			
		}catch(Exception e) {
			
			System.out.println("Db 접속 실패");
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public ArrayList<LinfoDTO> LinfoList(){
		
		ArrayList<LinfoDTO> l_list = new ArrayList<LinfoDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = dbConn();
			
			String sql = "select * from linux_info;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				LinfoDTO dto = new LinfoDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setlName(rs.getString("linux_name"));
				dto.setlIp(rs.getString("linux_ip"));
				dto.setPmAddr(rs.getString("pc_macaddr"));
				dto.setUserCnt(rs.getString("user_cnt"));
				dto.setRegDate(rs.getString("create_dt"));
				//System.out.println(dto.getlName());
				
				l_list.add(dto);
				//System.out.println(l_list);
				
				
			}
			System.out.println(l_list);
			
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return l_list;
		
	}
}
