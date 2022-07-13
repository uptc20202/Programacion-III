package test;

import model.MyTreads;
import model.MyTreads2;

public class Test {
	
	public static void main(String[] args) {
		MyTreads thread1 = new MyTreads("hilo 1");
		MyTreads2 aux = new MyTreads2("hilo 2");
		thread1.start();
		Thread thread2 = new Thread(aux);
		thread2.start();
		System.out.println("Aquí termina el hilo del main");
	}
}
