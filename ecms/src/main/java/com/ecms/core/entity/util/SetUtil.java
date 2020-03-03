package com.ecms.core.entity.util;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className QuestionController
 * @date 2018年3月21日下午12:07:08
 * @desc [用一句话描述改文件的功能]
 */
public class SetUtil {

	/**

	 * 获取两个集合的交集

	 * 

	 * @param s1

	 * @param s2

	 * @return

	 */
	public static <T> Set<T> intersection(Set<T> s1, Set<T> s2) {
		Set<T> result = new HashSet<T>(s1);
		result.retainAll(s2);
		return result;
	}

	/**

	 * 求两个集合的并集

	 * 

	 * @param s1

	 * @param s2

	 * @return

	 */
	public static <T> Set<T> union(Set<T> s1, Set<T> s2) {
		Set<T> result = new HashSet<T>(s1);
		result.addAll(s2);
		return result;
	}

	/**

	 * 两个集合的差集

	 * 

	 * @param superset

	 * @param subset

	 * @return

	 */
	public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subset);
		return result;

	}
}
