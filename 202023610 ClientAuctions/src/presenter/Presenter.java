
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import model.ValidateTable;
import net.Connection;
import view.CalculateView;
import view.ViewConsole;

public class Presenter implements ActionListener{
	
	private CalculateView view;
	private ViewConsole console;
	private Connection connection;
	
	public Presenter() throws UnknownHostException, IOException {
    	console = new ViewConsole();
    	connection = new Connection();
    	Thread thread = new Thread() {
			public void run() {
				while(true) {
					verify();
				}
			}
		};
		thread.start();
		view = new CalculateView(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("login")) {
			try {
				connection.writeInt(1);
				System.out.println(connection.readInt());
//				connection.writeUTF(view.getTxtUser());
//				connection.writeUTF(view.getTxtPassword());
//				if(connection.readBoolean()) {
//					String a=connection.readUTF();
//					String b=connection.readUTF();
//					String c=connection.readUTF();
//					view.fillTable(a,b,c);
//					view.showPanel("home");
//				}else {
//					console.writeString("Error Login");
//				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(command.equals("exit")) {
			view.showPanel("login");
		}
		if (command.equals("register")) {
			view.showPanel("register");
		}
		if(command.equals("login2")) {
			try {
				connection.writeInt(2);
				connection.writeUTF(view.getTxtNameRegister());
				connection.writeUTF(view.getTxtUserRegister());
				connection.writeUTF(view.getTxtPasswordRegister());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			view.showPanel("login");
			
		}
		if(command.equals("postAuctionWindow")) {
			view.setVisibleToAuction(true);
		}
		if(command.equals("toAuction")) {
			try {
				connection.writeInt(3);
				connection.writeUTF(view.getNameNewAuction());
				connection.writeUTF(view.getDescriptionNewAuction());
				connection.writeUTF(view.getValueNewAuction());
				view.setVisibleToAuction(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(command.equals("toBid")) {
			try {
				connection.writeInt(4);
				connection.writeInt(Integer.parseInt(view.getIdToBid()));
				connection.writeUTF(view.getValueToBid());
				view.setVisibleToBid(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(command.equals("changeTable")) {
			view.showOptionsTables();
		}
		if(command.equals("userData")) {
			view.showOptionsCard("userPage");
		}
		if(command.equals("buyOption")) {
			view.showOptionsCard("homeOptions");
		}
	}
	
	private void verify() {
		try {
			if(connection.available()) {
				int a =connection.readInt();
				System.out.println(a);
				switch(a) {
				case 1:
					login();
					break;
//				case 2:
//					register();
//					break;
//				case 3:
//					postAuction();
//					store.notifyObservers();
//					break;
//				case 4:
//					bidUp();
//					store.notifyObservers();
//					break;	
//				case 5:
//					break;
				case 99:
					console.writeString("2paso ");
					view.restorefillTable(connection.readUTF(),connection.readUTF(),connection.readUTF());
					break;	
				default:
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void login() {
		try {
			if(connection.readBoolean()) {
				connection.writeUTF(view.getTxtUser());
				connection.writeUTF(view.getTxtPassword());
				String a=connection.readUTF();
				String b=connection.readUTF();
				String c=connection.readUTF();
				view.fillTable(a,b,c);
				view.showPanel("home");
			}else {
				console.writeString("Error Login");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void start() throws IOException, InterruptedException{

	}

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		new Presenter().start();	
	}
}
