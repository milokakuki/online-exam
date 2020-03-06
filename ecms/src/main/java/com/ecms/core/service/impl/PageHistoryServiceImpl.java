
package com.ecms.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecms.core.dao.PageHistoryDao;
import com.ecms.core.entity.PageHistory;
import com.ecms.core.entity.Student;
import com.ecms.core.entity.User;
import com.ecms.core.service.PageHistoryService;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className PageHistoryServiceImpl
 * @date 2018年5月3日上午11:18:00
 * @desc [用一句话描述改文件的功能]
 */
@Service("pageHistoryService")
public class PageHistoryServiceImpl implements PageHistoryService {

	@Autowired
	private PageHistoryDao historyDao;

	@Override
	public List<PageHistory> findAll() {
		return historyDao.findAll();
	}

	@Override
	public List<PageHistory> findAll(Sort sort) {
		return historyDao.findAll(sort);
	}

	@Override
	public List<PageHistory> findAll(Iterable<Integer> ids) {
		return historyDao.findAll(ids);
	}

	@Override
	public PageHistory findById(Integer id) {
		return historyDao.findOne(id);
	}

	@Override
	public <S extends PageHistory> List<S> save(Iterable<S> entities) {
		return historyDao.save(entities);
	}

	@Override
	public <S extends PageHistory> S saveAndFlush(S entity) {
		return historyDao.saveAndFlush(entity);
	}

	@Override
	public <S extends PageHistory> void delete(S entity) {
		historyDao.delete(entity);
	}

	@Override
	public void deleteInBatch(Iterable<PageHistory> entities) {
		historyDao.deleteInBatch(entities);
	}

	@Override
	public <S extends PageHistory> List<S> findAll(Example<S> example) {
		return historyDao.findAll(example);
	}

	@Override
	public <S extends PageHistory> List<S> findAll(Example<S> example, Sort sort) {
		return historyDao.findAll(example, sort);
	}

	@Override
	public Page<PageHistory> findAll(Pageable pageable) {
		return historyDao.findAll(pageable);
	}
	
	@Override
	public PageHistory findByPageAndStudent(com.ecms.core.entity.Page page, Student student) {
		return historyDao.findByPageAndStudent(page, student);
	}

	@Override
	public List<PageHistory> findByStudent(Student student) {
		return historyDao.findByStudent(student);
	}
	
	@Override
	public PageHistory upDate(PageHistory pageHistory) {
		return historyDao.save(pageHistory);
	}

	@Override
	public PageHistory findByPageAndStudentAndStatus(com.ecms.core.entity.Page page, Student student, Integer status) {
		return historyDao.findByPageAndStudentAndStatus(page, student, status);
	}

	@Override
	public List<PageHistory> findAllByPageAndStudentAndStatus(com.ecms.core.entity.Page page, Student student, Integer status) {
		List<PageHistory> pageHistories = historyDao.findAll((root, query, builder) -> {

			List<Order> orders = new ArrayList<>();

			orders.add(builder.asc(root.<Long>get("id")));

			Predicate predicate = builder.conjunction();

			if (page != null && page.getId() > 0) {
				predicate.getExpressions().add(
						builder.equal(root.get("page").as(com.ecms.core.entity.Page.class), page));
			}
			
			if (student != null && student.getStudentid() > 0) {
				predicate.getExpressions().add(
						builder.equal(root.get("student").as(Student.class), student));
			}
			
			predicate.getExpressions().add(
					builder.equal(root.get("status").as(Integer.class), status));
			
			query.orderBy(orders);
			return predicate;
		});
		return pageHistories;
	}

	@Override
	public List<PageHistory> findAllByStudentAndStatus(Student student, Integer status) {
		List<PageHistory> pageHistories = historyDao.findAll((root, query, builder) -> {

			List<Order> orders = new ArrayList<>();

			orders.add(builder.asc(root.<Long>get("id")));

			Predicate predicate = builder.conjunction();
			
			if (student != null && student.getStudentid() > 0) {
				predicate.getExpressions().add(
						builder.equal(root.get("student").as(Student.class), student));
			}
			
			predicate.getExpressions().add(
					builder.equal(root.get("status").as(Integer.class), status));
			
			query.orderBy(orders);
			return predicate;
		});
		return pageHistories;
	}

}