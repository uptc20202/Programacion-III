package presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import view.View;

public class HellowClient {
	private View view;
	private final int PUERTO = 1234;
	private final String HOST = "localhost";
	private Socket socket;
	private DataOutputStream salida;
	private DataInputStream entrada;
	
	public HellowClient() throws UnknownHostException, IOException{
		view = new View();
		socket = new Socket(HOST, PUERTO);
		salida = new DataOutputStream(socket.getOutputStream());
		entrada = new DataInputStream(socket.getInputStream());
	}
	public void start() throws IOException, InterruptedException{
		view.writeString(entrada.readUTF());
		String option = entrada.readUTF(); 
		while(!option.equalsIgnoreCase("4")) {
			view.writeString(option);
			String option1 = entrada.readUTF();
			if(option1.equalsIgnoreCase("")) {
				view.writeString("Esperando respuesta...");
				salida.writeUTF(view.readString());
			}else {
				view.writeString(option1 + " Salida");
				
			}
			option = option1;
		};
//		for(int i = 0; i < 5; i++){
//			salida.writeUTF(view.readString());
//		}
		view.writeString("respuesta del servidor" + entrada.readUTF());
		socket.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		new HellowClient().start();
	}
}
