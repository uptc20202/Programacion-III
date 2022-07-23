
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CalculateView;

public class Presenter implements ActionListener{
	
	private CalculateView view;
	
	public Presenter() {
    	view = new CalculateView(this);
        run();
    }
	
	private void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new Presenter();	
	}
}
