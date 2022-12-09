package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import model.Game;
import model.QuestionsModel;
import model.ReaderData;
import view.Home;
import view.Question;

public class Presenter implements ActionListener{
	
	private Home view;
	private Question questions;
	private Game mainGame;
	private ArrayList<String> temporalAnswer;
	
	public Presenter() {
    	view = new Home(this);
    	run();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if (command.equals("nivel1")) {
			System.out.println("nivel1");
			questions = new Question(this);
			questions.setQuestionsFill(mainGame.getLevels().get(0).getLessons()[0].getQuestions());
 		}
		if (command.equals("answer1")) {
			temporalAnswer.add(questions.getjButton3Txt());
			questions.setJTextPane1(temporalAnswer);
			
 		}
		if (command.equals("nivel1")) {
			
 		}
		
	}
	
	private void run(){
		try {
			mainGame = ReaderData.readerGame("data/game.json");
			mainGame.setLevels(ReaderData.readerLevel("data/LessonsV1.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Presenter();	
	}

    
}
