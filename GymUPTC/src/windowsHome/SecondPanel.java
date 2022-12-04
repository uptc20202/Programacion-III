package windowsHome;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Rol;


public class SecondPanel extends JPanel{

	private JLabel alert, nombre, codigo, rol, photo, email;

	public SecondPanel(ActionListener listener) {
		initComponents(listener);
	}
	
	public void setData(String nombre, int codigo, Rol rol, String email) {
		this.nombre.setText(nombre);
		this.codigo.setText(String.valueOf(codigo));
		this.rol.setText(String.valueOf(rol));
		this.email.setText(email);
	}

	private void initComponents(ActionListener listener) {
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
		alert = new JLabel("Datos Personales");
		alert.setBorder(new EmptyBorder(0,45,10,0));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		alert.setFont(new Font("Arial", Font.BOLD, 25));
		add(alert,gbc);
		
		photo = new JLabel();
		photo.setIcon(new ImageIcon(new ImageIcon("source/first/user-icon.png").getImage().getScaledInstance(150, 
				150, Image.SCALE_DEFAULT)));
		//photo.setBounds(30, 30, 30, 30);
		//photo.setBorder(new EmptyBorder(30,0,0,0));
		photo.setAlignmentX(CENTER_ALIGNMENT);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 5;
		gbc.gridheight = 5;
		add(photo,gbc);
		
		nombre = new JLabel("nombre");
		nombre.setFont(new Font("Arial", Font.PLAIN, 15));
		gbc.gridx = 6;
		gbc.gridy = 1;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		nombre.setBorder(new EmptyBorder(20,20,0,0));
		add(nombre,gbc);
		
		codigo = new JLabel("codigo");
		codigo.setFont(new Font("Arial", Font.PLAIN, 15));
		gbc.gridx = 6;
		gbc.gridy = 2;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		codigo.setBorder(new EmptyBorder(20,20,0,0));
		add(codigo,gbc);
		
		rol = new JLabel("rol");
		rol.setFont(new Font("Arial", Font.PLAIN, 15));
		gbc.gridx = 6;
		gbc.gridy = 3;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		rol.setBorder(new EmptyBorder(20,20,0,0));
		add(rol,gbc);
		
		email = new JLabel("@uptc.edu.co");
		email.setFont(new Font("Arial", Font.PLAIN, 15));
		gbc.gridx = 6;
		gbc.gridy = 4;
		gbc.gridwidth = 5;
		gbc.gridheight = 1;
		email.setBorder(new EmptyBorder(20,20,0,0));
		add(email,gbc);
	}
	
	
	

}
