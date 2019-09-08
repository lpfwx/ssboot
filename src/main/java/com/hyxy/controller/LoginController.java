package com.hyxy.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hyxy.entity.Judge;
import com.hyxy.service.LoginService;

@Controller
@RequestMapping("LoginController")
public class LoginController {
	@Resource
	private LoginService loginService;
	@RequestMapping("login")
	public String login(@RequestParam Map<String, String> map,HttpServletRequest request) {
		/*
		 * Judge judge = loginService.login(map); if (judge != null) {
		 * request.getSession().setAttribute("judge", judge); }else { return
		 * "redirect:login.jsp"; } return "index";
		 */
		// 获取登录验证类
		Subject subject = SecurityUtils.getSubject();
		// 把数据名和密码传给自定义的myshiro中的AuthenticationToken token用户登录信息接口
		UsernamePasswordToken token = new UsernamePasswordToken(map.get("username"), map.get("password"));
		try {
			subject.login(token);
			return "index";
		} catch (Exception e) {
		  return "forward:/login.jsp";
	    }
	}
	/**
	 * 退出登录
	 */
	   @RequestMapping("logout")
	   public String logout(HttpServletRequest request) {
	      // subject的实现类DelegatingSubject的logout方法，将本subject对象的session清空了
	      Subject subject = SecurityUtils.getSubject();
	      subject.logout();
	      return "forward:/login.jsp";
	   }
}
