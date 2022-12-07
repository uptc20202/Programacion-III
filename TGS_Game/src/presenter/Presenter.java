package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Home;

public class Presenter implements ActionListener{
	
	private Home view;
	
	public Presenter() {
    	view = new Home(this);
        run();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if (command.equals("nivel1")) {
			
		}
		
	}
	
	private void run() {
		
	}
	
	public static void main(String[] args) {
		new Presenter();	
	}

    
}
