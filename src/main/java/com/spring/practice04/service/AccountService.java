package com.spring.practice04.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.spring.practice04.vo.BankVO;
import com.spring.practice04.vo.CategoryVO;
import com.spring.practice04.vo.InfoVO;

public interface AccountService {
	public BankVO bankInfo(String id) throws Exception;
	public void insert(InfoVO vo, HttpSession session) throws Exception;
 	public List<CategoryVO> categoryList() throws Exception;
 	public Map<String, Object> list(Map<String, Object> data, String id) throws Exception;
	public void delete(InfoVO vo, String id) throws Exception;
}
