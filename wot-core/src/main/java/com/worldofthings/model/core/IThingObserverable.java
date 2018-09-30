package com.worldofthings.model.core;

public interface IThingObserverable {
//	public void update(Observable obs, Object obj);
//	//Called when a change has occurred in the state of the observable.
//	public void addObserver(Observer obs);
//	//Adds an observer to the internal list of observers.
//	public void deleteObserver(Observer obs);
//	//Deletes an observer from the internal list of observers.
//	public void deleteObservers();
//	//Deletes all observers from the internal list of observers.
//	public int countObservers();
//	//Returns the number of observers in the internal list of observers.
//	public void setChanged();
//	//Sets the internal flag that indicates this observable has changed state.
//	public void clearChanged();
//	//Clears the internal flag that indicates this observable has changed state.
//	public boolean hasChanged();
//	//Returns the boolean value true if this observable has changed state.
//	public void notifyObservers();
//	//Checks the internal flag to see if the observable has changed state and notifies all observers.
//	public void notifyObservers(Object obj);
	
	public void addListener(IThingChangeListner listner);

	public void removeListener(IThingChangeListner listner);

	public void propogateChangeEventToUpstreamSubscribers(ThingChangeEvent thingChangeEvent);

}
