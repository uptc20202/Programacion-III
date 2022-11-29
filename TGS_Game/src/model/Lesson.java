package model;

public class Lesson {
	
	private String name;
	private boolean state;
	private Questions[] questions;
	
	public Lesson(String name, boolean state, Questions[] questions) {
		super();
		this.name = name;
		this.state = state;
		this.questions = questions;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Questions[] getQuestions() {
		return questions;
	}
	public void setQuestions(Questions[] questions) {
		this.questions = questions;
	}
}