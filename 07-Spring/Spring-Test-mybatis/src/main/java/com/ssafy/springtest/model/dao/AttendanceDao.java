package com.ssafy.springtest.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.springtest.model.Attendance;
import com.ssafy.springtest.model.User;

public interface AttendanceDao {
	List<Attendance> selectAttendance(User user) throws SQLException;
	void deleteAttendance(String ano) throws SQLException;
	void insertAttendance(Attendance attendance) throws SQLException;
	Attendance selectAttendanceByPK(String ano) throws SQLException;
}
