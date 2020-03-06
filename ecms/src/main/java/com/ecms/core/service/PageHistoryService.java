
package com.ecms.core.service;

import java.util.List;

import com.ecms.core.entity.Page;
import com.ecms.core.entity.PageHistory;
import com.ecms.core.entity.Student;
import com.ecms.core.service.base.SimpleService;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className PageHistoryService
 * @date 2018年5月3日上午11:16:42
 * @desc [用一句话描述改文件的功能]
 */
public interface PageHistoryService extends SimpleService<PageHistory, Integer> {
	PageHistory findByPageAndStudent(Page page,Student student);
	List<PageHistory> findByStudent(Student student);
	PageHistory upDate(PageHistory pageHistory);
	PageHistory findByPageAndStudentAndStatus(Page page, Student student, Integer status);
	List<PageHistory> findAllByPageAndStudentAndStatus(Page page, Student student, Integer status);
	List<PageHistory> findAllByStudentAndStatus(Student student, Integer status);
}
