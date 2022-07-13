package model;

public class Student {
	private String name;
	private int code;
	
	public Student(String name, int code) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", code=" + code + "]";
	}
	
	
}

