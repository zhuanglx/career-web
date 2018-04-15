package com.railway.labor.career.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.career.common.BaseResult;
import com.railway.labor.career.model.dto.LoginInfoDTO;
import com.railway.labor.career.model.query.LoginInfoQuery;
import com.railway.labor.career.service.UserService;

/**
 * 登录
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
public class LoginController extends BaseController{
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	@ResponseBody
	BaseResult<String> home() {
		BaseResult<String> baseResult = new BaseResult<>();
		baseResult.setSuccess(false);
		baseResult.setErrorCode("0001");
		baseResult.setErrorMsg("请登录");
		return baseResult;
	}

	@RequestMapping("/login.json")
	@ResponseBody
	BaseResult<LoginInfoDTO> login(@RequestBody LoginInfoQuery loginInfoQuery) {
		BaseResult<LoginInfoDTO> baseResult = new BaseResult<>();
		baseResult.setSuccess(false);
		if(loginInfoQuery==null|| StringUtils.isBlank(loginInfoQuery.getAccount())){
			baseResult.setErrorCode("0001");
			baseResult.setErrorMsg("请登录");
			return baseResult;
		}
		LoginInfoDTO loginInfo = null;
		try {
			loginInfo = userService.login(loginInfoQuery.getAccount(),
					loginInfoQuery.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		if (loginInfo != null) {
			request.getSession().setAttribute("loginInfo", loginInfo);
			baseResult.setSuccess(true);
			baseResult.setValue(loginInfo);
		}
		return baseResult;
	}

	@RequestMapping("/logout.json")
	@ResponseBody
	Object logout() {
		BaseResult<Long> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = (LoginInfoDTO) request.getSession().getAttribute("loginInfo");
			if(loginInfo!=null){
				request.getSession().removeAttribute("loginInfo");
				baseResult.setValue(loginInfo.getEmployeeId());
				baseResult.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return baseResult;
	}
}
