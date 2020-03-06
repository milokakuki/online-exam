
package com.ecms.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecms.core.dao.FieldDao;
import com.ecms.core.entity.Field;
import com.ecms.core.service.FieldService;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className FieldServiceImpl
 * @date   2018年3月22日上午9:29:51
 * @desc  [用一句话描述改文件的功能]
 */
@Service("fieldService")
public class FieldServiceImpl implements FieldService{

	@Autowired
	private FieldDao fieldDao;
	
	@Override
	public List<Field> findAll() {
		return fieldDao.findAll();
	}

	@Override
	public List<Field> findAll(Sort sort) {
		return fieldDao.findAll(sort);
	}

	@Override
	public List<Field> findAll(Iterable<Integer> ids) {
		return fieldDao.findAll(ids);
	}

	@Override
	public Field findById(Integer id) {
		return fieldDao.findOne(id);
	}

	@Override
	public <S extends Field> List<S> save(Iterable<S> entities) {
		return fieldDao.save(entities);
	}

	@Override
	public <S extends Field> S saveAndFlush(S entity) {
		return fieldDao.saveAndFlush(entity);
	}

	@Override
	public <S extends Field> void delete(S entity) {
		fieldDao.delete(entity);
	}

	@Override
	public void deleteInBatch(Iterable<Field> entities) {
		fieldDao.delete(entities);
	}

	@Override
	public <S extends Field> List<S> findAll(Example<S> example) {
		return fieldDao.findAll(example);
	}

	@Override
	public <S extends Field> List<S> findAll(Example<S> example, Sort sort) {
		return fieldDao.findAll(example,sort);
	}

	@Override
	public Page<Field> findAll(Pageable pageable) {
		return fieldDao.findAll(pageable);
	}
	
}