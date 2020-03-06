
package com.ecms.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className Page
 * @date 2018年4月17日下午6:00:34
 * @desc [试卷实体类]
 */
@Entity
@Table(name = "ECMS_PAGE")
public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1511489488751128344L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "duration")
	private Integer duration;

	@Column(name = "total_point")
	private float totalPoint;

	@Column(name = "pass_point")
	private float passPoint;

	@Column(name = "status")
	private int status;

	@Column(name = "create_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "creator")
	private String creator;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "page_type_id", nullable = true)
	private PageType pageType;

	@OneToMany(mappedBy = "page", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Set<QuestionPage> questionPages = new HashSet<>();

	@OneToMany(mappedBy = "page", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Set<PageHistory> pageHistories = new HashSet<>();

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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public float getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(float totalPoint) {
		this.totalPoint = totalPoint;
	}

	public float getPassPoint() {
		return passPoint;
	}

	public void setPassPoint(float passPoint) {
		this.passPoint = passPoint;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public PageType getPageType() {
		return pageType;
	}

	public void setPageType(PageType pageType) {
		this.pageType = pageType;
	}

	public Set<QuestionPage> getQuestionPages() {
		return questionPages;
	}

	public void setQuestionPages(Set<QuestionPage> questionPages) {
		this.questionPages = questionPages;
	}

	public Set<PageHistory> getPageHistories() {
		return pageHistories;
	}

	public void setPageHistories(Set<PageHistory> pageHistories) {
		this.pageHistories = pageHistories;
	}

}