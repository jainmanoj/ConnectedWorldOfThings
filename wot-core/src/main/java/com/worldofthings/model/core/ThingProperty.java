package com.worldofthings.model.core;

import com.worldofthings.common.DTYPES;


public class ThingProperty extends AbstractThingProperty {
	
	ThingProperty(String propertyName, String type, String value) {
		super(propertyName, type, value);
		// TODO Auto-generated constructor stub
	}


	<T> ThingProperty(String propertyName, T value) {
		super(propertyName,  value);
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		ThingProperty thingProperty = new ThingProperty("mykey",DTYPES.INTEGER.name(),"myvalue");
		System.out.println(" Thing Property " + thingProperty.toString());
	}

}
