/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年4月18日上午9:43:54</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.core.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ecms.core.entity.Page;
import com.ecms.core.entity.PageType;
import com.ecms.core.entity.Question;
import com.ecms.core.entity.QuestionPage;
import com.ecms.core.entity.QuestionType;
import com.ecms.core.entity.User;
import com.ecms.core.entity.util.Data;
import com.ecms.core.service.FieldService;
import com.ecms.core.service.KnowledgePointService;
import com.ecms.core.service.PageService;
import com.ecms.core.service.PageTypeService;
import com.ecms.core.service.QuestionPageService;
import com.ecms.core.service.QuestionService;
import com.ecms.core.service.QuestionTypeService;
import com.ecms.web.bind.Const;
import com.ecms.web.bind.Status;
import com.ecms.web.view.RequestElement;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className PageController
 * @date 2018年4月18日上午9:43:54
 * @desc [试卷管理控制层]
 */
@Controller
@RequestMapping("/admin/page")
public class PageController {

	@Autowired
	private PageService pageService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionTypeService questionTypeService;

	@Autowired
	private FieldService fieldService;

	@Autowired
	private KnowledgePointService knowledgePointService;

	@Autowired
	private PageTypeService pageTypeService;

	@Autowired
	private QuestionPageService questionPageService;

	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@GetMapping("/list")
	public String list(RequestElement element, Model model) {
		Sort sort = new Sort(Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(element.getPageNo() - 1, element.getPageSize(), sort);
		org.springframework.data.domain.Page<Page> page = pageService.findAll(pageable);
		int total = page.getTotalPages();
        int start = element.getPageNo()-3>0?element.getPageNo()-3:1;
        int end = element.getPageNo()+3<total?element.getPageNo()+3:total;
        model.addAttribute("page", page).addAttribute("start", start).addAttribute("end", end);
		return "admin/page/list";
	}
	
	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable(name="id")int id) {
		Page page = pageService.findById(id);
		List<QuestionPage> list = questionPageService.findByPage(id);
		for (QuestionPage questionPage : list) {
			questionPageService.delete(questionPage);
			questionService.delete(questionPage.getQuestion());
		}
		if(page != null) {
			pageService.delete(page);
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
			Page page = pageService.findById(id);
			List<QuestionPage> list = questionPageService.findByPage(id);
			for (QuestionPage questionPage : list) {
				questionPageService.delete(questionPage);
			}
			if(page != null) {
				pageService.delete(page);
			}
		}
		return "ok";
	}
	
	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@GetMapping("/add")
	public String add(Model model) {

		List<Field> fields = fieldService.findAll();

		List<KnowledgePoint> KnowledgePoints = knowledgePointService.findAll();

		List<PageType> pageTypes = pageTypeService.findAll();

		model.addAttribute("fileds", fields).addAttribute("knowledges", KnowledgePoints).addAttribute("pageTypes",
				pageTypes);
		
		List<Status> status = new LinkedList<>();
		status.add(Status.ACTIVED);
		status.add(Status.LOCKED);
		model.addAttribute("status", status);

		return "admin/page/add";
	}

	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@PostMapping("/add")
	public String add(Page page, HttpSession session) {
		User user = (User)session.getAttribute(Const.LOGIN_ADMIN);
		page.setCreator(user.getUsername());
		page.setCreateTime(new Date());
		pageService.saveAndFlush(page);
		//return "redirect:/admin/page/edit/" + page.getId();
		return "redirect:/admin/page/list";
	}

	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@PostMapping("/updata")
	public String updata(Integer id, float point) {
		Page page = pageService.findById(id);
		page.setPassPoint(point);
		pageService.saveAndFlush(page);
		return "redirect:/admin/page/list";
	}

	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		Page page = pageService.findById(id);
		List<Question> single = new ArrayList<>();
		List<Question> multiple = new ArrayList<>();
		List<Question> judge = new ArrayList<>();
		List<Question> fill = new ArrayList<>();
		List<QuestionPage> list = questionPageService.findByPage(id);
		float total = 0;
		for (QuestionPage questionPage : list) {
			questionPage.getQuestion().setPoints(questionPage.getPoints());
			if (questionPage.getQuestion().getQuestionType().getId() == 1) {
				single.add(questionPage.getQuestion());
			} else if (questionPage.getQuestion().getQuestionType().getId() == 2) {
				multiple.add(questionPage.getQuestion());
			} else if (questionPage.getQuestion().getQuestionType().getId() == 3) {
				judge.add(questionPage.getQuestion());
			} else {
				fill.add(questionPage.getQuestion());
			}
			total += questionPage.getPoints();
		}
		
