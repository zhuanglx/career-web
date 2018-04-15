package com.railway.labor.career.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railway.labor.career.common.BaseResult;
import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.constant.ErrorConstant;
import com.railway.labor.career.model.dto.DictDTO;
import com.railway.labor.career.model.dto.LoginInfoDTO;
import com.railway.labor.career.model.query.DictQuery;
import com.railway.labor.career.service.DictService;

/**
 * 用户
 * 
 * @author zhuanglinxiang
 * 
 */
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController{
	@Autowired
	private DictService dictService;
	
	@ModelAttribute
	public DictDTO modelAttribute(@RequestParam(required = false) Long id){
		return dictService.get(id);
	}
	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = { "list.json", "" })
	@ResponseBody
	public BaseResult<Pagination<DictQuery, DictDTO>> list(@RequestBody DictQuery dictQuery,@RequestBody Integer pageSize, @RequestBody Long pageIndex) {
		BaseResult<Pagination<DictQuery, DictDTO>> baseResult = new BaseResult<>();
		Pagination<DictQuery, DictDTO> pagination = new Pagination<>();
		pagination.setQuery(dictQuery);
		pagination.setPageIndex(pageIndex);
		pagination.setPageSize(pageSize);
		try {
			pagination = dictService.query(pagination);
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
	public BaseResult<DictDTO> get(@RequestBody Long id) {
		BaseResult<DictDTO> baseResult = new BaseResult<>();
		DictDTO dictDTO = null;
		try {
			dictDTO = dictService.get(id);
			if (dictDTO == null) {
				baseResult.setErrorCode(ErrorConstant.USER_NULL_CODE);
				baseResult.setErrorMsg(ErrorConstant.USER_NULL_MSG);
			} else {
				baseResult.setValue(dictDTO);
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
	 * 添加数据字典
	 * 
	 * @param dictDTO
	 * @return
	 */
	@RequestMapping(value = "add.json")
	@ResponseBody
	public BaseResult<DictDTO> add(DictDTO dictDTO) {
		BaseResult<DictDTO> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = getLoginUser();
			dictDTO.setCreator(loginInfo.getId());
			dictDTO.setCreateDate(new Date());
			dictDTO.setModifier(loginInfo.getId());
			dictDTO.setModifyDate(new Date());
			dictDTO.setDelFlag("0");
			dictService.insert(dictDTO);
			baseResult.setValue(dictDTO);
			baseResult.setSuccess(true);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorConstant.USER_QUERY_EXCEPTION_CODE);
			baseResult.setErrorMsg(ErrorConstant.USER_QUERY_EXCEPTION_MSG);
		}

		return baseResult;
	}
	
	/**
	 * 修改数据字典
	 * 
	 * @param dictDTO
	 * @return
	 */
	@RequestMapping(value = "update.json")
	@ResponseBody
	public BaseResult<DictDTO> update(DictDTO dictDTO) {
		BaseResult<DictDTO> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = getLoginUser();
			dictDTO.setModifier(loginInfo.getId());
			dictDTO.setModifyDate(new Date());
			dictService.update(dictDTO);
			baseResult.setValue(dictDTO);
			baseResult.setSuccess(true);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			baseResult.setErrorCode(ErrorConstant.USER_QUERY_EXCEPTION_CODE);
			baseResult.setErrorMsg(ErrorConstant.USER_QUERY_EXCEPTION_MSG);
		}
		return baseResult;
	}
	
	/**
	 * 删除数据字典
	 * 
	 * @param dictDTO
	 * @return
	 */
	@RequestMapping(value = "delete.json")
	@ResponseBody
	public BaseResult<Integer> delete(DictDTO dictDTO) {
		BaseResult<Integer> baseResult = new BaseResult<>();
		try {
			LoginInfoDTO loginInfo = getLoginUser();
			if(dictDTO!=null&&dictDTO.getId()!=null){
				dictDTO.setModifier(loginInfo.getId());
				dictDTO.setModifyDate(new Date());
				int result = dictService.delete(dictDTO);
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
