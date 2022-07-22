package presenter;

import java.io.IOException;
import java.net.Socket;

import model.Translator;
import net.Connection;

public class ThreadClient extends Thread {
	private Translator translator;
	private Connection connection;
	
	public ThreadClient(Socket socket) throws IOException {
		super();
		this.translator = new Translator();
		this.connection = new Connection(socket);
	}
	
	public void run() {
		
		try {
			connection.writeUTF("conexion aceptada");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("cliente conectado");
		System.out.println("datos recibidos");
		
		
	
		
		int option = 6;
		try {
		do {
			String menu = "Seleccione una opcion";
			
			connection.writeUTF(menu);
			
			option = connection.readInt();
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
				connection.writeUTF("Seleccione una opción correcta");
				break;
			}
		}while(option != 6);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("fin de la transmision");
		try {
			connection.writeUTF("datos recibidos exitosamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void translateToEnglish() throws IOException {
		connection.writeUTF("Digite la palabra que desea traducir");
		String word = translator.searchTranslate(connection.readUTF(), 1);
		connection.writeUTF("Traduccion en Ingles : " +word
				+" \n Precione enter para continuar");
		connection.readUTF();
	}
	
	public void translateToFrench() throws IOException {
		connection.writeUTF("Digite la palabra que desea traducir");
		String word = translator.searchTranslate(connection.readUTF(), 2);
		connection.writeUTF("Traduccion en Frances : " +word
				+" \n Precione enter para continuar");
		connection.readUTF();
	}
	
	public void addTranslateEN() throws IOException {
		connection.writeUTF("Digite la palabra que desea insertar");
		String word = connection.readUTF();
		connection.writeUTF("Digite su traduccion al ingles");
		String wordTranslate = connection.readUTF();
		translator.insertTranslate(word, wordTranslate, 1);
		connection.writeUTF("Palabra añadida exitosamente : "
				+" \n Precione enter para continuar");
		connection.readUTF();
	}
	
	public void addTranslateFR() throws IOException {
		connection.writeUTF("Digite la palabra que desea insertar");
		String word = connection.readUTF();
		connection.writeUTF("Digite su traduccion al frances");
		String wordTranslate = connection.readUTF();
		translator.insertTranslate(word, wordTranslate, 2);
		connection.writeUTF("Palabra añadida exitosamente : "
				+" \n Precione enter para continuar");
		connection.readUTF();
	}
	
	public void countWords() throws IOException {
		connection.writeUTF(" El diccionario en Ingles cuenta con : " + translator.countWords(1) + " palabras"
			+" \n El diccionario en Frances cuenta con : " + translator.countWords(2) + " palabras"
			+" \n Precione enter para continuar");
		connection.readUTF();
	}
	
	
}
