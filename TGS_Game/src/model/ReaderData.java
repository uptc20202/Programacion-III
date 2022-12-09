package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ReaderData {
	
	public static void RefreshData(Game game, String nameField) {
		String json = new Gson().toJson(game);
		
		PrintWriter print;
		try {
			print = new PrintWriter(nameField);
			print.write(json);
			print.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void RefreshLeve(Level[] game, String nameField) {
		String json = new Gson().toJson(game);
		
		PrintWriter print;
		try {
			print = new PrintWriter(nameField);
			print.write(json);
			print.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Game readerGame(String nameField) throws FileNotFoundException {
		Game game = new Game();
		JsonReader reader = new Gson().newJsonReader(new FileReader(nameField));
		game = new Gson().fromJson(reader, Game.class);
		
		return game;
		
	}
	
	public static ArrayList<Level> readerLevel(String nameField) throws FileNotFoundException{
		ArrayList<Level> levels = new ArrayList<Level>();
		JsonReader reader = new Gson().newJsonReader(new FileReader(nameField));
		Level[] levelArray= new Gson().fromJson(reader, Level[].class);
		
		for(Level level1 : levelArray) {
			levels.add(level1);
		}
		
		
		for(Level level1: levels) {
			System.out.println(level1+" TEst lectura");
		}
		return levels;
	}
	
	
}
