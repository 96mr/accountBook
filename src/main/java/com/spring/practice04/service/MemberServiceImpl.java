package com.spring.practice04.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public int regexId(String id) throws Exception{
		String idReg = "^[a-z0-9]{4,20}$";
		Pattern p = Pattern.compile(idReg);
		Matcher m = p.matcher(id);
		if(!m.matches()) return 0;
		
		if(dao.idCnt(id) != 0 ) return -1;
		return 1;
	}
	
	@Override
	public int regexPassword(String password) throws Exception{
		String pwReg = "^[a-z0-9]{8,30}$";
		Pattern p = Pattern.compile(pwReg);
		Matcher m = p.matcher(password);
		if(!m.matches()) return 0;
		return 1;
	}
}
