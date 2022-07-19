package model;

public class Translate {
	
	private String word;
	private String translation;
	
	public Translate(String word, String translation) {
		super();
		this.word = word;
		this.translation = translation;
	}
	
	public Translate(String word) {
		super();
		this.word = word;
	}



	public String getWord() {
		return word;
	}

	public String getTranslation() {
		return translation;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public String toString() {
		return "Translate [word=" + word + ", translation=" + translation + "]";
	}
	
}
