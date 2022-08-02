package home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CustomFont;
import view.CalculateView;

public class ToAuction extends JDialog implements ActionListener{

	private JLabel lbTitle, lbDescription,lbValue;
	private JTextField txtTitle,txtDescription,txtvalue;
	private JPanel panel;
	private Font font3;
	private JButton btnAuction;
	
	public ToAuction(CalculateView parent, boolean modal,ActionListener listener) {
		super(parent, modal);
		CustomFont customFont3 = new CustomFont("source\\font\\HarmoniaSansProCyr-Light.ttf");
		font3 = customFont3.customFontStream();
		setLayout(null);
		setLocationRelativeTo(null);
	    setBounds(440,10,410,210);
	    
	    initComponents( );
	}
	
	public void initComponents() {
		
		panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setSize(new Dimension(410,210));
	    panel.setBackground(new Color(0,0,0,0));
	    panel.setFont(font3.deriveFont(Font.BOLD, 14));
	    panel.setForeground(new Color(14,58,35));
	    add(panel);
	    
	    lbTitle = new JLabel("Digite Titulo de Subasta:");
	    lbTitle.setAlignmentX(CENTER_ALIGNMENT);
	    lbTitle.setFont(font3.deriveFont(Font.BOLD, 14));
	    lbTitle.setForeground(new Color(14,58,35));
		panel.add(lbTitle);
		
		txtTitle = new JTextField("");
		txtTitle.setAlignmentX(CENTER_ALIGNMENT);
		txtTitle.setMaximumSize(new Dimension(100,20));
		txtTitle.setFont(font3.deriveFont(Font.BOLD, 14));
		txtTitle.setForeground(new Color(14,58,35));
		panel.add(txtTitle);
		
		lbDescription = new JLabel("Digite Titulo de Subasta:");
		lbDescription.setAlignmentX(CENTER_ALIGNMENT);
		lbDescription.setFont(font3.deriveFont(Font.BOLD, 14));
		lbDescription.setForeground(new Color(14,58,35));
		panel.add(lbDescription);
		
		txtDescription = new JTextField("");
		txtDescription.setAlignmentX(CENTER_ALIGNMENT);
		txtDescription.setMaximumSize(new Dimension(100,20));
		txtDescription.setFont(font3.deriveFont(Font.BOLD, 14));
		txtDescription.setForeground(new Color(14,58,35));
		panel.add(txtDescription);
		
		lbValue = new JLabel("Digite Titulo de Subasta:");
		lbValue.setAlignmentX(CENTER_ALIGNMENT);
		lbValue.setFont(font3.deriveFont(Font.BOLD, 14));
	    lbValue.setForeground(new Color(14,58,35));
		panel.add(lbValue);
		
		txtvalue = new JTextField("");
		txtvalue.setAlignmentX(CENTER_ALIGNMENT);
		txtvalue.setMaximumSize(new Dimension(100,20));
		txtvalue.setFont(font3.deriveFont(Font.BOLD, 14));
		txtvalue.setForeground(new Color(14,58,35));
		panel.add(txtvalue);
		
		btnAuction = new JButton("SUBASTAR");
		btnAuction.setAlignmentX(CENTER_ALIGNMENT);
		btnAuction.setMaximumSize(new Dimension(100,20));
		btnAuction.setFont(font3.deriveFont(Font.BOLD, 14));
		btnAuction.setForeground(new Color(14,58,35));
		panel.add(btnAuction);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 
	}

}
		
