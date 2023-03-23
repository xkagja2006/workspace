package com.ssafy.self.student.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.self.student.model.Student;

public class StudentDaoImpl implements StudentDao{
	private static StudentDao instance = new StudentDaoImpl();
	private StudentDaoImpl() {};
	public static StudentDao getInstance() {
		return instance;
	}

	@Override
	public List<Student> selectStudent() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student selectStudentByNo(int no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(int no) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
