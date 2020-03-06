
package com.ecms.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ecms.core.entity.Question;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className QuestionDao
 * @date   2018年3月21日下午3:09:43
 * @desc  [用一句话描述改文件的功能]
 */
public interface QuestionDao extends JpaRepository<Question, Integer>, JpaSpecificationExecutor<Question>{


}
