package com.ecms.core.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecms.core.dao.UserDao;
import com.ecms.core.entity.User;
import com.ecms.core.service.UserService;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserService
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordHelper passwordHelper;	

	/* (non-Javadoc)
	 * @see com.ecms.core.service.base.SimpleService#findAll()
	 */
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.ecms.core.service.base.SimpleService#findAll(org.springframework.data.domain.Sort)
	 */
	@Override
	public List<User> findAll(Sort sort) {
		return userDao.findAll(sort);
	}

	/* (non-Javadoc)
	 * @see com.ecms.core.service.base.SimpleService#findAll(java.lang.Iterable)
	 */
	@Override
	public List<User> findAll(Iterable<Integer> ids) {
		return userDao.findAll(ids);
	}

	/* (non-Javadoc)
	 * @see com.ecms.core.service.base.SimpleService#findById(java.io.Serializable)
	 */
	@Override
	public User findById(Integer id) {
		return userDao.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.ecms.core.service.base.SimpleService#save(java.lang.Iterable)
	 */
	@Override
	public <S extends User> List<S> save(Iterable<S> entities) {
		for(User u:entities) {
			passwordHelper.encryptPassword(u);
			u.setCreateTime(new Date());
		}
		return userDao.save(entities);
	}

	/* (non-Javadoc)
	 * @see com.ecms.core.service.base.SimpleService#saveAndFlush(java.lang.Object)
	 */
	@Override
	public <S extends User> S saveAndFlush(S entity) {
		passwordHelper.encryptPassword(entity);
		entity.setCreateTime(new Date());
		return userDao.saveAndFlush(entity);
	}

	/* (non-Javadoc)
	 * @see com.ecms.core.service.base.SimpleService#delete(java.lang.Object)
	 */
	@Override
	public <S extends User> void delete(S entity) {
		userDao.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.ecms.core.service.base.SimpleService#deleteInBatch(java.lang.Iterable)
	 */
	@Override
	public void deleteInBatch(Iterable<User> entities) {
		userDao.deleteInBatch(entities);
	}

	/* (non-Javadoc)
	 * @see com.ecms.core.service.base.SimpleService#findAll(org.springframework.data.domain.Example)
	 */
	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		return userDao.findAll(example);
	}

	/* (non-Javadoc)
	 * @see com.ecms.core.service.base.SimpleService#findAll(org.springframework.data.domain.Example, org.springframework.data.domain.Sort)
	 */
	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		return userDao.findAll(example, sort);
	}

	/* (non-Javadoc)
	 * @see com.ecms.core.service.base.SimpleService#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<User> findAll(Pageable pageable) {
		return userDao.findAll(pageable);
	}

	/* (non-Javadoc)
	 * @see com.ecms.core.service.UserService#findByUsername(java.lang.String)
	 */
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User upDate(User user) {
		return userDao.save(user);
	}

}
