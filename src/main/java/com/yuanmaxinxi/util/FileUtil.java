package com.yuanmaxinxi.util;

public class FileUtil {
	 /**
	   * 获取文件后缀名
	   */
	public static String getEndFix(String fileName) {
		  return fileName.substring(fileName.lastIndexOf(".")+1);
	}
}
