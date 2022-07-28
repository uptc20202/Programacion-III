package home;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CustomFont;

public class Landing extends JPanel{
	
	private JPanel menu, table, options, optionsMain, head, optionsCard;
	private JLabel icon;
	private Font font;
	private JButton button1,button2, button3,buttonExit, buttonUser, buttonNofication, buttonOptionUser;
	private CardLayout cl, cl2;
	
	public Landing(ActionListener listener) {
		CustomFont customFont = new CustomFont("source\\font\\vremenagroteskbook.otf");
		font = customFont.customFontStream();
		initComponents(listener);
		
	}

	private void initComponents(ActionListener listener) {
		
		this.setLayout(new BorderLayout());
		
		menu = new JPanel();
		menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		menu.setBackground(new Color(20,85,52));
		add(menu, BorderLayout.WEST);
		
		icon = new JLabel();
		icon.setIcon(new ImageIcon(new ImageIcon("source/icon.png").getImage().getScaledInstance(40, 
				39, Image.SCALE_DEFAULT)));
		icon.setBorder(new EmptyBorder(30,10,40,60));
		menu.add(icon);
		
		button1 = new JButton();
		button1.setBounds(30, 30, 100, 30);
		button1.setBackground(new Color(20,85,52));
		button1.setBorder(new EmptyBorder(5,10,10,10));
		ImageIcon imgDue = new ImageIcon("source/menu/buttonBuy.png");
		button1.setIcon(new ImageIcon(imgDue.getImage().getScaledInstance(90, 
				22, Image.SCALE_SMOOTH)));
		menu.add(button1);
		
		button2 = new JButton();
		button2.setBounds(30, 30, 100, 30);
		button2.setBackground(new Color(20,85,52));
		button2.setBorder(new EmptyBorder(10,10,10,10));
		ImageIcon imgDue1 = new ImageIcon("source/menu/buttonSubastar.png");
		button2.setIcon(new ImageIcon(imgDue1.getImage().getScaledInstance(90, 
				22, Image.SCALE_SMOOTH)));
		menu.add(button2);
		
		
		button3 = new JButton();
		button3.setBounds(30, 30, 100, 30);
		button3.setBackground(new Color(20,85,52));
		button3.setBorder(new EmptyBorder(10,10,10,10));
		ImageIcon imgDue2 = new ImageIcon("source/menu/buttonBuys.png");
		button3.setIcon(new ImageIcon(imgDue2.getImage().getScaledInstance(90, 
				22, Image.SCALE_SMOOTH)));
		menu.add(button3);
		JLabel space = new JLabel("");
		space.setBorder(new EmptyBorder(100,10,170,10));
		menu.add(space);
		buttonExit = new JButton();
		buttonExit.setBounds(30, 30, 30, 30);
		buttonExit.setBackground(new Color(20,85,52));
		buttonExit.setBorder(new EmptyBorder(10,10,5,10));
		ImageIcon imgDue3 = new ImageIcon("source/menu/buttonExit.png");
		buttonExit.setIcon(new ImageIcon(imgDue3.getImage().getScaledInstance(55, 
				22, Image.SCALE_SMOOTH)));
		buttonExit.setAlignmentY(BOTTOM_ALIGNMENT);
		menu.add(buttonExit);
		
		
		
		optionsMain = new JPanel();
		optionsMain.setBackground(new Color(255,255,255));
		optionsMain.setLayout(new BorderLayout());
		add(optionsMain, BorderLayout.CENTER);
		
		optionsCard = new JPanel();
		optionsCard.setLayout(new CardLayout());
		optionsMain.add(optionsCard, BorderLayout.CENTER);
		
		cl = (CardLayout)(this.getLayout());
		cl.show(this, "homeOptions");
		
		head = new JPanel();
		head.setBorder(new EmptyBorder(2,750,2,2));
		head.setBackground(new Color(255,255,255));
		head.setLayout(new FlowLayout());
		head.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		head.setAlignmentY(RIGHT_ALIGNMENT);
		
		buttonNofication = new JButton();
		buttonNofication.setBounds(30, 30, 30, 30);
		buttonNofication.setBackground(new Color(255,255,255));
		buttonNofication.setBorder(new EmptyBorder(5,5,5,5));
		ImageIcon imgDue6 = new ImageIcon("source/menu2/icono campana.png");
		buttonNofication.setIcon(new ImageIcon(imgDue6.getImage().getScaledInstance(24, 
				25, Image.SCALE_SMOOTH)));
		buttonNofication.setAlignmentX(RIGHT_ALIGNMENT);
		head.add(buttonNofication);
		
		buttonUser = new JButton();
		buttonUser.setBounds(30, 30, 30, 30);
		buttonUser.setBackground(new Color(255,255,255));
		buttonUser.setBorder(new EmptyBorder(5,5,5,5));
		ImageIcon imgDue5 = new ImageIcon("source/menu2/icono Usuario.png");
		buttonUser.setIcon(new ImageIcon(imgDue5.getImage().getScaledInstance(25, 
				25, Image.SCALE_SMOOTH)));
		buttonUser.setAlignmentX(RIGHT_ALIGNMENT);
		head.add(buttonUser);

		buttonOptionUser = new JButton();
		buttonOptionUser.setBounds(30, 30, 30, 30);
		buttonOptionUser.setBackground(new Color(255,255,255));
		buttonOptionUser.setBorder(new EmptyBorder(5,5,5,20));
		ImageIcon imgDue4 = new ImageIcon("source/menu2/Tres puntos.png");
		buttonOptionUser.setIcon(new ImageIcon(imgDue4.getImage().getScaledInstance(4, 
				14, Image.SCALE_SMOOTH)));
		buttonOptionUser.setAlignmentX(RIGHT_ALIGNMENT);
		buttonOptionUser.setAlignmentY(CENTER_ALIGNMENT);
		head.add(buttonOptionUser);
		
		optionsMain.add(head,BorderLayout.NORTH);
		
		options = new JPanel();
		options.setLayout(new CardLayout());
		
	}
	
	
	
	public void showPanel(String option) {
		switch(option){
			case "login":
				cl.show(this, "login");
				break;
			case "home":
				cl.show(this, "home");
				break;
			case "register":
				cl.show(this, "register");
				break;	
			
		}
	}
	
}
