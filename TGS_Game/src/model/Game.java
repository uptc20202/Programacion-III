package model;

import java.time.LocalDate;
import java.time.ZoneId;
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
			System.out.println("La Ultima conexión fue hoy");
		} else if ((timeLastConnection - timeNow) == restOfOneDay && (timeLastConnection - timeNow) > restOfTwoDays) {
			System.out.println("La Ultima conexión fue hace un dia");
			setStreak(streak+1);
			System.out.println("Streak" + streak);
		} else if ((timeLastConnection - timeNow) <= restOfTwoDays) {
			System.out.println("La Ultima conexión fue hace dos dias o más");
		}
	}
}
