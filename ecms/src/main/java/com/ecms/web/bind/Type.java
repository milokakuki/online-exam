package com.ecms.web.bind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className Type
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public enum  Type {
	USER(1);
	
	private Integer value;
	
	private Type(Integer value) {
		this.value = value;
	}
	
	public Integer value() {
		return value;
	}
	
	public String parseText() {
		return this.toString();
	}
	
	public static List<Type> list(){
		List<Type> list = new ArrayList<>(Arrays.asList(Type.values()));
		return list;
	}
	
	public static class AttachType{
		public static final int USER = 0;
		public static final Map<Integer, String> STATE_INFO = new HashMap<Integer,String>();
		static {
			STATE_INFO.put(USER, "用户类型");
		}
	}
}
