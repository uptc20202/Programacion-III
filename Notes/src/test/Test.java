package test;

import model.Student;
import java.util.Scanner;

public class Test {
	private Scanner console;
	private Student student;
	
	public Test() {
		console = new Scanner(System.in);
		run();
	}
	
	public void run() {
		double[] score = new double[2];
		student = new Student(score);
		System.out.println("Ingrese nombre del alumno");
		student.setName(console.nextLine());
		System.out.println("Ingrese codigo");
		student.setCode(Integer.parseInt(console.nextLine()));
		for (int i = 0; i < score.length; i++) {
			System.out.println("Indique la nota del corte " + (i+1));
			score[i] = Integer.parseInt(console.nextLine());
		}	
		System.out.println( ""+ student.getName() + student.getCode() + "La nota final es" + student.calculateNote() );
	}
	
	public static void main(String[] args) {
		new Test();
		
	}
	

}
