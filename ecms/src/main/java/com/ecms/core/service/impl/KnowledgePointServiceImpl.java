
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