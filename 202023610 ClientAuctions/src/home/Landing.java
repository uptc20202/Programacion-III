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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.awt.print.PrinterException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.CustomFont;
import model.ValidateTable;
import view.CalculateView;
import view.DrawTable;

public class Landing extends CreateTable implements MouseListener {
	
	private JPanel menu, optionsMain, head, optionsCard;
	private JPanel firstScreen, headTable, tablePanel;
	private UserPage userPage;
	private JLabel icon;
	private JLabel txtTitle;
	private JComboBox<String> comboTable;
	private JScrollPane scrollOverallTable,scrollUserTable,scrollSortTable;
	private Font font,font2, font3;
	private JButton button1,button2, button3,buttonExit, buttonUser, buttonNofication, buttonOptionUser;
	private JTable overallTable,bidTables,sortTables;
	private CardLayout cl, cl2;
	private ArrayList<String[]> datasTables, datasTables2, tableBuysArray, tableShortArray; 
	private String user,name,position;
	private ToBid toBid;
	private ToAuction toAuction;
	private ActionListener listener;
	private JTextField bidNew;
	private CalculateView parent;
	private ValidateTable validateTable;
	private JPanel headTable2,secondScreen, tablePanel2;
	private JLabel txtTitle2;
	private JTable tableBuys;
	private JScrollPane scrollOverallTable3;
	private String notification;
	
	public Landing(ActionListener listener,String datasTable,String datasTable2,String user,String name, 
			String data3, String data4,String notification,CalculateView parent) {
		validateTable = new ValidateTable();
		this.notification = notification;
		this.position = "overallTable";
		this.parent = parent;
		this.datasTables = validateTable.fillTable(datasTable);
		this.datasTables2 = validateTable.fillTable(datasTable2);
		this.tableBuysArray = validateTable.fillTable(data4);
		this.tableShortArray = validateTable.fillTableSort(datasTable);
		this.user = user;
		this.name = name;
		toBid = new ToBid();
		CustomFont customFont = new CustomFont("source\\font\\vremenagroteskbook.otf");
		font = customFont.customFontStream();
		CustomFont customFont2 = new CustomFont("source\\font\\vremenagroteskbold.otf");
		font2 = customFont2.customFontStream();
		CustomFont customFont3 = new CustomFont("source\\font\\HarmoniaSansProCyr-Light.ttf");
		font3 = customFont3.customFontStream();
		this.listener = listener;
		userPage = new UserPage(listener,data3,name, user, parent);
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
		button1.setActionCommand("buyOption");
		button1.addActionListener(listener);
		menu.add(button1);
		
		button2 = new JButton();
		button2.setBounds(30, 30, 100, 30);
		button2.setBackground(new Color(20,85,52));
		button2.setBorder(new EmptyBorder(10,10,10,10));
		ImageIcon imgDue1 = new ImageIcon("source/menu/buttonSubastar.png");
		button2.setIcon(new ImageIcon(imgDue1.getImage().getScaledInstance(90, 
				22, Image.SCALE_SMOOTH)));
		button2.setActionCommand("postAuctionWindow");
		button2.addActionListener(listener);
		menu.add(button2);
		
		
		button3 = new JButton();
		button3.setBounds(30, 30, 100, 30);
		button3.setBackground(new Color(20,85,52));
		button3.setBorder(new EmptyBorder(10,10,10,10));
		ImageIcon imgDue2 = new ImageIcon("source/menu/buttonBuys.png");
		button3.setIcon(new ImageIcon(imgDue2.getImage().getScaledInstance(90, 
				22, Image.SCALE_SMOOTH)));
		button3.setActionCommand("myBuys");
		button3.addActionListener(listener);
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
		buttonExit.setActionCommand("exit");
		buttonExit.addActionListener(listener);
		menu.add(buttonExit);
		
		
		
		optionsMain = new JPanel();
		optionsMain.setBackground(new Color(255,255,255));
		optionsMain.setLayout(new BorderLayout());
		add(optionsMain, BorderLayout.CENTER);
		
		
		
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
		buttonNofication.setActionCommand("watchNotification");
		buttonNofication.addActionListener(listener);
		head.add(buttonNofication);
		
		buttonUser = new JButton();
		buttonUser.setBounds(30, 30, 30, 30);
		buttonUser.setBackground(new Color(255,255,255));
		buttonUser.setBorder(new EmptyBorder(5,5,5,5));
		ImageIcon imgDue5 = new ImageIcon("source/menu2/icono Usuario.png");
		buttonUser.setIcon(new ImageIcon(imgDue5.getImage().getScaledInstance(25, 
				25, Image.SCALE_SMOOTH)));
		buttonUser.setAlignmentX(RIGHT_ALIGNMENT);
		buttonUser.setActionCommand("userData");
		buttonUser.addActionListener(listener);
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
		buttonOptionUser.setActionCommand("userData");
		buttonOptionUser.addActionListener(listener);
		head.add(buttonOptionUser);
		optionsMain.add(head,BorderLayout.NORTH);
		
		toAuction = new ToAuction(parent,true,listener);
		toAuction.setVisible(false);
		
		
		initScreens(listener, name); 
		
		
	}
	
