package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Landing extends JPanel{
	
	private JLabel spaceReference, icon, iconGym, textHome, txtComplementUser, space;
	private JTextField txtUser;
	private JPasswordField txtPassword; 
	private JButton btnLogin, btnRegister;
	private JPanel buttons;
	
	public Landing(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		// TODO Auto-generated method stub
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setBackground(new Color(55,58,60));
		
		spaceReference = new JLabel();
		add(spaceReference);
		
		
		icon = new JLabel();
		icon.setIcon(new ImageIcon("source/first/acre_blancopng.png"));
		icon.setBorder(new EmptyBorder(30,0,0,0));
		icon.setAlignmentX(CENTER_ALIGNMENT);
		add(icon);
		
		iconGym = new JLabel();
		iconGym.setIcon(new ImageIcon(new ImageIcon("source/first/btn_Port_ActividaF.png").getImage().getScaledInstance(150, 
				150, Image.SCALE_DEFAULT)));
		iconGym.setAlignmentX(CENTER_ALIGNMENT);
		iconGym.setBorder(new EmptyBorder(30,0,0,0));
		add(iconGym);
		
		textHome = new JLabel("INGRESO A CAF");
		textHome.setAlignmentX(CENTER_ALIGNMENT);
		textHome.setFont(new Font("Arial", Font.PLAIN, 30));
		textHome.setBorder(new EmptyBorder(10,0,27,0));
		textHome.setForeground(new Color(255,255,255));
		add(textHome);
		
		txtUser = new JTextField("Usuario");
		txtUser.setMaximumSize(new Dimension(300,30));
		txtUser.setBackground(new Color(55,58,60));
		txtUser.setForeground(new Color(255,255,255));
		txtUser.setCaretColor(new Color(255,255,255));
//		txtUser.setBorder(new EmptyBorder(10,0,10,0));
		add(txtUser);
		
		txtComplementUser = new JLabel("@uptc.edu.co");
		txtComplementUser.setFont(new Font("Arial", Font.PLAIN, 13));
		txtComplementUser.setForeground(new Color(255,255,255));
		txtComplementUser.setBorder(new EmptyBorder(10,0,20,0));
		txtComplementUser.setAlignmentX(CENTER_ALIGNMENT);
		add(txtComplementUser);
		
		txtPassword = new JPasswordField("admin");
		txtPassword.setMaximumSize(new Dimension(300,30));
		txtPassword.setBackground(new Color(55,58,60));
		txtPassword.setForeground(new Color(255,255,255));
//		txtUser.setBorder(new EmptyBorder(10,0,10,0));
		txtPassword.setCaretColor(new Color(255,255,255));
		add(txtPassword);
		
		space = new JLabel("");
		space.setBorder(new EmptyBorder(10,0,10,0));
		add(space);
		
		buttons = new JPanel();
		buttons.setOpaque(false);
		buttons.setMaximumSize(new Dimension(200,60));
		
		btnLogin = new JButton("Ingresar");
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 13));
		btnLogin.setForeground(new Color(255,255,255));
		btnLogin.setBackground(new Color(55,58,60));
		btnLogin.setAlignmentX(CENTER_ALIGNMENT);
		btnLogin.setBorder(new RoundedBorder(10));
		btnLogin.setActionCommand("login");
		btnLogin.addActionListener(listener);
		buttons.add(btnLogin);
		
		btnRegister = new JButton("Sign Up");
		btnRegister.setFont(new Font("Arial", Font.PLAIN, 13));
		btnRegister.setForeground(new Color(255,255,255));
		btnRegister.setBackground(new Color(55,58,60));
		btnRegister.setAlignmentX(CENTER_ALIGNMENT);
		btnRegister.setBorder(new RoundedBorder(10));
		btnRegister.setActionCommand("SignUp");
		btnRegister.addActionListener(listener);
		buttons.add(btnRegister);
		
		add(buttons);
		
		
	}

	public JLabel getSpaceReference() {
		return spaceReference;
	}

	public JLabel getIcon() {
		return icon;
	}

	public JLabel getIconGym() {
		return iconGym;
	}

	public JLabel getTextHome() {
		return textHome;
	}

	public JLabel getTxtComplementUser() {
		return txtComplementUser;
	}

	public JLabel getSpace() {
		return space;
	}

	public String getTxtUser() {
		return txtUser.getText();
	}

	public String getTxtPassword() {
		return String.valueOf(txtPassword.getPassword());
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setSpaceReference(JLabel spaceReference) {
		this.spaceReference = spaceReference;
	}

	public void setIcon(JLabel icon) {
		this.icon = icon;
	}

	public void setIconGym(JLabel iconGym) {
		this.iconGym = iconGym;
	}

	public void setTextHome(JLabel textHome) {
		this.textHome = textHome;
	}

	public void setTxtComplementUser(JLabel txtComplementUser) {
		this.txtComplementUser = txtComplementUser;
	}

	public void setSpace(JLabel space) {
		this.space = space;
	}

	public void setTxtUser(String txtUser) {
		this.txtUser.setText(txtUser);
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	
}
