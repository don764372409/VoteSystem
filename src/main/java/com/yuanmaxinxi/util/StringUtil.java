package com.yuanmaxinxi.util;

public class StringUtil {
	public static boolean isNotNullAndEmpty(String str) {
		return str!=null&&!"".equals(str.trim());
	}
	public static boolean isNullOrEmpty(String str) {
		return str==null||"".equals(str.trim());
	}
}
