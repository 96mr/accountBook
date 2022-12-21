package com.spring.practice04.service;

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
public class MemberServiceImplTest {

	@Autowired
	private MemberService service;
	@Test
	public void testLogin() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setId("");
		vo.setPassword("");
		int i  = service.login(vo);
		System.out.println(i);
	}

}
