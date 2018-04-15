package com.railway.labor.career.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.railway.labor.career.model.dto.LoginInfoDTO;

public class BaseController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected  HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	
	public LoginInfoDTO getLoginUser(){
		return (LoginInfoDTO) request.getSession().getAttribute("loginInfo");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
