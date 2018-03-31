package com.railway.labor.career.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.career.common.BaseResult;
import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.constant.ErrorConstant;
import com.railway.labor.career.model.dto.PermissionDTO;
import com.railway.labor.career.model.query.PermissionQuery;
import com.railway.labor.career.service.PermissionService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
	protected static final Logger logger = LoggerFactory.getLogger(PermissionController.class);
	@Autowired
	private PermissionService permissionService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<PermissionQuery, PermissionDTO>> list(PermissionQuery permissionQuery) {
		BaseResult<Pagination<PermissionQuery, PermissionDTO>> baseResult = new BaseResult<>();
		Pagination<PermissionQuery, PermissionDTO> pagination = null;
		try {
			pagination = permissionService.query(permissionQuery);
			if(pagination==null){
				baseResult.setErrorCode(ErrorConstant.USER_NULL_CODE);
				baseResult.setErrorMsg(ErrorConstant.USER_NULL_MSG);
			}else{
				baseResult.setSuccess(true);
				baseResult.setValue(pagination);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorConstant.USER_QUERY_EXCEPTION_CODE);
			baseResult.setErrorMsg(ErrorConstant.USER_QUERY_EXCEPTION_MSG);
		}
	
		return baseResult;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "get")
	@ResponseBody
	public BaseResult<PermissionDTO> get(Long id) {
		BaseResult<PermissionDTO> baseResult = new BaseResult<>();
		PermissionDTO permissionDTO = null;
		try {
			permissionDTO = permissionService.get(id);
			if (permissionDTO == null) {
				baseResult.setErrorCode(ErrorConstant.USER_NULL_CODE);
				baseResult.setErrorMsg(ErrorConstant.USER_NULL_MSG);
			} else {
				baseResult.setValue(permissionDTO);
				baseResult.setSuccess(true);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorConstant.USER_QUERY_EXCEPTION_CODE);
			baseResult.setErrorMsg(ErrorConstant.USER_QUERY_EXCEPTION_MSG);
		}

		return baseResult;
	}
}
