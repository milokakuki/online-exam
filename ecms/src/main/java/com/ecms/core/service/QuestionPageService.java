
package com.ecms.core.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ecms.core.entity.Field;
import com.ecms.core.entity.Page;
import com.ecms.core.entity.Question;
import com.ecms.core.entity.QuestionPage;
import com.ecms.core.entity.QuestionType;
import com.ecms.core.service.base.SimpleService;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className QuestionPageService
 * @date   2018年4月26日下午2:58:13
 * @desc  [用一句话描述改文件的功能]
 */
public interface QuestionPageService extends SimpleService<QuestionPage, Integer>{

	List<QuestionPage> findByPage(Integer pid);

	void updata(QuestionPage po);

	QuestionPage findByPageAndQuestion(Page page, Question question);
	
	org.springframework.data.domain.Page<QuestionPage> findByPagep(Page page,Pageable pageable);

}
