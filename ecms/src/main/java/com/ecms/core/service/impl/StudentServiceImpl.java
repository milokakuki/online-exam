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
