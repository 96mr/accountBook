package com.spring.practice04.mapper;

import com.spring.practice04.vo.MemberVO;

public interface MemberMapper {
	public void register(MemberVO vo);
	public MemberVO login(String id);
	public int idCnt(String id);
}
