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
			menu();
			System.out.println("frase completa " + model.getPhrase());
			System.out.println("fin de la transmision");
			salida.writeUTF("datos recibidos exitosamente");
			socket.close();
		}
	}
	
	public void menu() throws IOException {
		
		int option = 5;
		do {
			String menu = "Seleccione una opcion";
			salida.writeUTF(menu);
			option = Integer.parseInt(entrada.readUTF());
			switch(option) {
				case 1:
					add() ;
					break;
				case 2:
					Subtraction();
					break;
				case 3:
					Multiplication() ;
					break;
				case 4:
					divide() ;
					break;	
				default:
					salida.writeUTF("Seleccione nuevamente la opcion");
					break;
			}
		}while(option != 5);
	}
	
	public void add() throws IOException {
		salida.writeUTF("Digite el primer número");
		String num1 = entrada.readUTF();
		salida.writeUTF("Digite el segundo número");
		String num2 = entrada.readUTF();
		salida.writeUTF("Resultado de la suma: "+calculator.toAdd(num1, num2)
			+" \n Precione enter para continuar");
		entrada.readUTF();
	}
	
	public void Subtraction() throws IOException {
		salida.writeUTF("Digite el primer número");
		String num1 = entrada.readUTF();
		salida.writeUTF("Digite el segundo número");
		String num2 = entrada.readUTF();
		salida.writeUTF("Resultado de la resta: "+calculator.toSubtraction(num1, num2)
			+" \n Precione enter para continuar");
		entrada.readUTF();
	}
	
	public void Multiplication() throws IOException {
		salida.writeUTF("Digite el primer número");
		String num1 = entrada.readUTF();
		salida.writeUTF("Digite el segundo número");
		String num2 = entrada.readUTF();
		salida.writeUTF("Resultado de la Multiplicación: "+calculator.toMultiplication(num1, num2)
			+" \n Precione enter para continuar");
		entrada.readUTF();
	}
	
	public void divide() throws IOException {
		salida.writeUTF("Digite el primer número");
		String num1 = entrada.readUTF();
		salida.writeUTF("Digite el segundo número");
		String num2 = entrada.readUTF();
		salida.writeUTF("Resultado de la Divicion: "+calculator.toDivide(num1, num2)
			+" \n Precione enter para continuar");
		entrada.readUTF();
	}
	
	public static void main(String[] args) throws IOException {
		new HellowServer().start();
	}
}

