package com.ecms.core.admin.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecms.core.entity.User;
import com.ecms.core.service.UserService;
import com.ecms.core.service.impl.PasswordHelper;
import com.ecms.web.bind.Const;
import com.ecms.web.bind.RoleType;
import com.ecms.web.bind.Status;
import com.ecms.web.view.RequestElement;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserController
 * @date   2018年3月19日下午2:02:06
 * @desc  [用户管理控制层]
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordHelper passwordHelper;
	
	@RequiresRoles(value = {"ADMIN"}, logical= Logical.OR)
	@GetMapping("/add")
	public String save(Model model) {
		List<RoleType> roles = RoleType.list();
		List<Status> status = new LinkedList<>();
		status.add(Status.ACTIVED);
		status.add(Status.LOCKED);
		model.addAttribute("roles", roles).addAttribute("status", status);
		return "admin/user/add";
	}
	
	@RequiresRoles(value = {"ADMIN"}, logical= Logical.OR)
	@PostMapping("/add")
	public String save(User user, Model model) {
		
		User tmp = userService.findByUsername(user.getUsername());
		if(tmp==null) {
			user.setTypeName(RoleType.text(user.getTypeId()).toString());
			userService.saveAndFlush(user);
			return "redirect:/admin/user/list";
		}else {
			List<RoleType> roles = RoleType.list();
			List<Status> status = new LinkedList<>();
			status.add(Status.ACTIVED);
			status.add(Status.LOCKED);
			model.addAttribute("roles", roles).addAttribute("status", status).addAttribute("msg", "用户名已用!").addAttribute("user", user);
			return "admin/user/add";
		}
	}
	
	@RequiresRoles(value = {"ADMIN"}, logical= Logical.OR)
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable(name="id")int id) {
		User user = userService.findById(id);
		if(user !=null){
			userService.delete(user);
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
			User user = userService.findById(id);
			if(user != null) {
				userService.delete(user);
			}
		}
		return "ok";
	}
	
	@RequiresRoles(value = {"ADMIN"}, logical= Logical.OR)
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable(name="id")Integer id,Model model) {
		User user = userService.findById(id);
		if(user != null){
			model.addAttribute("user", user);
			List<RoleType> roles = RoleType.list();
			List<Status> status = new LinkedList<>();
			status.add(Status.ACTIVED);
			status.add(Status.LOCKED);
			model.addAttribute("roles", roles).addAttribute("status", status);
		}else {
			return "redirect:/admin/user/list";
		}
		return "admin/user/edit";
	}
	
	@RequiresRoles(value = {"ADMIN"}, logical= Logical.OR)
	@PostMapping("/edit")
	public String edit(User user) {
		User u = userService.findById(user.getId());
		if(u != null) {
			user.setTypeName(RoleType.text(user.getTypeId()).toString());
			
			u.setUsername(user.getUsername());
			u.setRealname(user.getRealname());
			u.setPhone(user.getPhone());
			u.setEmail(user.getEmail());
			u.setProvince(user.getProvince());
			u.setStatus(user.getStatus());
			u.setTypeId(user.getTypeId());
			u.setTypeName(user.getTypeName());
			userService.upDate(u);
		}
		return "redirect:/admin/user/list";
	}
	
	@RequiresRoles(value = {"ADMIN"}, logical= Logical.OR)
	@GetMapping("/list")
	public String list(RequestElement element, Model model) {
		Sort sort = new Sort(Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(element.getPageNo()-1, element.getPageSize(), sort);
		Page<User> users = userService.findAll(pageable);
        int total = users.getTotalPages();
        int start = element.getPageNo()-3>0?element.getPageNo()-3:1;
        int end = element.getPageNo()+3<total?element.getPageNo()+3:total;
        model.addAttribute("page", users).addAttribute("start", start).addAttribute("end", end);
        return "admin/user/list";
	}
	
	@RequiresRoles(value = {"ADMIN"}, logical= Logical.OR)
	@PostMapping("/toggle-status/{id}")
	@ResponseBody
	public String toggoleStatus(@PathVariable(name="id")Integer id) {
		User user = userService.findById(id);
		if(user != null) {
			int status = user.getStatus();
			switch(status) {
			case 0:user.setStatus(Status.ACTIVED.value());break;
			case 1:user.setStatus(Status.LOCKED.value());break;
			}
			userService.upDate(user);
			return "yes";
		}else {
			return "no";
		}
	}
	
	@GetMapping("/pwd")
	public String modifyPwd() {
		return "admin/user/pwd";
	}
	
	@GetMapping("/checkpwd")
	@ResponseBody
	public String checkpwd(@RequestParam("pwd")String pwd,HttpSession session) {
		User u = (User)session.getAttribute(Const.LOGIN_ADMIN);
		User user = userService.findById(u.getId());
		String old_pwd = user.getPassword();
		user.setPassword(pwd);
		String new_pwd = passwordHelper.getPassword(user);
		if(new_pwd.equals(old_pwd)) {
			return "{\"state\":\"true\"}";
		}else {
			return "{\"state\":\"false\"}";
		}
	}
	
	@PostMapping("/modifypwd")
	public String modifypwd(@RequestParam("pwd")String pwd,HttpSession session) {
		User u = (User)session.getAttribute(Const.LOGIN_ADMIN);
		User user = userService.findById(u.getId());
		user.setPassword(pwd);
		userService.saveAndFlush(user);
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/admin/login";
	}
}
