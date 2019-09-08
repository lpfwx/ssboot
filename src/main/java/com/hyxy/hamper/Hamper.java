package com.hyxy.hamper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hyxy.entity.Judge;

public class Hamper implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getServletPath());
		System.out.println("controller控制器被执行之前调用拦截器");
		Judge judge = (Judge) request.getSession().getAttribute("judge");
		if(judge==null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
	        return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("在controller控制器执行完后，呈现视图之前调用拦截器");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("controller控制器执行完后，呈现视图之后调用的拦载器，释放资源");
	}

}
