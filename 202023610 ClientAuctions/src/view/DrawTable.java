package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import model.CustomFont;


public class DrawTable extends DefaultTableCellRenderer{
	
	private String type="text";

	private Font font;
	private JButton label;
	
	public DrawTable(){
		
	}	

	public DrawTable(String type) {
		super();
		this.type = type;
		CustomFont customFont3 = new CustomFont("source\\font\\HarmoniaSansProCyr-Light.ttf");
		font = customFont3.customFontStream();
		this.label =  new JButton("ENTRAR");
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		
		
        Color colorFondo = null;
        Color colorFondoPorDefecto=new Color( 192, 192, 192);
        Color colorFondoSeleccion=new Color( 140, 140 , 140);
    
        if (selected) {                
            this.setBackground(colorFondoPorDefecto );   
        }
        else
        {
        	
            this.setBackground(Color.white);
        }
                
  
        if( type.equals("text"))
        {
        
            if (focused) {
    			colorFondo=colorFondoSeleccion;
    		}else{
    			colorFondo= colorFondoPorDefecto;
    		}
   
            this.setText( (String) value );
            this.setBackground( (selected)? colorFondo :new Color(255,255,255));	
            this.setFont(font.deriveFont(Font.BOLD, 14));
    		this.setForeground(new Color(14,58,35));
    		this.setBorder(new EmptyBorder(100,10,100,10));
    		this.setBounds(50, 50, 50, 50);
            return this;
        }
         
        if( type.equals("button"))
        {
            
            label.setHorizontalAlignment( JLabel.CENTER );
            label.setForeground(new Color(255,255,255));
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            label.setBackground(new Color(20,85,52));
            return label;
        }
        if( type.equals("bidUP+"))
        {
        	label = new JButton("AUMETAR OFERTA");
            label.setHorizontalAlignment( JLabel.CENTER );
            label.setForeground(new Color(255,255,255));
            label.setBackground(new Color(20,85,52));
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            return label;
        }
        if( type.equals("cancel"))
        {
            label = new JButton("CERRAR");
            label.setBackground(new Color(185,50,36));
            label.setForeground(new Color(255,255,255));
            label.setHorizontalAlignment( JLabel.CENTER );
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            return label;
        }
        
      
		return this;
		
		
	}
	
	
	
}
