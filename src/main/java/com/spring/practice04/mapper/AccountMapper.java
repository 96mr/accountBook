package com.spring.practice04.mapper;

import java.util.List;
import java.util.Map;

import com.spring.practice04.vo.BankVO;
import com.spring.practice04.vo.CategoryVO;
import com.spring.practice04.vo.InfoVO;

public interface AccountMapper {
	public BankVO memberBankInfo(String id);
	public void insert(InfoVO vo);
	public List<InfoVO> list(Map<String, Object> data);
	public List<CategoryVO> categoryList();
	public void updateTotalAmount(InfoVO vo);
	public Map<String, Integer> selectTotalAmount(Map<String, Object> data);
	public void delete(InfoVO vo);
}
