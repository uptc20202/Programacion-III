package view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	
	private void generateJframeLanding(ActionListener listener,String datasTable,String datasTable2,
			String name, CalculateView parent) {
		landing = new Landing(listener,datasTable,datasTable2,login.getTxtUser(),name,parent);
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

	public void fillTable(String data1,String data2, String name, CalculateView parent) {
		// TODO Auto-generated method stub
		generateJframeLanding(listener,data1,data2,name,parent);
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

	public String getNameNewAuction() {
		// TODO Auto-generated method stub
		return landing.getNameNewAuction();
	}

	public String getDescriptionNewAuction() {
		// TODO Auto-generated method stub
		return landing.getDescriptionNewAuction() ;
	}

	public String getValueNewAuction() {
		// TODO Auto-generated method stub
		return landing.getValueNewAuction();
	}

	public String getIdToBid() {
		// TODO Auto-generated method stub
		return landing.getIdToBid();
	}

	public String getValueToBid() {
		// TODO Auto-generated method stub
		return landing.getValueToBid();
	}

	public void setVisibleToBid(boolean b) {
		// TODO Auto-generated method stub
		landing.setVisibleToBid(b);
	}

	public void showOptionsTables() {
		// TODO Auto-generated method stub
		landing.showOptionsTables();
	}

	public void showOptionsCard(String command) {
		// TODO Auto-generated method stub
		landing.showOptionsCard(command);
	}

	public void restorefillTable(String data1, String data2, String nickname) {
		// TODO Auto-generated method stub
		landing.restorefillTable( data1,  data2,  nickname);
	}

	
	
	
}
