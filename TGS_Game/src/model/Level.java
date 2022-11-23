package model;

public class Level {
	private String name;
	private String Descrition;
	private Lesson[] lessons;
	
	public Level(String name, String descrition, Lesson[] lessons) {
		this.name = name;
		Descrition = descrition;
		this.lessons = lessons;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrition() {
		return Descrition;
	}

	public void setDescrition(String descrition) {
		Descrition = descrition;
	}

	public Lesson[] getLessons() {
		return lessons;
	}

	public void setLessons(Lesson[] lessons) {
		this.lessons = lessons;
	}
}
