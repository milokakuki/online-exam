/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年5月3日上午10:38:08</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
package com.ecms.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className PageHistory
 * @date 2018年5月3日上午10:38:08
 * @desc [用一句话描述改文件的功能]
 */
@Entity
@Table(name = "ECMS_PAGE_HISTORY")
public class PageHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6488268400323922698L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

//	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = true)
//	@JoinColumn(name = "user_id", nullable = true)
//	private User user;
	
	@ManyToOne(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "student_id", nullable = true)
	private Student student;
	

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "page_id", nullable = true)
	private Page page;

	@Column(name = "answers", columnDefinition = "longblob")
	private HashMap<Integer, String> answers;

	@Column(name = "counts")
	private Float counts;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "status")
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public HashMap<Integer, String> getAnswers() {
		return answers;
	}

	public void setAnswers(HashMap<Integer, String> answers) {
		this.answers = answers;
	}

	public Float getCounts() {
		return counts;
	}

	public void setCounts(Float counts) {
		this.counts = counts;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
