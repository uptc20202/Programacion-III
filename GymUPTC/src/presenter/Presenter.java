package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import model.CreateUser;
import model.Management;
import model.ReaderTurn;
import model.Rol;
import model.Student;
import model.Turn;
import model.User;
import view.CalculateView;

public class Presenter implements ActionListener{
	
	private CalculateView view;
	private Management management;
	private CreateUser createUser;
	private ReaderTurn readerTurn;
	
	
	public Presenter() {
    	view = new CalculateView(this);
        run();
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("login")) {
			String option = management.login(view.getTxtUser(), view.getTxtPassword());
			if(option!=null) {
				readerDataDom();
				view.showPanel(option);
				if(management.searchStudentById(view.getTxtUser()) != null) {
					view.setData(management.searchStudentById(view.getTxtUser()).getName(),
		        		management.searchStudentById(view.getTxtUser()).getCode(),Rol.student,view.getTxtUser()+"@uptc.edu.co");
				}
			}else {
				System.out.print("Error de login");
			}
			
		}
		if (command.equals("SignUp")) {
			
			view.showPanel("register");
		}
		
		if (command.equals("SignUp2")) {
			management.RegisterStudent(view.getTxtName1().toLowerCase()+"."+view.getTxtlastName1().toLowerCase(), view.getTxtPassword2(),
					view.getTxtName1()+" "+view.getTxtName2()+" "+view.getTxtlastName1()+" "+view.getTxtlastName2(), 
					Integer.parseInt(view.getTxtCode()));
			view.setTxtUser(view.getTxtName1().toLowerCase()+"."+view.getTxtlastName1().toLowerCase());
			view.showPanel("login");
		}
		if (command.equals("leave")) {
				view.refreshDom(this); 
				view.showPanel("login");
		}
		if (command.equals("cancel")) {
			view.showPanel2("2");
		}
		for(int i = 0; i < management.getTurns().size();i++) {
			
		if(command.equals("reserve"+(1+i))) {
			
			management.takeTurn(i, view.getTxtUser(),"data/turns.json","data/users.json");
			int count = management.getTurns().get(i).getStudents().length;
			for(Student student:management.getTurns().get(i).getStudents()) {
				if(student!=null) {
					count--;
				}
			}
			view.setQuotas(count, i); 
			readerDataDom2();
		}
		}
		
		
		if (command.equals("cancelar1")) {
			int count = 0;
			for(int i = 0; i < management.getTurns().size();i++) {
				management.deteleTurn(i, view.getTxtUser(),"data/turns.json","data/users.json");
				for(Student student : management.getTurns().get(i).getStudents()) {
					if(student == null) {
						count++;
					}
				}
			//view.setQuotas(count, i); 
			view.refreshDom(this);

			}
		}
		
		if(command.equals("reserveData")) {
			view.showPanel2("1");
		}
		
		
		
		if(command.equals("userData")) {
			view.showPanel2("3");
		}
	}

	private void run() {
		createUser = new CreateUser("data/users.json");
        try {
			management = new Management(createUser.getUsers(),ReaderTurn.readerTurns("data/turns.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}
	
	public void readerDataDom() {
		int countSpace = 0;
        for(int i = 0; i < management.getTurns().size(); i++) {
        	countSpace = management.getTurns().get(i).getStudents().length;
        	for(Student student : management.getTurns().get(i).getStudents()) {
        		if(student != null) {
        			countSpace--;
        			readerDataDom2();
        			
        		}
        	}
        	
			view.addTurnPanelDom(this, management.getTurns().get(i).getStar()
					,management.getTurns().get(i).getFinalTurn(),countSpace);
		}
	}


	
	
	private void readerDataDom2() {
		int countSpace = 0;
        for(int i = 0; i < management.getTurns().size(); i++) {
        	countSpace = management.getTurns().get(i).getStudents().length;
        	for(Student student : management.getTurns().get(i).getStudents()) {
        		if(student != null) {
        			countSpace--;
        			Student student2 = management.searchStudentById(view.getTxtUser());
        			if(student2!=null&&student.getCode()== student2.getCode()) {
        				view.addTurnPanelDom2(this, management.getTurns().get(i).getStar()
        						,management.getTurns().get(i).getFinalTurn(),countSpace);
        				
        			}
        		}
        	}
        	
		}
		
	}

	public static void main(String[] args) {
		new Presenter();	
	}

}
