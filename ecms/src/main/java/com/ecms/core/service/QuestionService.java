
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
