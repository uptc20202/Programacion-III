package model;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Game {
	private int points;
	private Divition divition;
	private Date lastConnection;
	private int streak;
	private ArrayList<Level> levels;
	
	public Game() {
		super();
	}

	public Game(int points, Divition divition, Date lastConnection, int streak) {
		super();
		this.points = points;
		this.divition = divition;
		this.lastConnection = lastConnection;
		this.streak = streak;
		try {
			this.levels = ReaderData.readerLevel("data/LessonsV1.json");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

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

	public Date getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}

	public void increaseStreak() {
		Long today = 59960736000000l;
		Long restOfOneDay = 59960649600000l;
		Long restOfTwoDays = 59960563200000l;
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate localDate = LocalDate.now();
		Date nowDate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		Long timeLastConnection = lastConnection.getTime();
		Long timeNow = nowDate.getTime();

		if (timeLastConnection-timeNow == today) {
			System.out.println("La Ultima conexi�n fue hoy");
		} else if ((timeLastConnection - timeNow) == restOfOneDay && (timeLastConnection - timeNow) > restOfTwoDays) {
			System.out.println("La Ultima conexi�n fue hace un dia");
			setStreak(streak+1);
			System.out.println("Streak" + streak);
		} else if ((timeLastConnection - timeNow) <= restOfTwoDays) {
			System.out.println("La Ultima conexi�n fue hace dos dias o m�s");
		}
	}

	public void setDivition(Divition divition) {
		this.divition = divition;
	}

	@Override
	public String toString() {
		return "Game [points=" + points + ", divition=" + divition + ", lastConnection=" + lastConnection + ", streak="
				+ streak + ", level=" + "]";
	}

	public ArrayList<Level> getLevels() {
		return levels;
	}

	public void setLevels(ArrayList<Level> arrayList) {
		this.levels = arrayList;
	}
	
	
}
