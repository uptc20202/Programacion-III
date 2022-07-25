package model;

import resource.BynaryTreeSearch;
import resource.Queve;

public class User {
	private String name;
	private String nickname;
	private String password;
	private BynaryTreeSearch<Auction> sales;
	private Queve<Auction> buys;
	public String getName() {
		return name;
	}
	public String getNickname() {
		return nickname;
	}
	public String getPassword() {
		return password;
	}
	public BynaryTreeSearch<Auction> getSales() {
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
	public void setSales(BynaryTreeSearch<Auction> sales) {
		this.sales = sales;
	}
	public void setBuys(Queve<Auction> buys) {
		this.buys = buys;
	}
	
	
}
