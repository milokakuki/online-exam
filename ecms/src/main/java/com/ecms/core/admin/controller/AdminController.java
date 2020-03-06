package com.ecms.core.admin.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecms.core.entity.User;
import com.ecms.core.service.UserService;
import com.ecms.web.bind.Const;
import com.ecms.web.bind.RoleType;
import com.ecms.web.bind.Status;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className AdminController
 * @date   2018年3月9日下午3:26:47
 * @desc  [登陆与注册控制层]
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	/**
	 * 进入主页面
	 * @param session
	 * @return
	 */
	@GetMapping("/index")
	public String index(HttpSession session) {
		User user = (User)session.getAttribute(Const.LOGIN_ADMIN);
		if(user == null) {
			return "redirect:/admin/login";
		}else {
			user = userService.findByUsername(user.getUsername());
			user.setLastLoginTime(new Date());
			userService.upDate(user);
			return "admin/index";
		}
	}
	
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}
	
	@PostMapping("/login")
	public String login(String username,String password,String validateCode,Model model) {
		Session session = SecurityUtils.getSubject().getSession();
		//String validate_code = (String)session.getAttribute(Const.CHECK_CODE);
		//if(validateCode == null || validateCode.trim().equals("")||!validateCode.trim().equalsIgnoreCase(validate_code)) {
		//	model.addAttribute("msg", "验证码不正确！");
		//	return "admin/login";
		//}
		//session.removeAttribute(Const.CHECK_CODE);
		Subject currUser = SecurityUtils.getSubject();
		if(!currUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			try {
				System.out.println(username+password);
				currUser.login(token);
			}catch(UnknownAccountException uaex) {
				model.addAttribute("msg", "用户名或密码不正确")
				.addAttribute("firstName", username)
				.addAttribute("password", password);
				//.addAttribute("validateCode", validateCode);
				return "admin/login";
			}catch(LockedAccountException laex) {
				model.addAttribute("msg", username+"已被锁定")
				.addAttribute("firstName", username)
				.addAttribute("password", password);
				//.addAttribute("validateCode", validateCode);
				return "admin/login";
			}catch(AuthenticationException aex) {
				model.addAttribute("msg", "用户名或密码不正确")
				.addAttribute("firstName", username)
				.addAttribute("password", password);
				//.addAttribute("validateCode", validateCode);
				return "admin/login";
			}
		}
		if(currUser.isAuthenticated()) {
			User user = null;
			user = userService.findByUsername(username);
			if(user != null) {
				session.setAttribute(Const.LOGIN_ADMIN, user);
				return "redirect:/admin/index";
			}else {
				return "admin/login";
			}
		}
		return "admin/login";
	}
	
	@GetMapping("/logout")
	public String logOut() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/admin/login";
	}

	
	@GetMapping("/register")
	public String register() {
		return "admin/register";
	}
	
	@PostMapping("/register")
	public String register(User user, Model model) {
		
		User tmp = userService.findByUsername(user.getUsername());
		if(tmp==null) {
			user.setTypeId(2);
			user.setTypeName(RoleType.STUDENT.parseText());
			user.setStatus(Status.ENABLE.value());
			userService.saveAndFlush(user);
			return "admin/login";
		}else {
			model.addAttribute("msg", "用户名已注册").addAttribute("user", user);
			return "admin/register";
		}
	}
}