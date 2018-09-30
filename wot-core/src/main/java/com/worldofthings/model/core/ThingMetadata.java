package com.worldofthings.model.core;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.worldofthings.common.DTYPES;


public class ThingMetadata implements IMetadata {
	
	@Expose @SerializedName("metadataName")
	String metadataName;
	@Expose @SerializedName("valueType")
	ValueType value;
	
	ThingMetadata(String metadataName, String type, String value){
		this.metadataName=metadataName;
		this.value = new ValueType(type,value);
	}
	public ValueType getProperty() {
		return value;
	}
	public ValueType  getMetadata(String metadataName){
		if (this.metadataName.equals(metadataName))
			return value;
		else
			return null;
		
	}
	@Override
	public String toString() {
		return metadataName+"::"+value.toString();
	}

	
	public static void main(String[] args) {
		ThingMetadata test = new ThingMetadata("myMetaname",DTYPES.INTEGER.name(),"myMetavalue");
		System.out.println(" ThingMetadata " + test.toString());
	}

}
