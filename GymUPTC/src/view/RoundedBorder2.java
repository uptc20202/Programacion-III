package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundedBorder2 implements Border {

    private int radius;
    private Color color;

    public RoundedBorder2(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    	g.setColor(color);
    	g.fillRoundRect(x, y, width-1, height-1, radius, radius);
//        g.setColor(Color.blue);
//        
//        c.setBackground(color);
    	
    }
}