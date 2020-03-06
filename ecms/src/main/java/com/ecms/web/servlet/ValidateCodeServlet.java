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
 * @className ValidateCodeServlet
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
