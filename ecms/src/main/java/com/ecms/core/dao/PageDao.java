
package com.ecms.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecms.core.entity.Page;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className PageDao
 * @date   2018年4月18日上午10:09:53
 * @desc  [用一句话描述改文件的功能]
 */
public interface PageDao extends JpaRepository<Page, Integer>{

	List<Page> findByStatus(int i);

}
