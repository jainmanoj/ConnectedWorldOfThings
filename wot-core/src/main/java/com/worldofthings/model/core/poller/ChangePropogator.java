package com.worldofthings.model.core.poller;

import com.worldofthings.model.core.IThing;
import com.worldofthings.model.core.ThingChangeEvent;
import com.worldofthings.model.core.ThingEvent;
import com.worldofthings.model.core.ValueType;

public class ChangePropogator implements ICallback{
	
	IThing changeObserverThing;
	String eventName;
	
	public ChangePropogator (IThing thing, String eventName){
		this.changeObserverThing =thing;
		this.eventName = eventName;
	}

	@Override
	public <T> void execute(ValueType<T> valueType  , Boolean isActive) {
		ThingEvent updateEventState = new ThingEvent(eventName,valueType);
		updateEventState.setIsActive(isActive);
		ThingChangeEvent thingChangeEvent = new ThingChangeEvent(changeObserverThing,updateEventState);
		//changeObserverThing.detectAndPropogateChangeEventToUpstream(thingChangeEvent);
		changeObserverThing.analyzeBehavior(thingChangeEvent);
	}
}
