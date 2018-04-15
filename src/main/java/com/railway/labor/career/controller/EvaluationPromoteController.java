package com.railway.labor.career.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.career.common.BaseResult;
import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.constant.ErrorConstant;
import com.railway.labor.career.model.dto.EvaluationPromoteDTO;
import com.railway.labor.career.model.dto.LoginInfoDTO;
import com.railway.labor.career.model.query.EvaluationPromoteQuery;
import com.railway.labor.career.service.EvaluationPromoteService;

/**
 * 破格
 * 
 * @author zhuanglinxiang
 * 
 */

@Controller
@RequestMapping("/evaluationPromote")
public class EvaluationPromoteController extends BaseController{
	@Autowired
	private EvaluationPromoteService evaluationPromoteService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<EvaluationPromoteQuery, EvaluationPromoteDTO>> list(@RequestBody EvaluationPromoteQuery evaluationPromoteQuery, @RequestBody Integer pageSize, @RequestBody Long pageIndex) {
		BaseResult<Pagination<EvaluationPromoteQuery, EvaluationPromoteDTO>> baseResult = new BaseResult<>();
		Pagination<EvaluationPromoteQuery, EvaluationPromoteDTO> pagination = new Pagination<>();
		pagination.setQuery(evaluationPromoteQuery);
		pagination.setPageIndex(pageIndex);
		pagination.setPageSize(pageSize);
		try {
			pagination = evaluationPromoteService.query(pagination);
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
	
	/**
	 * 提交破格条件
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "add.json")
	@ResponseBody
	public BaseResult<EvaluationPromoteDTO> add(@RequestBody EvaluationPromoteDTO evaluationPromoteDTO) {
		BaseResult<EvaluationPromoteDTO> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = (LoginInfoDTO) request.getSession().getAttribute("loginInfo");
			evaluationPromoteDTO.setEvaluateDate(new Date());
			evaluationPromoteDTO.setCreator(loginInfo.getId());
			evaluationPromoteDTO.setCreateDate(new Date());
			evaluationPromoteDTO.setModifier(loginInfo.getId());
			evaluationPromoteDTO.setModifyDate(new Date());
			evaluationPromoteDTO.setDelFlag("0");
			evaluationPromoteService.insert(evaluationPromoteDTO);
			baseResult.setValue(evaluationPromoteDTO);
			baseResult.setSuccess(true);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorConstant.USER_QUERY_EXCEPTION_CODE);
			baseResult.setErrorMsg(ErrorConstant.USER_QUERY_EXCEPTION_MSG);
		}

		return baseResult;
	}
	
	/**
	 * 撤销破格信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "withdraw.json")
	@ResponseBody
	public BaseResult<Integer> withdraw(@RequestBody Long id) {
		BaseResult<Integer> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = (LoginInfoDTO) request.getSession().getAttribute("loginInfo");
			EvaluationPromoteDTO evaluationPromoteDTO = evaluationPromoteService.get(id);
			if(evaluationPromoteDTO!=null){
				evaluationPromoteDTO.setModifier(loginInfo.getId());
				evaluationPromoteDTO.setModifyDate(new Date());
				int result = evaluationPromoteService.delete(evaluationPromoteDTO);
				if(result>0){
					baseResult.setValue(result);
					baseResult.setSuccess(true);
				}else{
					baseResult.setErrorCode(ErrorConstant.USER_QUERY_EXCEPTION_CODE);
					baseResult.setErrorMsg(ErrorConstant.USER_QUERY_EXCEPTION_MSG);
				}
			}else{
				baseResult.setErrorCode(ErrorConstant.USER_QUERY_EXCEPTION_CODE);
				baseResult.setErrorMsg(ErrorConstant.USER_QUERY_EXCEPTION_MSG);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorConstant.USER_QUERY_EXCEPTION_CODE);
			baseResult.setErrorMsg(ErrorConstant.USER_QUERY_EXCEPTION_MSG);
		}

		return baseResult;
	}
}
