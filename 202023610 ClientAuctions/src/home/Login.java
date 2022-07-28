package home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import model.CustomFont;

public class Login extends JPanel{
	
	private JPanel spaceLogin, spaceBanner, buttons;
	private JLabel banner, icon, line, line2;
	private JTextField txtUser;
	private JPasswordField txtPassword; 
	private JButton btnLogin, btnRegister;
	private Font font, font2;

	public Login(ActionListener listener) {
		CustomFont customFont = new CustomFont("source\\font\\HarmoniaSansProCyr-Bold.ttf");
		font = customFont.customFontStream();
		font2 = new Font(customFont.customFontStream().getFamily(),TextAttribute.UNDERLINE_ON,Font.BOLD);
		initComponents(listener);
		
	}

	private void initComponents(ActionListener listener) {
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(20,85,52));
		spaceLogin = new JPanel();
		spaceLogin.setLayout(new BoxLayout(spaceLogin, BoxLayout.Y_AXIS));
		spaceLogin.setBackground(new Color(20,85,52));
		c.gridheight= 1;
		c.gridwidth =2;
		c.gridx =0;
		c.gridy =0;
		//add(test,c);
		c.ipady = 100;
		c.ipadx =  340;
		add(spaceLogin,c);
		
		spaceBanner = new JPanel();
		spaceBanner.setLayout(new BorderLayout());
		spaceBanner.setBackground(new Color(255,255,255));
		c.gridheight= 1;
		c.gridwidth =1;
		c.gridx =3;
		c.gridy =0;
		c.ipadx = 10;
		add(spaceBanner,c);
		
		banner = new JLabel();
		banner.setIcon(new ImageIcon(new ImageIcon("source/banner.png").getImage().getScaledInstance(230, 
				500, Image.SCALE_DEFAULT)));
		spaceBanner.add(banner, BorderLayout.CENTER);
		

		icon = new JLabel();
		icon.setIcon(new ImageIcon(new ImageIcon("source/icon.png").getImage().getScaledInstance(85, 
				83, Image.SCALE_DEFAULT)));
		icon.setBorder(new EmptyBorder(70,10,40,60));
		spaceLogin.add(icon);

		txtUser = new JTextField("Usuario");
		txtUser.setFont(font.deriveFont(Font.BOLD, 15));
		txtUser.setMaximumSize(new Dimension(300,40));
		txtUser.setBackground(new Color(20,85,52));
		txtUser.setForeground(new Color(255,255,255));
		txtUser.setCaretColor(new Color(255,255,255));
		txtUser.setBorder(new EmptyBorder(10,60,10,0));
		spaceLogin.add(txtUser);
		
		line = new JLabel();
		line.setIcon(new ImageIcon(new ImageIcon("source/line.png").getImage().getScaledInstance(390, 
				10, Image.SCALE_DEFAULT)));
		line.setBorder(new EmptyBorder(0,0,40,0));
		spaceLogin.add(line);
		
		txtPassword = new JPasswordField("Contraseña");
		txtPassword.setMaximumSize(new Dimension(300,30));
		txtPassword.setBackground(new Color(20,85,52));
		txtPassword.setForeground(new Color(255,255,255));
		txtPassword.setBorder(new EmptyBorder(10,60,10,0));
		txtPassword.setCaretColor(new Color(255,255,255));
		txtPassword.setFont(font.deriveFont(Font.BOLD, 15));
		spaceLogin.add(txtPassword);
		
		line2 = new JLabel();
		line2.setIcon(new ImageIcon(new ImageIcon("source/line.png").getImage().getScaledInstance(390, 
				10, Image.SCALE_DEFAULT)));
		spaceLogin.add(line2);
		line2.setBorder(new EmptyBorder(0,0,140,0));
		
		buttons = new JPanel();
		buttons.setBackground(new Color(20,85,52));
		buttons.setMaximumSize(new Dimension(330,60));
		buttons.setAlignmentX(LEFT_ALIGNMENT);
		spaceLogin.add(buttons);
		
		btnLogin = new JButton("INICIAR SESIÓN");
		btnLogin.setFont(font.deriveFont(Font.BOLD, 17));
		btnLogin.setForeground(new Color(20,85,52));
		btnLogin.setBackground(new Color(255,255,255));
		btnLogin.setAlignmentX(LEFT_ALIGNMENT);
		buttons.add(btnLogin);
		btnRegister = new JButton("REGISTRARSE");
		btnRegister.setAlignmentX(LEFT_ALIGNMENT);
		btnRegister.setFont(font2.deriveFont(Font.BOLD, 17));
		btnRegister.setForeground(new Color(55,181,77));
		btnRegister.setBackground(new Color(20,85,52));
		btnRegister.setBorder(new EmptyBorder(0,20,0,0));
	
		buttons.add(btnRegister);
		
		
		
	}

}
