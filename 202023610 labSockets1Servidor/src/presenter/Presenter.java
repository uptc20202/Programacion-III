package presenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;
import java.net.Socket;
import java.net.UnknownHostException;

import model.Translator;
import view.ViewConsole;

public class Presenter {
	private final int PORT = 1234;
	private ServerSocket serverSocket;
	
	public Presenter() throws IOException {
		serverSocket = new ServerSocket(PORT); 
	}
	
	public void start() throws IOException {
		while(true) {
			Socket socket = serverSocket.accept();
			new ThreadClient(socket).start();
			
		}
	}
	
	public static void main(String [] args) throws UnknownHostException, IOException, InterruptedException {
		new Presenter().start();
	}


}
