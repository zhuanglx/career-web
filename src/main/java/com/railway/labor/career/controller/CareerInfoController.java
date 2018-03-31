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
import com.railway.labor.career.model.dto.CareerInfoDTO;
import com.railway.labor.career.model.query.CareerInfoQuery;
import com.railway.labor.career.service.CareerInfoService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/careerInfo")
public class CareerInfoController {
	protected static final Logger logger = LoggerFactory.getLogger(CareerInfoController.class);
	@Autowired
	private CareerInfoService careerInfoService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list.json", "" })
	@ResponseBody
	public BaseResult<Pagination<CareerInfoQuery, CareerInfoDTO>> list(CareerInfoQuery careerInfoQuery) {
		BaseResult<Pagination<CareerInfoQuery, CareerInfoDTO>> baseResult = new BaseResult<>();
		Pagination<CareerInfoQuery, CareerInfoDTO> pagination = null;
		try {
			pagination = careerInfoService.query(careerInfoQuery);
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
	@RequestMapping(value = "get.json")
	@ResponseBody
	public BaseResult<CareerInfoDTO> get(Long id) {
		BaseResult<CareerInfoDTO> baseResult = new BaseResult<>();
		CareerInfoDTO careerInfoDTO = null;
		try {
			careerInfoDTO = careerInfoService.get(id);
			if (careerInfoDTO == null) {
				baseResult.setErrorCode(ErrorConstant.USER_NULL_CODE);
				baseResult.setErrorMsg(ErrorConstant.USER_NULL_MSG);
			} else {
				baseResult.setValue(careerInfoDTO);
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
