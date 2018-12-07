package com.yuanmaxinxi.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class IPUtils {
    private static String OS_NAME = null;
    /**
     * 查询本机外网IP网站
     */
    private static final String getWebIP = "http://ip.chinaz.com/getip.aspx";
    /**
     * 默认值
     */
    private static String IP = "未知";
    static {
       // System.out.println("初始化获取系统名称...");
        OS_NAME = System.getProperty("os.name");
    }

    public static String getIP(int queryFlag) {
        if (queryFlag == 1) {
            // 查询外网IP
            switch (IPUtils.getOsType()) {
            case 1:
                IP = IPUtils.getWinOuterIP();
                break;
            case 2:
                //IP = IPUtils.getLinuxIP(queryFlag);
                IP = IPUtils.getWinOuterIP();
                break;
            default:
                break;
            }
        } else {
            // 查询内网IP
            switch (IPUtils.getOsType()) {
            case 1:
                IP = IPUtils.getWinInnerIP();
                break;
            case 2:
                //IP = IPUtils.getLinuxIP(queryFlag);
                IP = IPUtils.getWinInnerIP();
                break;
            default:
                break;
            }
        }

        return IP;
    }

    /**
     * 获取window平台下外网IP
     * 
     * @return IP
     */
    private static String getWinOuterIP() {
    	
    	String ipFromNginx="";
    	HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	try{
    		ipFromNginx= request.getHeader("X-Real-IP");
    		if(ipFromNginx==null){
    			ipFromNginx= request.getRemoteAddr();
    		}
//    	    out.println("ipFromNginx:" + ipFromNginx);  
    	    //out.println("getRemoteAddr:" + request.getRemoteAddr());
    	}catch(Exception e){
    		//e.printStackTrace();
    		ipFromNginx="未知";
    	}
    	
    	return ipFromNginx;
    	
    	/*
    	
        try {
            URL url = new URL(getWebIP);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String s = "";
            StringBuffer sb = new StringBuffer("");
            String webContent = "";
            while ((s = br.readLine()) != null) {
                //System.err.println("---"+s);
                sb.append(s + "\r\n");
            }
            br.close();
            webContent = sb.toString();
            JSONObject jsonObject=JSONObject.fromObject(webContent);
            webContent = jsonObject.getString("ip");
            return webContent;
        } catch (Exception e) {
            //e.printStackTrace();
            System.err.println("获取外网IP网站访问失败！");
            return IP;
        }*/

    }

    /**
     * 获取window平台下内网IP
     * 
     * @return IP
     */
    private static String getWinInnerIP() {
        InetAddress[] inetAdds;
        try {
            inetAdds = InetAddress.getAllByName(InetAddress.getLocalHost()
                    .getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return IP;
        }
        return inetAdds[0].getHostAddress();
    }

    /**
     * 获取linux下的IP
     * @param queryFlag
     * 1表示查询外网IP 2表示查询内网IP
     * @return IP
     * @throws IOException 
     */
    private static String getLinuxIP(int queryFlag) {
         LineNumberReader input = null;
         String pathString = IPUtils.class.getResource("/").getPath();
         //类的路径
         //System.out.println(pathString);
         Process process=null;
         String line = "";
         try {
            Runtime.getRuntime().exec("dos2unix "+pathString+"test.sh");
            process = Runtime.getRuntime().exec("sh "+pathString+"test.sh "+(queryFlag==1?"1":"2"));
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            input = new LineNumberReader(ir);
            if((line = input.readLine()) != null) {
                IP = line;
            }
         } catch (IOException e) {
            e.printStackTrace();
            System.err.println("linux下获取IP失败!");
        }
        //System.out.println("exec shell result:ip====>" + IP);
        return IP;
    }
    /**
     * 目前只支持window和linux两种平台
     * 
     * @return 1 window 2 linux -1:未知
     */
    public static int getOsType() {
        // 将获取到的系统类型名称转为全部小写
        OS_NAME = OS_NAME.toLowerCase();
        if (OS_NAME.startsWith("win")) {
            return 1;
        }
        if (OS_NAME.startsWith("linux")) {
            return 2;
        }
        return -1;
    }

    /**
     * 测试方法
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
//        System.out.println("外网IP为："+IPUtils.getIP(1));  
			 
    }
/**
 *  权限
 * @param request 
 * */
	public static String qinghaiJurisdiction(HttpServletRequest request) {  
		String filePath=request.getServletContext().getRealPath("/");//导出的绝对路径
		filePath = filePath.replaceAll("\\\\", "/")+"WEB-INF/classes/jdbc.properties";  
		Properties properties = new Properties();  
		  InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(filePath));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			return null;
		}
		String authority= properties.getProperty("authority");  
		return authority; 		
	}
}