		List<Status> status = new LinkedList<>();
		status.add(Status.ACTIVED);
		status.add(Status.LOCKED);
		model.addAttribute("status", status);
		page.setTotalPoint(total);
		pageService.saveAndFlush(page);
		model.addAttribute("single", single);
		model.addAttribute("multiple", multiple);
		model.addAttribute("judge", judge);
		model.addAttribute("fill", fill);
		model.addAttribute("page", page);
		return "admin/page/edit";
	}
	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@PostMapping("/editforupdate")
	public String edit(Page page,HttpSession session){
		User user = (User)session.getAttribute(Const.LOGIN_ADMIN);
		page.setCreator(user.getUsername());
		pageService.saveAndFlush(page);
		return "redirect:/admin/page/list";
	}

	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@GetMapping("/addQuestion-{fieldId}-{knowledge}-{questionType}-{pid}")
	public String question(@PathVariable("fieldId") Integer fieldId, @PathVariable("knowledge") Integer knowledge,
			@PathVariable("questionType") Integer questionType, @PathVariable("pid") Integer pid,
			RequestElement element, Model model) {
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(element.getPageNo() - 1, element.getPageSize(), sort);
		//Field field = fieldService.findById(fieldId);
		//QuestionType qType = questionTypeService.findById(questionType);
		Page pagep = pageService.findById(pid);
		//org.springframework.data.domain.Page<Question> questions = questionService
		//		.findByFieldAndKnowledgePointAndQuestionType(field, knowledge, qType,pageable);
		//org.springframework.data.domain.Page<Question> questions = questionService
		//		.findByFieldAndKnowledgePointAndQuestionType(pagep,pageable);
		
		org.springframework.data.domain.Page<QuestionPage> questionPages = questionPageService.findByPagep(pagep, pageable);
				
		int total = questionPages.getTotalPages();
		int start = element.getPageNo() - 3 > 0 ? element.getPageNo() - 3 : 1;
		int end = element.getPageNo() + 3 < total ? element.getPageNo() + 3 : total;

		//List<Field> fields = fieldService.findAll();
		//model.addAttribute("fields", fields);
		//model.addAttribute("fieldId", fieldId);

		//List<KnowledgePoint> knowledgePoints = new ArrayList<>();
		//if (fieldId == 0) {
		//	knowledgePoints = knowledgePointService.findAll();
		//} else {
		//	knowledgePoints.addAll(knowledgePointService.getKnowledgePointByField(field));
		//}
		//model.addAttribute("knowledgePoints", knowledgePoints);
		//model.addAttribute("knowledge", knowledge);

		List<QuestionType> questionTypes = questionTypeService.findAll();
		model.addAttribute("questionTypes", questionTypes);
		model.addAttribute("questionType", questionType);
		
		//List<QuestionPage> questionPages = questionPageService.findByPage(pid);
		List<Integer> ids = new ArrayList<>();
		for (QuestionPage questionPage : questionPages) {
			ids.add(questionPage.getQuestion().getId());
		}
		
		model.addAttribute("ids", ids);
		model.addAttribute("pid", pid);
		model.addAttribute("page", questionPages).addAttribute("start", start).addAttribute("end", end);
		
		//return "admin/page/add_qustion";
		return "admin/question/list";
	}

	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@PostMapping(value = "/addQuestion", produces = "application/json;charset=UTF-8")
	@ResponseBody
	Data question(Integer pid, Integer... ids) {
		Page page = pageService.findById(pid);
		for (Integer id : ids) {
			Question question = questionService.findById(id);
			if (question != null) {
				QuestionPage questionPage = new QuestionPage();
				questionPage.setPage(page);
				questionPage.setQuestion(question);
				questionPage = questionPageService.saveAndFlush(questionPage);
			}
		}
		return Data.success(Data.NOOP);
	}

	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@GetMapping(value = "/deleteQuestion")
	public String delete_question(Integer qid, Integer pid, Model model) {
		List<QuestionPage> questions = questionPageService.findByPage(pid);
		for (QuestionPage po : questions) {
			if (po.getQuestion().getId() == qid) {
				questionPageService.delete(po);
			}
		}
		return "redirect:/admin/page/edit/" + pid;
	}

	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@GetMapping("/editPoints")
	public String edit_points(Integer qid, Integer pid, Model model) {
		Question question = questionService.findById(qid);
		Page page = pageService.findById(pid);
		model.addAttribute("question", question);
		model.addAttribute("page", page);
		return "admin/page/edit_question";
	}

	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@PostMapping(value = "/editPoints", produces = "application/json;charset=UTF-8")
	@ResponseBody
	Data edit_points(Integer qid, Integer pid, Integer type, Float points, Model model) {
		Data data = Data.failured("操作失败！");
		List<QuestionPage> questions = questionPageService.findByPage(pid);
		if (type == -1) {
			for (QuestionPage po : questions) {
				if (po.getQuestion().getId() == qid) {
					po.setPoints(points);
					questionPageService.updata(po);
					data = Data.success(Data.NOOP);
					return data;
				}
			}
			return data;
		} else {
			for (QuestionPage po : questions) {
				if (po.getQuestion().getQuestionType().getId() == type) {
					po.setPoints(points);
					questionPageService.updata(po);
				}
			}
			data = Data.success(Data.NOOP);
			return data;
		}

	}
	
	@RequiresRoles(value = {"ADMIN","TEACHER"}, logical= Logical.OR)
	@PostMapping("/toggle-status/{id}")
	@ResponseBody
	public String toggoleStatus(@PathVariable(name="id")Integer id) {
		Page page = pageService.findById(id);
		if(page != null) {
			int status = page.getStatus();
			switch(status) {
			case 0:page.setStatus(Status.ACTIVED.value());break;
			case 1:page.setStatus(Status.LOCKED.value());break;
			}
			pageService.saveAndFlush(page);
			return "yes";
		}else {
			return "no";
		}
	}
}
