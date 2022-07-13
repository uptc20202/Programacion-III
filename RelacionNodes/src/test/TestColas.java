package test;

import model.Student;
import resources.Node;
import resources.Queve;
import resources.Stack;

public class TestColas {
	
	public static void main(String[] args) {
		Queve<Integer> queve = new Queve<Integer>();
		queve.push(1);
		queve.push(2);
		queve.push(3);
		queve.push(4);
		queve.push(5);
		
		queve.poll();
		
		for(int a:queve) {
			System.out.println(a);
		}
	}
}
