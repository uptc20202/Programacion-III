package view;

import java.util.Scanner;

public class ViewConsole {
	private Scanner console;

	public ViewConsole() {
		super();
		this.console = new Scanner(System.in);
	}
	
	public String readString() {
		return console.nextLine();
	}
	
	public void writeString(String message) {
		System.out.println(message);
	}
}

