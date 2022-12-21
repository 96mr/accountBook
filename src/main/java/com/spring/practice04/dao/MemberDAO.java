package com.spring.practice04.dao;

import com.spring.practice04.vo.MemberVO;

public interface MemberDAO {
	public void register(MemberVO vo) throws Exception;
	public MemberVO login(String id) throws Exception;
	public int idCnt(String id) throws Exception;
}
