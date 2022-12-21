package com.spring.practice04.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.practice04.mapper.AccountMapper;
import com.spring.practice04.vo.BankVO;
import com.spring.practice04.vo.CategoryVO;
import com.spring.practice04.vo.InfoVO;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private AccountMapper mapper;
	
	@Override
	public BankVO memberBankInfo(String id) throws Exception {
		return mapper.memberBankInfo(id);
	}

	@Override
	public List<CategoryVO> categoryList() throws Exception {
		return mapper.categoryList();
	}

	@Override
	public void insert(InfoVO vo) throws Exception {
		mapper.insert(vo);
	}

	@Override
	public List<InfoVO> list(Map<String, Object> data) throws Exception {
		return mapper.list(data);
	}

	@Override
	public void delete(InfoVO vo) throws Exception{
		mapper.delete(vo);
	}

	@Override
	public void updateTotalAmount(InfoVO vo) throws Exception {
		mapper.updateTotalAmount(vo);
	}

	@Override
	public Map<String, Integer> selectTotalAmount(Map<String, Object> data) throws Exception {
		return mapper.selectTotalAmount(data);
	}
}
