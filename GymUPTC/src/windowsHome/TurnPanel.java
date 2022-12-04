package windowsHome;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CustomFont;
import view.RoundedBorder2;

public class TurnPanel extends JPanel{
	
	private JPanel turn1, space2;
	private JButton btnReserveTurn1;
	private JLabel nameTurn, schedule, quotas;
	private Font font;
	private int countTurn;
	private final String QUOTAS_TXT;
	private String comandButton1;
	
	
	public TurnPanel(ActionListener listener,int countTurn, String scheduleTxt,int avalideQuotas,String comandButton1) {
		super();
		QUOTAS_TXT = "Cupos disponibles : ";
		this.countTurn = countTurn;
		nameTurn = new JLabel("Turno: "+countTurn);
		schedule = new JLabel(scheduleTxt);
		quotas = new JLabel(QUOTAS_TXT+avalideQuotas);
		this.comandButton1 = comandButton1;
		CustomFont customFont = new CustomFont("source\\\\font\\\\rimouski-sb.ttf");
		font = customFont.customFontStream();
		initComponents(listener);
	}



	private void initComponents(ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		
		setMaximumSize(new Dimension(1000,110));
		setAlignmentX(LEFT_ALIGNMENT);
		setOpaque(false);
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		space2 = new JPanel();
		space2.setMaximumSize(new Dimension(20,10));
		space2.setAlignmentX(LEFT_ALIGNMENT);
		space2.setOpaque(false);
		add(space2);
		
		turn1 = new JPanel();
		turn1.setBackground(new Color(72,76,78));
//		turn1.setOpaque(false);
		GridBagLayout gbl = new GridBagLayout();
//		GridBagConstraints gbc = new GridBagConstraints();
		turn1.setLayout(gbl);
		turn1.setMaximumSize(new Dimension(800,80));
//		turn1.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 20));
		turn1.setBorder(new RoundedBorder2(50,new Color(72,76,78)));
		turn1.setAlignmentX(LEFT_ALIGNMENT);
		turn1.setOpaque(false);
		add(turn1);
		
		nameTurn.setFont(font.deriveFont(Font.BOLD, 14));
		nameTurn.setForeground(new Color(255,255,255));
		nameTurn.setBorder(new EmptyBorder(0,0,0,20));
		nameTurn.setAlignmentX(LEFT_ALIGNMENT);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		turn1.add(nameTurn,gbc);
		
		schedule.setFont(font.deriveFont(Font.BOLD, 14));
		schedule.setForeground(new Color(255,255,255));
		schedule.setBorder(new EmptyBorder(0,0,0,50));
		schedule.setAlignmentX(LEFT_ALIGNMENT);
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		turn1.add(schedule,gbc);
		
		quotas.setFont(font.deriveFont(Font.PLAIN, 12));
		quotas.setForeground(new Color(255,255,255));
//		quotas.setBorder(new EmptyBorder(10,0,20,0));
		quotas.setAlignmentX(LEFT_ALIGNMENT);
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		turn1.add(quotas,gbc);
		
		btnReserveTurn1 = new JButton("RESERVAR");
		btnReserveTurn1.setFont(font.deriveFont(Font.PLAIN, 14));
		btnReserveTurn1.setForeground(new Color(255,255,255));
		btnReserveTurn1.setBackground(new Color(56,80,98));
		btnReserveTurn1.setActionCommand(comandButton1+countTurn);
		btnReserveTurn1.addActionListener(listener);
		gbc.gridx = 8;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		turn1.add(btnReserveTurn1,gbc);		
	}



	public JPanel getTurn1() {
		return turn1;
	}



	public JPanel getSpace2() {
		return space2;
	}



	public JButton getBtnReserveTurn1() {
		return btnReserveTurn1;
	}



	public JLabel getNameTurn() {
		return nameTurn;
	}



	public JLabel getSchedule() {
		return schedule;
	}



	public JLabel getQuotas() {
		return quotas;
	}



	public Font getFont() {
		return font;
	}



	public int getCountTurn() {
		return countTurn;
	}



	public String getQUOTAS_TXT() {
		return QUOTAS_TXT;
	}



	public void setTurn1(JPanel turn1) {
		this.turn1 = turn1;
	}



	public void setSpace2(JPanel space2) {
		this.space2 = space2;
	}



	public void setBtnReserveTurn1(Color color, String txt) {
		this.btnReserveTurn1.setBackground(color);
		this.btnReserveTurn1.setText(txt);
		
	}



	public void setNameTurn(JLabel nameTurn) {
		this.nameTurn = nameTurn;
	}



	public void setSchedule(JLabel schedule) {
		this.schedule = schedule;
	}



	public void setQuotas(int availableQuotas) {
		this.quotas.setText(QUOTAS_TXT+availableQuotas);
	}



	public void setFont(Font font) {
		this.font = font;
	}



	public void setCountTurn(int countTurn) {
		this.countTurn = countTurn;
	}
	
	

}
