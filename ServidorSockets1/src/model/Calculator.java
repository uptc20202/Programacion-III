package model;

public class Calculator {
	private int result;

	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int toAdd(String num1, String num2) {
		return Integer.parseInt(num1) + Integer.parseInt(num2);
	}
	
	public int toSubtraction(String num1, String num2) {
		return Integer.parseInt(num1) - Integer.parseInt(num2);
	}
	
	public int toMultiplication(String num1, String num2) {
		return Integer.parseInt(num1) * Integer.parseInt(num2);
	}
	

}
