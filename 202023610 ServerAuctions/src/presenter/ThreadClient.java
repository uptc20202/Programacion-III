package presenter;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import model.Store;
import net.Connection;

public class ThreadClient extends Thread implements Observer {

	
	private Connection connection;
	private Store store;
	
	public ThreadClient(Socket socket, Store store) throws UnknownHostException, IOException {
		this.store = store;
		store.addUser("Administrador", "admin1", "admin1");
		connection = new Connection(socket);

	}

	@Override
public void run() {
		System.out.println("cliente conectado");
		System.out.println("datos recibidos");
		try {
			menu();
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

	@Override
	public void update() {
		int memory = 8;
		try {
			connection.writeInt(99);
			connection.writeInt(memory);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void menu() throws IOException {
		
		int option = 6;
		do {
			try {
				option = connection.readInt();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				return;
				//e.printStackTrace();
			}
			
			switch(option) {
			case 1:
				login();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;	
			case 5:
				break;
			case 6:
				break;	
			default:
				connection.writeUTF("Seleccione una opción correcta");
				break;
			}
		}while(option != 6);
	}
	
	public void login() throws IOException {
		String nickname = connection.readUTF();
		String password = connection.readUTF();
		connection.writeBoolean(store.login(nickname, password));
	}
}
