package model;

public class Word {
	private String txt;
	private int frequency;
	
	public Word(String txt) {
		super();
		this.txt = txt;
		this.frequency = 1;
	}
	

	public String getTxt() {
		return txt;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}


	@Override
	public String toString() {
		return "Word [Palabra=" + txt + ", Frecuencia=" + frequency + "]";
	}
	
	

}
