package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import login.Login;

public class MainPanel extends JPanel{
	
	private CardLayout cl;
	private Login login;
	
	public MainPanel(ActionListener listener) {
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		login = new Login(listener);
		this.setLayout(new CardLayout());
		add(login, "login");
		
		cl = (CardLayout)(this.getLayout());
		cl.show(this, "login");
		
	}
	
	public void showPanel(String option) {
		switch(option){
			case "login":
				cl.show(this, "login");
				break;
			case "homeStudent":
				cl.show(this, "homeStudent");
				break;
			case "register":
				cl.show(this, "register");
				break;	
			
		}
	}
	
	
}
