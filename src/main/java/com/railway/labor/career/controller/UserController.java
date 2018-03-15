package com.railway.labor.career.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.career.common.BaseResult;
import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.UserDTO;
import com.railway.labor.career.model.query.UserQuery;
/**
 * 用户
 * @author zhuanglinxiang
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<UserQuery,UserDTO>> list() {
		Pagination<UserQuery,UserDTO> pagination = new Pagination<UserQuery,UserDTO>();
		BaseResult<Pagination<UserQuery,UserDTO>> baseResult = new BaseResult<Pagination<UserQuery,UserDTO>>();
		baseResult.setSuccess(true);
		baseResult.setValue(pagination);
		return baseResult;
	}
}
