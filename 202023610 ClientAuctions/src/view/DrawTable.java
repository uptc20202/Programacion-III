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
		
		/*
		 * Este metodo controla toda la tabla, podemos obtener el valor que contiene
		 * definir que celda está seleccionada, la fila y columna al tener el foco en ella.
		 * 
		 * cada evento sobre la tabla invocará a este metodo
		 */
		
		//definimos colores por defecto
        Color colorFondo = null;
        Color colorFondoPorDefecto=new Color( 192, 192, 192);
        Color colorFondoSeleccion=new Color( 140, 140 , 140);
    	
        /*
         * Si la celda del evento es la seleccionada se asigna el fondo por defecto para la selección
         */
        if (selected) {                
            this.setBackground(colorFondoPorDefecto );   
        }
        else
        {
        	//Para las que no están seleccionadas se pinta el fondo de las celdas de blanco
            this.setBackground(Color.white);
        }
                
  
        if( type.equals("text"))
        {
        
            if (focused) {
    			colorFondo=colorFondoSeleccion;
    		}else{
    			colorFondo= colorFondoPorDefecto;
    		}
            //this.setHorizontalAlignment( JLabel.LEFT );
            this.setText( (String) value );
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(0,0,0) );   
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32) );
            this.setBackground( (selected)? colorFondo :new Color(255,255,255));	
            this.setFont(font.deriveFont(Font.BOLD, 14));
    		this.setForeground(new Color(14,58,35));
    		this.setBorder(new EmptyBorder(100,10,100,10));
    		this.setBounds(50, 50, 50, 50);
            //this.setFont(bold);
            return this;
        }
         
        if( type.equals("icono"))
        {
            
            label.setHorizontalAlignment( JLabel.LEFT );
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            return label;
        }
        
      
		return this;
		
		
	}
	
	
	
}