	public void initScreens(ActionListener listener,String name) {
		optionsCard = new JPanel();
		optionsCard.setLayout(new CardLayout());
		optionsMain.add(optionsCard, BorderLayout.CENTER);
		
		cl = (CardLayout)(optionsCard.getLayout());
		cl.show(optionsCard, "homeOptions");
		
		
		
		firstScreen = new JPanel();
		firstScreen.setBackground(new Color(255,255,255));
		firstScreen.setLayout(new BoxLayout(firstScreen, BoxLayout.Y_AXIS));
		optionsCard.add(firstScreen, "homeOptions");
		
		headTable = new JPanel();
		headTable.setBackground(new Color(255,255,255));
		headTable.setBorder(new EmptyBorder(10,0,10,60));
		firstScreen.add(headTable);
		
		
		txtTitle = new JLabel("Subastas");
		txtTitle.setFont(font2.deriveFont(Font.PLAIN, 16));
		txtTitle.setForeground(new Color(20,85,52));
		txtTitle.setBorder(new EmptyBorder(0,0,0,450));
		headTable.add(txtTitle);
		
		comboTable = new JComboBox<String>();
		comboTable.addItem("Todas las Subastas");
		comboTable.addItem("Subastas donde Participo");
		comboTable.addItem("Subastas Precio Menor a Mayor");
		comboTable.setFont(font.deriveFont(Font.BOLD, 15));
		comboTable.setForeground(new Color(255,255,255));
		comboTable.setBackground(new Color(20,85,52));
		comboTable.setActionCommand("changeTable");
		comboTable.addActionListener(listener);
		headTable.add(comboTable);
		
		tablePanel = new JPanel();
		tablePanel.setLayout(new CardLayout());
		
		cl2 = (CardLayout)(tablePanel.getLayout());
		cl2.show(tablePanel, "overallTable");
		
		overallTable = generateTable(validateTable.fillOverallTable(datasTables),"button");
		overallTable.addMouseListener(this);
		scrollOverallTable = new JScrollPane(overallTable);
		scrollOverallTable.setBorder(new EmptyBorder(30,60,20,60));
		scrollOverallTable.setBackground(new Color(255,255,255));
		tablePanel.add(scrollOverallTable,"overallTable");
		
		bidTables = generateTable(validateTable.fillOverallTable(datasTables2),"bidUP+");
		bidTables.addMouseListener(this);
		scrollUserTable = new JScrollPane(bidTables);
		scrollUserTable.setBorder(new EmptyBorder(30,60,20,60));
		scrollUserTable.setBackground(new Color(255,255,255));
		tablePanel.add(scrollUserTable,"userTable");
		
		sortTables = generateTable(validateTable.fillOverallTable(tableShortArray),"button");
		sortTables.addMouseListener(this);
		scrollSortTable = new JScrollPane(sortTables);
		scrollSortTable.setBorder(new EmptyBorder(30,60,20,60));
		scrollSortTable.setBackground(new Color(255,255,255));
		tablePanel.add(scrollSortTable,"sortTable");
		
		firstScreen.add(tablePanel);
		
		optionsCard.add(userPage,"userPage");
		myBuysScreen();
	}
	
	public void myBuysScreen() {
		
		secondScreen = new JPanel();
		secondScreen.setBackground(new Color(255,255,255));
		secondScreen.setLayout(new BoxLayout(secondScreen, BoxLayout.Y_AXIS));
		optionsCard.add(secondScreen, "buysOptions");
		
		headTable2 = new JPanel();
		headTable2.setBackground(new Color(255,255,255));
		headTable2.setBorder(new EmptyBorder(10,0,10,60));
		secondScreen.add(headTable2);
		
		
		txtTitle2 = new JLabel("Subastas Ganadas");
		txtTitle2.setFont(font2.deriveFont(Font.PLAIN, 16));
		txtTitle2.setForeground(new Color(20,85,52));
		txtTitle2.setBorder(new EmptyBorder(0,0,0,450));
		headTable2.add(txtTitle2);
		
		
		tableBuys = generateTable(validateTable.fillOverallTable(tableBuysArray),"text");
		scrollOverallTable3 = new JScrollPane(tableBuys);
		scrollOverallTable3.setBorder(new EmptyBorder(30,60,20,60));
		scrollOverallTable3.setBackground(new Color(255,255,255));
		secondScreen.add(scrollOverallTable3);
	}
	
	
		
