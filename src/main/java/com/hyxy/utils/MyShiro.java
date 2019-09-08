package com.hyxy.utils;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.hyxy.entity.Judge;
import com.hyxy.service.LoginService;

public class MyShiro extends AuthorizingRealm {
	@Resource
	private LoginService loginService;
	 /**
	 * 用户登录验证
	 */

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// token封装了用户登录信息
	      // 获取用户名
	      String userName = (String) token.getPrincipal();
	      // 跟据用户名查询用户信息
	      Judge judge = loginService.getByUserName(userName);
	      if (judge != null) {
	         //从数据库获取到用户和密码，会和提交的用户名密码进行比较,不匹配会报错
	         AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(judge.getUsername(), judge.getPassword(), "");
	         return authcInfo;
	      } else {
	         return null;
	      }
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		 // 获取用户名
	      String userName = (String) principals.getPrimaryPrincipal();
	   // 获取到当前登录用户的认证信息
	      SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	   // 给用户授权角色
	      authorizationInfo.setRoles(loginService.getRoles(userName));
	      // 给用户授权权限
	      authorizationInfo.setStringPermissions(loginService.getPermissions(userName));
		return authorizationInfo;
	}
	
}
