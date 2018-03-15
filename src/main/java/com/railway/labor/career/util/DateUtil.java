package com.railway.labor.career.util;

import java.util.Date;
/**
 * 日期工具类
 * @author zhuanglinxiang
 *
 */
public class DateUtil {
	
public static long compare(Date date1,Date date2){
	return date1.getTime()-date2.getTime();
}
}
