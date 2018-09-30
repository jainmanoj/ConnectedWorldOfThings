package com.worldofthings.model.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Function;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public class ThingAction extends AbstractThingAction {
	

	ThingAction(String actionName, ValueType inputParams, ValueType outputParams) {
		super(actionName, inputParams, outputParams);
	}

	public static void main(String[] args) {
//		ThingAction test = new ThingAction("actionName",DTYPES.INTEGER.name(),"actionName Value");
//		System.out.println(" ThingActionName " + test.toString());
		//TestClass testClass = new TestClass();
		IThing testThing = new SmartThing("ManojCar","ManojWorld","Car");
		String actionName="actionName";
		ValueType inputParams = new ValueType("Hello Manoj");
		ValueType outputParams = new ValueType("Hi Caller");		
		
	    IAction action = new ThingAction(actionName,inputParams,outputParams);
	    testThing.addAction(action);
	    
	    IAction testAction = testThing.getAction(actionName);
	    
	    testAction.doExecute();


	}





}
