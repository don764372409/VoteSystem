package com.yuanmaxinxi.web;
import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.util.FileUtil;
@RequestMapping("/upload")
@Controller
public class UploadController {
	/**
	 * 上传
	 * @param file
	 * @param req
	 * @param type 上传类型,head为头像上传,validate为身份验证图片上传,product为商品图片上传
	 * @return
	 */
	@RequestMapping("/on")
	public @ResponseBody ResultDTO upload(@RequestParam("file")MultipartFile file,HttpServletRequest req){
		System.err.println("上传头像");
		ResultDTO dto;
		String fileName;
		try {
			//获取后缀
			String endFix = FileUtil.getEndFix(file.getOriginalFilename());
			//拼接文件名
			fileName =new Date().getTime()+"."+endFix;
			String basePath = "/upload/headImg";
			org.springframework.core.io.Resource res = new ClassPathResource("static\\upload\\headImg");
			String path = res.getURL().getPath().substring(1);
			//创建一个空文件
			File targetFile = new File(path,fileName);
			if(!targetFile.exists()){
				targetFile.createNewFile();  
			}
			//写文件
			file.transferTo(targetFile); 
			dto = ResultDTO.getIntance(true,basePath+"/"+fileName);
		} catch (Exception e) {
			e.printStackTrace();
			dto = ResultDTO.getIntance(false,"上传失败,数据异常,请检查请求参数是否正确");
		}
		//拼接前台web路劲
		return dto;
	}
}
