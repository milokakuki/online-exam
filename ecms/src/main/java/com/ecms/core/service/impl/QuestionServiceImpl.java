/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年3月21日下午3:08:52</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.SetJoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecms.core.dao.QuestionDao;
import com.ecms.core.entity.Field;
import com.ecms.core.entity.KnowledgePoint;
import com.ecms.core.entity.Question;
import com.ecms.core.entity.QuestionType;
import com.ecms.core.service.QuestionService;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className QuestionServiceImpl
 * @date   2018年3月21日下午3:08:52
 * @desc  [用一句话描述改文件的功能]
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public List<Question> findAll() {
		return questionDao.findAll();
	}

	@Override
	public List<Question> findAll(Sort sort) {
		return questionDao.findAll(sort);
	}

	@Override
	public List<Question> findAll(Iterable<Integer> ids) {
		return questionDao.findAll(ids);
	}

	@Override
	public Question findById(Integer id) {
		return questionDao.findOne(id);
	}

	@Override
	public <S extends Question> List<S> save(Iterable<S> entities) {
		return questionDao.save(entities);
	}

	@Override
	@Transactional
	public <S extends Question> S saveAndFlush(S entity) {
		return questionDao.saveAndFlush(entity);
	}

	@Override
	public <S extends Question> void delete(S entity) {
		questionDao.delete(entity);
	}

	@Override
	public void deleteInBatch(Iterable<Question> entities) {
		questionDao.deleteInBatch(entities);
	}

	@Override
	public <S extends Question> List<S> findAll(Example<S> example) {
		return questionDao.findAll(example);
	}

	@Override
	public <S extends Question> List<S> findAll(Example<S> example, Sort sort) {
		return questionDao.findAll(example,sort);
	}

	@Override
	public Page<Question> findAll(Pageable pageable) {
		return questionDao.findAll(pageable);
	}

	@Override
	public Page<Question> findByFieldAndKnowledgePointAndQuestionType(Field field, Integer knowledgePoint, QuestionType type, Pageable pageable) {
		Page<Question> page = questionDao.findAll((root, query, builder) -> {

			List<Order> orders = new ArrayList<>();

			orders.add(builder.asc(root.<Long>get("id")));

			Predicate predicate = builder.conjunction();

			if (field != null && field.getId() > 0) {
				predicate.getExpressions().add(
						builder.equal(root.get("field").as(Field.class), field));
			}
			
			if (knowledgePoint != null && knowledgePoint > 0) {
				SetJoin<Question,KnowledgePoint> depJoin = root.join(root.getModel().getSet("knowledgePoint",KnowledgePoint.class));  
				predicate.getExpressions().add(
						builder.equal(depJoin.get("id").as(Integer.class), knowledgePoint));
			}
			if (type != null && type.getId() > 0) {
				predicate.getExpressions().add(
						builder.equal(root.get("questionType").as(QuestionType.class), type));
			}
			query.orderBy(orders);
			return predicate;
		}, pageable);
		
		return page;
	}

	@Override
	public List<Question> findAllByFieldAndKnowledgePointAndQuestionType(Field field, Integer knowledgePoint,
			QuestionType type) {
		List<Question> questions = questionDao.findAll((root, query, builder) -> {

			List<Order> orders = new ArrayList<>();

			orders.add(builder.asc(root.<Long>get("id")));

			Predicate predicate = builder.conjunction();

			if (field != null && field.getId() > 0) {
				predicate.getExpressions().add(
						builder.equal(root.get("field").as(Field.class), field));
			}
			
			if (knowledgePoint != null && knowledgePoint > 0) {
				SetJoin<Question,KnowledgePoint> depJoin = root.join(root.getModel().getSet("knowledgePoint",KnowledgePoint.class));  
				predicate.getExpressions().add(
						builder.equal(depJoin.get("id").as(Integer.class), knowledgePoint));
			}
			if (type != null && type.getId() > 0) {
				predicate.getExpressions().add(
						builder.equal(root.get("questionType").as(QuestionType.class), type));
			}
			query.orderBy(orders);
			return predicate;
		});
		return questions;
	}
	
	@Override
	@Transactional
	public void update(Question po) {
		questionDao.save(po);
	}

}
