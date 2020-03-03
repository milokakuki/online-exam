/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年3月15日下午5:57:11</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.web.bind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className RoleType
 * @date   2018年3月15日下午5:57:11
 * @desc  [用一句话描述改文件的功能]
 */
public enum RoleType {
	
	ADMIN, TEACHER, STUDENT;
	
	public String parseText() {
		return this.toString();
	}
	
	public int parseInt() {
		return this.ordinal();
	}
	
	public static RoleType text(int ordinal) {
		for(RoleType r:RoleType.values()) {
			if(r.ordinal() == ordinal) {
				return r;
				
			}
		}
		return null;
	}
	
	public static List<RoleType> list(){
		List<RoleType> list = new ArrayList<>(Arrays.asList(RoleType.values()));
		return list;
	}
}
