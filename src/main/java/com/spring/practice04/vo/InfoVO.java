package com.spring.practice04.vo;

import java.util.Date;

import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InfoVO {
	private int no;
	private int b_no;
	private int p_no;
	@Min(value=1)
	private int c_no;
	@Min(value=1, message="금액을 입력해주세요")
	private int amount;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date regdate;
	private String type;
	private CategoryVO categoryList;
	
	public InfoVO() {
		
	}
	
	public InfoVO(int p_no, int c_no, int amount, Date regdate, String type) {
		super();
		this.p_no = p_no;
		this.c_no = c_no;
		this.amount = amount;
		this.regdate = regdate;
		this.type = type;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no= c_no;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public CategoryVO getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(CategoryVO categoryList) {
		this.categoryList = categoryList;
	}

	@Override
	public String toString() {
		return "InfoVO [no=" + no + ", b_no=" + b_no + ", p_no=" + p_no + ", c_no=" + c_no + ", amount=" + amount
				+ ", regdate=" + regdate + ", type=" + type + "]";
	}
	
}
