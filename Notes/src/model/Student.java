package model;


public class Student {
	private String name;
	private int code;
	private double[] notes;


	public Student(double[] notes) {
		this.notes = notes;	
		
	}
	
	public double calculateNote() {
		double finalNote = 0;
		finalNote = (notes[0]+notes[1]) / 2;
		
		return finalNote;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCode() {
		return code;
	}

	public int comparatorCode(Student student) {
		return code-student.getCode();
	}
	
	

}