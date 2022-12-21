package com.spring.practice04.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.practice04.dao.MemberDAO;
import com.spring.practice04.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Inject
	BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public int register(MemberVO vo) throws Exception {
		if(!vo.getPassword().equals(vo.getPwCheck()))
			return -1;
		if(dao.idCnt(vo.getId())==0) {
			vo.setPassword(passwordEncoder.encode(vo.getPassword()));
			dao.register(vo);
			return 1;
		}
		return 0;
	}

	@Override
	public int login(MemberVO vo) throws Exception {
		MemberVO member = dao.login(vo.getId());
		if(member != null) {
			if(passwordEncoder.matches(vo.getPassword(), member.getPassword()))
				return 1;
		}
		return 0;
	}

	@Override
	public int idCnt(String id) throws Exception {
		return dao.idCnt(id);
	}

}
