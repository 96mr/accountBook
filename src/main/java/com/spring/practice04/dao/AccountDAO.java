package com.spring.practice04.dao;

import java.util.List;
import java.util.Map;

import com.spring.practice04.vo.BankVO;
import com.spring.practice04.vo.CategoryVO;
import com.spring.practice04.vo.InfoVO;

public interface AccountDAO {
	public BankVO memberBankInfo(String id) throws Exception;
	public List<CategoryVO> categoryList() throws Exception;
	public void insert(InfoVO vo) throws Exception;
	public List<InfoVO> list(Map<String, Object> data) throws Exception;
	public void delete(InfoVO vo) throws Exception;
	public void updateTotalAmount(InfoVO vo) throws Exception;
	public Map<String, Integer> selectTotalAmount(Map<String, Object> data) throws Exception;
}
