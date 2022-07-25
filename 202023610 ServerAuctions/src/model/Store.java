package model;

import java.util.ArrayList;
import java.util.Comparator;

import resource.BynaryTreeSearch;

public class Store {
	private BynaryTreeSearch<Auction> sales;
	
	public void stopAuction(String id){
		
	}
	
	public boolean sourceAuctionStatus(String id) {
		return false;
	}
	
	public void postAuction(String tittle,String id,String description,long minimumBid,int type) {
		
	}
	
	public ArrayList<Auction> sourceAuctions(Comparator comparator){
		return null;
	}
	
	public void addUser(String name,String nickname,String password) {
		
	}
	
	public void login(String nickname,String password) {
		
	}
	
	public String generateAlert(String id) {
		return null;
	}
}
