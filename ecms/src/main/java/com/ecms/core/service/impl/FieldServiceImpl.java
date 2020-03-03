/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年3月22日上午9:29:51</center>
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