
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
 * @className QuestionType
 * @date 2018年3月21日上午9:40:22
 * @desc [用一句话描述改文件的功能]
 */

@Entity
@Table(name = "ECMS_QUESTIONTYPE")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class QuestionType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 680988789498154720L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "questionType", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Set<Question> questions;

	public QuestionType() {
		super();
	}

	public QuestionType(int id, String name, Set<Question> questions) {
		super();
		this.id = id;
		this.name = name;
		this.questions = questions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}