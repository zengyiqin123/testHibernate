package com.zeng.entity;

public class Users {
	private Integer userid;
	private String loginname;
	private String loginpwd;
	private String sex;
	
	public Users() {
		super();
	}
	public Users(Integer userid, String loginname, String loginpwd, String sex) {
		super();
		this.userid = userid;
		this.loginname = loginname;
		this.loginpwd = loginpwd;
		this.sex = sex;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Users [loginname=" + loginname + ", loginpwd=" + loginpwd + "]";
	}
	

}
