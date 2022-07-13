package model;

import java.util.ArrayList;
import java.util.Comparator;

import resources.BynaryTreeSearch;

public class Paragraph {
	private BynaryTreeSearch<Word> words;
	private Comparator comparatorSearch;

	public Paragraph() {
		super();
		this.words = new BynaryTreeSearch<Word>(new Comparator<Word>() {
            @Override
            public int compare(Word t1, Word t2) {
                return t1.getTxt().compareToIgnoreCase(t2.getTxt());
            }
        });
		
		comparatorSearch = new Comparator<Word>() {
            @Override
            public int compare(Word t1, Word t2) {
                return t1.getTxt().equalsIgnoreCase(t2.getTxt())?0:1;
            }
        };
        
	}
	
	public void readerParagraph(String paragraph) {
		String[] newStr = paragraph.split(" ");
        for (int i = 0; i < newStr.length; i++) {
        	insertWord(newStr[i].replaceAll("\\p{Punct}", ""));
        }
	}
	
	public void insertWord(String word) {
		
		Word wordNew =  words.search(comparatorSearch, new Word(word));
		
		if(wordNew==null) {
			words.insert(new Word(word));
		}else {
			wordNew.setFrequency(wordNew.getFrequency()+1);
		}
	}
	
	public ArrayList<Word> showInorder() {
		return words.showInorder();
	}
	
	
	
	
}
