package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import home.Landing;
import home.Login;
import home.Register;

public class MainPanel extends JPanel{
	
	private CardLayout cl;
	private Login login;
	private Register register;
	private Landing landing;
	private ActionListener listener;
	
	public MainPanel(ActionListener listener) {
		initComponents(listener);
		this.listener = listener;
	}
	
	private void initComponents(ActionListener listener) {
		login = new Login(listener);
		register = new Register(listener);
		this.setLayout(new CardLayout());
		add(login, "login");
		add(register,"register");
		cl = (CardLayout)(this.getLayout());
		cl.show(this, "login");
		
	}
	
	private void generateJframeLanding(ActionListener listener,String datasTable,CalculateView parent) {
		landing = new Landing(listener,datasTable,login.getTxtUser(),parent);
		add(landing, "home");
	}
	
	public void showPanel(String option) {
		cl.show(this, option);
	}
	
	public String getTxtUser() {
		return login.getTxtUser();
	}

	public String getTxtPassword() {
		return login.getTxtPassword();
	}

	public void fillTable(String datasTable,CalculateView parent) {
		// TODO Auto-generated method stub
		generateJframeLanding(listener,datasTable,parent);
	}

	public String getTxtNameRegister() {
		// TODO Auto-generated method stub
		return register.getTxtNameUser();
	}

	public String getTxtUserRegister() {
		// TODO Auto-generated method stub
		return register.getTxtUser();
	}

	public String getTxtPasswordRegister() {
		// TODO Auto-generated method stub
		return register.getTxtPassword();
	}

	public void setVisibleToAuction() {
		// TODO Auto-generated method stub
		landing.setVisibleToAuction(true);
	}
	
	
}
