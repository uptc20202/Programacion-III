package home;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.CustomFont;
import view.DrawTable;

public class CreateTable extends JPanel{
	
	private Font font3;

	public CreateTable() {
		super();
		CustomFont customFont3 = new CustomFont("source\\font\\HarmoniaSansProCyr-Light.ttf");
		font3 = customFont3.customFontStream();
		
	}

	public JTable generateTable(Object [][] datas,String type) {
		String[] namesColumn = {"ID","TITULO","VALOR DE ENTRADA","  "};
		if(type.equalsIgnoreCase("text")) {
			namesColumn[3] = "VENDEDOR";
		}
		DefaultTableModel modelo = new DefaultTableModel(datas,namesColumn){
		    public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
		};
		JTable table = new JTable (modelo);
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
}
