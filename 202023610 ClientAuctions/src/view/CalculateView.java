package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

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

	public void fillTable(String datasTable) {
		// TODO Auto-generated method stub
		panel.fillTable(datasTable,this);
		
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
}