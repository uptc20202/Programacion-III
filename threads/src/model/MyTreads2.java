package model;

public class MyTreads2 implements Runnable{

	private String name;
	
	public MyTreads2(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i =0; i < 10; i++) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + " " + getName());
		}
		System.out.println("Se termina la ejecucion del hilo "+getName());
	}
	public String getName() {
		return name;
	}
	
	
	
}
