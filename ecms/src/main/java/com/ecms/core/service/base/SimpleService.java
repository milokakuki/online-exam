package com.ecms.core.service.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserService
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public interface SimpleService<T, ID extends Serializable> {
	
	List<T> findAll();

	List<T> findAll(Sort sort);

	List<T> findAll(Iterable<ID> ids);
	
	T findById(ID id);

	<S extends T> List<S> save(Iterable<S> entities);

	<S extends T> S saveAndFlush(S entity);

	<S extends T> void delete(S entity);
	
	void deleteInBatch(Iterable<T> entities);

	<S extends T> List<S> findAll(Example<S> example);

	<S extends T> List<S> findAll(Example<S> example, Sort sort);
	
	Page<T> findAll(Pageable pageable);
}
