package com.worldofthings.model.core;

import java.util.List;

public interface IBehavior {
	
	public String analyzeBehavior();

	public void buildBehaviorFunction();


	public String getBehaviorFunctionName();

	public String getBehaviorName();

	public List<String> getEventNames();

	String getActionName();

}
