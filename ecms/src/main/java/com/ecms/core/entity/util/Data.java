/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年3月21日下午3:15:02</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.core.entity.util;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className QuestionFilter
 * @date   2018年3月21日下午3:04:37
 * @desc  [用一句话描述改文件的功能]
 */
public class Data implements Serializable {

	private static final long serialVersionUID = 3708308180295578873L;

	public static int CODE_SUCCESS = 0;

	public static int CODE_FAILURED = -1;

	public static String NOOP = "";

	private int code;

	private String message;

	private Object data;
	
	private ArrayList<Button> links = new ArrayList<>();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ArrayList<Button> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Button> links) {
		this.links = links;
	}

	private Data(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static final Data success(Object data) {
		return new Data(Data.CODE_SUCCESS, "操作成功", data);
	}

	public static final Data success(String message, Object data) {
		return new Data(Data.CODE_SUCCESS, message, data);
	}

	public static final Data failured(int code, String message) {
		return new Data(code, message, null);
	}

	public static final Data failured(String message) {
		return failured(Data.CODE_FAILURED, message);
	}

	public Data addLink(String link, String text) {
		links.add(new Button(text, link));
		return this;
	}

	public class Button {
		private String text;
		private String link;

		public Button() {
			super();
		}

		public Button(String text, String link) {
			super();
			this.text = text;
			this.link = link;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}
	}

}