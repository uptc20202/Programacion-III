package model;

import resource.AVLTree;

public class Auction {
	private String title, description, author;
	private Long minimumBid;
	private int id;
	private boolean status;
	private AVLTree<Bid> bids;
	
	public Auction(String title, int id, String description, String author, Long minimumBid) {
		super();
		this.title = title;
		this.description = description;
		this.author = author;
		this.minimumBid = minimumBid;
		this.id = id;
		this.status = true;
	}



	public Auction(int id) {
		super();
		this.id = id;
	}



	public Auction(String author) {
		super();
		this.author = author;
	}



	public String getTitle() {
		return title;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public Long getMinimumBid() {
		return minimumBid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMinimumBid(Long minimumBid) {
		this.minimumBid = minimumBid;
	}



	public boolean getStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void addBid(Bid bid) {
		bids.insert(bid);
	}



	public String getAuthor() {
		return author;
	}



	public AVLTree<Bid> getBids() {
		return bids;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public void setBids(AVLTree<Bid> bids) {
		this.bids = bids;
	}
	
	
	
	
}
