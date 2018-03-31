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
import com.railway.labor.career.model.dto.EvaluationConditionDTO;
import com.railway.labor.career.model.query.EvaluationConditionQuery;
import com.railway.labor.career.service.EvaluationConditionService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/evaluationCondition")
public class EvaluationConditionController {
	protected static final Logger logger = LoggerFactory.getLogger(EvaluationConditionController.class);
	@Autowired
	private EvaluationConditionService evaluationConditionService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<EvaluationConditionQuery, EvaluationConditionDTO>> list(EvaluationConditionQuery evaluationConditionQuery) {
		BaseResult<Pagination<EvaluationConditionQuery, EvaluationConditionDTO>> baseResult = new BaseResult<>();
		Pagination<EvaluationConditionQuery, EvaluationConditionDTO> pagination = null;
		try {
			pagination = evaluationConditionService.query(evaluationConditionQuery);
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
	public BaseResult<EvaluationConditionDTO> get(Long id) {
		BaseResult<EvaluationConditionDTO> baseResult = new BaseResult<>();
		EvaluationConditionDTO evaluationConditionDTO = null;
		try {
			evaluationConditionDTO = evaluationConditionService.get(id);
			if (evaluationConditionDTO == null) {
				baseResult.setErrorCode(ErrorConstant.USER_NULL_CODE);
				baseResult.setErrorMsg(ErrorConstant.USER_NULL_MSG);
			} else {
				baseResult.setValue(evaluationConditionDTO);
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
