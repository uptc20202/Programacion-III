package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Game;
import model.Lesson;
import model.Level;
import model.QuestionsModel;
import model.ReaderData;

public class Test {
	
	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("Hola ");
		Game game = ReaderData.readerGame("data/game.json");
//		ReaderData.RefreshData(game, "data/game.json");
		System.out.println("Hola ");
		System.out.println(game
				+"Hola "+ game.getStreak());
		
		Level level = new Level("Autores","Identifica principales autores en la TGS",
				new Lesson[] {new Lesson("Nivel 1",false,new QuestionsModel[] {
						new QuestionsModel("Creador de la teoría general de sistemas:",0,
								new String[]{"Ludwig"},new String[]{"Ludwig"})}
						)}
				);
		
		Level[] level1 = new Level[] {level};
		
		ReaderData.RefreshLeve(level1,"data/levels.json");
	}
}
