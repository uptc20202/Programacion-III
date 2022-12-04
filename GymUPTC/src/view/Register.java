package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Register extends JPanel{

	private JLabel name1,name2,lastname1,lastname2, code,password;
	private JTextField txtName1, txtName2, txtlastName1, txtlastName2, txtCode;
	private JPasswordField txtPassword; 
	private JButton btnRegister;
	
	public Register(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {

		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setBackground(new Color(55,58,60));
		
		name1 = new JLabel("Digite su primer nombre");
		name1.setAlignmentX(CENTER_ALIGNMENT);
		name1.setFont(new Font("Arial", Font.PLAIN, 20));
		name1.setForeground(new Color(255,255,255));
		name1.setBorder(new EmptyBorder(10,0,20,0));
		name1.setAlignmentX(CENTER_ALIGNMENT);
		add(name1);
		
		txtName1 = new JTextField();
		txtName1.setMaximumSize(new Dimension(300,30));
		txtName1.setBackground(new Color(55,58,60));
		txtName1.setForeground(new Color(255,255,255));
		txtName1.setCaretColor(new Color(255,255,255));
		add(txtName1);
		
		name2 = new JLabel("Digite su segundo nombre");
		name2.setAlignmentX(CENTER_ALIGNMENT);
		name2.setFont(new Font("Arial", Font.PLAIN, 20));
		name2.setForeground(new Color(255,255,255));
		name2.setBorder(new EmptyBorder(10,0,20,0));
		name2.setAlignmentX(CENTER_ALIGNMENT);
		add(name2);
		
		txtName2 = new JTextField();
		txtName2.setMaximumSize(new Dimension(300,30));
		txtName2.setBackground(new Color(55,58,60));
		txtName2.setForeground(new Color(255,255,255));
		txtName2.setCaretColor(new Color(255,255,255));
		add(txtName2);
		
		lastname1 = new JLabel("Digite su primer apellido");
		lastname1.setFont(new Font("Arial", Font.PLAIN, 20));
		lastname1.setForeground(new Color(255,255,255));
		lastname1.setBorder(new EmptyBorder(10,0,20,0));
		lastname1.setAlignmentX(CENTER_ALIGNMENT);
		add(lastname1);
		
		txtlastName1 = new JTextField();
		txtlastName1.setMaximumSize(new Dimension(300,30));
		txtlastName1.setBackground(new Color(55,58,60));
		txtlastName1.setForeground(new Color(255,255,255));
		txtlastName1.setCaretColor(new Color(255,255,255));
		add(txtlastName1);
		
		lastname2 = new JLabel("Digite su segundo apellido");
		lastname2.setFont(new Font("Arial", Font.PLAIN, 20));
		lastname2.setForeground(new Color(255,255,255));
		lastname2.setBorder(new EmptyBorder(10,0,20,0));
		lastname2.setAlignmentX(CENTER_ALIGNMENT);
		add(lastname2);
		
		txtlastName2 = new JTextField();
		txtlastName2.setMaximumSize(new Dimension(300,30));
		txtlastName2.setBackground(new Color(55,58,60));
		txtlastName2.setForeground(new Color(255,255,255));
		txtlastName2.setCaretColor(new Color(255,255,255));
		add(txtlastName2);
		
		code = new JLabel("Digite su codigo");
		code.setFont(new Font("Arial", Font.PLAIN, 20));
		code.setForeground(new Color(255,255,255));
		code.setBorder(new EmptyBorder(10,0,20,0));
		code.setAlignmentX(CENTER_ALIGNMENT);
		add(code);
		
		txtCode = new JTextField();
		txtCode.setMaximumSize(new Dimension(300,30));
		txtCode.setBackground(new Color(55,58,60));
		txtCode.setForeground(new Color(255,255,255));
		txtCode.setCaretColor(new Color(255,255,255));
		add(txtCode);
		
		password = new JLabel("Digite su contraseña");
		password.setFont(new Font("Arial", Font.PLAIN, 20));
		password.setForeground(new Color(255,255,255));
		password.setBorder(new EmptyBorder(10,0,20,0));
		password.setAlignmentX(CENTER_ALIGNMENT);
		add(password);
		
		txtPassword = new JPasswordField();
		txtPassword.setMaximumSize(new Dimension(300,30));
		txtPassword.setBackground(new Color(55,58,60));
		txtPassword.setForeground(new Color(255,255,255));
//		txtUser.setBorder(new EmptyBorder(10,0,10,0));
		txtPassword.setCaretColor(new Color(255,255,255));
		add(txtPassword);
		
		btnRegister = new JButton("Sign Up");
		btnRegister.setFont(new Font("Arial", Font.PLAIN, 13));
		btnRegister.setForeground(new Color(255,255,255));
		btnRegister.setBackground(new Color(55,58,60));
		btnRegister.setAlignmentX(CENTER_ALIGNMENT);
		btnRegister.setBorder(new RoundedBorder(10));
		btnRegister.setActionCommand("SignUp2");
		btnRegister.addActionListener(listener);
		add(btnRegister);
		
		
	}

	public String getTxtName1() {
		return txtName1.getText();
	}

	public String getTxtName2() {
		return txtName2.getText();
	}

	public String getTxtlastName1() {
		return txtlastName1.getText();
	}

	public String getTxtlastName2() {
		return txtlastName2.getText();
	}

	public String getTxtCode() {
		return txtCode.getText();
	}

	public String getTxtPassword() {
		return txtPassword.getText();
	}
	
	
	
	
}