	public void showOptionsCard(String option) {
		cl.show(optionsCard, option);
	}
	
	public void showOptionsTables() {
		switch(comboTable.getSelectedItem().toString()) {
			case "Todas las Subastas":
				cl2.show(tablePanel, "overallTable");
				position = "overallTable";
				break;
			case "Subastas donde Participo":
				cl2.show(tablePanel, "userTable");
				position = "userTable";
				break;
			case "Subastas Precio Menor a Mayor":
				cl2.show(tablePanel, "sortTable");
				position = "sortTable";
				break;	
			default:
				break;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = overallTable.rowAtPoint(e.getPoint());
		int column = overallTable.columnAtPoint(e.getPoint());
		int row2 = bidTables.rowAtPoint(e.getPoint());
		int column2 = bidTables.columnAtPoint(e.getPoint());
		int row3 = sortTables.rowAtPoint(e.getPoint());
		int column3 = sortTables.columnAtPoint(e.getPoint());
		if (column==3) {
			if(position.equalsIgnoreCase("overallTable")) {
				validarSelectionMouse(row,datasTables);
			}else if(position.equalsIgnoreCase("userTable")){
				validarSelectionMouse(row2,datasTables2);
			}else if(position.equalsIgnoreCase("sortTable")) {
				validarSelectionMouse(row3,tableShortArray);
			}	
		}
		
	}

	private void validarSelectionMouse(int row,ArrayList<String[]> table) {
		String id = table.get(row)[0];
		String title = table.get(row)[1];
		String Description= table.get(row)[4];
		String value= table.get(row)[2];
		if(!table.get(row)[3].equalsIgnoreCase(user)) {
			toBid = new ToBid(parent,true,listener,id,title,Description,value);
			toBid.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "¡Es tu subasta! \n"
					+ " Si deseas cancelarla dirigete al menu de usuario");
		}	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void setVisibleToAuction(Boolean result) {
		toAuction.setVisible(result);
		if(result) {
			toAuction.dispose();
		}	
	}
	
	public String getNameNewAuction() throws NullPointerException{
		// TODO Auto-generated method stub
		return toAuction.getTxtTitle();
	}

	public String getDescriptionNewAuction() {
		// TODO Auto-generated method stub
		return toAuction.getTxtDescription();
	}

	public String getValueNewAuction() {
		// TODO Auto-generated method stub
		return toAuction.getTxtvalue().replaceAll("[^\\d.]", "");
	}

	public int getIdToBid() throws NullPointerException{
		// TODO Auto-generated method stub
		return toBid.getId();
	}

	public String getValueToBid() throws NullPointerException{
		// TODO Auto-generated method stub
		if(!toBid.validateInput()) {
			JOptionPane.showMessageDialog(null, "Puja no creada "
				+ "\n Ingresa Una Oferta Mayor a la Ultima");
		}	
		return toBid.getBidValue().replaceAll("[^\\d.]", "");
	}
	
	public void showNotification() {
		if(notification.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "No hay notificaciones");
		}else {
			JOptionPane.showMessageDialog(null,notification);
		}
		setButtonNofication(false);
	}

	public void setVisibleToBid(boolean result) {
		// TODO Auto-generated method stub
		toBid.setVisible(result);
		if(result) {
			toBid.dispose();
		}	
	}
	
	public void setNotification(String text) {
		String notification1 = "Ganaste la subasta: "+text+"\n";
		notification = notification1+"\n"+notification;
	}


	public void setNotification(String nickname, String tittle) {
		// TODO Auto-generated method stub
		String notification1 = nickname+" a ganado la subasta "+tittle
				+" ¡Sigue participando y aumenta tus posibilidades de ganar! \n";
		notification = notification1+"\n"+notification;
	}

	public void setButtonNofication(Boolean validation) {
		if(validation) {
			ImageIcon imgDue6 = new ImageIcon("source/menu2/icono notificacion.png");
			buttonNofication.setIcon(new ImageIcon(imgDue6.getImage().getScaledInstance(24, 
					25, Image.SCALE_SMOOTH)));
	
		}else {
			ImageIcon imgDue6 = new ImageIcon("source/menu2/icono campana.png");
			buttonNofication.setIcon(new ImageIcon(imgDue6.getImage().getScaledInstance(24, 
					25, Image.SCALE_SMOOTH)));
		}
	}	

	public int getIdToSell() throws NullPointerException{
		// TODO Auto-generated method stub
		return userPage.getIdToSell();
	}

	public void setVisibleToCancel(boolean result) {
		// TODO Auto-generated method stub
		userPage.setVisibleToCancel(result);
	}
	
}
