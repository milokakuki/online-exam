package com.ecms.core.admin.controller;

import java.util.LinkedList;
import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecms.core.entity.Field;
import com.ecms.core.entity.KnowledgePoint;
import com.ecms.core.service.FieldService;
import com.ecms.core.service.KnowledgePointService;
import com.ecms.web.bind.Status;
import com.ecms.web.view.RequestElement;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className KnowledgePointController
 * @date   2018年3月22日上午11:38:36
 * @desc  [知识点管理控制层]
 */
@Controller
@RequestMapping("admin/knowledgePoint")
public class KnowledgePointController {
	
	@Autowired
	private KnowledgePointService knowledgePointService;
	
	@Autowired
	private FieldService fieldService;
	
	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@GetMapping("/list")
	public String list(RequestElement element, Model model) {
		Sort sort = new Sort(Direction.ASC, "id");
		Pageable pageable = new PageRequest(element.getPageNo()-1, element.getPageSize(), sort);
		Page<KnowledgePoint> knowledgePoints = knowledgePointService.findAll(pageable);
        int total = knowledgePoints.getTotalPages();
        int start = element.getPageNo()-3>0?element.getPageNo()-3:1;
        int end = element.getPageNo()+3<total?element.getPageNo()+3:total;
        model.addAttribute("page", knowledgePoints).addAttribute("start", start).addAttribute("end", end);
		return "admin/knowledge/list";
	}
	
	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@GetMapping("/add")
	public String add(Model model) {
		List<Status> status = new LinkedList<>();
		List<Field> fields = fieldService.findAll();
		status.add(Status.ACTIVED);
		status.add(Status.LOCKED);
		
		model.addAttribute("status", status).addAttribute("fields", fields);
		
		return "admin/knowledge/add";
	}
	
	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@PostMapping("/add")
	public String add(KnowledgePoint knowledgePoint) {
		knowledgePointService.saveAndFlush(knowledgePoint);
		return "redirect:/admin/knowledgePoint/list";
	}
	
	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable(name="id")int id) {
		KnowledgePoint knowledgePoint = knowledgePointService.findById(id);
		if(knowledgePoint != null) {
			knowledgePointService.delete(knowledgePoint);
			return "Y";
		}else {
			return "N";
		}
	}
	
	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@PostMapping("/deleteBatch")
	@ResponseBody
	public String deleteBatch(Integer...ids) {
		for (Integer id : ids) {
			KnowledgePoint knowledgePoint = knowledgePointService.findById(id);
			if(knowledgePoint != null) {
				knowledgePointService.delete(knowledgePoint);
			}
		}
		return "ok";
	}
	
	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable(name="id")int id, Model model) {
		KnowledgePoint knowledgePoint = knowledgePointService.findById(id);
		List<Status> status = new LinkedList<>();
		List<Field> fields = fieldService.findAll();
		status.add(Status.ACTIVED);
		status.add(Status.LOCKED);
		model.addAttribute("status", status).addAttribute("point", knowledgePoint).addAttribute("fields", fields);
		return "admin/knowledge/edit";
	}
	
	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@PostMapping("/edit")
	public String edit(KnowledgePoint knowledgePoint){
		knowledgePointService.saveAndFlush(knowledgePoint);
		return "redirect:/admin/knowledgePoint/list";
	}
}
