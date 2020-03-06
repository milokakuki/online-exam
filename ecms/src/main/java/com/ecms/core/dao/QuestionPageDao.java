
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
