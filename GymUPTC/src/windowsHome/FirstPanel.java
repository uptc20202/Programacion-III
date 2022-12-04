package windowsHome;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CustomFont;
import model.ReaderTurn;
import model.Student;
import model.Turn;

public class FirstPanel extends JPanel{
	
	private JPanel space1;
	private JLabel dateNow;
	private Font font;
	private int countTurn;
	private ReaderTurn readerTurn;
	private ArrayList<TurnPanel> turnPanel;
	private int dia;
	private Calendar c;
	
	public FirstPanel(ActionListener listener) {
		CustomFont customFont = new CustomFont("source\\\\font\\\\rimouski-sb.ttf");
		font = customFont.customFontStream();
		turnPanel = new ArrayList<TurnPanel>();
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		countTurn = 1;
		setBackground(new Color(55,58,60));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		space1 = new JPanel();
		space1.setLayout(new BoxLayout(space1,BoxLayout.X_AXIS));
		space1.setOpaque(false);
		space1.setAlignmentX(LEFT_ALIGNMENT);
		add(space1);
		
		dateNow = new JLabel();
		dateNow.setFont(font.deriveFont(Font.BOLD, 14));
		dateNow.setForeground(new Color(255,255,255));
		dateNow.setBorder(new EmptyBorder(10,0,20,0));
		dateNow.setAlignmentX(LEFT_ALIGNMENT);
		dateNow.setBorder(BorderFactory.createEmptyBorder(30, 20, 10, 20));
		setDateOne();
		space1.add(dateNow);
		
	}
	
	public TurnPanel addTurnPanel(ActionListener listener, String star, String finalTurn,int avalideQuotas,String fieldCommand) {
		TurnPanel turnPanel = new TurnPanel(listener,countTurn, "De "+star+". a "+finalTurn,avalideQuotas,fieldCommand);
		countTurn++;
		return turnPanel;
	}
	
	public TurnPanel addTurnPanel(ActionListener listener, String star, String finalTurn,int avalideQuotas,String fieldCommand,
			Color color,String txt) {
		TurnPanel turnPanel = new TurnPanel(listener,countTurn, "De "+star+". a "+finalTurn,avalideQuotas,fieldCommand);
		turnPanel.setBtnReserveTurn1(color, txt);
		countTurn++;
		return turnPanel;
	}
	
	
	public void addTurnPanelDom(ActionListener listener, String star,String finalTurn,int availableQuotas, String fieldCommand) {
		if(dia!=Calendar.SATURDAY){
			 
			
			turnPanel.add(addTurnPanel(listener,star,finalTurn,availableQuotas,fieldCommand));
			for(TurnPanel turnPanel1 : turnPanel) {
				add(turnPanel1);
			}

		}
	}
	
	public void addTurnPanelDom(ActionListener listener, String star,String finalTurn,int availableQuotas,
			String fieldCommand,Color color,String txt) {
		if(dia!=Calendar.SATURDAY){
			 
			
			turnPanel.add(addTurnPanel(listener,star,finalTurn,availableQuotas,fieldCommand,color,txt));
			for(TurnPanel turnPanel1 : turnPanel) {
				add(turnPanel1);
			}

		}
	}
	
	private void setDateOne() {
		c = Calendar.getInstance();
		 
		 dia =  c.get(Calendar.DAY_OF_WEEK);
		 if(dia==Calendar.SUNDAY){
		   dateNow.setText("TURNOS DÍA LUNES, "+(c.get(Calendar.DAY_OF_MONTH)+1));
		 }if(dia==Calendar.MONDAY){
		   //Lunes
			 dateNow.setText("TURNOS DÍA MARTES, "+(c.get(Calendar.DAY_OF_MONTH)+1));
		 }
		 if(dia==Calendar.TUESDAY){
		   //Martes
			 dateNow.setText("TURNOS DÍA MIERCOLES, "+(c.get(Calendar.DAY_OF_MONTH)+1));
		 }
		 if(dia==Calendar.WEDNESDAY){
			 dateNow.setText("Turnos día Jueves,  "+(c.get(Calendar.DAY_OF_MONTH)+1));
			 }
		 if(dia==Calendar.THURSDAY){
			 dateNow.setText("TURNOS DÍA VIERNES, "+(c.get(Calendar.DAY_OF_MONTH)+1));
			 }
			 
		 if(dia==Calendar.FRIDAY){
			 dateNow.setText("TURNOS DÍA SABADO, "+(c.get(Calendar.DAY_OF_MONTH)+1));
			 }
		 if(dia==Calendar.SATURDAY){
			 dateNow.setText("NO HAY TURNOS DISPONIBLES PARA EL DÍA "+(c.get(Calendar.DAY_OF_MONTH)+1));
			 
			 }
			 
	}
	
	public int getCountTurn() {
		return countTurn;
	}
	
	public void setQuotas(int avalideQuotas, int position) {
		System.out.println(turnPanel.size());
		turnPanel.get(position).setQuotas(avalideQuotas);
	}
	
	public void refreshDom() {
		turnPanel = new ArrayList<TurnPanel>();
	}
	
	


}
