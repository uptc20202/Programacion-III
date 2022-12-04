package model;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class CustomFont {
	
	private String fontName;
	
	
	
	public CustomFont(String fontName) {
		super();
		this.fontName = fontName;
	}



	public Font customFontStream() {
 
        try {
            InputStream myStream = new BufferedInputStream(
                    new FileInputStream(fontName));
            return Font.createFont(Font.TRUETYPE_FONT, myStream);
        } catch (Exception ex) {
            //Si existe un error se carga fuente por defecto ARIAL
            System.err.println(ex  + " No se cargo la fuente");
            return new Font("Arial", Font.PLAIN, 14);            
        }
	}

}
