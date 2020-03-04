/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年5月3日上午11:16:42</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.core.service;

import java.util.List;

import com.ecms.core.entity.Page;
import com.ecms.core.entity.PageHistory;
import com.ecms.core.entity.Student;
import com.ecms.core.service.base.SimpleService;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className PageHistoryService
 * @date 2018年5月3日上午11:16:42
 * @desc [用一句话描述改文件的功能]
 */
public interface PageHistoryService extends SimpleService<PageHistory, Integer> {
	PageHistory findByPageAndStudent(Page page,Student student);
	PageHistory findByStudent(Student student);
	PageHistory upDate(PageHistory pageHistory);
	PageHistory findByPageAndStudentAndStatus(Page page, Student student, Integer status);
	List<PageHistory> findAllByPageAndStudentAndStatus(Page page, Student student, Integer status);
	List<PageHistory> findAllByStudentAndStatus(Student student, Integer status);
}
