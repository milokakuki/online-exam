/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年3月22日上午11:40:38</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.core.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecms.core.dao.KnowledgePointDao;
import com.ecms.core.entity.Field;
import com.ecms.core.entity.KnowledgePoint;
import com.ecms.core.service.KnowledgePointService;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className KnowledgeServiceImpl
 * @date   2018年3月22日上午11:40:38
 * @desc  [用一句话描述改文件的功能]
 */
@Service("knowledgePointService")
public class KnowledgePointServiceImpl implements KnowledgePointService{

	@Autowired
	private KnowledgePointDao knowledgePointDao;
	
	@Override
	public List<KnowledgePoint> findAll() {
		return knowledgePointDao.findAll();
	}

	@Override
	public List<KnowledgePoint> findAll(Sort sort) {
		return knowledgePointDao.findAll(sort);
	}

	@Override
	public List<KnowledgePoint> findAll(Iterable<Integer> ids) {
		return knowledgePointDao.findAll(ids);
	}

	@Override
	public KnowledgePoint findById(Integer id) {
		return knowledgePointDao.findOne(id);
	}

	@Override
	public <S extends KnowledgePoint> List<S> save(Iterable<S> entities) {
		return knowledgePointDao.save(entities);
	}

	@Override
	public <S extends KnowledgePoint> S saveAndFlush(S entity) {
		return knowledgePointDao.saveAndFlush(entity);
	}

	@Override
	public <S extends KnowledgePoint> void delete(S entity) {
		knowledgePointDao.delete(entity);
	}

	@Override
	public void deleteInBatch(Iterable<KnowledgePoint> entities) {
		knowledgePointDao.delete(entities);
	}

	@Override
	public <S extends KnowledgePoint> List<S> findAll(Example<S> example) {
		return knowledgePointDao.findAll(example);
	}

	@Override
	public <S extends KnowledgePoint> List<S> findAll(Example<S> example, Sort sort) {
		return knowledgePointDao.findAll(example,sort);
	}

	@Override
	public Page<KnowledgePoint> findAll(Pageable pageable) {
		return knowledgePointDao.findAll(pageable);
	}

	@Override
	public Set<KnowledgePoint> getKnowledgePointByField(Field field) {
		return knowledgePointDao.getKnowledgePointByField(field);
	}

}