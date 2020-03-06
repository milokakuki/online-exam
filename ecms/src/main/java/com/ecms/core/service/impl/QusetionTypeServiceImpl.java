
package com.ecms.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecms.core.dao.QuestionTypeDao;
import com.ecms.core.entity.QuestionType;
import com.ecms.core.service.QuestionTypeService;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className QusetionTypeServiceImpl
 * @date   2018年3月23日上午10:29:01
 * @desc  [用一句话描述改文件的功能]
 */
@Service("questionTypeService")
public class QusetionTypeServiceImpl implements QuestionTypeService{

	@Autowired
	private QuestionTypeDao questionTypeDao;
	
	@Override
	public List<QuestionType> findAll() {
		return questionTypeDao.findAll();
	}

	@Override
	public List<QuestionType> findAll(Sort sort) {
		return questionTypeDao.findAll(sort);
	}

	@Override
	public List<QuestionType> findAll(Iterable<Integer> ids) {
		return questionTypeDao.findAll(ids);
	}

	@Override
	public QuestionType findById(Integer id) {
		return questionTypeDao.findOne(id);
	}

	@Override
	public <S extends QuestionType> List<S> save(Iterable<S> entities) {
		return questionTypeDao.save(entities);
	}

	@Override
	public <S extends QuestionType> S saveAndFlush(S entity) {
		return questionTypeDao.saveAndFlush(entity);
	}

	@Override
	public <S extends QuestionType> void delete(S entity) {
		questionTypeDao.delete(entity);
	}

	@Override
	public void deleteInBatch(Iterable<QuestionType> entities) {
		questionTypeDao.deleteInBatch(entities);
	}

	@Override
	public <S extends QuestionType> List<S> findAll(Example<S> example) {
		return questionTypeDao.findAll(example);
	}

	@Override
	public <S extends QuestionType> List<S> findAll(Example<S> example, Sort sort) {
		return questionTypeDao.findAll(example,sort);
	}

	@Override
	public Page<QuestionType> findAll(Pageable pageable) {
		return questionTypeDao.findAll(pageable);
	}

}
