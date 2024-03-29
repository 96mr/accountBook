package com.spring.practice04.service;

import com.spring.practice04.vo.MemberVO;

public interface MemberService {
	public int register(MemberVO vo) throws Exception;
	public int login(MemberVO vo) throws Exception;
	public int regexId(String id) throws Exception;
	public int regexPassword(String password) throws Exception;
}
