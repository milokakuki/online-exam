
package com.ecms.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecms.core.dao.PageTypeDao;
import com.ecms.core.entity.PageType;
import com.ecms.core.service.PageTypeService;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className PageTypeServiceImpl
 * @date   2018年4月18日下午5:55:29
 * @desc  [用一句话描述改文件的功能]
 */
@Service("pageTypeService")
public class PageTypeServiceImpl implements PageTypeService {

	@Autowired
	private PageTypeDao pageTypeDao;
	@Override
	public List<PageType> findAll() {
		return pageTypeDao.findAll();
	}

	@Override
	public List<PageType> findAll(Sort sort) {
		return pageTypeDao.findAll(sort);
	}

	@Override
	public List<PageType> findAll(Iterable<Integer> ids) {
		return pageTypeDao.findAll(ids);
	}

	@Override
	public PageType findById(Integer id) {
		return pageTypeDao.findOne(id);
	}

	@Override
	public <S extends PageType> List<S> save(Iterable<S> entities) {
		return pageTypeDao.save(entities);
	}

	@Override
	public <S extends PageType> S saveAndFlush(S entity) {
		return pageTypeDao.saveAndFlush(entity);
	}

	@Override
	public <S extends PageType> void delete(S entity) {
		pageTypeDao.delete(entity);
	}

	@Override
	public void deleteInBatch(Iterable<PageType> entities) {
		pageTypeDao.deleteInBatch(entities);
	}

	@Override
	public <S extends PageType> List<S> findAll(Example<S> example) {
		return pageTypeDao.findAll(example);
	}

	@Override
	public <S extends PageType> List<S> findAll(Example<S> example, Sort sort) {
		return pageTypeDao.findAll(example,sort);
	}

	@Override
	public Page<PageType> findAll(Pageable pageable) {
		return pageTypeDao.findAll(pageable);
	}

}
