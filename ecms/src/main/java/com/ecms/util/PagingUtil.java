/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年3月21日下午3:16:53</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.util;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className PagingUtil
 * @date   2018年3月21日下午3:16:53
 * @desc  [用一句话描述改文件的功能]
 */
public class PagingUtil {

	/**
	 * 返回anchor类型的分页
	 * @param currentPageNo
	 * @param maxPageNo
	 * @param parameters
	 * @param url
	 * @return
	 */
	public static String getPagelink(int currentPageNo, int maxPageNo, String parameters, String url) {

		currentPageNo = currentPageNo > maxPageNo ? maxPageNo : currentPageNo;
		int begainNo = currentPageNo - 5 > 0 ? currentPageNo - 5 : 1;
		int endNo = begainNo + 9 > maxPageNo ? maxPageNo : begainNo + 9;
		StringBuffer bf = new StringBuffer();

		if (maxPageNo > 1) {
			bf.append(currentPageNo > 1 ? ("<li><a href = \"" + url + "?page=" + (currentPageNo - 1 > 1 ? currentPageNo - 1 : 1) + parameters + "\">上一页</a></li>") : "<li class=\"disabled\"><a>上一页</a></li>");
			for (int i = begainNo; i <= endNo; i++) {

				if (i == currentPageNo) {

					bf.append("<li class=\"active\"><a href = \"" + url + "?page=" + i + parameters + "\" >" + i + "</a></li>");
				} else
					bf.append("<li><a href = \"" + url + "?page=" + i + parameters + "\" >" + i + "</a></li>");
			}
			bf.append(currentPageNo < maxPageNo ? ("<li><a href = \"" + url + "?page=" + (currentPageNo + 1 > maxPageNo ? maxPageNo : currentPageNo + 1) + parameters + "\">下一页</a></li>") : "<li class=\"disabled\"><a>下一页</a></li>");
			return bf.toString();
		}
		return "";

	}
	
	
	/**
	 * 返回button类型的分页
	 * @param currentPageNo
	 * @param maxPageNo
	 * @return
	 */
	public static String getPageBtnlink(int currentPageNo, int maxPageNo) {

		currentPageNo = currentPageNo > maxPageNo ? maxPageNo : currentPageNo;
		int begainNo = currentPageNo - 5 > 0 ? currentPageNo - 5 : 1;
		int endNo = begainNo + 9 > maxPageNo ? maxPageNo : begainNo + 9;
		StringBuffer bf = new StringBuffer();

		if (maxPageNo > 1) {
			bf.append(currentPageNo > 1 ? ("<li><a data-id = \"" + (currentPageNo - 1 > 1 ? currentPageNo - 1 : 1) + "\" >上一页</a></li>") : "<li class=\"disabled\"><a>上一页</a></li>");
			for (int i = begainNo; i <= endNo; i++) {

				if (i == currentPageNo) {

					bf.append("<li class=\"active\"><a data-id = \"" + i + "\">" + i + "</a></li>");
				} else
					bf.append("<li><a data-id = \"" + i + "\" >" + i
							+ "</a></li>");
			}
			bf.append(currentPageNo < maxPageNo ? ("<li><a data-id = \"" + (currentPageNo + 1 > maxPageNo ? maxPageNo : currentPageNo + 1) + "\" >下一页</a></li>") : "<li class=\"disabled\"><a>下一页</a></li>");
			return bf.toString();
		}
		return "";

	}
	
	public static void main(String[] args){
		System.out.println(PagingUtil.getPageBtnlink(5,100));
	}

}
