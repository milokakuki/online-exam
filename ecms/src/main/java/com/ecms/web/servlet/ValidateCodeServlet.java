/**

 *  TCMS2.0 版权声明<br/>

    <center>Copyright (c) 2018 www.ecms.com</center> 

 <center> 2018年1月30日</center>

<center>TCMS(ecms Content Management System)的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>

<center>未经桃李云事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云授权的所属服务器上做镜像或以其他任何方式使用。</center>

<center>凡侵犯桃李云版权等知识产权的，桃李云将依法追究其法律责任。</center>

 */
package com.ecms.web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecms.util.CheckCodeUtil;
import com.ecms.web.bind.Const;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserService
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public class ValidateCodeServlet extends HttpServlet implements Servlet{

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		String initSize =this.getServletConfig().getInitParameter("size"); 
		String initWidth = this.getServletConfig().getInitParameter("width");
		String initHeight = this.getServletConfig().getInitParameter("height");
		int size = (initSize !=null)?Integer.parseInt(initSize):4;
		int w=(initWidth != null)?Integer.parseInt(initWidth):146;
		int h=(initHeight != null)?Integer.parseInt(initHeight):35;
		String validateCode = CheckCodeUtil.generateVerifyCode(size);
		HttpSession session = request.getSession();
		session.setAttribute(Const.CHECK_CODE, validateCode);
		System.out.println(session.getAttribute(Const.CHECK_CODE));
		CheckCodeUtil.outputImage(w, h, response.getOutputStream(), validateCode);
	}
}
