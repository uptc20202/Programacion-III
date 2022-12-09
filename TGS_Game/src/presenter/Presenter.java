package presenter;

import java.awt.Color;
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
			questions = new Question(this);
			questions.setQuestionsFill(mainGame.getLevels().get(0).getLessons()[0].getQuestions());
			temporalAnswer.clear();
 		}
		if (command.equals("answer1")) {
			if(!temporalAnswer.contains(questions.getjButton3Txt())) {
				temporalAnswer.add(questions.getjButton3Txt());
				questions.getjButton3Paint(Color.green);
			}else {
				temporalAnswer.remove(questions.getjButton3Txt());
				questions.getjButton3Paint(Color.white);
			}
			questions.setJTextArea2(temporalAnswer);
			
 		}
		if (command.equals("answer2")) {
			if(!temporalAnswer.contains(questions.getjButton2Txt())) {
				temporalAnswer.add(questions.getjButton2Txt());
				questions.getjButton2Paint(Color.green);
			}else {
				temporalAnswer.remove(questions.getjButton2Txt());
				questions.getjButton2Paint(Color.white);
			}
			questions.setJTextArea2(temporalAnswer);
			
 		}if (command.equals("answer3")) {
			if(!temporalAnswer.contains(questions.getjButton5Txt())) {
				temporalAnswer.add(questions.getjButton5Txt());
				questions.getjButton5Paint(Color.green);
			}else {
				temporalAnswer.remove(questions.getjButton5Txt());
				questions.getjButton5Paint(Color.white);
			}
			questions.setJTextArea2(temporalAnswer);
			
 		}if (command.equals("answer4")) {
			if(!temporalAnswer.contains(questions.getjButton6Txt())) {
				temporalAnswer.add(questions.getjButton6Txt());
				questions.getjButton6Paint(Color.green);
			}else {
				temporalAnswer.remove(questions.getjButton6Txt());
				questions.getjButton6Paint(Color.white);
			}
			questions.setJTextArea2(temporalAnswer);
			
 		}if (command.equals("answer5")) {
			if(!temporalAnswer.contains(questions.getjButton9Txt())) {
				temporalAnswer.add(questions.getjButton9Txt());
				questions.getjButton9Paint(Color.green);
			}else {
				temporalAnswer.remove(questions.getjButton9Txt());
				questions.getjButton9Paint(Color.white);
			}
			questions.setJTextArea2(temporalAnswer);
			
 		}if (command.equals("answer6")) {
			if(!temporalAnswer.contains(questions.getjButton4Txt())) {
				temporalAnswer.add(questions.getjButton4Txt());
				questions.getjButton4Paint(Color.green);
			}else {
				temporalAnswer.remove(questions.getjButton4Txt());
				questions.getjButton4Paint(Color.white);
			}
			questions.setJTextArea2(temporalAnswer);
			
 		}if (command.equals("answer7")) {
			if(!temporalAnswer.contains(questions.getjButton8Txt())) {
				temporalAnswer.add(questions.getjButton8Txt());
				questions.getjButton8Paint(Color.green);
			}else {
				temporalAnswer.remove(questions.getjButton8Txt());
				questions.getjButton8Paint(Color.white);
			}
			questions.setJTextArea2(temporalAnswer);
			
 		}
 		if (command.equals("answer8")) {
			if(!temporalAnswer.contains(questions.getjButton7Txt())) {
				temporalAnswer.add(questions.getjButton7Txt());
				questions.getjButton7Paint(Color.green);
			}else {
				temporalAnswer.remove(questions.getjButton7Txt());
				questions.getjButton7Paint(Color.white);
			}
			questions.setJTextArea2(temporalAnswer);
			
 		}
		if (command.equals("checkAnswer")) {
			mainGame.getLevels().get(0).getLessons()[questions.getLevelNumber()].getQuestions()[questions.getPositionQuestions()].valitaPointsAnswer(temporalAnswer);
 		}
		
	}
	
	private void run(){
		temporalAnswer = new ArrayList<String>();
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
