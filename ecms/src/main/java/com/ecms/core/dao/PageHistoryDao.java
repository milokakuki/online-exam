
package com.ecms.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

import com.ecms.core.entity.Page;
import com.ecms.core.entity.PageHistory;
import com.ecms.core.entity.Student;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className PageHistory
 * @date 2018年5月3日上午11:15:42
 * @desc [用一句话描述改文件的功能]
 */
public interface PageHistoryDao extends JpaRepository<PageHistory, Integer>, JpaSpecificationExecutor<PageHistory>{
	PageHistory findByPageAndStudent(Page page,Student student);
	List<PageHistory> findByStudent(Student student);
   PageHistory findByPageAndStudentAndStatus(Page page, Student student, Integer status);
   List<Page> findPageByStudentAndStatus(Student student, Integer status);
}
