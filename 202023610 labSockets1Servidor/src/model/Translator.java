package model;

public class Translator {
	
	private Dictionary dictionarySF;
	private Dictionary dictionarySE;
	
	
	
	public Translator() {
		super();
		this.dictionarySF = new Dictionary();
		this.dictionarySE = new Dictionary();
	}

	public void insertTranslate(String i, String z,int x) {
		if(x==1) {
			dictionarySF.insertTranslate(i, z);
		}else if(x == 2) {
			dictionarySE.insertTranslate(i, z);
		}
	}
	
	public String searchTranslate(String word1, int dictionaryNumber) {
		if(dictionaryNumber==1) {
			return dictionarySF.searchTranslate(word1);
		}else if(dictionaryNumber == 2) {
			return dictionarySE.searchTranslate(word1);
		}
		return null;
	}
	
	public int countWords(int dictionaryNumber) {
		int value = 0;
		if(dictionaryNumber==1) {
			value = dictionarySF.countWords();
		}else if(dictionaryNumber == 2) {
			value = dictionarySE.countWords();
		}
		return value;
	}

}
