package com.spring.practice04.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.practice04.service.MemberService;
import com.spring.practice04.vo.MemberVO;

@Controller
public class MemberController {
	
	@Inject
	MemberService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("member", new MemberVO());
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("member") @Valid MemberVO member, BindingResult binding,
						   RedirectAttributes rttr, Model model) throws Exception {
		if(binding.hasErrors()) {
			return "register";
		}
		
		int result = service.register(member);
		if(result == 1) {
			rttr.addFlashAttribute("msg", "성공적으로 가입하였습니다!");
			return "redirect:/login";
		}else if(result == -1) {
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "register";
		}else {
			rttr.addFlashAttribute("msg", "이미 가입한 아이디 입니다.");
			return "redirect:/login";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/idChk", method = RequestMethod.POST)
	public int idCheck(@RequestBody String id) throws Exception {	
		String idReg = "^[a-z0-9]{4,20}$";
		Pattern p = Pattern.compile(idReg);
		Matcher m = p.matcher(id);
		if(!m.matches()) return 0;
		
		if(service.idCnt(id) != 0 ) return -1;
		return 1;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pwChk", method = RequestMethod.POST)
	public int pwCheck(@RequestBody String password) throws Exception {
		String pwReg = "^[a-z0-9]{8,30}$";
		Pattern p = Pattern.compile(pwReg);
		Matcher m = p.matcher(password);
		if(!m.matches()) return 0;
		return 1;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session, Model model) {
		if(session.getAttribute("sessionID")!= null) {
			return "redirect:/account/calendar";
		}
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("member") MemberVO vo,
						HttpSession session, RedirectAttributes rttr) throws Exception {
		int chk = service.login(vo);
		
		if(chk == 1) {
			session.setAttribute("sessionID", vo.getId());
			String prev_url = (String) session.getAttribute("prev_url"); //이전 페이지가 있는가?(인터셉터)
			if(prev_url == null) prev_url = "/account/calendar";
			return "redirect:"+prev_url;
		}else {
			rttr.addFlashAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
