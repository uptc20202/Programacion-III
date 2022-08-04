
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
	private String postionPanelCommand,positionCardComman;
	
	public Presenter() throws UnknownHostException, IOException {
    	console = new ViewConsole();
    	connection = new Connection();
    	postionPanelCommand = "";
    	positionCardComman = "";
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
				connection.writeUTF(view.getTxtUser());
				connection.writeUTF(view.getTxtPassword());
				postionPanelCommand = "home";
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(command.equals("exit")) {
			view.showPanel("login");
			postionPanelCommand="login";
		}
		if (command.equals("register")) {
			view.showPanel("register");
			postionPanelCommand="register";
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
			postionPanelCommand="login";
		}
		if(command.equals("postAuctionWindow")) {
			view.setVisibleToAuction(true);
		}
		if(command.equals("toAuction")) {
			try {
				view.setVisibleToAuction(false);
				connection.writeInt(3);
				connection.writeUTF(view.getNameNewAuction());
				connection.writeUTF(view.getDescriptionNewAuction());
				connection.writeUTF(view.getValueNewAuction());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(command.equals("toBid")) {
			try {
				view.setVisibleToBid(false);
				connection.writeInt(4);
				connection.writeInt(Integer.parseInt(view.getIdToBid()));
				connection.writeUTF(view.getValueToBid());
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
			positionCardComman="userPage";
		}
		if(command.equals("buyOption")) {
			view.showOptionsCard("homeOptions");
			positionCardComman = "homeOptions";
		}
	}
	
	private void verify() {
		try {
			if(connection.available()) {
				switch(connection.readInt()) {
				case 1:
					login();
					break;
				
				case 99:
					view.fillTable(connection.readUTF(),connection.readUTF(),connection.readUTF(),
							connection.readUTF());
					view.restorefillTable(postionPanelCommand,positionCardComman);
					break;	
				default:
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void register() {
		// TODO Auto-generated method stub
		
	}

	public void login() {
		try {
			if(connection.readBoolean()) {
				view.fillTable(connection.readUTF(),connection.readUTF(),connection.readUTF()
						,connection.readUTF());
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
