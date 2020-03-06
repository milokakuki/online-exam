package com.ecms.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ecms.web.bind.Const;


/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserService
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public class RegularUtil {
	/**

	 * 获取文本中img标签的src属性值

	 * 

	 * @param content

	 *            文本内容

	 * @return

	 */
	public static List<String> getImgStr(String content) {
		List<String> list = new ArrayList<String>();
		// 目前img标签标示有3种表达式

		// <img alt="" src="1.jpg"/> <img alt="" src="1.jpg"></img> <img alt=""

		// src="1.jpg">

		// 开始匹配content中的<img />标签

		Pattern p_img = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)");
		Matcher m_img = p_img.matcher(content);
		boolean result_img = m_img.find();
		if (result_img) {
			while (result_img) {
				// 获取到匹配的<img />标签中的内容

				String str_img = m_img.group(2);
				// 开始匹配<img />标签中的src

				Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
				Matcher m_src = p_src.matcher(str_img);
				if (m_src.find()) {
					String str_src = m_src.group(3);
					list.add(str_src);
				}
				// 匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src

				result_img = m_img.find();
			}
		}
		return list;
	}

	/**

	 * 给指定内容文本中的img标签添加CSS类

	 * 

	 * @param content

	 *            文本内容

	 * @param css

	 *            CSS类

	 * @return

	 */
	public static String addImgCss(String content, String css) {
		String regex = "(?i)(\\<img)([^\\>]+\\>)";
		content = content.replaceAll(regex, "$1 class=\"" + css + "\"$2");
		return content;
	}

	/**

	 * 验证是否是电话号码

	 * 

	 * @param phoneNumber

	 * @return

	 */
	public static boolean isPhoneNumber(String phoneNumber) {
		return Pattern.matches(Const.REGEX_MOBILE, phoneNumber);
	}
	/**

	 * 验证是否是邮箱

	 * @param email

	 * @return

	 */
	public static boolean isEmail(String email) {
		return Pattern.matches(Const.REGEX_EMAIL, email);
	}
	
	/**

	 * 验证是否是身份证号码

	 * @param idCard

	 * @return

	 */
	public static boolean isIdCard(String idCard) {
		return Pattern.matches(Const.REGEX_ID_CARD, idCard);
	}
	public static void main(String[] args) {
		String number = "522321199109024331";
		System.out.println(RegularUtil.isIdCard(number));
	}
	
	
}
