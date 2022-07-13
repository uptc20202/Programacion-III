package view;

import java.util.Scanner;

public class View {
	private Scanner console;

	public View() {
		super();
		this.console = new Scanner(System.in);
	}
	
	public String readString() {
		return console.nextLine();
	}
	
	public void writeString(String message) {
		System.out.print(message);
	}
}
