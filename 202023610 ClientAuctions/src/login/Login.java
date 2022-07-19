package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel{
	
	private JPanel spaceLogin, spaceBanner;
	private JLabel banner, icon;
	private JTextField txtUser;
	private JPasswordField txtPassword; 
	private JButton btnLogin, btnRegister;

	public Login(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(20,85,52));
		double heightMainPanel = 600;
		double widthMainPanel = 1000;
		spaceLogin = new JPanel();
		spaceLogin.setLayout(new BoxLayout(spaceLogin, BoxLayout.X_AXIS));
		spaceLogin.setBackground(new Color(20,85,52));
		c.gridheight= 1;
		c.gridwidth =2;
		c.gridx =0;
		c.gridy =0;
		//add(test,c);
		c.ipady = 100;
		c.ipadx =  740;
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
		icon.setIcon(new ImageIcon(new ImageIcon("source/icon.png").getImage().getScaledInstance(50, 
				50, Image.SCALE_DEFAULT)));
		spaceLogin.add(icon);
		
	}

}
