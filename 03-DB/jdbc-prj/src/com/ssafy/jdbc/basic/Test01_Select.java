package com.ssafy.jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test01_Select {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			StringBuffer sql = new StringBuffer();
			sql.append(" select employee_id, last_name, salary");
			sql.append(" from employees");
			sql.append(" order by salary desc limit 5");
			System.out.println(sql.toString());
			try(
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezon=UTC",
					"ssafy", "ssafy"
					);
					PreparedStatement stmt = con.prepareStatement(sql.toString());
			){
				System.out.println(con);
				ResultSet rs = stmt.executeQuery();	//select
//				stmt.executeUpdate();	//select 이외
				while(rs.next()) {		//데이터가 있으면
					Employee e = new Employee();
					e.setEmployeeId(rs.getInt("employee_id"));
					e.setLastName(rs.getString("last_name"));
					e.setSalary(rs.getDouble("salary"));
					System.out.println(e);
					list.add(e);
				}
				System.out.println(list);
				ObjectMapper mapper = new ObjectMapper();
				try {
					String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
					System.out.println(json);
					
					
					String str = mapper.writeValueAsString(list);
					System.out.println(str);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
