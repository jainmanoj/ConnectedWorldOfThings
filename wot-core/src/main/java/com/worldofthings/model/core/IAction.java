package com.worldofthings.model.core;

import java.util.List;


public interface IAction {
	
	IAction getAction(String actionName);
	
	ValueType<?> getValue();
	void setValue(ValueType<?> value);

	void doExecute();

	List<IThing> invokeAction(IThing toThing, String actionName);

	



}
