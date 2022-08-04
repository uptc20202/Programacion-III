package presenter;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import model.Store;
import model.User;
import net.Connection;

public class ThreadClient extends Thread implements Observer {

	
	private Connection connection;
	private Store store;
	private User user;
	
	public ThreadClient(Socket socket, Store store) throws UnknownHostException, IOException {
		this.store = store;
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
		
	}

	@Override
	public void update() {
		try {
			connection.writeInt(99);
			connection.writeUTF(store.getSalesToString());
			connection.writeUTF(store.searchBidInAuctionToString(user.getNickname()));
			connection.writeUTF(user.getName());
			connection.writeUTF(store.getMySales(user.getNickname()));
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
				connection.writeInt(1);
				login();
				break;
			case 2:
				register();
				break;
			case 3:
				postAuction();
				store.notifyObservers();
				break;
			case 4:
				bidUp();
				store.notifyObservers();
				break;	
			case 5:
				break;	
			default:
				break;
			}
		}while(option != 6);
	}
	
	private void bidUp() {
		// TODO Auto-generated method stub
		int id =0;
		long value=0;
		try {
			id= connection.readInt();
			value = Long.parseLong(connection.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		store.bidUp(user, id, value);
		
	}

	private void postAuction() {
		String tittle ="";
		String description="";
		long minimumBid=0;
		User author=null;
		try {
			tittle = connection.readUTF();
			description=connection.readUTF();
			minimumBid= Long.parseLong(connection.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		store.postAuction(tittle, description, minimumBid, user);
	}

	private void register() throws IOException {
		String userName = connection.readUTF();
		String nickname = connection.readUTF();
		String password = connection.readUTF();
		store.addUser(userName, nickname, password);
	}

	public void login() throws IOException {
		
		String nickname = connection.readUTF();
		String password = connection.readUTF();
		
		if(store.login(nickname, password)) {
			user = store.searchUsers(nickname);
			connection.writeBoolean(true);
			connection.writeUTF(store.getSalesToString());
			connection.writeUTF(store.searchBidInAuctionToString(nickname));
			connection.writeUTF(user.getName());
			connection.writeUTF(store.getMySales(nickname));
		}else {
			connection.writeBoolean(false);
		}
		
	}
}
