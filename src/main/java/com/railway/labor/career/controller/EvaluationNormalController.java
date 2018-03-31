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
import com.railway.labor.career.model.dto.EvaluationNormalDTO;
import com.railway.labor.career.model.query.EvaluationNormalQuery;
import com.railway.labor.career.service.EvaluationNormalService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/evaluationNormal")
public class EvaluationNormalController {
	protected static final Logger logger = LoggerFactory.getLogger(EvaluationNormalController.class);
	@Autowired
	private EvaluationNormalService evaluationNormalService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<EvaluationNormalQuery, EvaluationNormalDTO>> list(EvaluationNormalQuery evaluationNormalQuery) {
		BaseResult<Pagination<EvaluationNormalQuery, EvaluationNormalDTO>> baseResult = new BaseResult<>();
		Pagination<EvaluationNormalQuery, EvaluationNormalDTO> pagination = null;
		try {
			pagination = evaluationNormalService.query(evaluationNormalQuery);
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
	public BaseResult<EvaluationNormalDTO> get(Long id) {
		BaseResult<EvaluationNormalDTO> baseResult = new BaseResult<>();
		EvaluationNormalDTO evaluationNormalDTO = null;
		try {
			evaluationNormalDTO = evaluationNormalService.get(id);
			if (evaluationNormalDTO == null) {
				baseResult.setErrorCode(ErrorConstant.USER_NULL_CODE);
				baseResult.setErrorMsg(ErrorConstant.USER_NULL_MSG);
			} else {
				baseResult.setValue(evaluationNormalDTO);
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
