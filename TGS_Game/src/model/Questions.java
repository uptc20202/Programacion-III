package model;

public class Questions {
	
	private String name;
	private int points;
	private int allowedError;
	private String[] answersTrue;
	private String[] answersFalse;

	public Questions(String name, int allowedError, String[] answersTrue, String[] answersFalse) {
		super();
		this.name = name;
		this.points = 0;
		this.allowedError = allowedError;//maxima cantidad de errores permitidos para pasar una pregunta 
		this.answersTrue = answersTrue;//Lista de respuestas correctas
		this.answersFalse = answersFalse;//Lista de respuestas falsas que se presentaran al usuario mezcladas con correctas
	}

	public boolean valitaPointsAnswer(String[] answers) {
		int error = 0;
		if(answers.length == answersTrue.length ) {
			int index = 0;
			for(String partAnswer :answers) {
				
				if(allowedError < error) {
					return false;
				}
				
				if(partAnswer.equalsIgnoreCase(answersTrue[index])) {
					points = points+2;
				}else {
					
					for(String partAnswer2 :answersTrue) {
						if(partAnswer2.equalsIgnoreCase(partAnswer)) {
							points++;
						}else {
							error++;
						}
					}
				}
				index++;
			}
		}
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
	
	
}