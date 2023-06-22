package com.spring.practice04.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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

import com.spring.practice04.service.AccountService;
import com.spring.practice04.vo.InfoVO;

@Controller
public class AccountController {
	
	@Inject
	AccountService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) throws Exception {
		if(session.getAttribute("sessionID")!= null) {
			return "redirect:/account/calendar";
		}
		return "home";
	}
	
	@RequestMapping(value = "/account/calendar", method = RequestMethod.GET)
	public String calendar(HttpServletRequest request, Model model) throws Exception {
		return "/account/calendar";
	}
	
	@RequestMapping(value = "/account/chart", method = RequestMethod.GET)
	public String chart(HttpServletRequest request, Model model) throws Exception {
		return "/account/chart";
	}
	

	@RequestMapping(value = "/account/add", method = RequestMethod.GET)
	public String add(HttpSession session, Model model) throws Exception {
		model.addAttribute("info", new InfoVO());
		model.addAttribute("category",service.categoryList());
		return "/account/add";
	}
	@RequestMapping(value = "/account/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("info") @Valid InfoVO info, BindingResult binding,
						HttpSession session) throws Exception {
		if(binding.hasErrors())
			return "/account/add";
		String id = (String) session.getAttribute("sessionID");
		service.insert(info, id);
		return "redirect:/account/calendar";
	}
	
	@ResponseBody
	@RequestMapping(value = "/account/list", method = RequestMethod.POST)
	public Map<String, Object> list(@RequestBody Map<String, Object> data, HttpSession session) throws Exception {
		String id = (String) session.getAttribute("sessionID");
		Map<String, Object> map = service.list(data, id);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/account/delete", method = RequestMethod.DELETE)
	public String delete(@RequestBody InfoVO vo, HttpSession session) throws Exception {
		String id = (String) session.getAttribute("sessionID");
		service.delete(vo, id);
		return "/account/calendar";
	}
}
