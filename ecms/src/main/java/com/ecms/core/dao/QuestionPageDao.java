/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年4月26日下午2:57:22</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ecms.core.entity.Page;
import com.ecms.core.entity.Question;
import com.ecms.core.entity.QuestionPage;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className QuestionPageDao
 * @date   2018年4月26日下午2:57:22
 * @desc  [用一句话描述改文件的功能]
 */
public interface QuestionPageDao extends JpaRepository<QuestionPage, Integer>, JpaSpecificationExecutor<QuestionPage>{

	QuestionPage findByPageAndQuestion(Page page, Question question);

	List<QuestionPage> findByPage(Page page);

}
