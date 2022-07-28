package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import home.Landing;
import home.Login;

public class MainPanel extends JPanel{
	
	private CardLayout cl;
	private Login login;
	private Landing landing;
	
	public MainPanel(ActionListener listener) {
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		login = new Login(listener);
		landing = new Landing(listener);
		this.setLayout(new CardLayout());
		add(login, "login");
		add(landing, "home");
		
		cl = (CardLayout)(this.getLayout());
		cl.show(this, "home");
		
	}
	
	public void showPanel(String option) {
		switch(option){
			case "login":
				cl.show(this, "login");
				break;
			case "home":
				cl.show(this, "home");
				break;
			case "register":
				cl.show(this, "register");
				break;	
			
		}
	}
	
	
}
