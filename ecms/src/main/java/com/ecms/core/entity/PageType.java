
package com.ecms.core.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className PageType
 * @date   2018年4月18日上午10:04:31
 * @desc  [用一句话描述改文件的功能]
 */
@Entity
@Table(name="ECMS_PAGE_TYPE")
public class PageType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -290939061830242635L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="name")
	private String name;

	@OneToMany(mappedBy="pageType",cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	private Set<Page> pages = new HashSet<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Page> getPages() {
		return pages;
	}

	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}
	
}