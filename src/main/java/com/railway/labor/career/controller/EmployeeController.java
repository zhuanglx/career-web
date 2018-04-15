package com.railway.labor.career.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.career.common.BaseResult;
import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.constant.ErrorConstant;
import com.railway.labor.career.model.dto.EmployeeDTO;
import com.railway.labor.career.model.query.EmployeeQuery;
import com.railway.labor.career.service.EmployeeService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController  extends BaseController{
	@Autowired
	private EmployeeService employeeService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<EmployeeQuery, EmployeeDTO>> list(@RequestBody EmployeeQuery employeeQuery, @RequestBody Integer pageSize, @RequestBody Long pageIndex) {
		BaseResult<Pagination<EmployeeQuery, EmployeeDTO>> baseResult = new BaseResult<>();
		Pagination<EmployeeQuery, EmployeeDTO> pagination = new Pagination<>();
		pagination.setQuery(employeeQuery);
		pagination.setPageIndex(pageIndex);
		pagination.setPageSize(pageSize);
		try {
			pagination = employeeService.query(pagination);
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
	public BaseResult<EmployeeDTO> get(@RequestBody Long id) {
		BaseResult<EmployeeDTO> baseResult = new BaseResult<>();
		EmployeeDTO employeeDTO = null;
		try {
			employeeDTO = employeeService.get(id);
			if (employeeDTO == null) {
				baseResult.setErrorCode(ErrorConstant.USER_NULL_CODE);
				baseResult.setErrorMsg(ErrorConstant.USER_NULL_MSG);
			} else {
				baseResult.setValue(employeeDTO);
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
