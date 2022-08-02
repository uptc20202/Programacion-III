
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

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
				connection.writeUTF(view.getTxtUser());
				connection.writeUTF(view.getTxtPassword());
				if(connection.readBoolean()) {
					view.fillTable(connection.readUTF());
					view.showPanel("home");
				}else {
					console.writeString("Error Login");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(command.equals("exit")) {
			view.showPanel("login");
		}
		
	}
	
	private void verify() {
		try {
			if(connection.available()) {
				int data = connection.readInt();
				if(data != 99) {
					console.writeString("paso ");
				}else {
//					console.showMessage("memoria cambio " + connection.readInt());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() throws IOException, InterruptedException{

	}

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		new Presenter().start();	
	}
}
