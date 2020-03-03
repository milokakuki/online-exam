/**
 *  桃李云平台版权声明<br/>
    <center>Copyright (c) 2017 www.ecms.com</center> 
 <center> 2018年3月21日上午10:15:17</center>
<center>贵州桃李云科技有限公司拥有本平台的所有资料（包括但不限于文字、图片、音频、视频资料及页面设计、排版、软件等）的版权和/或其他相关知识产权。</center>
<center>未经桃贵州桃李云科技有限公司事先书面许可,对本平台的任何内容、任何单位和个人不得以任何方式复制、转载、链接、转帖、引用、刊登、发表、反编译或者在非桃李云科技所属服务器上做镜像或以其他任何方式使用。</center>
<center>凡侵犯贵州桃李云科技有限公司版权等知识产权的，贵州桃李云科技有限公司将依法追究其法律责任。</center>
 */
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className Point
 * @date 2018年3月21日上午10:15:17
 * @desc [知识点实体类]
 */
@Entity
@Table(name = "ECMS_KNOWLEDGEPOINT")
public class KnowledgePoint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1605041729750346490L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "field_id", nullable = true)
	private Field field;

	@Column(name = "memo")
	private String memo;

	@Column(name = "status")
	private int status;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Question.class)
	@JoinTable(name = "ECMS_QUSETION_KNOWLEDGE_POINT", joinColumns = {
			@JoinColumn(name = "knowledge_point_id") }, inverseJoinColumns = { @JoinColumn(name = "question_id") })
	private Set<Question> questions = new HashSet<>();

	public KnowledgePoint() {
		super();
	}

	public KnowledgePoint(Integer id, String name, Field field, String memo, int status, Set<Question> questions) {
		super();
		this.id = id;
		this.name = name;
		this.field = field;
		this.memo = memo;
		this.status = status;
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

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}