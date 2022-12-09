package model;

import java.util.Arrays;

public class Lesson {
	
	private String name;
	private boolean state;
	private QuestionsModel[] questions;
	
	public Lesson(String name, boolean state, QuestionsModel[] questions) {
		super();
		this.name = name;
		this.state = state;
		this.questions = questions;
	}
	
	public int calculatePoins() {
		int points = 0; 
		for(QuestionsModel poinsQuestions: questions) {
			points = points +poinsQuestions.getPoints();
		}
		return points;
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
	public QuestionsModel[] getQuestions() {
		return questions;
	}
	public void setQuestions(QuestionsModel[] questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Lesson [name=" + name + ", state=" + state + ", questions=" + Arrays.toString(questions) + "]";
	}
	
	
}
