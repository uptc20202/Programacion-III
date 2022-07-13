package test;

import java.util.Scanner;

import model.Operator;
import resources.Stack;

public class test {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Operator operator = new Operator();
		
		System.out.println("Digite El Primer Número");
		String number1 =  teclado. nextLine();
		System.out.println("Digite El Segundo Número");
		String number2 =  teclado. nextLine();
		
		operator.add(number1, number2);	
		
		System.out.println("El resultado es: ");
		Stack stack = operator.getResult();
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
		
	}
}
