package model;

import java.util.Date;

public class Game {
	private int points;
	private Divition divition;
	private Date lastConnection;
	private int streak;
	

	public DivitionName getDivition() {
		return divition.calculateDivition(points);
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getStreak() {
		return streak;
	}

	public void setStreak(int streak) {
		this.streak = streak;
	}
	
	
	

}
