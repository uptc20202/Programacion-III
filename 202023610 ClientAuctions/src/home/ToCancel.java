package home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CustomFont;
import view.CalculateView;

public class ToCancel extends JDialog{

	private JLabel bidTitle, bidDescription,bidValue;
	private JPanel panel;
	private Font font3;
	private JButton btnCancel,btnSell;
	private String id;
	private ActionListener listener;
	
	public ToCancel(CalculateView parent, boolean modal,ActionListener listener,String id,String Title,
			String description, String value) {
		super(parent, modal);
		this.listener = listener;
		this.id = id;
		CustomFont customFont3 = new CustomFont("source\\font\\HarmoniaSansProCyr-Light.ttf");
		font3 = customFont3.customFontStream();
		setLayout(null);
		setLocationRelativeTo(null);
	    setBounds(440,10,410,210);
	    
	    initComponents( Title,  description,  value);
	}
	
	public ToCancel() {
		// TODO Auto-generated constructor stub
	}

	public void initComponents(String Title, String description, String value) {
		
		panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setSize(new Dimension(410,210));
	    panel.setBackground(new Color(0,0,0,0));
	    panel.setFont(font3.deriveFont(Font.BOLD, 14));
	    panel.setForeground(new Color(14,58,35));
	    add(panel);
	    
		bidTitle = new JLabel("Titulo Subasta: "+Title);
		bidTitle.setAlignmentX(CENTER_ALIGNMENT);
		bidTitle.setFont(font3.deriveFont(Font.BOLD, 14));
		bidTitle.setForeground(new Color(14,58,35));
		panel.add(bidTitle);
		
		bidDescription = new JLabel("Descripcion Subasta: "+description);
		bidDescription.setAlignmentX(CENTER_ALIGNMENT);
		bidDescription.setFont(font3.deriveFont(Font.BOLD, 14));
		bidDescription.setForeground(new Color(14,58,35));
		panel.add(bidDescription);
		
		bidValue = new JLabel("Valor para venta "+"$"+value);
		bidValue.setAlignmentX(CENTER_ALIGNMENT);
		bidValue.setFont(font3.deriveFont(Font.BOLD, 14));
		bidValue.setForeground(new Color(14,58,35));
		panel.add(bidValue);
		
		JPanel btnOptions = new JPanel();
		btnSell = new JButton("VENDER");
		btnSell.setAlignmentX(CENTER_ALIGNMENT);
		btnSell.setMaximumSize(new Dimension(200,20));
		btnSell.setFont(font3.deriveFont(Font.BOLD, 14));
		btnSell.setForeground(new Color(14,58,35));
		btnSell.setActionCommand("toSell");
		btnSell.addActionListener(listener);
		btnOptions.add(btnSell);
		
		btnCancel = new JButton("ELIMINAR SUBASTA");
		btnCancel.setAlignmentX(CENTER_ALIGNMENT);
		btnCancel.setMaximumSize(new Dimension(200,20));
		btnCancel.setFont(font3.deriveFont(Font.BOLD, 14));
		btnCancel.setForeground(new Color(14,58,35));
		btnCancel.setActionCommand("toCancel");
		btnCancel.addActionListener(listener);
		btnOptions.add(btnCancel);
		
		panel.add(btnOptions);
	}

	public int getId() throws NullPointerException{
		if(id==null) {
			return 0;
		}
		return Integer.parseInt(id);
	}
	
	
}
