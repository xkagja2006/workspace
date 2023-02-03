package com.ssafy.jdbc.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class SqlSession {
	private static Properties prop = new Properties();
	
	static {
		try {
			prop.load(new FileReader("db.properties"));
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static int executeUpdate(String sql, Object...args) throws Exception {
		try(
			Connection con = getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);	
		) {
			int parameterIndex = 1;
			for (Object arg : args) {
				stmt.setObject(parameterIndex++, arg);
			}
			return stmt.executeUpdate();
		}		
	}
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				prop.getProperty("url"), prop.getProperty("username"),prop.getProperty("password")
		);
	} 
	public static int insert(String sql, Object...args) throws Exception {
		return executeUpdate(sql, args);		
	} 
	public static int update(String sql, Object...args) throws Exception {
		return executeUpdate(sql, args);
	} 
	public static int delete(String sql, Object...args) throws Exception {
		return executeUpdate(sql, args);	
	} 
}












