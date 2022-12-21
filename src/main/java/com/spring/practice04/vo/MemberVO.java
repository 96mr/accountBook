package com.spring.practice04.vo;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberVO {
	@NotBlank(message="아이디를 입력해주세요")
	@Pattern(regexp="^[a-zA-z0-9]{4,20}$", message="4~20자리 영문자 또는 숫자로 입력해주세요")
	private String id;
	@NotNull
	@Pattern(regexp="^[a-zA-z0-9]{8,30}$", message="8~30자리 영문자와 숫자를 입력해주세요")
	private String password;
	private String pwCheck;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPwCheck() {
		return pwCheck;
	}
	public void setPwCheck(String pwCheck) {
		this.pwCheck = pwCheck;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", regdate=" + regdate + ", pwCheck="+ pwCheck+"]";
	}
}
