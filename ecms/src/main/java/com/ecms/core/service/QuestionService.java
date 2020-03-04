/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年3月21日下午3:08:05</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.core.service;

import java.util.List;
import java.util.Set;

//import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ecms.core.entity.Field;
import com.ecms.core.entity.Question;
import com.ecms.core.entity.QuestionPage;
import com.ecms.core.entity.QuestionType;
import com.ecms.core.service.base.SimpleService;
import com.ecms.core.entity.Page;;
/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className QuestionService
 * @date   2018年3月21日下午3:08:05
 * @desc  [用一句话描述改文件的功能]
 */
public interface QuestionService extends SimpleService<Question, Integer>{

	org.springframework.data.domain.Page<Question> findByFieldAndKnowledgePointAndQuestionType(Field field,Integer knowledge,QuestionType qType,List<QuestionPage> questionpages ,Pageable pageable);
	org.springframework.data.domain.Page<Question> findByFieldAndKnowledgePointAndQuestionType(Field field,Integer knowledge,QuestionType qType,Integer pid,Pageable pageable);
	org.springframework.data.domain.Page<Question> findByFieldAndKnowledgePointAndQuestionType(Page page,Pageable pageable);
	
	org.springframework.data.domain.Page<Question> findByFieldAndKnowledgePointAndQuestionType(Field field,Integer knowledge,QuestionType qType,Pageable pageable);

	void update(Question po);

	List<Question> findAllByFieldAndKnowledgePointAndQuestionType(Field field, Integer knowledgePoint,
			QuestionType questionType);

}
