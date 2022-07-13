package model;

public class User {
	private int identificationNumber;
	private String name;
	private int numberPriority;
	
	
	
	public User(int identificationNumber, String name, int numberPriority) {
		super();
		this.identificationNumber = identificationNumber;
		this.name = name;
		this.numberPriority = numberPriority;
	}
	public int getIdentificationNumber() {
		return identificationNumber;
	}
	public int getNumberPriority() {
		return numberPriority;
	}
	public void setNumberPriority(int numberPriority) {
		this.numberPriority = numberPriority;
	}
	public String getName() {
		return name;
	}
	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [identificationNumber=" + identificationNumber + ", name=" + name + ", numberPriority="
				+ numberPriority + "]";
	}
	
	
}
