
package com.ecms.core.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecms.web.servlet.ValidateCodeServlet;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserService
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
@Configuration
public class CmsWebServletConfigure {

	@Bean
	public ServletRegistrationBean checkCodeServletBean() {
		return new ServletRegistrationBean(new ValidateCodeServlet(),"/checkcode");
	}
}
