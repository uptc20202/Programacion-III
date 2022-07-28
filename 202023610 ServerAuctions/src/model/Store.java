package model;

import java.util.ArrayList;
import java.util.Comparator;

import resource.AVLTree;
import resource.Queve;

public class Store {
	private AVLTree<Auction> sales;
	private AVLTree<User> users;
	private int idConsecutive;
	
	
	
	public Store() {
		super();
		idConsecutive = 1;
		this.sales = new AVLTree<Auction>(new Comparator<Auction>() {

			@Override
			public int compare(Auction o1, Auction o2) {
				// TODO Auto-generated method stub
				return o1.getId()-o2.getId();
			}
			
		});
		this.users = new AVLTree<User>(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return o1.getNickname().equalsIgnoreCase(o2.getNickname())?1:0;
			}
			
		});
	}
	
	public Queve<Auction> sourceBidInAuction(String nickname) {
		Queve<Auction> acuctionByBid = new Queve<Auction>();
		
		ArrayList<Auction> sales1 = sales.showInorder();
		for(Auction auction : sales1) {
			ArrayList<Bid> bids1 = auction.getBids().showInorder();
			for(Bid bid: bids1) {
				if(bid.getUser().getNickname().equalsIgnoreCase(nickname)) {
					acuctionByBid.push(auction);
				}
			}
		}
		
		return acuctionByBid;
	}

	public void stopAuction(int id){
		sourceAuction(id).setStatus(false);
	}
	
	public void bidUp(User user, int id, Long valueBid) {
		sourceAuction(id).addBid(new Bid(valueBid,user));
	}
	
	public boolean sourceAuctionStatus(int id) {
		return sourceAuction(id).getStatus();
	}
	
	public void postAuction(String tittle,String description,long minimumBid,int type) {
		sales.insert(new Auction(tittle, idConsecutive, description, minimumBid, type));
		idConsecutive++;
	}
	
	public ArrayList<Auction> sourceAuctions(){
		return sales.showInorder();
	}
	
	public Auction sourceAuction(int id){
		Auction auction = sales.search(new Comparator<Auction>() {

			@Override
			public int compare(Auction o1, Auction o2) {
				// TODO Auto-generated method stub
				return o1.getId() - o2.getId();
			}
			
		}, new Auction(id));
		return auction;
	}
	
	public void addUser(String name,String nickname,String password) {
		users.insert(new User(name,nickname,password));
	}
	
	public boolean login(String nickname,String password) {
		User user1 = sourceStudents(nickname); 
		return user1.getPassword().equalsIgnoreCase(password);
	}
	
	public String generateAlert(String id) {
		return null;
	}
	
	public User sourceStudents(String nickname) {
		User user1 = users.search(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return o1.getNickname().equalsIgnoreCase(o2.getNickname())?1:0;
			}
			
		}, new User(nickname));
		return user1;
	}
}
