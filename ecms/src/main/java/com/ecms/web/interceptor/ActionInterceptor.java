/**

 *  TCMS2.0 版权声明<br/>

    <center>Copyright (c) 2018 www.ecms.com</center> 

 <center> 2018年1月30日</center>

<center>TCMS(ecms Content Management System)的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>

<center>未经桃李云事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云授权的所属服务器上做镜像或以其他任何方式使用。</center>

<center>凡侵犯桃李云版权等知识产权的，桃李云将依法追究其法律责任。</center>

 */
package com.ecms.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ecms.web.bind.Const;


/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserService
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
