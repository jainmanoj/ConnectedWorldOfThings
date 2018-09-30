package com.worldofthings.model.core.poller;

import java.util.function.Predicate;

import com.worldofthings.model.core.IThing;
import com.worldofthings.model.core.SmartThing;
import com.worldofthings.model.core.ValueType;
import com.worldofthings.model.core.WOTFunctions;

public class MetricChangeDetector<T> implements ICondition<T> {
	
	Predicate<ValueType<T>> callbackconditionInActive;
	Predicate<ValueType<T>> callbackconditionActive;
	ICallback callbackFunction;
	
	public MetricChangeDetector(Predicate<ValueType<T>> callbackconditionInActive,Predicate<ValueType<T>> callbackconditionActive,  ICallback callbackFunction) {
		this.callbackconditionInActive=callbackconditionInActive;
		this.callbackconditionActive=callbackconditionActive;
		this.callbackFunction=callbackFunction;

	}
	
	@Override
	public  boolean evaluateConditionFunction(ValueType<T> testVal) {
	//public boolean evaluateConditionFunction(ValueType<T> testVal) {
		//System.out.println(callbackcondition.test(new Double(9)));// prints true
		if (this.callbackconditionInActive.test(testVal)) {
			this.callbackFunction.execute(testVal,true);	//Make Change Sensor Poller Event as Active - is in Bad state
			return true;
		} else if (this.callbackconditionActive.test(testVal)) {
			this.callbackFunction.execute(testVal,false);	//Make Change Sensor Poller Event as InActive - Revert to OK state
			return true;
		} else {
			return false;
		}
	}

	
	public static void main(String[] args) {

		Predicate<ValueType<Double>> callbackconditionL = WOTFunctions.GRETERTHANEQUALTO(new ValueType<Double>(10.0));
		callbackconditionL.test(new ValueType<Double>(20.4));
		Predicate<ValueType<Double>> callbackconditionU = WOTFunctions.LESSTHANEQUALTO(new ValueType<Double>(90.0));
		Predicate<ValueType<Integer>> callbackconditionN = WOTFunctions.EQUALTO(new ValueType<Integer>(10));
		IThing car1 = new SmartThing("Test","TestWorld","Test");
		ICallback changePropogatorFn=new ChangePropogator(car1,"LowTyrePressure");
		
		MetricChangeDetector<Double> myTest3 = new MetricChangeDetector<Double>(callbackconditionL, callbackconditionU,changePropogatorFn);
		System.out.println(myTest3.evaluateConditionFunction(new ValueType(70.0)));
		System.out.println(myTest3.evaluateConditionFunction(new ValueType(7.0)));
		

	}

}
