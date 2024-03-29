package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import home.Login;

public class CalculateView extends JFrame{
	
	private MainPanel panel;
	
	public CalculateView(ActionListener listener) {
		super("Auction");
		
		this.setSize(1000,600);
		this.setResizable(false);
		this.setLayout(new GridLayout(4,1));
		initComponents(listener);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void initComponents(ActionListener listener) {
		panel = new MainPanel(listener);
		this.setContentPane(panel);
		
	}
	
	public void showPanel(String option) {
		panel.showPanel(option);
	}
	
	public String getTxtUser() {
		return panel.getTxtUser();
	}

	public String getTxtPassword() {
		return panel.getTxtPassword();
	}

	public void fillTable(String data1, String data2, String name, String data3, String data4) {
		// TODO Auto-generated method stub
		panel.fillTable(data1,data2,name,data3,data4,this);
		
	}

	public String getTxtNameRegister() {
		return panel.getTxtNameRegister();
	}

	public String getTxtUserRegister() {
		// TODO Auto-generated method stub
		return panel.getTxtUserRegister();
	}

	public String getTxtPasswordRegister() {
		// TODO Auto-generated method stub
		return panel.getTxtPasswordRegister();
	}

	public void setVisibleToAuction(boolean b) {
		// TODO Auto-generated method stub
		panel.setVisibleToAuction();
		
	}

	public String getNameNewAuction() {
		// TODO Auto-generated method stub
		return panel.getNameNewAuction();
	}

	public String getDescriptionNewAuction() {
		// TODO Auto-generated method stub
		return panel.getDescriptionNewAuction() ;
	}

	public String getValueNewAuction() {
		// TODO Auto-generated method stub
		return panel.getValueNewAuction();
	}

	public int getIdToBid() {
		// TODO Auto-generated method stub
		return panel.getIdToBid();
	}

	public String getValueToBid() throws NullPointerException{
		// TODO Auto-generated method stub
		return panel.getValueToBid();
	}

	public void setVisibleToBid(boolean b) {
		// TODO Auto-generated method stub
		panel.setVisibleToBid(b);
	}

	public void showOptionsTables() {
		// TODO Auto-generated method stub
		panel.showOptionsTables();
	}

	public void showOptionsCard(String command) {
		// TODO Auto-generated method stub
		panel.showOptionsCard(command);
	}

	public void restorefillTable(String postionPanelCommand, String positionCardComman) {
		// TODO Auto-generated method stub
		panel.restorefillTable(postionPanelCommand,positionCardComman);
	}

	public int getIdToSell() {
		// TODO Auto-generated method stub
		return panel.getIdToSell() ;
	}

	public void setVisibleToCancel(boolean result) {
		// TODO Auto-generated method stub
		panel.setVisibleToCancel(result);
	}

	public void toAlertLogin() {
		// TODO Auto-generated method stub
		panel.toAlertLogin();
	}

	public void watchNotification() {
		// TODO Auto-generated method stub
		panel.watchNotification();
	}

	public void setButtonNofication() {
		// TODO Auto-generated method stub
		panel.setButtonNofication();
	}

	public void setNotification(String nickname, String tittle) {
		// TODO Auto-generated method stub
		panel.setNotification( nickname,  tittle);
	}

	public void setNotification(String tittle) {
		// TODO Auto-generated method stub
		panel.setNotification(tittle);
	}

	
}