/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年4月28日下午2:14:20</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecms.core.entity.Field;
import com.ecms.core.entity.Page;
import com.ecms.core.entity.PageHistory;
import com.ecms.core.entity.Question;
import com.ecms.core.entity.QuestionPage;
import com.ecms.core.entity.Student;
import com.ecms.core.entity.User;
import com.ecms.core.entity.util.Data;
import com.ecms.core.service.FieldService;
import com.ecms.core.service.PageHistoryService;
import com.ecms.core.service.PageService;
import com.ecms.core.service.QuestionPageService;
import com.ecms.core.service.QuestionService;
import com.ecms.core.service.StudentService;
import com.ecms.core.service.UserService;
import com.ecms.web.bind.Const;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className IndexController
 * @date 2018年4月28日下午2:14:20
 * @desc [用一句话描述改文件的功能]
 */
@Controller
public class IndexController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private UserService userService;

	@Autowired
	private FieldService fieldService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private PageService pageService;

	@Autowired
	private QuestionPageService questionPageService;

	@Autowired
	private PageHistoryService pageHistoryService;


	@GetMapping(value = { "/", "/index" })
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/setting")
	public String setting(HttpSession session, Model model) {
		User user = (User) session.getAttribute(Const.LOGIN_ADMIN);
		if (user == null) {
			return "redirect:/admin/login";
		} else {
			user = userService.findByUsername(user.getUsername());
			user.setLastLoginTime(new Date());
			userService.upDate(user);
			List<Field> fields = fieldService.findAll();
			model.addAttribute("fields", fields);
			model.addAttribute("user", user);
			return "setting";
		}
	}

	@PostMapping("/setting")
	public String setting(User user) {
		User po = userService.findById(user.getId());
		po.setPhone(user.getPhone());
		po.setEmail(user.getEmail());
		userService.upDate(po);
		return "redirect:/";
	}

	@GetMapping("/practice")
	public String practice() {
		return "practice";
	}

	@GetMapping("/list_page")
	public String list_page(Model model, HttpSession session) {
		User user = (User) session.getAttribute(Const.LOGIN_ADMIN);
		if (user == null) {
			return "error/login_error";
		} else {
			List<Page> pages = pageService.findByStatus(1);
			model.addAttribute("list", pages);
			return "list_page";
		}
	}
	
	@GetMapping("/test_page1")
	public String test_page1(Model model, HttpSession session) {
		User user = (User) session.getAttribute(Const.LOGIN_ADMIN);
		if (user == null) {
			return "error/login_error";
		} else {
			List<Page> pages = pageService.findByStatus(1);
			model.addAttribute("list", pages);
			return "test_page1";
		}
	}

//	@GetMapping("/detail_page")
//	public String detail_page(Integer id, HttpSession session, Model model) {
//		//User user = (User) session.getAttribute(Const.LOGIN_ADMIN);
//		Student student = (Student)session.getAttribute(Const.LOGIN_ADMIN);
//		if (student == null) {
//			return "redirect:/admin/login";
//		} else {
//			student = studentService.findByName(student.getName());
//			Page page = pageService.findById(id);
//			List<QuestionPage> questionPages = questionPageService.findByPage(id);
//			List<Question> questions = new ArrayList<>();
//			for (QuestionPage questionPage : questionPages) {
//				questions.add(questionPage.getQuestion());
//			}
//
//			PageHistory po = pageHistoryService.findByPageAndUserAndStatus(page, student, true);
//
//			long time = 0;
//			if (po != null) {
//				time = page.getDuration() * 60 *1000 + po.getCreateTime().getTime() - new Date().getTime();
//				model.addAttribute("pageHistory", po);
//			} else {
//				PageHistory pageHistory = new PageHistory();
//				pageHistory.setStatus(true);
//				pageHistory.setPage(page);
//				pageHistory.setUser(user);
//				pageHistory.setCreateTime(new Date());
//				pageHistoryService.saveAndFlush(pageHistory);
//
//				time = page.getDuration() * 60 * 1000 + pageHistory.getCreateTime().getTime() - new Date().getTime();
//				model.addAttribute("pageHistory", pageHistory);
//
//			}
//			time = time - time%1000;
//			if(time>0){
//				time /= 1000;
//			}else{
//				time = 0;
//			}
//			model.addAttribute("time", String.valueOf(time));
//			model.addAttribute("questions", questions);
//			model.addAttribute("page", page);
//			return "detail_page";
//		}
//	}
	
	@GetMapping("/detail_page")
	public String detail_page(Integer id, HttpSession session, Model model) {
		//User user = (User) session.getAttribute(Const.LOGIN_ADMIN);
		Student student = (Student)session.getAttribute(Const.LOGIN_ADMIN);
		if (student == null) {
			return "redirect:/admin/login";
		} else {
			student = studentService.findByName(student.getName());
			Page page = pageService.findById(id);
			List<QuestionPage> questionPages = questionPageService.findByPage(id);
			List<Question> questions = new ArrayList<>();
			for (QuestionPage questionPage : questionPages) {
				questions.add(questionPage.getQuestion());
			}

			PageHistory po = pageHistoryService.findByPageAndStudent(page, student);

			long time = 0;
			if (po != null) {
				time = page.getDuration() * 60 *1000 + po.getCreateTime().getTime() - new Date().getTime();
				model.addAttribute("pageHistory", po);
			} else {
				PageHistory pageHistory = new PageHistory();
				pageHistory.setStatus(true);
				pageHistory.setPage(page);
				pageHistory.setStudent(student);
				pageHistory.setCreateTime(new Date());
				pageHistoryService.saveAndFlush(pageHistory);

				time = page.getDuration() * 60 * 1000 + pageHistory.getCreateTime().getTime() - new Date().getTime();
				model.addAttribute("pageHistory", pageHistory);

			}
			time = time - time%1000;
			if(time>0){
				time /= 1000;
			}else{
				time = 0;
			}
			model.addAttribute("time", String.valueOf(time));
			model.addAttribute("questions", questions);
			model.addAttribute("page", page);
			return "detail_page";
		}
	}
	
	
	
	@GetMapping("/submit_page")
	@ResponseBody
	Data submit_page(PageHistory pageHistory) {

		PageHistory po = pageHistoryService.findById(pageHistory.getId());
		po.setAnswers(pageHistory.getAnswers());
		float counts = 0;

		for (Integer key : po.getAnswers().keySet()) {
			Question question = questionService.findById(key);
			String answer = po.getAnswers().get(key);
			if (answer.equals(question.getAnswer())) {
				QuestionPage questionPage = questionPageService.findByPageAndQuestion(po.getPage(), question);
				counts += questionPage.getPoints();
			}
		}
		po.setCounts(counts);
		po.setStatus(false);
		pageHistoryService.saveAndFlush(po);

		return Data.success(Data.NOOP);
	}
	
	@GetMapping("/user_page")
	public String user_page(Model model, HttpSession session) {
		User user = (User) session.getAttribute(Const.LOGIN_ADMIN);
		if (user == null) {
			return "redirect:/admin/login";
		}
		user = userService.findByUsername(user.getUsername());
		List<PageHistory> pageHistories = pageHistoryService.findAllByPageAndUserAndStatus(null, user, false);

		model.addAttribute("list", pageHistories);
		return "user_page";
	}
}