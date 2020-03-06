package com.ecms.core.service;

import com.ecms.core.entity.User;
import com.ecms.core.service.base.SimpleService;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserService
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public interface UserService extends SimpleService<User, Integer>{
	User findByUsername(String username);
	User upDate(User user);
}
