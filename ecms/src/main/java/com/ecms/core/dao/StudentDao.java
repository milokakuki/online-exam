package com.ecms.core.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ecms.core.entity.Student;

public interface StudentDao extends  JpaRepository<Student, Integer> , JpaSpecificationExecutor<Student>{
	Student findByName(String name);
	Student findByEmail(String email);
	Student findByStudentid(Integer studentId);
	Student findByStudentidAndEmailAndStatus(Integer studentId, String email, Integer status);
}
