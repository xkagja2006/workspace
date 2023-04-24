package com.ssafy.springtest.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.springtest.model.Attendance;
import com.ssafy.springtest.model.User;
import com.ssafy.springtest.model.dao.AttendanceDao;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	private final AttendanceDao attendanceDao;
	public AttendanceServiceImpl(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}
	@Override
	public List<Attendance> list(User user) throws Exception {
		return attendanceDao.selectAttendance(user);
	}
	
	@Override
	public void multiDelete(List<String> anoList) throws Exception {
		for (String ano : anoList) {
			attendanceDao.deleteAttendance(ano);
		}
	}
	@Override
	public void regist(Attendance attendance) throws Exception {
		attendanceDao.insertAttendance(attendance);
	}
	@Override
	public Attendance detail(String ano) throws Exception {
		return attendanceDao.selectAttendanceByPK(ano);
	}
}








