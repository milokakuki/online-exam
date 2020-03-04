package com.ecms.core.admin.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecms.core.dao.PageHistoryDao;
import com.ecms.core.dao.StudentDao;
import com.ecms.core.entity.PageHistory;
import com.ecms.core.entity.Student;
import com.ecms.core.service.PageHistoryService;
import com.ecms.web.view.RequestElement;

@Controller
@RequestMapping("/admin/mark")
public class MarkController {

	@Autowired
	private PageHistoryService pageHistoryService;
	
	@Autowired
	private PageHistoryDao pageHistoryDao;

	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@GetMapping("/init")
	public String init(RequestElement element, Model model) {
		boolean flag = false;
		model.addAttribute("flag", flag);
		return "admin/mark/list";
	}
	
	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@GetMapping("/list")
	public String list(RequestElement element, Model model) {
		Sort sort = new Sort(Direction.DESC, "endTime");
		Pageable pageable = new PageRequest(element.getPageNo() - 1, element.getPageSize(), sort);
		Page<PageHistory> phs = pageHistoryService.findAll(pageable);
		int total = phs.getTotalPages();
		int start = element.getPageNo() - 3 > 0 ? element.getPageNo() - 3 : 1;
		int end = element.getPageNo() + 3 < total ? element.getPageNo() + 3 : total;
		model.addAttribute("page", phs).addAttribute("start", start).addAttribute("end", end);
		boolean flag = true;
		model.addAttribute("flag", flag);
		
		//System.out.println(phs.toString());
		return "admin/mark/list";
	}
	
	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@PostMapping("/search")
	public String search(RequestElement element, Model model, @RequestParam("name") String name,
			@RequestParam("school") String school, @RequestParam("phone") String phone,
			@RequestParam("email") String email, HttpSession session) {
		Specification<PageHistory> sp = new Specification<PageHistory>() {

			@Override
			public Predicate toPredicate(Root<PageHistory> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate condition1 = null;
				Join<Student, PageHistory> join = root.join("student", JoinType.LEFT);
				if (StringUtils.isNotBlank(name)) {
					condition1 = cb.like(join.get("name"), "%" + name + "%");
				} else {
					condition1 = cb.like(join.get("name"), "%%");
				}
				Predicate condition2 = null;
				if (StringUtils.isNotBlank(school)) {
					condition2 = cb.like(join.get("school"), "%" + school + "%");
				} else {
					condition2 = cb.like(join.get("school"), "%%");
				}
				Predicate condition3 = null;
				if (StringUtils.isNotBlank(phone)) {
					condition3 = cb.like(join.get("phone"), "%" + phone + "%");
				} else {
					condition3 = cb.like(join.get("phone"), "%%");
				}
				Predicate condition4 = null;
				if(StringUtils.isNotBlank(email)) {
					condition4 = cb.like(join.get("email"), "%" + email + "%");
				}else {
					condition4 = cb.like(join.get("email"), "%%");
				}
				query.where(condition1, condition2, condition3,condition4);
				return null;
			}
		};

		Sort sort = new Sort(Direction.DESC, "endTime");
		Pageable pageable = new PageRequest(element.getPageNo() - 1, element.getPageSize(), sort);
		Page<PageHistory> phs = pageHistoryDao.findAll(sp,pageable);
		int total = phs.getTotalPages();
		int start = element.getPageNo() - 3 > 0 ? element.getPageNo() - 3 : 1;
		int end = element.getPageNo() + 3 < total ? element.getPageNo() + 3 : total;
		model.addAttribute("page", phs).addAttribute("start", start).addAttribute("end", end);
		boolean flag = true;
		model.addAttribute("flag", flag);
		
		return "admin/mark/list";
	}
	
	@RequiresRoles(value = { "ADMIN" }, logical = Logical.OR)
	@GetMapping("/manual/{pagehistoryid}")
	public String edit(@PathVariable(name = "pagehistoryid") Integer pagehistoryId, Model model) {
		PageHistory ph = pageHistoryService.findById(pagehistoryId);
		if (ph != null) {
			model.addAttribute("questions", ph.getPage().getQuestionPages());
			
			System.out.println("测试是否可以取得数据:"+ph.getAnswers());
		} else {
			return "redirect:/admin/mark/list";
		}
		return "admin/mark/detail";
	}
}
