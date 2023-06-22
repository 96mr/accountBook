package com.spring.practice04.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String exception404(NoHandlerFoundException e, Model model) {
		model.addAttribute("exception", e);
		return "error";
	}
	
	@ExceptionHandler(DataAccessException.class)
	public String dataException(DataAccessException e, Model model) {
		model.addAttribute("exception", e);
		return "error";
	}
	
	//500 에러 처리
	@ExceptionHandler(Exception.class)
	public String exception(Exception e, Model model) {
		model.addAttribute("exception", e);
		return "error";
	}
}
