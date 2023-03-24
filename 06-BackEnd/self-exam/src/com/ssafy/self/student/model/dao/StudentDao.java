package com.ssafy.self.student.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.self.student.model.Student;

public interface StudentDao {
	List<Student> selectStudent() throws SQLException;
	Student selectStudentByNo(int no) throws SQLException;
	void insertStudent(Student student) throws SQLException;
	void deleteStudent(int no) throws SQLException;
	
}
