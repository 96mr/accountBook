package com.spring.practice04.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.practice04.vo.CategoryVO;
import com.spring.practice04.vo.InfoVO;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class AccountServiceImplTest {

	@Autowired
	AccountService service;
	
	@Test
	public void testBankInfo() throws Exception {
		System.out.println(service.bankInfo("example").getNo());
	}

	@Test
	public void testInsert() {
		
	}

	@Test
	public void testCategoryList() throws Exception {
		List<CategoryVO> list = service.categoryList();
		System.out.println(list.get(1).getName());
	}
	
	public void testList() throws Exception {
		
	}

}
