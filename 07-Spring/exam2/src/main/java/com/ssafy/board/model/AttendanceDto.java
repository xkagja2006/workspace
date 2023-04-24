package com.ssafy.board.model;

import com.ssafy.member.model.MemberDto;

public class AttendanceDto {
	private String ano;
	private String userid;
	private String issuedate;
	private String issue;
	//상세 정보에서 필요한 유저 정보를 담기 위한 UserInfo
	private MemberDto userInfo;
	
	public AttendanceDto() {
		
	}

	public AttendanceDto(String ano, String userid, String issuedate, String issue, MemberDto userInfo) {
		super();
		this.ano = ano;
		this.userid = userid;
		this.issuedate = issuedate;
		this.issue = issue;
		this.userInfo = userInfo;
	}
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public MemberDto getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(MemberDto userInfo) {
		this.userInfo = userInfo;
	}
	@Override
	public String toString() {
		return "AttendanceDto [ano=" + ano + ", userid=" + userid + ", issuedate=" + issuedate + ", issue=" + issue
				+ ", userInfo=" + userInfo + "]";
	}
	
	
}
