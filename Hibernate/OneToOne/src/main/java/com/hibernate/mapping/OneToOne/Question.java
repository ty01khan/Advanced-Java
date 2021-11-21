package com.hibernate.mapping.OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name = "QID")
	private int qid;
	
	@Column(name = "Question")
	private String ques;
	
	@OneToOne
	@JoinColumn(name = "AID")
	private Answer answer;
	
	public Question() {
		super();
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
}
