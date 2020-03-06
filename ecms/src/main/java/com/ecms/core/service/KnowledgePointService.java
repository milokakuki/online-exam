
package com.ecms.core.service;

import java.util.Set;

import com.ecms.core.entity.Field;
import com.ecms.core.entity.KnowledgePoint;
import com.ecms.core.service.base.SimpleService;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className KnowledgeService
 * @date   2018年3月22日上午11:39:48
 * @desc  [用一句话描述改文件的功能]
 */
public interface KnowledgePointService extends SimpleService<KnowledgePoint, Integer>{

	Set<KnowledgePoint> getKnowledgePointByField(Field field);

}
