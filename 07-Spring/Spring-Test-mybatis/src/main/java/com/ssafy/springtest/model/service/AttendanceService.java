package com.ssafy.springtest.model.service;

import java.util.List;

import com.ssafy.springtest.model.Attendance;
import com.ssafy.springtest.model.User;

public interface AttendanceService {
	List<Attendance> list(User user) throws Exception;
	void multiDelete(List<String> anoList) throws Exception;
	void regist(Attendance attendance) throws Exception;
	Attendance detail(String ano) throws Exception;
}
