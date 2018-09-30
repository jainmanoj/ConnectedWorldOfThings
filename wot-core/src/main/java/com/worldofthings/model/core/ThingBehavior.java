package com.worldofthings.model.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThingBehavior implements IBehavior {

	@Expose
	@SerializedName("behaviorName")
	String behaviorName;
	@Expose
	@SerializedName("behaviorFunctionName")
	String behaviorFunctionName;
	List<String> eventNames;
	String actionName;

	public ThingBehavior(String behaviorName, List<String> eventNames, String behaviorFunctionName, String actionName) {
		this.behaviorName = behaviorName;
		this.behaviorFunctionName = behaviorFunctionName;
		this.eventNames = eventNames;
		this.actionName=actionName;
	}

	@Override
	public String getBehaviorName() {
		return behaviorName;
	}

	@Override
	public String getBehaviorFunctionName() {
		return behaviorFunctionName;
	}

	@Override
	public List<String> getEventNames() {
		return eventNames;
	}

	@Override
	public String getActionName() {
		return actionName;
	}

	@Override
	public String toString() {
		return behaviorName + "::" + behaviorFunctionName;
	}

	@Override
	public String analyzeBehavior() {
		
		//String output = behaviorFunction.apply(t)
		return null;
	}

	@Override
	public void buildBehaviorFunction() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		BiFunction<String, String, String> testBehavior = (x, y) -> {
			return x + y;
		};
//		ThingBehavior behavior = new ThingBehavior("TestBehavior", testBehavior);
//		String output = behavior.analyzeBehavior();
//		System.out.println(" ThingBehavior " + behavior.toString() + "::" + output);

	}

}
