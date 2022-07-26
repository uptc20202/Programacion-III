package model;

import java.util.ArrayList;

import presenter.Observer;

public abstract class Subject {
	private ArrayList<Observer> observers;
 	
	
	
	public Subject() {
		super();
		this.observers = new ArrayList<Observer>();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(Observer observer : observers) {
			observer.update();
		}
	}
	
	
}
