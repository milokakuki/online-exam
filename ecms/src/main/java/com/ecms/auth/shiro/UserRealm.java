package com.ecms.auth.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecms.core.entity.User;
import com.ecms.core.service.UserService;
import com.ecms.web.bind.Status;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserService
 * @date   2018年3月16日上午9:56:21
 * @desc  [shiro权限认证文件]
 */
public class UserRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;

	/* (non-Javadoc)

	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)

	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		if(principal == null) {
			throw new AuthorizationException("凭证为空!");
		}
		SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
		Set<String> roles = new HashSet<>();
		String loginName = (String)principal.getPrimaryPrincipal();
		User user = null;
		user = userService.findByUsername(loginName);
		if(user != null) {
			roles.add(user.getTypeName());
			authInfo.setRoles(roles);
			return authInfo;
		}else {
			return null;
		}
	}

	/* (non-Javadoc)

	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)

	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		String loginName = (String) token.getPrincipal();
		User user = null;
		
		user = userService.findByUsername(loginName);
		
		if(user == null) {
			throw new UnknownAccountException("UnknownAccount!");
		}
		if(user.getStatus() == Status.LOCKED.value()) {
			throw new LockedAccountException("LockedAccount !");
		}
		SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo(
				user.getUsername(),
				user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()),
				getName());
		
		return authInfo;
	}
}
