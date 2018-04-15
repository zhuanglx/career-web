package com.railway.labor.career.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.railway.labor.career.model.dto.LoginInfoDTO;
import com.railway.labor.career.model.query.LoginInfoQuery;
import com.railway.labor.career.service.PermissionService;
import com.railway.labor.career.service.RoleService;
import com.railway.labor.career.service.UserService;

public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		LoginInfoQuery loginInfoQuery = (LoginInfoQuery) principalCollection
				.getPrimaryPrincipal();
		LoginInfoDTO loginInfoDTO = userService.login(loginInfoQuery.getAccount(),
				loginInfoQuery.getPassword());

		if (loginInfoDTO == null) {
			return null;
		}
		// RoleQuery roleQuery = new RoleQuery();
		// roleQuery.se
		// roleService.query(roleQuery);

		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

		//
		// for (Role role:user.getRoles()) {
		// //添加角色
		// simpleAuthorizationInfo.addRole(role.getRoleName());
		// for (Permission permission:role.getPermissions()) {
		// //添加权限
		// simpleAuthorizationInfo.addStringPermission(permission.getPermission());
		// }
		// }
		return simpleAuthorizationInfo;
	}

	// 用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		if (authenticationToken.getPrincipal() == null) {
			return null;
		}
		// 获取用户信息
		LoginInfoQuery loginInfoQuery = (LoginInfoQuery) authenticationToken
				.getPrincipal();
		LoginInfoDTO loginInfoDTO = userService.login(loginInfoQuery.getAccount(),
				loginInfoQuery.getPassword());
		if (loginInfoDTO == null) {
			return null;
		} else {
			return new SimpleAuthenticationInfo(loginInfoQuery,
					loginInfoQuery.getPassword(), getName());
		}
	}

}
