package com.ecms.core.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className Field
 * @date 2018年3月21日上午9:14:22
 * @desc [知识库实体类]
 */
@Entity
@Table(name = "ECMS_FIELD")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Field implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7198114443937901951L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "memo")
	private String memo;

	@Column(name = "status")
	private Integer status;

	@JsonIgnore
	@OneToMany(mappedBy = "field", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Set<KnowledgePoint> knowledgePoints;

	@JsonIgnore
	@OneToMany(mappedBy = "field", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Set<Question> questions;

	public Field() {
		super();
	}

	public Field(Integer id, String name, String memo, Integer status, Set<KnowledgePoint> knowledgePoints,
			Set<Question> questions) {
		super();
		this.id = id;
		this.name = name;
		this.memo = memo;
		this.status = status;
		this.knowledgePoints = knowledgePoints;
		this.questions = questions;
	}

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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<KnowledgePoint> getKnowledgePoints() {
		return knowledgePoints;
	}

	public void setKnowledgePoints(Set<KnowledgePoint> knowledgePoints) {
		this.knowledgePoints = knowledgePoints;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}