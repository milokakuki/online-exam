
package com.ecms.core.service;

import java.util.List;

import com.ecms.core.entity.Page;
import com.ecms.core.service.base.SimpleService;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className PageService
 * @date   2018年4月18日上午10:08:01
 * @desc  [用一句话描述改文件的功能]
 */
public interface PageService extends SimpleService<Page, Integer>{

	List<Page> findByStatus(int i);
	

}
