/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年3月19日下午2:02:06</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.core.admin.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecms.core.dao.StudentDao;
import com.ecms.core.entity.PageHistory;
import com.ecms.core.entity.Student;
import com.ecms.core.service.PageHistoryService;
import com.ecms.core.service.PageService;
import com.ecms.core.service.StudentService;
import com.ecms.web.view.RequestElement;

@Controller
@RequestMapping("/admin/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private PageHistoryService pageHistoryService;
	
	@Autowired
	private PageService pageService;

	@Autowired
	private StudentDao studentDao;

	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@GetMapping("/init")
	public String init(RequestElement element, Model model) {
		boolean flag = false;
		model.addAttribute("flag", flag);
		return "admin/student/list";
	}

	@GetMapping("/list")
	public String list(RequestElement element, Model model) {
		Sort sort = new Sort(Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(element.getPageNo() - 1, element.getPageSize(), sort);
		Page<Student> students = studentService.findAll(pageable);
		int total = students.getTotalPages();
		int start = element.getPageNo() - 3 > 0 ? element.getPageNo() - 3 : 1;
		int end = element.getPageNo() + 3 < total ? element.getPageNo() + 3 : total;
		model.addAttribute("page", students).addAttribute("start", start).addAttribute("end", end);
		boolean flag = true;
		model.addAttribute("flag", flag);
		return "admin/student/list";
	}

	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@PostMapping("/search")
	public String search(RequestElement element, Model model, @RequestParam("name") String name,
			@RequestParam("school") String school, @RequestParam("phone") String phone,
			@RequestParam("email") String email, HttpSession session) {
		Specification<Student> sp = new Specification<Student>() {

			@Override
			public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate condition1 = null;
				if (StringUtils.isNotBlank(name)) {
					condition1 = cb.like(root.get("name"), "%" + name + "%");
				} else {
					condition1 = cb.like(root.get("name"), "%%");
				}
				Predicate condition2 = null;
				if (StringUtils.isNotBlank(school)) {
					condition2 = cb.like(root.get("school"), "%" + school + "%");
				} else {
					condition2 = cb.like(root.get("school"), "%%");
				}
				Predicate condition3 = null;
				if (StringUtils.isNotBlank(phone)) {
					condition3 = cb.like(root.get("phone"), "%" + phone + "%");
				} else {
					condition3 = cb.like(root.get("phone"), "%%");
				}
				Predicate condition4 = null;
				if(StringUtils.isNotBlank(email)) {
					condition4 = cb.like(root.get("email"), "%" + email + "%");
				}else {
					condition4 = cb.like(root.get("email"), "%%");
				}

				query.where(condition1, condition2, condition3,condition4);
				return null;
			}

		};

		Sort sort = new Sort(Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(element.getPageNo() - 1, element.getPageSize(), sort);
		Page<Student> students = studentDao.findAll(sp, pageable);
		int total = students.getTotalPages();
		int start = element.getPageNo() - 3 > 0 ? element.getPageNo() - 3 : 1;
		int end = element.getPageNo() + 3 < total ? element.getPageNo() + 3 : total;
		model.addAttribute("page", students).addAttribute("start", start).addAttribute("end", end);
		boolean flag = true;
		model.addAttribute("flag", flag);
		
		return "admin/student/list";
	}

	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@GetMapping("/search")
	public String clear(Model model) {
		boolean flag = false;
		model.addAttribute("flag", flag);
		return "admin/student/list";
	}

	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@GetMapping("/add")
	public String add(Model model) {
		/**
		 * 添加试卷信息
		 */
		List<com.ecms.core.entity.Page> testPages = pageService.findAll();
		model.addAttribute("testPages", testPages);
		return "admin/student/add";
	}

	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@PostMapping("/add")
	public String save(Student student,@RequestParam("pageType1")String pageType1,@RequestParam("pageType2")String pageType2, Model model) {
		Student tmp = studentService.findByName(student.getName());
		Student tmp2 = studentService.findByEmail(student.getEmail());
		student.setCreateTime(new Date());
		if (tmp == null) {
			if(tmp2 == null) {
				Integer pType1 = 0; 
				if(pageType1 != "") {
					PageHistory pageHistory = new PageHistory();
					pType1 = Integer.parseInt(pageType1);
					pageHistory.setCreateTime(new Date());
					pageHistory.setStudent(student);
					com.ecms.core.entity.Page p1 = new com.ecms.core.entity.Page();
					p1.setId(pType1);
					pageHistory.setPage(p1);
					pageHistoryService.saveAndFlush(pageHistory);
				}
				Integer pType2 = 0;
				if(pageType2 != "") {
					PageHistory pageHistory2 = new PageHistory();
					pType2 = Integer.parseInt(pageType2);
					pageHistory2.setCreateTime(new Date());
					pageHistory2.setStudent(student);
					com.ecms.core.entity.Page p2 = new com.ecms.core.entity.Page();
					p2.setId(pType2);
					pageHistory2.setPage(p2);
					pageHistoryService.saveAndFlush(pageHistory2);
				}
				//studentService.saveAndFlush(student);
				return "redirect:/admin/student/list";
			}else {
				model.addAttribute("msg", "邮箱已用!").addAttribute("student", student);
				return "admin/student/add";
			}
			
		} else {
			model.addAttribute("msg", "用户名已用!").addAttribute("student", student);
			return "admin/student/add";
		}
		
	}

	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@GetMapping("/edit/{studentid}")
	public String edit(@PathVariable(name = "studentid") Integer studentId, Model model) {
		Student student = studentService.findByStudentId(studentId);
		if (student != null) {
			model.addAttribute("student", student);
		} else {
			return "redirect:/admin/student/list";
		}
		return "admin/student/edit";
	}

	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@PostMapping("/edit")
	public String edit(Student student) {
		Student s = studentService.findByStudentId(student.getStudentid());
		PageHistory p = pageHistoryService.findByStudent(s);
		if (s != null) {
			s.setName(student.getName());
			s.setPhone(student.getPhone());
			s.setSchool(student.getSchool());
			s.setMajor(student.getMajor());
			s.setBirthdate(student.getBirthdate());
			s.setDegree(student.getDegree());
			s.setUpdateTime(new Date());
			p.setStudent(s);
			pageHistoryService.upDate(p);
			// studentService.upDate(s);
		}
		return "redirect:/admin/student/list";
	}
	
	@RequiresRoles(value = {"ADMIN"}, logical= Logical.OR)
	@DeleteMapping("/delete/{studentid}")
	@ResponseBody
	public String delete(@PathVariable(name="studentid")int studentId) {
		Student student = studentService.findByStudentId(studentId);
		PageHistory pageHistory = pageHistoryService.findByStudent(student);
		if(student !=null && pageHistory != null){
			pageHistoryService.delete(pageHistory);
			studentService.delete(student);
			return "Y";
		}else {
			return "N";
		}
	}
	
	@RequiresRoles(value = {"ADMIN"}, logical= Logical.OR)
	@PostMapping(value="/deleteBatch")
	@ResponseBody
	public String deleteBatch(Integer...ids) {
		for (Integer id : ids) {
			Student student = studentService.findByStudentId(id);
			PageHistory pageHistory = pageHistoryService.findByStudent(student);
			if(student != null && pageHistory != null) {
				pageHistoryService.delete(pageHistory);
				studentService.delete(student);
			}
		}
		return "ok";
	}
	
	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@GetMapping("/generate")
	public String add2(Model model) {
		/**
		 * 添加试卷信息
		 */
		List<com.ecms.core.entity.Page> testPages = pageService.findAll();
		model.addAttribute("testPages", testPages);
		return "admin/student/add";
	}

	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@PostMapping("/generate")
	public String save2(Student student,@RequestParam("pageType1")String pageType1,@RequestParam("pageType2")String pageType2,@RequestParam("link")String link, Model model) {
		Student tmp = studentService.findByName(student.getName());
		Student tmp2 = studentService.findByEmail(student.getEmail());
		student.setCreateTime(new Date());
		if (tmp == null) {
			if(tmp2 == null) {
				Integer pType1 = 0; 
				if(pageType1 != "") {
					PageHistory pageHistory = new PageHistory();
					pType1 = Integer.parseInt(pageType1);
					pageHistory.setCreateTime(new Date());
					pageHistory.setStudent(student);
					com.ecms.core.entity.Page p1 = new com.ecms.core.entity.Page();
					p1.setId(pType1);
					pageHistory.setPage(p1);
					pageHistoryService.saveAndFlush(pageHistory);
				}
				Integer pType2 = 0;
				if(pageType2 != "") {
					PageHistory pageHistory2 = new PageHistory();
					pType2 = Integer.parseInt(pageType2);
					pageHistory2.setCreateTime(new Date());
					pageHistory2.setStudent(student);
					com.ecms.core.entity.Page p2 = new com.ecms.core.entity.Page();
					p2.setId(pType2);
					pageHistory2.setPage(p2);
					pageHistoryService.saveAndFlush(pageHistory2);
				}
				//studentService.saveAndFlush(student);
				int studentid = student.getStudentid();
				String email = student.getEmail();
				String strLink = "http://localhost:8081/admin/student/list?studentid="+studentid+"?email="+email;
				System.out.println("******************strLink = "+strLink+"*****************************");
				model.addAttribute("strLink", strLink).addAttribute("studentid", studentid);
				/**
				 * 添加试卷信息
				 */
				List<com.ecms.core.entity.Page> testPages = pageService.findAll();
				model.addAttribute("testPages", testPages);
			    return "admin/student/add";
			}else {
				model.addAttribute("msg", "邮箱已用!").addAttribute("student", student);
				return "admin/student/add";
			}
			
		} else {
			model.addAttribute("msg", "用户名已用!").addAttribute("student", student);
			return "admin/student/add";
		}
		
	}
	
}