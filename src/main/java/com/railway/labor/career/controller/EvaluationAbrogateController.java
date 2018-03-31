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
import com.railway.labor.career.model.dto.EvaluationAbrogateDTO;
import com.railway.labor.career.model.query.EvaluationAbrogateQuery;
import com.railway.labor.career.service.EvaluationAbrogateService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/evaluationAbrogate")
public class EvaluationAbrogateController {
	protected static final Logger logger = LoggerFactory.getLogger(EvaluationAbrogateController.class);
	@Autowired
	private EvaluationAbrogateService evaluationAbrogateService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO>> list(EvaluationAbrogateQuery evaluationAbrogateQuery) {
		BaseResult<Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO>> baseResult = new BaseResult<>();
		Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO> pagination = null;
		try {
			pagination = evaluationAbrogateService.query(evaluationAbrogateQuery);
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
	public BaseResult<EvaluationAbrogateDTO> get(Long id) {
		BaseResult<EvaluationAbrogateDTO> baseResult = new BaseResult<>();
		EvaluationAbrogateDTO evaluationAbrogateDTO = null;
		try {
			evaluationAbrogateDTO = evaluationAbrogateService.get(id);
			if (evaluationAbrogateDTO == null) {
				baseResult.setErrorCode(ErrorConstant.USER_NULL_CODE);
				baseResult.setErrorMsg(ErrorConstant.USER_NULL_MSG);
			} else {
				baseResult.setValue(evaluationAbrogateDTO);
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
