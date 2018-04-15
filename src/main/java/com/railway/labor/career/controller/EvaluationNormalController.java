package com.railway.labor.career.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.railway.labor.career.common.BaseResult;
import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.constant.ErrorConstant;
import com.railway.labor.career.model.dto.EvaluationNormalDTO;
import com.railway.labor.career.model.dto.LoginInfoDTO;
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
public class EvaluationNormalController extends BaseController{
	@Autowired
	private EvaluationNormalService evaluationNormalService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<EvaluationNormalQuery, EvaluationNormalDTO>> list(@RequestBody EvaluationNormalQuery evaluationNormalQuery, @RequestBody Integer pageSize, @RequestBody Long pageIndex) {
		BaseResult<Pagination<EvaluationNormalQuery, EvaluationNormalDTO>> baseResult = new BaseResult<>();
		Pagination<EvaluationNormalQuery, EvaluationNormalDTO> pagination = new Pagination<>();
		try {
			pagination = evaluationNormalService.query(pagination);
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
	public BaseResult<EvaluationNormalDTO> get(@RequestBody Long id) {
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
	/**
	 * 添加参评
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "add.json")
	@ResponseBody
	public BaseResult<EvaluationNormalDTO> add(@RequestBody EvaluationNormalDTO evaluationNormalDTO) {
		BaseResult<EvaluationNormalDTO> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = (LoginInfoDTO) request.getSession().getAttribute("loginInfo");
			evaluationNormalDTO.setEvaluateDate(new Date());
			evaluationNormalDTO.setCreator(loginInfo.getId());
			evaluationNormalDTO.setCreateDate(new Date());
			evaluationNormalDTO.setModifier(loginInfo.getId());
			evaluationNormalDTO.setModifyDate(new Date());
			evaluationNormalDTO.setDelFlag("0");
			evaluationNormalService.insert(evaluationNormalDTO);
			baseResult.setValue(evaluationNormalDTO);
			baseResult.setSuccess(true);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorConstant.USER_QUERY_EXCEPTION_CODE);
			baseResult.setErrorMsg(ErrorConstant.USER_QUERY_EXCEPTION_MSG);
		}

		return baseResult;
	}
	/**
	 * 撤销参评信息
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
			EvaluationNormalDTO evaluationNormalDTO = evaluationNormalService.get(id);
			if(evaluationNormalDTO!=null){
				evaluationNormalDTO.setModifier(loginInfo.getId());
				evaluationNormalDTO.setModifyDate(new Date());
				int result = evaluationNormalService.delete(evaluationNormalDTO);
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
	
	/**
	 * 撤销参评信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "importFile.json")
	@ResponseBody
	public BaseResult<Integer> importFile(@RequestParam(value="importFile") MultipartFile importFile) {
		BaseResult<Integer> baseResult = new BaseResult<>();
		try {
			logger.info("importFile={}",importFile==null?"":importFile.getOriginalFilename());
			LoginInfoDTO loginInfo = (LoginInfoDTO) request.getSession().getAttribute("loginInfo");
			
			
			if(importFile!=null){
				int result = evaluationNormalService.importExcel(importFile.getInputStream(), loginInfo);
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
