package model;

import java.util.ArrayList;
import java.util.Comparator;

import resource.AVLTree;
import resource.Queve;

public class Store extends Subject{
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
				return o1.getNickname().equalsIgnoreCase(o2.getNickname())?0:1;
			}
			
		});
	}
	
	public Queve<Auction> searchBidInAuction(String nickname) {
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
		searchAuction(id).setStatus(false);
	}
	
	public void bidUp(User user, int id, Long valueBid) {
		searchAuction(id).addBid(new Bid(valueBid,user));
	}
	
	public boolean searchAuctionStatus(int id) {
		return searchAuction(id).getStatus();
	}
	
	public void postAuction(String tittle,String description,long minimumBid,User author) {
		sales.insert(new Auction(tittle, idConsecutive, description,author.getNickname(), minimumBid));
		idConsecutive++;
	}
	
	public ArrayList<Auction> searchAuctions(){
		return sales.showInorder();
	}
	
	public Auction searchAuction(int id){
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
		User user1 = searchUsers(nickname); 
		if(user1!=null) {
			return user1.getPassword().equalsIgnoreCase(password);
		}
		return false;
	}
	
	public String generateAlert(String id) {
		return null;
	}
	
	public User searchUsers(String nickname) {
		User user1 = users.search(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return o1.getNickname().equalsIgnoreCase(o2.getNickname())?0:1;
			}
			
		}, new User(nickname));
		return user1;
	}

	public AVLTree<Auction> getSales() {
		return sales;
	}

	public AVLTree<User> getUsers() {
		return users;
	}

	public int getIdConsecutive() {
		return idConsecutive;
	}
	
	public String getSalesToString() {
		 StringBuilder sbuilder = new StringBuilder();
		 System.out.println(sales.showInorder().size() + " total subastas");
		 for(Auction auction:sales.showInorder()) {
			 sbuilder.append(auction.getId()+",");
			 sbuilder.append(auction.getTitle()+",");
			 sbuilder.append(auction.getMinimumBid()+",");
			 sbuilder.append(auction.getAuthor()+",");
			 sbuilder.append(auction.getDescription()+";");
		 }
		 return sbuilder.toString();
	}

	public void setSales(AVLTree<Auction> sales) {
		this.sales = sales;
	}

	public void setUsers(AVLTree<User> users) {
		this.users = users;
	}

	public void setIdConsecutive(int idConsecutive) {
		this.idConsecutive = idConsecutive;
	}
	
	
}
