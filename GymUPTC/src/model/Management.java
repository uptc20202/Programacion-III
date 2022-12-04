package model;		

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Management {
	
	private Schedule schedule;
	private ArrayList<User> users;
	private ArrayList<Turn> turns;
	
	public Management(ArrayList<User> users,ArrayList<Turn> turns) {
		super();
		this.users = users;
		this.turns = turns;
//		users.add(new User("admin","admin","admin",null));
	}

	public String login(String id, String password) {
		for(User user :users) {
			if(id.equals(user.getId()) && password.equals(user.getPassword())) {
				return (user.getRol()==Rol.admin)?"homeStudent":"homeStudent";
			}
		}
		return null;
	}
	
	public Student searchStudentById(String id) {
		for(int i = 0; i < users.size(); i++) {
		
			if(users.get(i).getId().equals(id) ){
				System.out.print(i);
				return users.get(i).getStudent();
			}
		}
		/*for(User user :users) {
			if(id.equals( user.getId()) ){
				return user.getStudent();
			}
		}*/
		return null;
	}
	
	public Integer searchPositionById(String id) {
		for(int i = 0; i < users.size(); i++) {
			if(id.equals(users.get(i).getId()) ){
				System.out.print(i);
				return i;
			}
		}
		return null;
	}
	
	public Student searchStudents(int code) {
		for(User user :users) {
			if(code == user.getStudent().getCode() ) {
				return user.getStudent();
			}
		}
		return null;	
	}
	
	private void searchStudentsDay() {}

	private void blockStudent(){}
	
	public void takeTurn(int turn, String userId,String nameField1,String nameField2) {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getId().equals(userId) && users.get(i).isAllowBooking()!=false) {
				turns.get(turn).addStudent(users.get(i).getStudent());
				users.get(i).setAllowBooking(false);
				ReaderTurn.RefreshData(turns, nameField1);
				CreateUser.RefreshData(users, nameField2);
			}
		}
	}
	
	public void deteleTurn(int turn, String userId,String nameField1,String nameField2) {
		int student = searchPositionById(userId);
		for(int i = 0; i < turns.get(turn).getStudents().length; i++) {
			if(turns.get(turn).getStudents()[i] != null && 
					turns.get(turn).getStudents()[i].getCode() == users.get(student).getStudent().getCode()) {
				turns.get(turn).getStudents()[i] = null;
				users.get(student).setAllowBooking(true);
				ReaderTurn.RefreshData(turns, nameField1);
				CreateUser.RefreshData(users, nameField2);
			}
		}
	}
	
	public void RegisterStudent(String id, String password, String name, int code) {
		User student1 = new User(id,password,"student",new Student(name,code));
		users.add(student1);
		CreateUser.RefreshData(users,"data/users.json");
	}
	
	public Schedule getSchedule() {
		return schedule;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Turn> getTurns() {
		return turns;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public void setTurns(ArrayList<Turn> turns) {
		this.turns = turns;
	}
	
	
}
