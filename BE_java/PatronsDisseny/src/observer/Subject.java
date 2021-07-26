package observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private List<Observer> observadors = new ArrayList<Observer>();
	private int state;
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state =state;
		notifyAllObservers();
	}
	
	public void attach(Observer observer) {
		observadors.add(observer);
	}
	
	public void notifyAllObservers() {
		for(Observer obs : observadors) {
			obs.update();
		}
	}
	
}
