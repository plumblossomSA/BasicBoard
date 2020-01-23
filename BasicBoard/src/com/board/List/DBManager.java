package com.board.List;

import java.sql.Connection;
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;

public class DBManager {
	
	public static Connection getConnect() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("testsa");
			
			conn = ds.getConnection();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
