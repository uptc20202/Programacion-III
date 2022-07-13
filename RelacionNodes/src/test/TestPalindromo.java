package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class TestPalindromo {
	
	public static void main(String[] args){
		
		
		
		BufferedReader entrada = new BufferedReader( new
				InputStreamReader(System.in));
		Stack<Character> pila;
		String palabra;
		boolean pal;
		pila = new Stack<Character>();
		try {
			System.out.println("Palabra o frase: ");
			while ((palabra = entrada.readLine()) != null)
			{
				for (int i = 0; i < palabra.length(); i++){
					pila.push(new Character(palabra.charAt(i)));
				}
				pal = true;
				int i = 0;
	 
				while (pal && !pila.empty()){
					Character q;
					q = pila.pop();
					pal = q.charValue() == palabra.charAt(i++);
				}
				if (pal && pila.empty())
					System.out.println(palabra + " es un palíndromo");
				else
					System.out.println(palabra + " no es un palíndromo");
				}
		}
		catch (Exception e) {;}
		
	}
		
		
		

}
