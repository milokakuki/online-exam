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
