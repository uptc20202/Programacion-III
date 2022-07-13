package model;

public class MyTreads extends Thread{
	
	public MyTreads(String str) {
		super(str);
	}
	
	public void run() {
		for(int i =0; i < 10; i++) {
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + " " + getName());
		}
		System.out.println("Se termina la ejecucion del hilo "+getName());
	}
}
