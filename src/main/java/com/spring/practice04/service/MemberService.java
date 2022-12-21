package com.spring.practice04.service;

import com.spring.practice04.vo.MemberVO;

public interface MemberService {
	public int register(MemberVO vo) throws Exception;
	public int login(MemberVO vo) throws Exception;
	public int idCnt(String id) throws Exception;
}
