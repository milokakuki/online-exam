
package com.ecms.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author 沙文
 * @email shaw053852@126.com
 * @className Question
 * @date 2018年3月21日上午9:19:33
 * @desc [问题实体类]
 */
@Entity
@Table(name = "ECMS_QUESTION")
@JsonIgnoreProperties(ignoreUnknown = true, value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8293929803246000398L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "title_img")
	private String titleImg;

	@Column(name = "choice_list", columnDefinition = "longblob")
	private LinkedHashMap<String, String> choiceList;

	@Column(name = "choice_img_list", columnDefinition = "longblob")
	private LinkedHashMap<String, String> choiceImgList;

	@Column(name = "points")
	private float points;

	@Column(name = "create_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@Column(name = "answer")
	private String answer;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "field_id", nullable = true)
	private Field field;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "question_type_id", nullable = true)
	private QuestionType questionType;

	@Column(name = "difficulty")
	private float difficulty;

	@Column(name = "analysis", columnDefinition = "longtext COMMENT '问题分析'", nullable = true)
	private String analysis;

	//@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = KnowledgePoint.class)
	//@JoinTable(name = "ECMS_QUSETION_KNOWLEDGE_POINT", joinColumns = {
	//@JoinColumn(name = "question_id") }, inverseJoinColumns = { @JoinColumn(name = "knowledge_point_id") })
	//private Set<KnowledgePoint> knowledgePoint = new HashSet<>();

	@OneToMany(mappedBy = "question", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private Set<QuestionPage> questionPages = new HashSet<>();

	@Column(name = "creator")
	private String creator;

	@Column(name = "keyword")
	private String keyword;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public LinkedHashMap<String, String> getChoiceList() {
		return choiceList;
	}

	public void setChoiceList(LinkedHashMap<String, String> choiceList) {
		this.choiceList = choiceList;
	}

	public LinkedHashMap<String, String> getChoiceImgList() {
		return choiceImgList;
	}

	public void setChoiceImgList(LinkedHashMap<String, String> choiceImgList) {
		this.choiceImgList = choiceImgList;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public float getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(float difficulty) {
		this.difficulty = difficulty;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	//public Set<KnowledgePoint> getKnowledgePoint() {
	//	return knowledgePoint;
	//}

	//public void setKnowledgePoint(Set<KnowledgePoint> knowledgePoint) {
	//	this.knowledgePoint = knowledgePoint;
	//}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Set<QuestionPage> getQuestionPages() {
		return questionPages;
	}

	public void setQuestionPages(Set<QuestionPage> questionPages) {
		this.questionPages = questionPages;
	}
}