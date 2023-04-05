package com.ssafy.paging.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	public static Connection getConnection() throws SQLException, NamingException {
		return ((DataSource) new InitialContext().lookup("java:comp/env/jdbc/paging")).getConnection();
	}
}
