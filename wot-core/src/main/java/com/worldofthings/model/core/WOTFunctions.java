package com.worldofthings.model.core;


import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class WOTFunctions {

	public static <T> Predicate<ValueType<T>> GRETERTHANEQUALTO(ValueType<T> testCondition){
		Predicate<ValueType<T>> function = x -> x.greaterThanEqualTo(testCondition);
		return function;
	}

	public static <T> Predicate<ValueType<T>> LESSTHANEQUALTO(ValueType<T> testCondition){
		Predicate<ValueType<T>> function = x -> x.lessThanEqualTo(testCondition);
		return function;
	}
	
	public static <T> Predicate<ValueType<T>> EQUALTO(ValueType<T> testCondition){
		Predicate<ValueType<T>> function = x -> x.equalTo(testCondition);
		return function;
	}

	public static Function<List<IEvent>, IEvent> AGGREGATEEVENT() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static BiFunction<Boolean, Boolean,String> LOGICALANDEVENT(String action) {
		
		BiFunction<Boolean, Boolean,String> function = (x,y) -> x && y  ? action :  "";
		return function;
	}
	
	public static Function<List<IEvent>,String> LOGICALANDEVENTS(String action) {
		Function<List<IEvent>,String> function = (events) -> {
			Boolean isActive=true;
			for (IEvent event : events ) {
				isActive &= event.getIsActive();
			}
			if (isActive) {
				return action;
			} else {
				return action;
			}
		}; 
		return function;
	}
	

	public static Function<List<IEvent>,  String> getFunction(String behaviorFunctionName, String actionName) {
		switch (behaviorFunctionName) {
		case "LOGICALANDEVENTS":
			return WOTFunctions.LOGICALANDEVENTS(actionName);
		}
		return null;
	}
	
	//BinaryOperator<Function<ValueType,ValueType>> compose = (f,g) -> x -> g.apply(f.apply(x));
	
//	public static Function<ValueType, ValueType> invoke(ValueType input) {
//		
//		System.out.println("Invoke input "+input.toString());
//		ValueType output =new ValueType(new String("Return"));
//		System.out.println("Invke output "+output.toString());
//		return ;
//	 }
	
//	BiFunction<Trade,Trade,Trade> tradeMerger2 = (t1, t2) -> {
//		  // calling another method for merger
//		  return merge(t1,t2);
//		};
//
//		// This method is called from the lambda.
//		// You can prepare a sophisticated algorithm to merge a trade in here
//		private Trade merge(Trade t1, Trade t2){
//		  t1.setQuantity(t1.getQuantity()+t2.getQuantity());
//		  return t1;
//ThingBehavior car1StearingWobbling = ThingBehavior("StearingWobbling", WOTFunctions.LOGICALANDEVENT(car1AggregatedlowTyrePressure,car1AggregatedlowTyrePressure.getIsActive(),"CALLSERVICECENTER"));
		
//		}
	
	public static void main(String[] args) {
		Predicate<ValueType<Double>> callbackconditionL = WOTFunctions.GRETERTHANEQUALTO(new ValueType<Double>(10.0));
		Predicate<ValueType<Double>> callbackconditionU = WOTFunctions.LESSTHANEQUALTO(new ValueType<Double>(90.0));
	
		System.out.println(callbackconditionL.test(new ValueType<Double>(70.0)));
		System.out.println(callbackconditionL.test(new ValueType<Double>(7.0)));
		
		
		System.out.println(callbackconditionU.test(new ValueType<Double>(99.0)));
		System.out.println(callbackconditionU.test(new ValueType<Double>(7.0)));
		
		BiFunction<Boolean, Boolean, String> behaviorFn1 = WOTFunctions.LOGICALANDEVENT("TESTACTION");
		System.out.println(behaviorFn1.apply(true, true));
		
		
		
	}



}