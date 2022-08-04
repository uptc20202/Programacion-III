package model;

import java.util.ArrayList;
import java.util.Comparator;

import means.AVLTree;
import resource.Stack;

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
				return o1.getId()- o2.getId();
			}
			
		});
		
		this.users = new AVLTree<User>(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return o1.getNickname().compareToIgnoreCase(o2.getNickname());
			}
			
		});
	}
	
	public Stack<Auction> searchBidInAuction(String nickname) {
		Stack<Auction> acuctionByBid = new Stack<Auction>();
		
		ArrayList<Auction> sales1 = sales.inOrder();
		for(Auction auction : sales1) {
			Stack<Bid> bids1 = auction.getBids();
			Stack<Bid> aux = new Stack<Bid>();
			while(!bids1.isEmpty()) {
				if(bids1.peek().getUser().getNickname().equalsIgnoreCase(nickname)) {
					acuctionByBid.push(auction);
				}
				aux.push(bids1.pop());
				
			}
			
			while(!aux.isEmpty()) {
				bids1.push(aux.pop());
			}
		}
		
		return acuctionByBid;
	}

	public void stopAuction(int id){
		searchAuction(id).setStatus(false);
	}
	
	public void bidUp(User user, int id, Long valueBid) {
		Auction auction1 = searchAuction(id);
		auction1.addBid(new Bid(valueBid,user));
		auction1.setMinimumBid(valueBid+1);
	}
	
	public boolean searchAuctionStatus(int id) {
		return searchAuction(id).getStatus();
	}
	
	public void postAuction(String tittle,String description,long minimumBid,User author) {
		sales.add(new Auction(tittle, idConsecutive, description,author.getNickname(), minimumBid));
		idConsecutive++;
	}
	
	public ArrayList<Auction> searchAuctions(){
		return sales.inOrder();
	}
	
	public Auction searchAuction(int id){
		Auction auction = sales.searchNode(new Auction(id)).getData();
		return auction;
	}
	
	public void addUser(String name,String nickname,String password) {
		users.add(new User(name,nickname,password));
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
		User user1 = users.searchNode( new User(nickname)).getData();
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
		 for(Auction auction:sales.inOrder()) {
			 sbuilder.append(auction.getId()+",");
			 sbuilder.append(auction.getTitle()+",");
			 sbuilder.append(auction.getMinimumBid()+",");
			 sbuilder.append(auction.getAuthor()+",");
			 sbuilder.append(auction.getDescription()+";");
		 }
		 return sbuilder.toString();
	}
	
	public String searchBidInAuctionToString(String nickname) {
		StringBuilder sbuilder = new StringBuilder();
		Stack<Auction> auctions = searchBidInAuction(nickname);
		while(!auctions.isEmpty()) {
			Auction auction = auctions.pop();
			sbuilder.append(auction.getId()+",");
			sbuilder.append(auction.getTitle()+",");
			sbuilder.append(auction.getMinimumBid()+",");
			sbuilder.append(auction.getAuthor()+",");
			sbuilder.append(auction.getDescription()+";");
		}
		 
		 return sbuilder.toString();
	}
	
	public String getMySales(String nickname) {
		StringBuilder sbuilder = new StringBuilder();
		Stack<Auction> auctions = searchMySales(nickname);
		while(!auctions.isEmpty()) {
			Auction auction = auctions.pop();
			sbuilder.append(auction.getId()+",");
			sbuilder.append(auction.getTitle()+",");
			sbuilder.append(auction.getMinimumBid()+",");
			sbuilder.append(auction.getAuthor()+",");
			sbuilder.append(auction.getDescription()+";");
		}
		 
		 return sbuilder.toString();
	}

	public Stack<Auction> searchMySales(String nickname) {
		Stack<Auction> acuctionByBid = new Stack<Auction>();
		
		ArrayList<Auction> sales1 = sales.inOrder();
		for(Auction auction : sales1) {
				if(auction.getAuthor().equalsIgnoreCase(nickname)) {
					acuctionByBid.push(auction);
				}
		}
		return acuctionByBid;
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
