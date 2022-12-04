package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import model.CustomFont;
import model.Rol;
import model.Student;
import model.Turn;
import windowsHome.FirstPanel;
import windowsHome.SecondPanel;
import windowsHome.TurnPanel;

public class HomeStudent extends JPanel{
	
	private JPanel menu, dataOption, menuMain;
	private FirstPanel onePanel;
	private FirstPanel secondPanel;
	private SecondPanel threePanel;
	private JButton btnReserve, btnDue, btnCancel, btnLeave, btnUserIcon;
	private JLabel dateNow;
	private Font font;
	private CardLayout cl;
	private JScrollPane scroll;
	
	public HomeStudent(ActionListener listener) {
		CustomFont customFont = new CustomFont("source\\\\font\\\\rimouski-sb.ttf");
		font = customFont.customFontStream();
		initComponents(listener);
	}
	
	private void initPanel(ActionListener listener) {
		
		menu = new JPanel();
		menu.setLayout(new BorderLayout());
		menu.setBackground(new Color(36,38,40));
		add(menu, BorderLayout.WEST);
		
		menuMain = new JPanel();
		menuMain.setLayout(new BoxLayout(menuMain,BoxLayout.Y_AXIS));
		menuMain.setBackground(new Color(36,38,40));
		menu.add(menuMain, BorderLayout.CENTER);
		menuMain.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		
		dataOption = new JPanel();
		dataOption.setLayout(new CardLayout());
		//dataOption.setPreferredSize(new Dimension(1380,800));
		add(dataOption, BorderLayout.CENTER);
		
		onePanel = new FirstPanel(listener);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(onePanel);
		dataOption.add(scroll, "1");
		
		secondPanel = new FirstPanel(listener);
		
		dataOption.add(secondPanel, "2");
		threePanel = new SecondPanel(listener);
		dataOption.add(threePanel,"3");
		
	}

	private void initComponents(ActionListener listener) {
//		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(new BorderLayout());
		initPanel(listener);
		
		cl = (CardLayout)(dataOption.getLayout());
		cl.show(dataOption, String.valueOf(1));
		
		btnUserIcon = new JButton();
		btnUserIcon.setBounds(30, 30, 30, 30);
		ImageIcon imgUserIcon = new ImageIcon("source/first/user-icon.png");
		btnUserIcon.setIcon(new ImageIcon(imgUserIcon.getImage().getScaledInstance(btnUserIcon.getWidth(), 
				btnUserIcon.getHeight(), Image.SCALE_SMOOTH)));
		btnUserIcon.setAlignmentX(CENTER_ALIGNMENT);
		//btnUserIcon.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnUserIcon.setBackground(new Color(36,38,40));
		btnUserIcon.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
		btnUserIcon.setActionCommand("userData");
		btnUserIcon.addActionListener(listener);
		menu.add(btnUserIcon,BorderLayout.NORTH);
		
		btnReserve = new JButton();
		btnReserve.setBounds(35, 35, 35, 35);
		ImageIcon imgReserve = new ImageIcon("source/first/IconoCalendario.png");
		btnReserve.setIcon(new ImageIcon(imgReserve.getImage().getScaledInstance(btnReserve.getWidth(), 
				btnReserve.getHeight(), Image.SCALE_SMOOTH)));
		btnReserve.setAlignmentX(CENTER_ALIGNMENT);
		btnReserve.setBackground(new Color(36,38,40));
		btnReserve.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));
		btnReserve.setActionCommand("reserveData");
		btnReserve.addActionListener(listener);
		menuMain.add(btnReserve);
		
		btnDue = new JButton();
		btnDue.setBounds(30, 30, 30, 30);
		ImageIcon imgDue = new ImageIcon("source/first/due.png");
		btnDue.setIcon(new ImageIcon(imgDue.getImage().getScaledInstance(btnDue.getWidth(), 
				btnDue.getHeight(), Image.SCALE_SMOOTH)));
		btnDue.setAlignmentX(CENTER_ALIGNMENT);
		btnDue.setBackground(new Color(36,38,40));
		btnDue.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));
		menuMain.add(btnDue);
		
		btnCancel = new JButton();
		btnCancel.setBounds(35, 35, 35, 35);
		ImageIcon imgCancel = new ImageIcon("source/first/cancel.png");
		btnCancel.setIcon(new ImageIcon(imgCancel.getImage().getScaledInstance(btnCancel.getWidth(), 
				btnCancel.getHeight(), Image.SCALE_SMOOTH)));
		btnCancel.setAlignmentX(CENTER_ALIGNMENT);
		btnCancel.setBackground(new Color(36,38,40));
		btnCancel.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));
		btnCancel.setActionCommand("cancel");
		btnCancel.addActionListener(listener);
		menuMain.add(btnCancel);
		
		btnLeave = new JButton();
		btnLeave.setBounds(30, 30, 30, 30);
		ImageIcon imgLeave = new ImageIcon("source/first/Salir.png");
		btnLeave.setIcon(new ImageIcon(imgLeave.getImage().getScaledInstance(btnLeave.getWidth(), 
				btnLeave.getHeight(), Image.SCALE_SMOOTH)));
		btnLeave.setAlignmentX(CENTER_ALIGNMENT);
		btnLeave.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnLeave.setBackground(new Color(36,38,40));
		btnLeave.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));
		btnLeave.setActionCommand("leave");
		btnLeave.addActionListener(listener);
		menu.add(btnLeave, BorderLayout.SOUTH);
		
		
	}
	
	public void addTurnPanelDom(ActionListener listener, String star,String finalTurn,int availableQuotas) {
		onePanel.addTurnPanelDom(listener, star, finalTurn, availableQuotas,"reserve");
	}
	
	public void addTurnPanelDom2(ActionListener listener, String star,String finalTurn,int availableQuotas) {
		secondPanel.addTurnPanelDom(listener, star, finalTurn, availableQuotas,"cancelar",new Color(156,94,15)
				,"Cancelar");
	}
	
	public void setQuotas(int avalideQuotas, int position) {
		onePanel.setQuotas(avalideQuotas, position);
	}
	
	public void showPanel(String option) {
		switch(option){
			case "1":
				cl.show(dataOption, option);
				break;
			case "2":
				cl.show(dataOption, option);
				break;	
			case "3":
				cl.show(dataOption, option);
				break;	
			
		}
	}
	
	public void refreshDom(ActionListener listener) {
		secondPanel = new FirstPanel(listener);
//		dataOption.add(secondPanel, "2");
		
	}
	
	public void setData(String nombre, int codigo, Rol rol,String email) {
		threePanel.setData(nombre, codigo, rol,email);
	}
	
}
