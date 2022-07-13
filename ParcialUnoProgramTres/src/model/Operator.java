package model;

import resources.Stack;

public class Operator {
	private Stack<Integer> number1;
	private Stack<Integer> number2;
	private Stack<Integer> result;
	
	public Operator() {
		super();
		number1= new Stack();
		number2= new Stack();
		result= new Stack();
	}

	public void add(String num1, String num2) {
		insertNumbers(num1, number1);
		insertNumbers(num2, number2);
		operateNumbers();
	}
	
	public void operateNumbers() {
		int numberResult = 0;
		int leftoverNumber = 0;
		while(!number1.isEmpty() || !number2.isEmpty()) {
			
			if(!number1.isEmpty() && !number2.isEmpty()) {
				numberResult = number1.pop() + number2.pop() + leftoverNumber;
			}else {
				if(number1.isEmpty()) {
					numberResult = number2.pop();
				}else {
					numberResult = number1.pop();
				}
			}
			
			if(String.valueOf(numberResult).length()>1) {
				String decomposedNumber = String.valueOf(numberResult);
				String newNumber = "";
				for(int i = 0;decomposedNumber.length()-1>i;i++) {
					newNumber=newNumber+decomposedNumber.charAt(i);
				}
				leftoverNumber = Integer.parseInt(newNumber);
				numberResult = Integer.parseInt(String.valueOf(decomposedNumber
						.charAt(decomposedNumber.length()-1))) ;
				result.push(numberResult);
			}else {
				result.push(numberResult);
				leftoverNumber = 0;
			}
			
		}
		if(leftoverNumber!=0) {
			result.push(leftoverNumber);
		}
		
	}
	
	
	
	public void insertNumbers(String num1,Stack<Integer> number) {
		for(int i = 0; num1.length() > i; i++) {
			number.push(Integer.parseInt(
					String.valueOf(num1.charAt(i))));
		}
	}

	public Stack<Integer> getNumber1() {
		return number1;
	}

	public Stack<Integer> getNumber2() {
		return number2;
	}

	public Stack<Integer> getResult() {
		return result;
	}

	public void setNumber1(Stack<Integer> number1) {
		this.number1 = number1;
	}

	public void setNumber2(Stack<Integer> number2) {
		this.number2 = number2;
	}

	public void setResult(Stack<Integer> result) {
		this.result = result;
	}
	
	
	
}
