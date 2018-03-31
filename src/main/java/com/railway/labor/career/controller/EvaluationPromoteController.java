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
import com.railway.labor.career.model.dto.EvaluationPromoteDTO;
import com.railway.labor.career.model.query.EvaluationPromoteQuery;
import com.railway.labor.career.service.EvaluationPromoteService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */

@Controller
@RequestMapping("/evaluationPromote")
public class EvaluationPromoteController {
	protected static final Logger logger = LoggerFactory.getLogger(EvaluationPromoteController.class);
	@Autowired
	private EvaluationPromoteService evaluationPromoteService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<EvaluationPromoteQuery, EvaluationPromoteDTO>> list(EvaluationPromoteQuery evaluationPromoteQuery) {
		BaseResult<Pagination<EvaluationPromoteQuery, EvaluationPromoteDTO>> baseResult = new BaseResult<>();
		Pagination<EvaluationPromoteQuery, EvaluationPromoteDTO> pagination = null;
		try {
			pagination = evaluationPromoteService.query(evaluationPromoteQuery);
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
	public BaseResult<EvaluationPromoteDTO> get(Long id) {
		BaseResult<EvaluationPromoteDTO> baseResult = new BaseResult<>();
		EvaluationPromoteDTO evaluationPromoteDTO = null;
		try {
			evaluationPromoteDTO = evaluationPromoteService.get(id);
			if (evaluationPromoteDTO == null) {
				baseResult.setErrorCode(ErrorConstant.USER_NULL_CODE);
				baseResult.setErrorMsg(ErrorConstant.USER_NULL_MSG);
			} else {
				baseResult.setValue(evaluationPromoteDTO);
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
