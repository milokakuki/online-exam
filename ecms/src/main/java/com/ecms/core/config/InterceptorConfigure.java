/**

 *  TCMS2.0 版权声明<br/>

    <center>Copyright (c) 2018 www.ecms.com</center> 

 <center> 2018年1月30日</center>

<center>TCMS(ecms Content Management System)的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>

<center>未经桃李云事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云授权的所属服务器上做镜像或以其他任何方式使用。</center>

<center>凡侵犯桃李云版权等知识产权的，桃李云将依法追究其法律责任。</center>

 */
package com.ecms.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ecms.web.interceptor.ActionInterceptor;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserService
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
@Configuration
public class InterceptorConfigure extends WebMvcConfigurerAdapter {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ActionInterceptor());
		super.addInterceptors(registry);
	}
	
	

}
