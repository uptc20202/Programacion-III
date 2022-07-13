package pilas;

import java.util.*;
import java.io.*;

public class Palindromo {
	
	private String word;
	private Stack<Character> pila;
	
	
	public Palindromo(String word) {
		super();
		this.word = word;
		for (int i = 0; i < word.length(); i++){
			pila.push(new Character(word.charAt(i)));
		}
	}

	


	public void copiarPila(Stack<Character> stackRoot, Stack<Character> stack2) {
		stackRoot = pila;
		for (int i = 0; i < word.length(); i++){
			stack2.push(stackRoot.pop());
		}
		
	}
	
	public boolean validatePalindromo(String word) {
		
		boolean pal;
		while (word != null){
			for (int i = 0; i < word.length(); i++){
				pila.push(new Character(word.charAt(i)));
			}
			
			
			pal = true;
			int i = 0;
 
			while (pal && !pila.empty()){
				Character q;
				q = pila.pop();
				pal = q.charValue() == word.charAt(i++);
			}
			if (pal && pila.empty())
				return true;
			else {
				return false;
			}
		}
		return false;
	}
	
	
	
}
