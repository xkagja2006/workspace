package com.ssafy.day09;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
	private int hour;
	private double temp;
	private String wfKor; // 날씨 상태
	private String wdKor; // 바람 방향

	private int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public String getWfKor() {
		return wfKor;
	}

	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}

	public String getWdKor() {
		return wdKor;
	}

	public void setWdKor(String wdKor) {
		this.wdKor = wdKor;
	}

	@Override
	public String toString() {
		return "Weather [" + hour + "시 : " + temp + "도, " + wfKor + ", " + wdKor + "풍]";
	}

	
}
