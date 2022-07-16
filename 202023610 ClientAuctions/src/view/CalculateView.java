package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import login.Login;

public class CalculateView extends JFrame{
	
	private Login panel;
	
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
		panel = new Login(listener);
		this.setContentPane(panel);
		
	}
}