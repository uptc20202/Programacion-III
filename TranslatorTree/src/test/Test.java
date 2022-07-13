package test;

import model.Translator;

public class Test {
	public static void main(String[] args) {
		Translator translator = new Translator();
		translator.insertTranslate("Tiempo", "Time", 1);
		translator.insertTranslate("Persona", "Person", 1);
		translator.insertTranslate("Año", "Year", 1);
		translator.insertTranslate("Camino", "Way", 1);
		translator.insertTranslate("Día", "Day", 1);
		translator.insertTranslate("Cosa", "Thing", 1);
		
		System.out.println(translator.searchTranslate("Camino", 1));
		
	}
}
