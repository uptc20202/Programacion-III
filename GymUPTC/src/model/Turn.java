package model;

import java.util.ArrayList;

public class Turn {
	private Student[] students;
	private String star;
	private String finalTurn;
	
	public Turn( String star, String finalTurn) {
		super();
		this.students = new Student[25];
		this.star = star;
		this.finalTurn = finalTurn;
	}

	public Student[] getStudents() {
		return students;
	}

	public String getStar() {
		return star;
	}

	public String getFinalTurn() {
		return finalTurn;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public void setFinalTurn(String finalTurn) {
		this.finalTurn = finalTurn;
	}
	
	public void addStudent(Student student) {
		int i = 0;
		do{
			i++;
		}while(students[i] != null); 
			
		students[i] = student;
	}
	
	
	
	
}
