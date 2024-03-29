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
	private String notification;
	
	public MainPanel(ActionListener listener) {
		notification = "";
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
			String name, String data3, String data4, CalculateView parent) {
		landing = new Landing(listener,datasTable,datasTable2,login.getTxtUser(),name,data3,data4,notification,parent);
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

	public void fillTable(String data1,String data2, String name, String data3, String data4, CalculateView parent) {
		// TODO Auto-generated method stub
		generateJframeLanding(listener,data1,data2,name,data3,data4,parent);
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

	public int getIdToBid() throws NullPointerException{
		// TODO Auto-generated method stub
		return landing.getIdToBid();
	}

	public String getValueToBid() throws NullPointerException{
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

	public void restorefillTable(String postionPanelCommand, String positionCardComman) {
		// TODO Auto-generated method stub
		cl.show(this, postionPanelCommand);
		landing.showOptionsCard(positionCardComman);
	}

	public int getIdToSell() throws NullPointerException{
		// TODO Auto-generated method stub
		return landing.getIdToSell() ;
	}

	public void setVisibleToCancel(boolean result) {
		// TODO Auto-generated method stub
		landing.setVisibleToCancel(result);
	}

	public void toAlertLogin() {
		// TODO Auto-generated method stub
		login.toAlert();
	}

	public void watchNotification() {
		// TODO Auto-generated method stub
		landing.showNotification();
	}

	public void setButtonNofication() {
		// TODO Auto-generated method stub
		landing.setButtonNofication(true);
	}

	public void setNotification(String nickname, String tittle) {
		// TODO Auto-generated method stub
		landing.setNotification(nickname,tittle);
	}

	public void setNotification(String tittle) {
		// TODO Auto-generated method stub
		landing.setNotification(tittle);
	}

	
	
	
}
