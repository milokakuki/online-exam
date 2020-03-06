package com.ecms.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.ecms.web.exception.CmsException;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className ExceptionHandler
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public class ExceptionHandler implements HandlerExceptionResolver{

	/*
	 * (non-Javadoc)
	 * @see
	 * org.springframework.web.servlet.HandlerExceptionResolver#resolveException(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * java.lang.Exception)
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		// 判断是否ajax请求
		if (request.getHeader("accept") != null && (!(request.getHeader("accept").indexOf("application/json") > -1
				|| (request.getHeader("X-Requested-With") != null
						&& request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)))) {
			// 如果不是ajax，JSP格式返回

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", false);
			if (exception instanceof CmsException) {
				map.put("errorMsg", exception.getMessage());
			} else {
				map.put("errorMsg", "系统异常！");
			}
			exception.printStackTrace();
			// 对于非ajax请求，我们都统一跳转到error.jsp页面

			return new ModelAndView("/error", map);
		} else {
			// 如果是ajax请求，JSON格式返回

			try {
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter writer = response.getWriter();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("success", false);
				// 为安全起见，只有业务异常我们对前端可见，否则统一归为系统异常

				if (exception instanceof CmsException) {
					map.put("errorMsg", exception.getMessage());
				} else {
					map.put("errorMsg", "系统异常！");
				}
				exception.printStackTrace();
				writer.write(JSONUtils.toJSONString(map));
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
