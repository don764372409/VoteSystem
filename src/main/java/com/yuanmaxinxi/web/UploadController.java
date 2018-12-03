package com.yuanmaxinxi.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baidu.ueditor.ActionEnter;
import com.yuanmaxinxi.dto.ResultDTO;
import com.yuanmaxinxi.util.FileUtil;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@RequestMapping("/config")
	public void config(HttpServletRequest request,HttpServletResponse response) {
		org.springframework.core.io.Resource res = new ClassPathResource("static\\H-ui\\lib\\ueditor\\1.4.3.3\\jsp\\config.json");
		InputStream is = null;
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Content-Type" , "text/html");
		try {
//			is = new FileInputStream(res.getFile());
//			StringBuffer sb = new StringBuffer();
//			byte[] b = new byte[1024];
//			int length=0;
//			while(-1!=(length=is.read(b))){
//				sb.append(new String(b,0,length,"utf-8"));
//			}
//			String result = sb.toString().replaceAll("/\\*(.|[\\r\\n])*?\\*/","");
//			out.print(result);
			PrintWriter out = response.getWriter();
			String rootPath = request.getServletContext().getRealPath("/resource/H-ui/lib/ueditor/1.4.3.3/" );
			System.err.println(new ActionEnter( request, rootPath ).exec());
			out.write( new ActionEnter( request, rootPath ).exec() );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 上传
	 * @param file
	 * @param req
	 * @param type 上传类型,head为头像上传,validate为身份验证图片上传,product为商品图片上传
	 * @return
	 */
	@RequestMapping("/on")
	public @ResponseBody ResultDTO upload(MultipartFile file,HttpServletRequest req){
		ResultDTO dto;
		String fileName;
		try {
			//获取后缀
			String endFix = FileUtil.getEndFix(file.getOriginalFilename());
			//拼接文件名
			fileName =new Date().getTime()+"."+endFix;
			String basePath = "/upload";
			String path = req.getServletContext().getRealPath("/upload");
			//创建一个空文件
			File targetFile = new File(path,fileName);
			if(!targetFile.exists()){
				File parent = targetFile.getParentFile();
				if (!parent.exists()) {
					parent.mkdirs();
				}
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
