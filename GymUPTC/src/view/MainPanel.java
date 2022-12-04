package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.CustomFont;
import model.Rol;

public class MainPanel extends JPanel{
	
	private CardLayout cl;
	private Landing landing;
	private HomeStudent homeStudent;
	private Register register;
	
	public MainPanel(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		landing = new Landing(listener);
		homeStudent = new HomeStudent(listener);
		register = new Register(listener);
		this.setLayout(new CardLayout());
		add(landing, "login");
		add(homeStudent, "homeStudent");
		add(register, "register");
		
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
	
	public String getTxtUser() {
		return landing.getTxtUser();
	}

	public String getTxtPassword() {
		return landing.getTxtPassword();
	}
	
	public void addTurnPanelDom(ActionListener listener, String star,String finalTurn,int availableQuotas) {
		homeStudent.addTurnPanelDom(listener, star, finalTurn, availableQuotas);
	}
	
	public void addTurnPanelDom2(ActionListener listener, String star,String finalTurn,int availableQuotas) {
		homeStudent.addTurnPanelDom2(listener, star, finalTurn, availableQuotas);
	}
	
	
	public void setQuotas(int avalideQuotas, int position) {
		homeStudent.setQuotas(avalideQuotas, position);
	}
	
	public void showPanel2(String option) {
		homeStudent.showPanel(option);
	} 
	
	public void refreshDom(ActionListener listener) {
		homeStudent = new HomeStudent(listener);
		add(homeStudent, "homeStudent");
		//homeStudent.refreshDom( listener);
	}
	
	public void setData(String nombre, int codigo, Rol rol,String email) {
		homeStudent.setData(nombre, codigo, rol,email);
	}
	
	public String getTxtName1() {
		return register.getTxtName1();
	}

	public String getTxtName2() {
		return register.getTxtName2();
	}

	public String getTxtlastName1() {
		return register.getTxtlastName1();
	}

	public String getTxtlastName2() {
		return register.getTxtlastName2();
	}

	public String getTxtCode() {
		return register.getTxtCode();
	}

	public String getTxtPassword2() {
		return register.getTxtPassword();
	}
	
	public void setTxtUser(String txtUser) {
		landing.setTxtUser(txtUser);
	}
}
