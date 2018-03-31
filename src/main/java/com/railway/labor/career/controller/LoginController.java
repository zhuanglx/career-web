package com.railway.labor.career.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.career.common.BaseResult;
import com.railway.labor.career.model.dto.LoginInfoDTO;
import com.railway.labor.career.service.UserService;

/**
 * 登录
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
public class LoginController {
	protected static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "/login";
	}

	@RequestMapping("/login")
	@ResponseBody
	BaseResult<LoginInfoDTO> login(LoginInfoDTO loginInfoDTO,
			HttpServletRequest request) {
		LoginInfoDTO loginInfo = null;
		try {
			loginInfo = userService.login(loginInfoDTO.getAccount(),
					loginInfoDTO.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		if (loginInfo != null) {
			request.getSession().setAttribute("loginInfo", loginInfo);
		}
		BaseResult<LoginInfoDTO> baseResult = new BaseResult<>();
		baseResult.setSuccess(true);
		baseResult.setValue(loginInfo);
		return baseResult;
	}

	@RequestMapping("/logout")
	@ResponseBody
	Object logout(HttpServletRequest request, HttpServletResponse response) {
		BaseResult<Long> baseResult = new BaseResult<>();
		baseResult.setSuccess(true);
		baseResult.setValue(12L);
		return baseResult;
	}
}
