/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年3月21日下午2:58:06</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.core.entity.util;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className QuestionFilter
 * @date   2018年3月21日下午3:04:37
 * @desc  [用一句话描述改文件的功能]
 */
public class FileNameUtils {
	private static String YYYYMM = "/yyyy/MMdd/";
	private static String DDHHMMSS = "ddHHmmss";
	
	private static String YYYYMMDDHHMMSS = "/yyyy/MMdd/ddHHmmss";
	
	/**
	 * 36个小写字母和数字
	 */
	public static final char[] N36_CHARS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z' };
	
	/**
	 * 生成当前年月日格式的文件路径
	 * 
	 * yyyyMM 200806
	 * 
	 * @return 结果字符串
	 */
	public static String genPathName() {
		return DateFormatUtils.format(new Date(), YYYYMM);
	}
	
	/**
	 * 生成文件名
	 * 以当前日、时间开头加4位随机数的文件名
	 * 
	 * ddHHmmss 03102230
	 * 
	 * @return 10位长度文件名
	 */
	public static String genFileName() {
		return DateFormatUtils.format(new Date(), DDHHMMSS) + RandomStringUtils.random(4, N36_CHARS);
	}

	/**
	 * 生成文件名
	 * 以当前时间开头加4位随机数的文件名
	 * 
	 * @param ext 文件名后缀，不带'.'
	 * @return 10位长度文件名+文件后缀
	 */
	public static String genFileName(String ext) {
		return genFileName() + "." + ext;
	}
	
	/**
	 * 生成路径和文件名
	 * 以当前时间开头加4位随机数的文件名
	 * 
	 * @param ext 文件名后缀，不带'.'
	 * @return 10位长度文件名+文件后缀
	 */
	public static String genPathAndFileName(String ext) {
		return DateFormatUtils.format(new Date(), YYYYMMDDHHMMSS) + RandomStringUtils.random(4, N36_CHARS) + "." + ext;
	}
}
