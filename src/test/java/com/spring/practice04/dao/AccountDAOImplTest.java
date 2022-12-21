package com.spring.practice04.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.practice04.vo.InfoVO;
@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})

public class AccountDAOImplTest {

	@Autowired
	private AccountDAO dao;
	
	@Test
	public void testInsert() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Date date = dateFormat.parse("2022-04-23");
		InfoVO vo = new InfoVO(1,4,20000,date,"expend");
		vo.setB_no(0);
		dao.insert(vo);
	}

}
