package presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import model.Translator;;

public class HellowServer {
	private Translator translator;
	private final int PUERTO = 1234;
	private ServerSocket serverSocket;
	private Socket socket;
	private DataOutputStream salida;
	private DataInputStream entrada;
	
	public HellowServer() throws IOException {
		translator = new Translator();
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
			System.out.println("fin de la transmision");
			salida.writeUTF("datos recibidos exitosamente");
			socket.close();
		}
	}
	
	public void menu() throws IOException {
		
		int option = 6;
		do {
			String menu = "Seleccione una opcion";
			salida.writeUTF(menu);
			option = Integer.parseInt(entrada.readUTF());
			switch(option) {
			case 1:
				translateToEnglish();
				break;
			case 2:
				translateToFrench();
				break;
			case 3:
				addTranslateEN();
				break;
			case 4:
				addTranslateFR();
				break;	
			case 5:
				countWords();
				break;
			
			default:
				salida.writeUTF("Seleccione una opción correcta");
				break;
			}
		}while(option != 6);
	}
	
	public void translateToEnglish() throws IOException {
		salida.writeUTF("Digite la palabra que desea traducir");
		String word = translator.searchTranslate(entrada.readUTF(), 1);
		salida.writeUTF("Traduccion en Ingles : " +word
				+" \n Precione enter para continuar");
		entrada.readUTF();
	}
	
	public void translateToFrench() throws IOException {
		salida.writeUTF("Digite la palabra que desea traducir");
		String word = translator.searchTranslate(entrada.readUTF(), 2);
		salida.writeUTF("Traduccion en Frances : " +word
				+" \n Precione enter para continuar");
		entrada.readUTF();
	}
	
	public void addTranslateEN() throws IOException {
		salida.writeUTF("Digite la palabra que desea insertar");
		String word = entrada.readUTF();
		salida.writeUTF("Digite su traduccion al ingles");
		String wordTranslate = entrada.readUTF();
		translator.insertTranslate(word, wordTranslate, 1);
		salida.writeUTF("Palabra añadida exitosamente : "
				+" \n Precione enter para continuar");
		entrada.readUTF();
	}
	
	public void addTranslateFR() throws IOException {
		salida.writeUTF("Digite la palabra que desea insertar");
		String word = entrada.readUTF();
		salida.writeUTF("Digite su traduccion al frances");
		String wordTranslate = entrada.readUTF();
		translator.insertTranslate(word, wordTranslate, 2);
		salida.writeUTF("Palabra añadida exitosamente : "
				+" \n Precione enter para continuar");
		entrada.readUTF();
	}
	
	public void countWords() throws IOException {
		salida.writeUTF(" El diccionario en Ingles cuenta con : " + translator.countWords(1) + " palabras"
			+" \n El diccionario en Frances cuenta con : " + translator.countWords(2) + " palabras"
			+" \n Precione enter para continuar");
		entrada.readUTF();
	}
	
	public static void main(String[] args) throws IOException {
		new HellowServer().start();
	}
}

