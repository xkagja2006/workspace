package com.ssafy.springtest.model;

public class User {
	private String userid;
	private String userpw;
	private String position;
	private String name;
	private String rname;
	private int rclass;
	
	public User(String userid, String userpw, String position, String name, String rname, int rclass) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.position = position;
		this.name = name;
		this.rname = rname;
		this.rclass = rclass;
	}


	public User() {
		super();
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getRclass() {
		return rclass;
	}
	public void setRclass(int rclass) {
		this.rclass = rclass;
	}
	@Override
	public String toString() {
		return "UserInfoDto [userid=" + userid + ", userpw=" + userpw + ", position=" + position + ", name=" + name
				+ ", rname=" + rname + ", rclass=" + rclass + "]";
	}
	
	
	
}
