package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class CreateUser {	
	
	private ArrayList<User> users;
	
	
	public CreateUser(String nameField) {
		super();
		try {
			readerUsers(nameField);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CreateUser(String id, String password, String rol1, String name, int code) {
		users = new ArrayList<User>();
		try {
			createNewUser(id, password, rol1, name, code);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createNewUser(String id, String password, String rol1, String name, int code) throws FileNotFoundException {
		User user = new User(id,password,rol1,new Student(name,code));
		users.add(user);
		
		String json = new Gson().toJson(users);
		//System.out.println(json);
		
		PrintWriter print = new PrintWriter("data/nuevoArchivo.json");
		print.write(json);
		print.close();
	}

	public void readerUsers(String nameField) throws FileNotFoundException {
		users = new ArrayList<User>();
		JsonReader reader = new Gson().newJsonReader(new FileReader(nameField));
		User[] use= new Gson().fromJson(reader, User[].class);
		
		for(User user : use) {
			users.add(user);
		}
	}

	public static void RefreshData(ArrayList<User> users1,String nameField) {
		String json = new Gson().toJson(users1);
		
		PrintWriter print;
		try {
			print = new PrintWriter(nameField);
			print.write(json);
			print.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	
}
