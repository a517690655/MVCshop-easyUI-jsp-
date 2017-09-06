package org.lanqiao.entity;

public class PasswordAnswer {
	private String answerID;
	private String aQuestion;
	private String answer;
	private String email;
	private String userID;
	public String getAnswerID() {
		return answerID;
	}
	public void setAnswerID(String answerID) {
		this.answerID = answerID;
	}
	public String getaQuestion() {
		return aQuestion;
	}
	public void setaQuestion(String aQuestion) {
		this.aQuestion = aQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public PasswordAnswer() {
		super();
	}
	public PasswordAnswer(String answerID, String aQuestion, String answer,
			String email, String userID) {
		super();
		this.answerID = answerID;
		this.aQuestion = aQuestion;
		this.answer = answer;
		this.email = email;
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		return "PasswordAnswer [answerID=" + answerID + ", aQuestion="
				+ aQuestion + ", answer=" + answer + ", email=" + email
				+ ", userID=" + userID + "]";
	}
	
}
