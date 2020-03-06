package com.ecms.web.bind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className Status
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public enum Status {
	
	/**

	 * 草稿

	 */
	DRAFT(-1),
	/**

	 * 提交

	 */
	COMMIT(0),
	/**

	 * 发布

	 */
	PUSH(1),
	/**

	 * 临时

	 */
	TEMP(0),
	/**

	 * 可用

	 */
	ENABLE(1),
	/**

	 *锁定

	 */
	LOCKED(0),
	/**

	 * 可用

	 */
	ACTIVED(1);
	
	private Integer value;
	
	private Status(Integer value) {
		this.value = value;
	}
	
	public Integer value() {
		return value;
	}
	
	public String parseText() {
		return this.toString();
	}
	
	public static List<Status> list(){
		List<Status> list = new ArrayList<>(Arrays.asList(Status.values()));
		return list;
	}
}
