package model;

import java.util.Comparator;

import resource.AVLTree;
import resource.Queve;

public class User {
	private String name;
	private String nickname;
	private String password;
	private AVLTree<Auction> sales;
	private Queve<Auction> buys;
	
	
	
	public User(String name, String nickname, String password) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.password = password;
		this.sales = new AVLTree<Auction>(new Comparator<Auction>() {
            @Override
            public int compare(Auction t1, Auction	 t2) {
                return t1.getTitle().compareToIgnoreCase(t2.getTitle());
            }
        });
		this.buys = new Queve<Auction>();
	}
	
	
	
	public User(String nickname) {
		super();
		this.nickname = nickname;
	}



	public String getName() {
		return name;
	}
	public String getNickname() {
		return nickname;
	}
	public String getPassword() {
		return password;
	}
	public AVLTree<Auction> getSales() {
		return sales;
	}
	public Queve<Auction> getBuys() {
		return buys;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSales(AVLTree<Auction> sales) {
		this.sales = sales;
	}
	public void setBuys(Queve<Auction> buys) {
		this.buys = buys;
	}



	@Override
	public String toString() {
		return "User [name=" + name + ", nickname=" + nickname + ", password=" + password + "] \n";
	}


	
	
}
