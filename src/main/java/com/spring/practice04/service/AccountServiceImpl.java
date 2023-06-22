package com.spring.practice04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice04.dao.AccountDAO;
import com.spring.practice04.vo.BankVO;
import com.spring.practice04.vo.CategoryVO;
import com.spring.practice04.vo.InfoVO;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO dao;
	
	@Override
	public BankVO bankInfo(String id) throws Exception {
		return dao.memberBankInfo(id);
	}

	@Override
	public void insert(InfoVO vo, String id) throws Exception {
		int bank = dao.memberBankInfo(id).getNo();
		vo.setB_no(bank);
		dao.insert(vo);
		dao.updateTotalAmount(vo);
	}

	@Override
	public List<CategoryVO> categoryList() throws Exception {
		return dao.categoryList();
	}

	@Override
	public Map<String, Object> list(Map<String, Object> data, String id) throws Exception {
		int bank = dao.memberBankInfo(id).getNo();
		data.put("bank", bank);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("amountTotal", dao.selectTotalAmount(data));
		map.put("list", dao.list(data));
		return map;
	}

	@Override
	public void delete(InfoVO vo, String id) throws Exception {
		int bank = dao.memberBankInfo(id).getNo();
		vo.setB_no(bank);
		dao.delete(vo);
		vo.setType(vo.getType().equals("income")?"expend":"income");
		dao.updateTotalAmount(vo);
	}

}
