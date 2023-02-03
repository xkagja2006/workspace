package jdbctest_0203.com.ssafy.jdbc;

public class DriverLoadingTest {
	
	public DriverLoadingTest() {
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
		new DriverLoadingTest();
	}
}
