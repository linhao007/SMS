package jxau.linhu.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import jxau.linhu.exception.DBException;

public class DBUtil {
	
	public static Connection getConn(){
		Connection conn = null;
		Properties prop = new Properties(); 
		try {
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream(
					"db.properties");
	    prop.load(in); 
		String driverClassName = prop.getProperty("driverClassName");
		Class.forName(driverClassName);
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		conn = DriverManager
					.getConnection(url,username,password);
		System.out.println("获得连接");
		} catch (Exception e) {
			try {
				throw new DBException("数据库连接错误");
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return conn;
	}
	
	public static void closeConn(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeStmt(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeRs(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
