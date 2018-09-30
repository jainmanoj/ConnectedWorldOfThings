package com.worldofthings.model.core.poller;

import com.worldofthings.model.core.ValueType;

interface ICondition<T>  {   
	public  boolean evaluateConditionFunction(ValueType<T> testVal);
}

//
//@FunctionalInterface
//interface Function3 <A, B, C, R> { 
////R is like Return, but doesn't have to be last in the list nor named R.
//    public R apply (A a, B b, C c);
//}