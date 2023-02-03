package com.ssafy.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test02Update {
	public Test02Update() throws ClassNotFoundException {
		// 라이브러리의 jar파일 주소
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	private void insert() throws SQLException {
		String name = "싸피";
		String content = "자바를 이용한 데이터베이스 연결";
		StringBuffer sql = new StringBuffer();
		sql.append("insert into tb_test( ");
		sql.append("	name, content ");
		sql.append(") values ( ");
		sql.append("	?, ? ");
		sql.append(") ");
		System.out.println(sql);

		try (
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb", "ssafy","ssafy");
				PreparedStatement stmt = con.prepareStatement(sql.toString());
		) {
			// SQL 문장을 실행하기 전에 ? 에 들어갈 값을 설정한다.
			stmt.setString(1, name);
			stmt.setString(2, content);
			
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + "개의 행이 추가되었습니다.");
		}
	}

	private void delete() throws SQLException {
		int no = 1;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from tb_test ");
		sql.append("where ");
		sql.append("no = ? ");
		System.out.println(sql);
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb", "ssafy","ssafy"
						);
				PreparedStatement stmt = con.prepareStatement(sql.toString());
				){
			
			stmt.setInt(1, no);
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + "개의 행이 삭제되었습니다.");
			
		}
		
	}

	private void update() throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("update tb_test ");
		sql.append("	set content = ? ");
		sql.append("where no = ? ");
		try(	//자동close를 위해 try()안에 넣어준다.
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/ssafydb","ssafy","ssafy"
						);
				PreparedStatement stmt = con.prepareStatement(sql.toString());
				){
			int parameterIndex = 1;
			stmt.setString(parameterIndex++,"변경된 자바 JDBC 연습2" );
			stmt.setInt(parameterIndex++,2 );
			int cnt = stmt.executeUpdate();
			System.out.println(cnt + "개의 행이 변경되었습니다.");
		}
	}

	public static void main(String[] args) {
		Test02Update t;
		try {
			t = new Test02Update();
//			t.insert();
			t.update();
//			t.delete();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
