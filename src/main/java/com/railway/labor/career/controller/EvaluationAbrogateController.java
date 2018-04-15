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
import com.railway.labor.career.model.dto.EvaluationAbrogateDTO;
import com.railway.labor.career.model.dto.LoginInfoDTO;
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
public class EvaluationAbrogateController  extends BaseController{
	@Autowired
	private EvaluationAbrogateService evaluationAbrogateService;

	/**
	 * 不参评
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list", "" })
	@ResponseBody
	public BaseResult<Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO>> list(@RequestBody EvaluationAbrogateQuery evaluationAbrogateQuery, @RequestBody Integer pageSize, @RequestBody Long pageIndex) {
		BaseResult<Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO>> baseResult = new BaseResult<>();
		Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO> pagination = new Pagination<>();
		pagination.setQuery(evaluationAbrogateQuery);
		pagination.setPageIndex(pageIndex);
		pagination.setPageSize(pageSize);
		try {
			pagination = evaluationAbrogateService.query(pagination);
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
	 * 添加不参评
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "add.json")
	@ResponseBody
	public BaseResult<EvaluationAbrogateDTO> add(@RequestBody EvaluationAbrogateDTO evaluationAbrogateDTO) {
		response.setHeader("Access-Control-Allow-Origin","*");
		BaseResult<EvaluationAbrogateDTO> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = (LoginInfoDTO) request.getSession().getAttribute("loginInfo");
			evaluationAbrogateDTO.setEvaluateDate(new Date());
			evaluationAbrogateDTO.setCreator(loginInfo.getId());
			evaluationAbrogateDTO.setCreateDate(new Date());
			evaluationAbrogateDTO.setModifier(loginInfo.getId());
			evaluationAbrogateDTO.setModifyDate(new Date());
			evaluationAbrogateDTO.setDelFlag("0");
			evaluationAbrogateService.insert(evaluationAbrogateDTO);
			baseResult.setValue(evaluationAbrogateDTO);
			baseResult.setSuccess(true);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorConstant.USER_QUERY_EXCEPTION_CODE);
			baseResult.setErrorMsg(ErrorConstant.USER_QUERY_EXCEPTION_MSG);
		}

		return baseResult;
	}
	
	/**
	 * 撤销不参评信息
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
			EvaluationAbrogateDTO evaluationAbrogateDTO = evaluationAbrogateService.get(id);
			if(evaluationAbrogateDTO!=null){
				evaluationAbrogateDTO.setModifier(loginInfo.getId());
				evaluationAbrogateDTO.setModifyDate(new Date());
				int result = evaluationAbrogateService.delete(evaluationAbrogateDTO);
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
