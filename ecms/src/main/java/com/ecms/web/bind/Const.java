package com.ecms.web.bind;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className Const
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public class Const {

	
	/**

	 * 前端登录用户

	 */
	public static final String LOGIN_USER = "login_user";
	
	/**

	 * 后端登录用户

	 */
	public static final String LOGIN_ADMIN = "login_admin";
	
	/**

	 * 验证码

	 */
	public static final String CHECK_CODE = "check_code";
	
	/**

	 * 默认密码

	 */
	public static final String DEFAULT_PWD = "rcms123456";
	
	/**

	 * 七牛云对象存储

	 */
	public static final String OSS_QINIU = "oss-qiniu";
	
	/**

	 * 七牛云存储地址名称

	 */
	public static final String QINIU_PATH = "path";
	
	/**

	 * 七牛云存储接入码名称

	 */
	public static final String QINIU_ACCESS = "qiniuAccess";
	
	/**

	 * 七牛云存储秘钥名称

	 */
	public static final String QINIU_KEY = "qiniuKey";
	
	/**

	 * 七牛云存储“水桶”名称

	 */
	public static final String QINIU_BUCKET_NAME = "bucketName";
	
	/**

	 * 阿里云对象存储

	 */
	public static final String OSS_ALIYUN = "oss_aliyun";
	
	/**

	 * 默认第一页

	 */
	public static final Integer DEFAULT_PAGE_ON = 1;
	/**

	 * 默认的分页大小

	 */
	public static final Integer DEFAULT_PAGE_SIZE = 15;
	
	/**

	 * 男性

	 */
	public static final Integer MALE = 1;
	/**

	 * 女性

	 */
	public static final Integer FEMALE = 0;
	/**

	 * 性别保密

	 */
	public static final Integer SEX_SECRET = -1;
	
	/**

	 * 默认的用户头像

	 */
	public static final String DEFAULT_USER_AVATAR = "assert/img/default_user_avatar.png";
	
	/**

	 * 正则表达式：验证手机号码

	 */
	public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	
	/**

	 * 正则表达式：验证邮箱

	 */
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	
	/**

     * 正则表达式：验证身份证

     */
    public static final String REGEX_ID_CARD = "(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)";
    
    /**
     * 站点名称
     */
    public static final String SITE_NAME  = "site_name";
    /**
     * 站点标题
     */
    public static final String SITE_TITLE = "site_title";
    /**
     * 站点子标题
     */
    public static final String SITE_SUB_TITLE = "site_sub_title";
    /**
     * 站点域名
     */
    public static final String SITE_DOMAIN = "site_domain";
    /**
     * 站点联系邮箱
     */
    public static final String SITE_EMAIL = "site_email";
    /**
     * 站点联系地址
     */
    public static final String SITE_ADDRESS = "site_address";
    /**
     * 联系电话
     */
    public static final String SITE_MOBILE = "site_mobile";
    /**
     * 邮政编码
     */
    public static final String SITE_POST_CODE = "site_post_code";
    /**
     * 站点描述
     */
    public static final String SITE_DESCRIPTION = "site_description";
    /**
     * 站点关键词
     */
    public static final String SITE_KEYWORDS = "site_keywords";
    /**
     * 备案号
     */
    public static final String SITE_ICP = "site_icp";
    /**
     * 版权信息
     */
    public static final String SITE_COPYRIGHT = "site_copyright";
    /**
     * 站点标志
     */
    public static final String SITE_LOGO = "site_logo";
    
	public static class HttpClient{
		/**

		 * 基本路径

		 */
		public static final String BASE_PATH = basePath();
		
		/**

		 * 上下文路径

		 */
		public static final String CONTEXT_PATH = request().getServletContext().getContextPath();
		
		/**

		 * 静态化模板路径前缀

		 */
		public static final String TEMPLATE_PREFIX = context().getResource("static").getPath();
		
		public static final String STATIC_PATH = context().getResource("templates").getPath();
		
		private static String basePath() {
			ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			final String path = request.getScheme()+"://"
								+request.getServerName()+":"
								+(request.getServerPort()==80?"":request.getServerPort())
								+request.getContextPath();
			return path;
		}
		
		private static HttpServletRequest request() {
			ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			return request;
		}
		
		private static ClassLoader context() {
			ClassLoader loader = ClassUtils.getDefaultClassLoader();
			return loader;
		}
	}
}