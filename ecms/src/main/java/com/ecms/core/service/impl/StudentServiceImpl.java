/**

 *  TCMS2.0 版权声明<br/>

    <center>Copyright (c) 2018 www.ecms.com</center> 

 <center> 2018年1月30日</center>

<center>TCMS(ecms Content Management System)的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>

<center>未经桃李云事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云授权的所属服务器上做镜像或以其他任何方式使用。</center>

<center>凡侵犯桃李云版权等知识产权的，桃李云将依法追究其法律责任。</center>

 */
package com.ecms.core.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecms.core.dao.StudentDao;
import com.ecms.core.entity.Student;
import com.ecms.core.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public List<Student> findAll(Sort sort) {
		return studentDao.findAll(sort);
	}

	@Override
	public List<Student> findAll(Iterable<Integer> ids) {
		return studentDao.findAll(ids);
	}

	@Override
	public Student findById(Integer id) {
		return studentDao.findOne(id);
	}

	@Override
	public <S extends Student> List<S> save(Iterable<S> entities) {
		for(Student s:entities) {
			s.setCreateTime(new Date());
		}
		return studentDao.save(entities);
	}

	@Override
	public <S extends Student> S saveAndFlush(S entity) {
		entity.setCreateTime(new Date());
		return studentDao.saveAndFlush(entity);
	}

	@Override
	public <S extends Student> void delete(S entity) {
		studentDao.delete(entity);
	}

	@Override
	public void deleteInBatch(Iterable<Student> entities) {
		studentDao.deleteInBatch(entities);
	}

	@Override
	public <S extends Student> List<S> findAll(Example<S> example) {
		return studentDao.findAll(example);
	}

	@Override
	public <S extends Student> List<S> findAll(Example<S> example, Sort sort) {
		return studentDao.findAll(example,sort);
	}

	@Override
	public Page<Student> findAll(Pageable pageable) {
		return studentDao.findAll(pageable);
	}

	@Override
	public Student findByName(String username) {
		return studentDao.findByName(username);
	}

	@Override
	public Student upDate(Student student) {
		return studentDao.save(student);
	}

	@Override
	public Student findByStudentId(Integer studentId) {
		return studentDao.findByStudentid(studentId);
	}

	@Override
	public Student findByEmail(String email) {
		return studentDao.findByEmail(email);
	}

	@Override
	public Student findByStudentidAndEmailAndStatus(Integer studentId, String email, Integer status) {
		return studentDao.findByStudentidAndEmailAndStatus(studentId, email, status);
	}
		
}
