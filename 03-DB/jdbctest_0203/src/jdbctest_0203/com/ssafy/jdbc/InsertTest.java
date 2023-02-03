package jdbctest_0203.com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	public InsertTest() {
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
		InsertTest it = new InsertTest();
		int cnt = it.register("안효인", 28);
		if(cnt != 0)
			System.out.println("성공");
		else
			System.out.println("실패");
		
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimeAone=UTC","ssafy","ssafy");
	}
	
	private int register(String name, int age) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;		//반납하는 방법 -> finally 또는 try를 통한 오토클로즈
		try {
			//DB연결
			conn = getConnection();
			//SQL 실행 준비
			StringBuilder sql = new StringBuilder("insert into jdbctest (name, age) ");
			sql.append("values (?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			//SQL 실행
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return cnt;
	}
	
}
