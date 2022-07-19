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
		String optionUser = "";
		String menu = "\n1. Sumar.\r\n"
				+ "2. Restar.\r\n"
				+ "3. Multiplicar.\r\n"
				+ "4. Dividir.\r\n"
				+ "5. Terminar.\r\n";
		System.out.println(menu);
		while(!optionUser.equalsIgnoreCase("5")) {
			if(option.equals("5")) {
				socket.close();
			}
			view.writeString(option);
			optionUser = view.readString();
			salida.writeUTF(optionUser);
			option = entrada.readUTF();
			if(option.equals("Seleccione una opcion")) {
				System.out.println(menu);
			}
		};
		view.writeString("respuesta del servidor" +  entrada.readUTF());
		socket.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		new HellowClient().start();
	}
}
