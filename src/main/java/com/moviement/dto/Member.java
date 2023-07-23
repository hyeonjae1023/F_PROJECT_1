package com.moviement.dto;

import java.util.Map;

public class Member extends Dto {
	public String loginId;
	public String loginPw;
	public String name;
	public String Email;
	public String nickName;
	

	public Member(Map<String, Object> row) {
		super(row);
		this.loginId = (String) row.get("loginId");
		this.loginPw = (String) row.get("loginPw");
		this.name = (String) row.get("name");
		this.Email = (String) row.get("Email");
		this.nickName = (String) row.get("nickName");
	}

	public Member(String loginId, String Email, String nickName, String loginPw, String name) {
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.name = name;
		this.Email = Email;
		this.nickName = nickName;
	}
}