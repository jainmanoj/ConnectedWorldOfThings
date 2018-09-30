package com.worldofthings.model.core;


public class ThingChangeEvent {
	
	IThing thing;
	IEvent updateEventState;


	public ThingChangeEvent(IThing thing, IEvent updateEventState) {
		this.thing = thing;
		this.updateEventState=updateEventState;

	}
	
	public IThing getThing(){
		return thing;
	}
	

	public IEvent getUpdateEventState() {
		return updateEventState;
	}
	
	@Override
	public String toString() {
		String str = thing.toString()+":::" + updateEventState.toString();
		return str;
	}

}
