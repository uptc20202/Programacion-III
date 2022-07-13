package test;

import java.util.Scanner;

import model.Paragraph;
import model.Word;

public class Test {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Paragraph paragraph = new Paragraph();
		
		System.out.println("Digite la Frase o Parrafo");
		paragraph.readerParagraph(teclado. nextLine());
		
		for(Word word: paragraph.showInorder()) {
			if(word.getFrequency()>1) {
				System.out.println(word);
			}	
		}
		
	}
}
