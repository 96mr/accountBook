package com.spring.practice04.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.practice04.mapper.MemberMapper;
import com.spring.practice04.vo.MemberVO;
@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public void register(MemberVO vo) throws Exception {
		mapper.register(vo);
	}

	@Override
	public MemberVO login(String id) throws Exception{
		return mapper.login(id);
	}

	@Override
	public int idCnt(String id) throws Exception {
		return mapper.idCnt(id);
	}

}
