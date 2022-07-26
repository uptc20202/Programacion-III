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
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					verify();
				}
			}
		};
		thread.start();
	}
	
	private void verify() {
		if()
	}
	
	public void start() throws IOException, InterruptedException{
		view.writeString(entrada.readUTF());
		
		String option = entrada.readUTF(); 
		String optionUser = "";
		String menu = "\n1. Obtener la traducci�n en ingl�s de una palabra en espa�ol\r\n"
				+ "2. Obtener la traducci�n en franc�s de una palabra en espa�ol\r\n"
				+ "3. Agregar una nueva traducci�n al diccionario espa�ol-ingl�s\r\n"
				+ "4. Agregar una nueva traducci�n al diccionario espa�ol-franc�s\r\n"
				+ "5. Total de palabras que contiene cada uno de los diccionarios\r\n"
				+ "6. Salir";
		System.out.println(menu);
		while(!optionUser.equalsIgnoreCase("6")) {
			view.writeString(option);
			optionUser = view.readString();
			salida.writeUTF(optionUser);
			option = entrada.readUTF();
			if(option.equals("Seleccione una opcion")) {
				System.out.println(menu);
			}
		};
		view.writeString("respuesta del servidor: " +  entrada.readUTF());
		socket.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		new HellowClient().start();
	}
}
