package jdbctest_0203.com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public ConnectionTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("실패!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		Connection conn = ct.getConnection();
		if(conn != null)
				System.out.println("DB연결 성공!");
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimeAone=UTC","ssafy","ssafy");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
