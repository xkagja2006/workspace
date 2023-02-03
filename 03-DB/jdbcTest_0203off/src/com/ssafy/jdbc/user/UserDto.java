package com.ssafy.jdbc.user;

public class UserDto {
	private String id;
	private String name;
	private String password;
	private String addr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", password=" + password + ", addr=" + addr + "]";
	}
}
