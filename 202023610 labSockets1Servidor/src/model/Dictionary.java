package model;

import java.util.Comparator;

import resource.BynaryTreeSearch;

public class Dictionary  {
	
	private BynaryTreeSearch<Translate> words;
	
	
	
	public Dictionary() {
		super();
		this.words = new BynaryTreeSearch<Translate>(new Comparator<Translate>() {
            @Override
            public int compare(Translate t1, Translate t2) {
                return t1.getWord().compareToIgnoreCase(t2.getWord());
            }
        });
	}

	public String searchTranslate(String word1) {
		Translate translate1 = words.search(
				new Comparator<Translate>() {

			@Override
			public int compare(Translate o1, Translate o2) {
				// TODO Auto-generated method stub
				return o1.getWord().equalsIgnoreCase(o2.getWord())?1:0;
			}
			
		}, new Translate(word1));
		
		if(translate1==null) {
			return "Palabra no encontrada \n";
		}
		
		return translate1.getTranslation();
	}
	
	public void insertTranslate(String word1, String word2) {
		words.insert(new Translate(word1,word2));
	}
	
	public int countWords() {
		return words.showPreorder().size();
	}
}