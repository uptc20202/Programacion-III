package presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import model.Calculator;
import model.Model;

public class HellowServer {
	private Model model;
	private Calculator calculator;
	private final int PUERTO = 1234;
	private ServerSocket serverSocket;
	private Socket socket;
	private DataOutputStream salida;
	private DataInputStream entrada;
	
	public HellowServer() throws IOException {
		model = new Model();
		calculator = new Calculator();
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
			String menu = "\n1. Sumar.\r\n"
					+ "2. Restar.\r\n"
					+ "3. Multiplicar.\r\n"
					+ "4. Terminar.\r\n";
			salida.writeUTF(menu);
			menu();
//			for(int i = 0; i < 5; i++){
//				model.addWord(entrada.readUTF());
//			}
			System.out.println("frase completa " + model.getPhrase());
			System.out.println("fin de la transmision");
			salida.writeUTF("datos recibidos exitosamente");
			socket.close();
		}
	}
	
	public void menu() throws IOException {
		
		String option = "";
		do {
//			
//			salida.writeUTF("Digite la opcion desea: ");
			option = entrada.readUTF();
			switch(option) {
				case "1":
					add() ;
					break;
				case "2":
					Subtraction();
					break;
				case "3":
					Multiplication() ;
					break;
				default:
					salida.writeUTF("Seleccione una opción correcta");
					break;
			}
		}while(option != "4");
		salida.writeUTF("4");
	}
	
	public void add() throws IOException {
		salida.writeUTF("Digite los números que desea sumar");
		salida.writeUTF("Resultado: "+calculator.toAdd(entrada.readUTF(), entrada.readUTF()));
	}
	
	public void Subtraction() {
		
	}
	
	public void Multiplication() {
		
	}
	
	public static void main(String[] args) throws IOException {
		new HellowServer().start();
	}
}

