package com.ecms.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ecms.web.bind.Const;


/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className ActionInterceptor
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public class ActionInterceptor extends HandlerInterceptorAdapter {

	protected Logger logger=Logger.getLogger(this.getClass());
	
	private static String PATH = "path";	//基本路径，上下文路径
	
	private static String BASE_PATH = "basePath";	//完整的路径

	public static boolean IS_WINDOWS = false;
	
	/*
	 * 判断是否是Windows操作系统
	 */
	static {
		if(System.getProperty("os.name").toLowerCase().indexOf("windows")>0) {
			IS_WINDOWS = true;
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute(PATH, Const.HttpClient.BASE_PATH);
		request.setAttribute(BASE_PATH, Const.HttpClient.CONTEXT_PATH);
		return true;
	}
}
