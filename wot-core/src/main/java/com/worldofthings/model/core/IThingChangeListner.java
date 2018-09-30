package com.worldofthings.model.core;

public interface IThingChangeListner {
	public String publishChangeEventToUpstreamSubscribers(ThingChangeEvent thingChangeEvent);
	//public void detectAndPropogateChangeEventToUpstream(ThingChangeEvent thingChangeEvent);
}
