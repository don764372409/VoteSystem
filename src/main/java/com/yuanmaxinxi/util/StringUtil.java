package com.yuanmaxinxi.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	public static boolean isNotNullAndEmpty(String str) {
		return str!=null&&!"".equals(str.trim());
	}
	public static boolean isNullOrEmpty(String str) {
		return str==null||"".equals(str.trim());
	}
	/**
	    * 将短时间格式字符串转换为时间 yyyy-MM-dd 
	    * 
	    * @param strDate
	   * @return
	    */
	 public static Date strToDate(String strDate) {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    ParsePosition pos = new ParsePosition(0);
	    Date strtodate = formatter.parse(strDate, pos);
	    return strtodate;
	 }
}
