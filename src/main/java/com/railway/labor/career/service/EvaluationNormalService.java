package com.railway.labor.career.service;

import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.EvaluationNormalDAO;
import com.railway.labor.career.model.dto.EvaluationNormalDTO;
import com.railway.labor.career.model.dto.LoginInfoDTO;
import com.railway.labor.career.model.query.EvaluationNormalQuery;
import com.railway.labor.career.util.DateUtil;
import com.railway.labor.career.util.ExcelUtil;

@Service
public class EvaluationNormalService {
	protected static final Logger logger = LoggerFactory
			.getLogger(EvaluationNormalService.class);

	@Autowired
	private EvaluationNormalDAO evaluationNormalDAO;

	public Pagination<EvaluationNormalQuery, EvaluationNormalDTO> query(Pagination<EvaluationNormalQuery, EvaluationNormalDTO> pagination) {
		return evaluationNormalDAO.query(pagination);
	}

	public EvaluationNormalDTO get(Long id) {
		return evaluationNormalDAO.get(id);
	}

	public void insert(EvaluationNormalDTO evaluationNormalDTO) {
		evaluationNormalDAO.insert(evaluationNormalDTO);
	}

	public void update(EvaluationNormalDTO evaluationNormalDTO) {
		evaluationNormalDAO.insert(evaluationNormalDTO);
	}

	public int delete(EvaluationNormalDTO evaluationNormalDTO) {
		evaluationNormalDTO.setDelFlag("1");
		return evaluationNormalDAO.update(evaluationNormalDTO);
	}

	public int importExcel(InputStream inputStream, LoginInfoDTO loginInfo)
			throws Exception {
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				inputStream);
		XSSFWorkbook wb = new XSSFWorkbook(bufferedInputStream);
		XSSFSheet sheet = wb.getSheetAt(0);
		if (sheet == null || sheet.getLastRowNum() < 1) {
			throw new Exception("当前文件不是有效的excel模板");
		}

		XSSFRow headRow = sheet.getRow(0);
		int colStart = 0;
		int colEnd = 50;
		List<PropertyDescriptor> propertyDescriptorList = new ArrayList<>(
				colEnd - colStart + 1);
		
		List<Integer> columnIndexList = new ArrayList<>();
		
		for (int i = colStart; i <= colEnd; i++) {
			XSSFCell cell = headRow.getCell(i);
			String fieldName = null;
			logger.info("headRow, cell[{}]={}", i, cell);
			if (cell != null) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					fieldName = cell.getStringCellValue();
				} else {
					fieldName = cell.getRawValue();
				}
			}

			if (StringUtils.isNotBlank(fieldName)) {
				Field field = EvaluationNormalDTO.class
						.getDeclaredField(fieldName);
				try {
					propertyDescriptorList.add(new PropertyDescriptor(
							field.getName(), EvaluationNormalDTO.class));
					columnIndexList.add(i);
				} catch (Exception e) {
					logger.error("错误： 目标对象中不存在属性{%s}的SETTER方法!", fieldName);
				}
			}
		}
		
		EvaluationNormalDTO evaluationNormalDTO = new EvaluationNormalDTO();
		int handledCount = 0;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (!ExcelUtil.rowHasData(row, columnIndexList)) {
				continue;
			}
			handledCount++;
			int size = columnIndexList.size();
			for (int j = 0; j < size; j++) {
				XSSFCell cell = row.getCell(columnIndexList.get(j));
				logger.info("row[{}], cell[{}]={}", i, columnIndexList.get(j), cell);
				Object cellValue = null;
				if (cell != null) {
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						cellValue = cell.getStringCellValue();
					} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
						cellValue = cell.getRawValue();
					} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						short format = cell.getCellStyle().getDataFormat();
			            if (format == 14 || format == 31 || format == 57 || format == 58  
			                    || (176<=format && format<=178) || (182<=format && format<=196) 
			                    || (210<=format && format<=213) || (208==format ) ) { // 日期
			            	cellValue = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue());
			            } else if (format == 20 || format == 32 || format==183 || (200<=format && format<=209) ) { // 时间
			            	cellValue = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue());
			            } else {
			            	cellValue = cell.getRawValue();
			            }
					} else {
						cellValue = cell.getRawValue();
					}
				}
				Method writeMethod = propertyDescriptorList.get(j)
						.getWriteMethod();
				if (cellValue != null
						|| StringUtils.isNotBlank((String) cellValue)) {
					Class parameterType = writeMethod.getParameterTypes()[0];
					if (String.class.equals(parameterType)) {
						if (Date.class.equals(cellValue.getClass()) ) {
							cellValue = DateUtil.DateToString((Date) cellValue, "yyyy-MM-dd HH:mm:ss");
						}
						cellValue = String.valueOf(cellValue);
					} else if (Integer.class.equals(parameterType)) {
						cellValue = Integer.valueOf((String) cellValue);
					} else if (Double.class.equals(parameterType)) {
						cellValue = Double.valueOf((String) cellValue);
					} else if (Long.class.equals(parameterType)) {
						cellValue = Long.valueOf((String) cellValue);
					} else if (Byte.class.equals(parameterType)) {
						cellValue = Byte.valueOf((String) cellValue);
					} else if (Date.class.equals(parameterType) &&!Date.class.equals(cellValue.getClass()) ) {
						cellValue = DateUtil.StringToDate((String) cellValue, "yyyy-MM-dd HH:mm:ss",
								"yyyy-MM-dd");
					}
				}
				writeMethod.invoke(evaluationNormalDTO, cellValue);
			}
			
			evaluationNormalDTO.setCreateDate(new Date());
			evaluationNormalDTO.setModifier(loginInfo.getId());
			evaluationNormalDTO.setModifyDate(new Date());
			evaluationNormalDAO.insert(evaluationNormalDTO);
		}
		return handledCount;
	}

}
