package com.worldofthings.model.core;

import java.util.List;
import java.util.function.Function;

public interface IEvent {

	String getEventName();
	boolean isPropogated();
	String getSourceClassType();
	String getSourceObjectChannel();
	ValueType<?> getValue();
	ValueType<?> getValue(String eventName);
	void setPropogation(boolean isPropogated, String sourceClassType,String sourceObjectChannel,Function<List<IEvent>, IEvent> function);
	void setValue(ValueType<?> value);
	IEvent propagate(IThing toThing,String eventName);
	IEvent push(IThing toThing, String eventName);
	Boolean getIsActive();
	void setIsActive(Boolean isActive);

}
