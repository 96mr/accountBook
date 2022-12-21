package com.spring.practice04.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.practice04.vo.MemberVO;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class MemberDAOImplTest {
	
	@Autowired
	private MemberDAO dao;

	@Test
	public void testLogin() throws Exception {
		MemberVO v = new MemberVO();
		v.setId("example");
		v.setPassword("qwer1234");
		MemberVO vo = dao.login(v.getId());
		System.out.println(vo.getId());
		assertEquals(vo.getId(), "example");
	}

}
