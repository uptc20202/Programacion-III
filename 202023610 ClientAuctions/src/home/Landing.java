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

public class Landing extends JPanel implements MouseListener{
	
	private JPanel menu, optionsMain, head, optionsCard;
	private JPanel firstScreen, headTable, tablePanel;
	private UserPage userPage;
	private JLabel icon;
	private JLabel txtTitle;
	private JComboBox<String> comboTable;
	private JScrollPane scrollOverallTable,scrollUserTable;
	private Font font,font2, font3;
	private JButton button1,button2, button3,buttonExit, buttonUser, buttonNofication, buttonOptionUser;
	private JTable overallTable,bidTables,userTable;
	private CardLayout cl, cl2;
	private ArrayList<String[]> datasTables, datasTables2; 
	private String user,name;
	private ToBid toBid;
	private ToAuction toAuction;
	private ActionListener listener;
	private JTextField bidNew;
	private CalculateView parent;
	private ValidateTable validateTable,validateTable2;
	
	public Landing(ActionListener listener,String datasTable,String datasTable2,String user,String name, 
			CalculateView parent) {
		validateTable = new ValidateTable();
		validateTable2 = new ValidateTable();
		this.parent = parent;
		this.datasTables = validateTable.fillTable(datasTable, user);
		this.datasTables2 = validateTable2.fillTable(datasTable2, user);
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
		
		String[] namesColumn = {"ID","TITULO","VALOR DE ENTRADA","  "};
		
		overallTable = generateTable(validateTable.fillOverallTable(),namesColumn,"button");
		scrollOverallTable = new JScrollPane(overallTable);
		scrollOverallTable.setBorder(new EmptyBorder(30,60,20,60));
		scrollOverallTable.setBackground(new Color(255,255,255));
		tablePanel.add(scrollOverallTable,"overallTable");
		
		bidTables = generateTable(validateTable2.fillOverallTable(),namesColumn,"bidUP+");
		scrollUserTable = new JScrollPane(bidTables);
		scrollUserTable.setBorder(new EmptyBorder(30,60,20,60));
		scrollUserTable.setBackground(new Color(255,255,255));
		tablePanel.add(scrollUserTable,"userTable");
		
		firstScreen.add(tablePanel);
		
		userTable =generateTable(validateTable.fillUserTable(),namesColumn,"cancel");
		userPage = new UserPage(listener,userTable,name, user, parent);
		optionsCard.add(userPage,"userPage");
	}
	
	public JTable generateTable(Object [][] datas,String[] namesColumn,String type) {
		
		DefaultTableModel modelo = new DefaultTableModel(datas,namesColumn){
		    public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
		};
		JTable table = new JTable (modelo);
		table.addMouseListener(this);
		table.setFont(font3.deriveFont(Font.BOLD, 14));
		table.setForeground(new Color(14,58,35));
		Object objeto = table.getColumnModel().getColumn(3);
		
		table.setBackground(new Color(255,255,255));
		table.setRowHeight(25);
		table.getColumnModel().getColumn(0).setCellRenderer(new DrawTable("text"));
		table.getColumnModel().getColumn(1).setCellRenderer(new DrawTable("text"));
		table.getColumnModel().getColumn(2).setCellRenderer(new DrawTable("text"));
		table.getColumnModel().getColumn(3).setCellRenderer(new DrawTable(type));
		

		return table;
	}
	
	
	
	public void showOptionsCard(String option) {
		cl.show(optionsCard, option);
	}
	
	public void showOptionsTables() {
		switch(comboTable.getSelectedItem().toString()) {
			case "Todas las Subastas":
				cl2.show(tablePanel, "overallTable");
				break;
			case "Subastas donde Participo":
				cl2.show(tablePanel, "userTable");
				break;
			default:
				break;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = overallTable.rowAtPoint(e.getPoint());
		int column = overallTable.columnAtPoint(e.getPoint());
		
		if (column==3) {
			validarSelectionMouse(row);
		}
		
	}

	private void validarSelectionMouse(int row) {
		String id = datasTables.get(row)[0];
		String title = datasTables.get(row)[1];
		String Description= datasTables.get(row)[4];
		String value= datasTables.get(row)[2];
		toBid = new ToBid(parent,true,listener,id,title,Description,value);
		toBid.setVisible(true);
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
	
	public String getNameNewAuction() {
		// TODO Auto-generated method stub
		return toAuction.getTxtTitle();
	}

	public String getDescriptionNewAuction() {
		// TODO Auto-generated method stub
		return toAuction.getTxtDescription();
	}

	public String getValueNewAuction() {
		// TODO Auto-generated method stub
		return toAuction.getTxtvalue();
	}

	public String getIdToBid() {
		// TODO Auto-generated method stub
		return toBid.getId();
	}

	public String getValueToBid() {
		// TODO Auto-generated method stub
		return toBid.getBidValue();
	}

	public void setVisibleToBid(boolean result) {
		// TODO Auto-generated method stub
		toBid.setVisible(result);
		if(result) {
			toBid.dispose();
		}	
	}

	public void restorefillTable(String data1, String data2, String nickname) {
		// TODO Auto-generated method stub
		String[] namesColumn = {"ID","TITULO","VALOR DE ENTRADA","  "};
		
		this.datasTables = validateTable.fillTable(data1, user);
		this.datasTables2 = validateTable2.fillTable(data2, user);
		
		bidTables = generateTable(validateTable2.fillOverallTable(),namesColumn,"bidUP+");
		overallTable = generateTable(validateTable.fillOverallTable(),namesColumn,"button");
		userTable =generateTable(validateTable.fillUserTable(),namesColumn,"cancel");
		
	} 
	
	
	
}
