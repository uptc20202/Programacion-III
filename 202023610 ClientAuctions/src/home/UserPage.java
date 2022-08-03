package home;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.CustomFont;
import view.CalculateView;

public class UserPage extends JScrollPane implements MouseListener{
	
	private JPanel generalPanel,panelDataUser,panelTable;
	private JLabel alert, iconUser, lbname, nickName,txtTitle;
	private JTable table;
	private String name,user;
	private Font font2;

	public UserPage(ActionListener listener,JTable datasTable,String name,String user, 
			CalculateView parent) {
		table = datasTable;
		this.name = name;
		this.user = user;
		CustomFont customFont2 = new CustomFont("source\\font\\vremenagroteskbold.otf");
		font2 = customFont2.customFontStream();
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		// TODO Auto-generated method stub
		generalPanel = new JPanel();
		generalPanel.setLayout(new BoxLayout(generalPanel, BoxLayout.Y_AXIS));
		add(generalPanel);
		setViewportView(generalPanel);
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gbl = new GridBagLayout();
		panelDataUser = new JPanel();
		panelDataUser.setLayout(gbl);
		panelDataUser.setBorder(new EmptyBorder(0,0,0,0));
		generalPanel.add(panelDataUser);
		
		
		alert = new JLabel("Datos De Usuario");
		alert.setBorder(new EmptyBorder(0,45,10,0));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		alert.setFont(new Font("Arial", Font.BOLD, 25));
		panelDataUser.add(alert,gbc);
		
		iconUser = new JLabel();
		iconUser.setIcon(new ImageIcon(new ImageIcon("source/menu2/icono Usuario.png").getImage().getScaledInstance(150, 
				150, Image.SCALE_DEFAULT)));
		iconUser.setAlignmentX(CENTER_ALIGNMENT);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 5;
		gbc.gridheight = 5;
		panelDataUser.add(iconUser,gbc);
		
		lbname = new JLabel("nombre");
		lbname.setFont(new Font("Arial", Font.PLAIN, 15));
		gbc.gridx = 6;
		gbc.gridy = 1;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		lbname.setBorder(new EmptyBorder(20,20,0,0));
		panelDataUser.add(lbname,gbc);
		
		nickName = new JLabel("codigo");
		nickName.setFont(new Font("Arial", Font.PLAIN, 15));
		gbc.gridx = 6;
		gbc.gridy = 2;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		nickName.setBorder(new EmptyBorder(20,20,0,0));
		panelDataUser.add(nickName,gbc);
		setData();
		
		
		panelTable = new JPanel();
		panelTable.setLayout(new BoxLayout(panelTable, BoxLayout.Y_AXIS));
		txtTitle = new JLabel("Mis Subastas");
		txtTitle.setFont(font2.deriveFont(Font.PLAIN, 16));
		txtTitle.setForeground(new Color(20,85,52));
		txtTitle.setBorder(new EmptyBorder(0,0,0,450));
		panelTable.add(txtTitle);
		
		panelTable.add(table);
		generalPanel.add(panelTable);
	}
	
	public void setData() {
		this.lbname.setText(name);
		this.nickName.setText(user);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

}
