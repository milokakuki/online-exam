/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年3月23日上午10:29:01</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
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
