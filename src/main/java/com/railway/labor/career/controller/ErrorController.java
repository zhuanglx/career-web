package com.railway.labor.career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.career.common.BaseResult;
import com.railway.labor.career.service.UserService;

/**
 * 登录
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
public class ErrorController extends BaseController{
	@Autowired
	private UserService userService;

	@RequestMapping("/error.json")
	@ResponseBody
	BaseResult<String> error(String errorCode) {
		BaseResult<String> baseResult = new  BaseResult<>();
		baseResult.setSuccess(false);
		baseResult.setErrorCode(errorCode);
		//baseResult.setErrorMsg(msg);
		return baseResult;
	}

}
