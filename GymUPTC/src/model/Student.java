package model;

import java.util.ArrayList;

public class Student {
	@Override
	public String toString() {
		return "Student [name=" + name + ", code=" + code + ", dues=" + dues + "]";
	}

	private String name;
	private int code;
	private ArrayList<Due> dues;
	
	public Student(String name, int code) {
		super();
		this.name = name;
		this.code = code;
		dues = new ArrayList<Due>();
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	public ArrayList<Due> getDues() {
		return dues;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setDues(ArrayList<Due> dues) {
		this.dues = dues;
	}
	
	
	
	
}
