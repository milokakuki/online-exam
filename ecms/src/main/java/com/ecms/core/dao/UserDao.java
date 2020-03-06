package com.ecms.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecms.core.entity.User;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserDao
 * @date   2018年3月16日上午10:02:07
 * @desc  [用一句话描述改文件的功能]
 */
public interface UserDao extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
