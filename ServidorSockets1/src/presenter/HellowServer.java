package presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import model.Model;

public class HellowServer {
	private Model model;
	private final int PUERTO = 1234;
	private ServerSocket serverSocket;
	private Socket socket;
	private DataOutputStream salida;
	private DataInputStream entrada;
	
	public HellowServer() throws IOException {
		model = new Model();
		serverSocket = new ServerSocket(PUERTO);
	}
	
	public void start() throws IOException{
		while(true) {
			socket = serverSocket.accept();
			salida = new DataOutputStream(socket.getOutputStream());
			entrada = new DataInputStream(socket.getInputStream());
			salida.writeUTF("conexion aceptada");
			System.out.println("cliente conectado");
			System.out.println("datos recibidos");
			for(int i = 0; i < 5; i++){
				model.addWord(entrada.readUTF());
			}
			System.out.println("frase completa " + model.getPhrase());
			System.out.println("fin de la transmision");
			salida.writeUTF("datos recibidos exitosamente");
			socket.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new HellowServer().start();
	}
}

