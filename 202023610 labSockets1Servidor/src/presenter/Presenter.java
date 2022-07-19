package presenter;

import java.util.Date;

import model.Translator;
import view.ViewConsole;

public class Presenter {
	private ViewConsole view;
	private Translator translator;
	
	public Presenter() {
		view = new ViewConsole();
		translator = new Translator();
		run();
	}
	
	public void run() {
		String option = "";
		do {
			String menu = "1. Obtener la traducción en inglés de una palabra en español\r\n"
					+ "2. Obtener la traducción en francés de una palabra en español\r\n"
					+ "3. Agregar una nueva traducción al diccionario español-inglés\r\n"
					+ "4. Agregar una nueva traducción al diccionario español-francés\r\n"
					+ "5. Total de palabras que contiene cada uno de los diccionarios\r\n"
					+ "6. Salir";
			System.out.println(menu);
			option = view.readString("Digite la opcion desea: ");
			switch(option) {
				case "1":
					translateToEnglish();
					break;
				case "2":
					translateToFrench();
					break;
				case "3":
					addTranslateEN();
					break;
				case "4":
					addTranslateFR();
					break;	
				case "5":
					countWords();
					break;
				
				default:
					System.out.println("Seleccione una opción correcta");
					break;
			}
		}while(option != "6");
		
	}
	
	public void translateToEnglish() {
		
		String word = view.readString("Digite la palabra que desea traducir");
		System.out.println("Traduccion en Ingles : " +translator.searchTranslate(word, 1));
	}
	
	public void translateToFrench() {
		String word = view.readString("Digite la palabra que desea traducir");
		System.out.println("Traduccion en Frances : " +translator.searchTranslate(word, 2));
	}
	
	public void addTranslateEN() {
		String word = view.readString("Digite la palabra que desea insertar");
		String word2 = view.readString("Digite su traduccion al ingles");
		translator.insertTranslate(word, word2, 1);
	}
	
	public void addTranslateFR() {
		String word = view.readString("Digite la palabra que desea insertar");
		String word2 = view.readString("Digite su traduccion al ingles");
		translator.insertTranslate(word, word2, 2);
	}
	
	public void countWords() {
		System.out.println(" El diccionario en Ingles cuenta con : " + translator.countWords(1) + " palabras");
		System.out.println(" El diccionario en Frances cuenta con : " + translator.countWords(2) + " palabras");
	}
	
	public static void main(String [] args) {
		new Presenter();
		
	}

}
