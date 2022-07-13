package model;

public class Model {
	private String phrase;
	
	public Model() {
		phrase = "";
	}
	
	public void addWord(String word) {
		phrase += word;
	}

	public String getPhrase() {
		return phrase;
	}
	
	

}
