package model;
import resources.PriorityQueve;

public class Eps {
	private PriorityQueve<User> userList;
	
	public void takeTurn(User user) {
		userList = new PriorityQueve<User>();
		userList.push(user.getNumberPriority(), user);
	} 
	
	public User callUser() {
		return userList.poll();
	}
	
	
	
}
