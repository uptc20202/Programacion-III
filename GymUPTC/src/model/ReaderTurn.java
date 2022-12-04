package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ReaderTurn {
	
	private ArrayList<Turn> turns;
	
	public ArrayList<Turn> getTurns() {
		return turns;
	}

	public ReaderTurn(String nameField) {
		super();
		try {
			readerTurns(nameField);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ReaderTurn(String star, String finalTurn) {
		turns = new ArrayList<Turn>();
		try {
			createNewTurn(star, finalTurn);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createNewTurn(String star, String finalTurn) throws FileNotFoundException {
		Turn turn = new Turn(star,finalTurn);
		turns.add(turn);
		
		String json = new Gson().toJson(turns);
		//System.out.println(json);
		
		PrintWriter print = new PrintWriter("data/nuevoArchivoTurns.json");
		print.write(json);
		print.close();
	}
	
	public static void RefreshData(ArrayList<Turn> turns1, String nameField) {
		String json = new Gson().toJson(turns1);
		
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

	public static ArrayList<Turn> readerTurns(String nameField) throws FileNotFoundException {
		ArrayList<Turn> turns = new ArrayList<Turn>();
		JsonReader reader = new Gson().newJsonReader(new FileReader(nameField));
		Turn[] turnArray= new Gson().fromJson(reader, Turn[].class);
		
		for(Turn turn1 : turnArray) {
			turns.add(turn1);
		}
		
		return turns;
	}
	
	

}
