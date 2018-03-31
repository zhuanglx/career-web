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
import com.railway.labor.career.model.dto.SysDictDTO;
import com.railway.labor.career.model.query.SysDictQuery;
import com.railway.labor.career.service.SysDictService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/sysDict")
public class SysDictController {
	protected static final Logger logger = LoggerFactory.getLogger(SysDictController.class);
	@Autowired
	private SysDictService sysDictService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<SysDictQuery, SysDictDTO>> list(SysDictQuery sysDictQuery) {
		BaseResult<Pagination<SysDictQuery, SysDictDTO>> baseResult = new BaseResult<>();
		Pagination<SysDictQuery, SysDictDTO> pagination = null;
		try {
			pagination = sysDictService.query(sysDictQuery);
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
	public BaseResult<SysDictDTO> get(Long id) {
		BaseResult<SysDictDTO> baseResult = new BaseResult<>();
		SysDictDTO sysDictDTO = null;
		try {
			sysDictDTO = sysDictService.get(id);
			if (sysDictDTO == null) {
				baseResult.setErrorCode(ErrorConstant.USER_NULL_CODE);
				baseResult.setErrorMsg(ErrorConstant.USER_NULL_MSG);
			} else {
				baseResult.setValue(sysDictDTO);
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
