/**

 *  TCMS2.0 版权声明<br/>

    <center>Copyright (c) 2018 www.ecms.com</center> 

 <center> 2018年1月30日</center>

<center>TCMS(ecms Content Management System)的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>

<center>未经桃李云事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云授权的所属服务器上做镜像或以其他任何方式使用。</center>

<center>凡侵犯桃李云版权等知识产权的，桃李云将依法追究其法律责任。</center>

 */
package com.ecms.web.exception;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserService
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public class CmsException extends RuntimeException{

	private static final long serialVersionUID = 7106822586251164559L;

	protected String key;
	protected Object[] args;

	/**

	 * 

	 */
	public CmsException() {
		super();
	}

	/**

	 * @param arg0

	 * @param arg1

	 * @param arg2

	 * @param arg3

	 */
	public CmsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**

	 * @param arg0

	 * @param arg1

	 */
	public CmsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**

	 * @param arg0

	 */
	public CmsException(String key) {
		super(key);
	}

	/**

	 * @param arg0

	 */
	public CmsException(Throwable arg0) {
		super(arg0);
	}
}
