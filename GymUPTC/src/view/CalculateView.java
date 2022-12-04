package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import model.Rol;
import presenter.Presenter;

public class CalculateView extends JFrame {
	
	private MainPanel panel;

		public CalculateView(ActionListener listener) {
			super("CAF UPTC");
			
			this.setSize(1000,700);
			this.setLayout(new GridLayout(4,1));
			initComponents(listener);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}

		private void initComponents(ActionListener listener) {
			panel = new MainPanel(listener);
			this.setContentPane(panel);
			
		}
		
		public String getTxtUser() {
			return panel.getTxtUser();
		}

		public String getTxtPassword() {
			return panel.getTxtPassword();
		}
		
		public void showPanel(String option) {
			panel.showPanel(option);
		}
		
		public void addTurnPanelDom(ActionListener listener, String star,String finalTurn,int availableQuotas) {
			panel.addTurnPanelDom(listener, star, finalTurn, availableQuotas);
		}
		
		public void addTurnPanelDom2(ActionListener listener, String star,String finalTurn,int availableQuotas) {
			panel.addTurnPanelDom2(listener, star, finalTurn, availableQuotas);
		}
		
		public void setQuotas(int avalideQuotas, int position) {
			panel.setQuotas(avalideQuotas, position);
		}
		
		public void showPanel2(String option) {
			panel.showPanel2(option);
		} 
		
		public void refreshDom(ActionListener listener) {
			panel.refreshDom( listener);;
		}
		
		public void setData(String nombre, int codigo, Rol rol,String email) {
			panel.setData(nombre, codigo, rol, email);
		}
		
		public String getTxtName1() {
			return panel.getTxtName1();
		}

		public String getTxtName2() {
			return panel.getTxtName2();
		}

		public String getTxtlastName1() {
			return panel.getTxtlastName1();
		}

		public String getTxtlastName2() {
			return panel.getTxtlastName2();
		}

		public String getTxtCode() {
			return panel.getTxtCode();
		}

		public String getTxtPassword2() {
			return panel.getTxtPassword2();
		}

		public void setTxtUser(String txtUser) {
			panel.setTxtUser(txtUser);
		}
}
	