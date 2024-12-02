package ownUtil;

public interface Observable {
	public void addObserver(Observer obs);
	public void removObserver(Observer obs);
	public void notifyObservers();

}
