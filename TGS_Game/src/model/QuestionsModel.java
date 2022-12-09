package model;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionsModel {
	
	private String name;
	private int points;
	private int allowedError;
	private String[] answersTrue;
	private String[] answersFalse;

	public QuestionsModel(String name, int allowedError, String[] answersTrue, String[] answersFalse) {
		super();
		this.name = name;
		this.points = 0;
		this.allowedError = allowedError;//maxima cantidad de errores permitidos para pasar una pregunta 
		this.answersTrue = answersTrue;//Lista de respuestas correctas
		this.answersFalse = answersFalse;//Lista de respuestas falsas que se presentaran al usuario mezcladas con correctas
	}
	
	
	public boolean valitaPointsAnswer(ArrayList<String> temporalAnswer) {
		int error = 0;
		if(temporalAnswer.size() == answersTrue.length ) {
			int index = 0;
			for(String partAnswer :temporalAnswer) {
				
				if(allowedError < error) {
					points = 0;
					return false;
				}
				
				if(!partAnswer.equalsIgnoreCase(answersTrue[index])) {
					
					for(String partAnswer2 :answersTrue) {
						if(!partAnswer2.equalsIgnoreCase(partAnswer)) {
							error++;
						}
					}
				}
				index++;
			}
		}else {
			points = 0;
			return false;
		}
		points = 20;
		return true;
	}
	
	public boolean validatePosition(String answer, int position) {
		if(answer.equalsIgnoreCase(answersTrue[position])) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public String[] getAnswersTrue() {
		return answersTrue;
	}

	public String[] getAnswersFalse() {
		return answersFalse;
	}


	@Override
	public String toString() {
		return "QuestionsModel [name=" + name + ", points=" + points + ", allowedError=" + allowedError
				+ ", answersTrue=" + Arrays.toString(answersTrue) + ", answersFalse=" + Arrays.toString(answersFalse)
				+ "]";
	}
	
	
}
