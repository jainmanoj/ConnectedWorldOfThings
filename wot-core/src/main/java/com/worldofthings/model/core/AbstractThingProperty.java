package com.worldofthings.model.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class AbstractThingProperty implements IProperty {
	
	@Expose @SerializedName("propertyName")
	String propertyName;
	@Expose @SerializedName("valueType")
	ValueType<?> value;
	@Expose @SerializedName("propertyClassType")
	String propertyClassType="base";
	
	<T> AbstractThingProperty(String propertyName, T value ){
		this.propertyName=propertyName;
		this.value = new ValueType<T>(value);
	}
	
	<T> AbstractThingProperty(String propertyName, String type, String value ){
		this.propertyName=propertyName;
		this.value = new ValueType(type,value);
	}
	
	public ValueType<?> getProperty() {
		return value;
	}
	public ValueType<?> getProperty(String propertyName) {
		if (this.propertyName.equals(propertyName))
			return value;
		else
			return null;
		
	}
	
	
	
	public String getPropertyClassType() {
		return propertyClassType;
	}
	public void setPropertyClassType(String propertyClassType) {
		this.propertyClassType = propertyClassType;
	}
	
	@Override
	public String toString() {
		return propertyName+"::"+value.toString();
	}


}

