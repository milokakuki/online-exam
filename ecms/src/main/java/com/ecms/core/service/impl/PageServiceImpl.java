
package com.ecms.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecms.core.dao.PageDao;
import com.ecms.core.entity.Page;
import com.ecms.core.service.PageService;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className PageServiceImpl
 * @date 2018年4月18日上午10:08:58
 * @desc [用一句话描述改文件的功能]
 */
@Service("pageService")
public class PageServiceImpl implements PageService {

	@Autowired
	private PageDao pageDao;

	@Override
	public List<Page> findAll() {
		return pageDao.findAll();
	}

	@Override
	public List<Page> findAll(Sort sort) {
		return pageDao.findAll(sort);
	}

	@Override
	public List<Page> findAll(Iterable<Integer> ids) {
		return pageDao.findAll(ids);
	}

	@Override
	public Page findById(Integer id) {
		return pageDao.findOne(id);
	}

	@Override
	public <S extends Page> List<S> save(Iterable<S> entities) {
		return pageDao.save(entities);
	}

	@Override
	public <S extends Page> S saveAndFlush(S entity) {
		return pageDao.saveAndFlush(entity);
	}

	@Override
	public <S extends Page> void delete(S entity) {
		pageDao.delete(entity);
	}

	@Override
	public void deleteInBatch(Iterable<Page> entities) {
		pageDao.deleteInBatch(entities);
	}

	@Override
	public <S extends Page> List<S> findAll(Example<S> example) {
		return pageDao.findAll(example);
	}

	@Override
	public <S extends Page> List<S> findAll(Example<S> example, Sort sort) {
		return pageDao.findAll(example, sort);
	}

	@Override
	public org.springframework.data.domain.Page<Page> findAll(Pageable pageable) {
		return pageDao.findAll(pageable);
	}

	@Override
	public List<Page> findByStatus(int i) {
		return pageDao.findByStatus(i);
	}

}