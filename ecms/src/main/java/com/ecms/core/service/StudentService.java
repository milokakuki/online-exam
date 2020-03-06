package com.ecms.core.service;


import com.ecms.core.entity.Student;
import com.ecms.core.service.base.SimpleService;


public interface StudentService extends SimpleService<Student, Integer>{
	Student findByName(String username);
	Student findByEmail(String email);
	Student findByStudentId(Integer studentId);
	Student upDate(Student student);
	Student findByStudentidAndEmailAndStatus(Integer studentId,  String email, Integer status);
}
