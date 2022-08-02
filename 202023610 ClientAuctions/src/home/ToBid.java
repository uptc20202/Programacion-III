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

public class ToBid extends JDialog implements ActionListener{

	private JLabel txtTitle, bidTitle, bidDescription,bidValue;
	private JTextField bidNew;
	private JPanel panel;
	private Font font3;
	private JButton bidUp;
	
	public ToBid(CalculateView parent, boolean modal,ActionListener listener,String Title,
			String description, String value) {
		super(parent, modal);
		CustomFont customFont3 = new CustomFont("source\\font\\HarmoniaSansProCyr-Light.ttf");
		font3 = customFont3.customFontStream();
		setLayout(null);
		setLocationRelativeTo(null);
	    setBounds(440,10,410,210);
	    
	    initComponents( Title,  description,  value);
	}
	
	public void initComponents(String Title, String description, String value) {
		
		panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setSize(new Dimension(410,210));
	    panel.setBackground(new Color(0,0,0,0));
	    panel.setFont(font3.deriveFont(Font.BOLD, 14));
	    panel.setForeground(new Color(14,58,35));
	    add(panel);
	    
		bidTitle = new JLabel(Title);
		bidTitle.setAlignmentX(CENTER_ALIGNMENT);
		bidTitle.setFont(font3.deriveFont(Font.BOLD, 14));
		bidTitle.setForeground(new Color(14,58,35));
		panel.add(bidTitle);
		
		bidDescription = new JLabel(description);
		bidDescription.setAlignmentX(CENTER_ALIGNMENT);
		bidDescription.setFont(font3.deriveFont(Font.BOLD, 14));
		bidDescription.setForeground(new Color(14,58,35));
		panel.add(bidDescription);
		
		bidValue = new JLabel("Valor minimo de entrada "+"$"+value);
		bidValue.setAlignmentX(CENTER_ALIGNMENT);
		bidValue.setFont(font3.deriveFont(Font.BOLD, 14));
		bidValue.setForeground(new Color(14,58,35));
		panel.add(bidValue);
		
		bidNew = new JTextField("$"+value);
		bidNew.setAlignmentX(CENTER_ALIGNMENT);
		bidNew.setMaximumSize(new Dimension(100,20));
		bidNew.setFont(font3.deriveFont(Font.BOLD, 14));
		bidNew.setForeground(new Color(14,58,35));
		panel.add(bidNew);
		
		bidUp = new JButton("ENTRAR EN SUBASTA");
		bidUp.setAlignmentX(CENTER_ALIGNMENT);
		bidUp.setMaximumSize(new Dimension(200,20));
		bidUp.setFont(font3.deriveFont(Font.BOLD, 14));
		bidUp.setForeground(new Color(14,58,35));
		panel.add(bidUp);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 
	}

}