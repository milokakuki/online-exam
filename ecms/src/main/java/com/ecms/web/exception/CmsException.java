package com.ecms.web.exception;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className CmsException
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public class CmsException extends RuntimeException{

	private static final long serialVersionUID = 7106822586251164559L;

	protected String key;
	protected Object[] args;

	/**

	 * 

	 */
	public CmsException() {
		super();
	}

	/**

	 * @param arg0

	 * @param arg1

	 * @param arg2

	 * @param arg3

	 */
	public CmsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**

	 * @param arg0

	 * @param arg1

	 */
	public CmsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**

	 * @param arg0

	 */
	public CmsException(String key) {
		super(key);
	}

	/**

	 * @param arg0

	 */
	public CmsException(Throwable arg0) {
		super(arg0);
	}
}
