package com.worldofthings.model.core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.worldofthings.common.DIRECTIONS;
import com.worldofthings.common.DTYPES;
import com.worldofthings.common.SUMMARIZEDBYFUNC;


public class ThingEvent implements IEvent {
	
	@Expose @SerializedName("eventName")
	String eventName;
	@Expose @SerializedName("valueType")
	ValueType<?> value;
	@Expose @SerializedName("isActive")
	Boolean isActive =false;
	
	@Expose @SerializedName("isPropogated")
	boolean isPropogated;
	@Expose @SerializedName("sourceClassType")
	String sourceClassType;
	@Expose @SerializedName("sourceObjectChannel")
	String sourceObjectChannel;
	

	
	
	public <T> ThingEvent(String eventName, T value){
		this.eventName=eventName;
		this.value = new ValueType<T>(value);
		this.isPropogated=false;
		sourceClassType=null;
		sourceObjectChannel=null;
	}
	
	public <T> ThingEvent(String eventName, String type, String value){
		this.eventName=eventName;
		this.value = new ValueType<T>(type,value);
		this.isPropogated=false;
		sourceClassType=null;
		sourceObjectChannel=null;
	}
	
	public <T> ThingEvent(String eventName, ValueType<T> value){
		this.eventName=eventName;
		this.value = value;
		this.isPropogated=false;
		sourceClassType=null;
		sourceObjectChannel=null;
	}
	
	<T> ThingEvent(String eventName, String type, String value, Boolean isPropogated, String sourceClassType, String sourceObjectChannel ){
		this.eventName=eventName;
		this.value = new ValueType<T>(type,value);
		this.isPropogated=false;
		this.sourceClassType=sourceClassType;
		this.sourceObjectChannel=sourceObjectChannel;
		
	}

	public ThingEvent() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String getEventName() {
		return eventName;
	}

	
	@Override
	public boolean isPropogated() {
		return isPropogated;
	}
	
	@Override
	public String getSourceClassType() {
		return sourceClassType;
	}
	
	@Override
	public String getSourceObjectChannel() {
		return sourceObjectChannel;
	}
	
	@Override
	public ValueType<?> getValue() {
		return value;
	}
	@Override
	public ValueType<?>  getValue(String eventName){
		if (this.eventName.equals(eventName))
			return value;
		else
			return null;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public void setValue(ValueType<?> value) {
		this.value=value;
		
	}
	
	public void setPropogation(	boolean isPropogated, String sourceClassType,String sourceObjectChannel,Function<List<IEvent>, IEvent> function){
		this.isPropogated=isPropogated;
		this.sourceClassType=sourceClassType;
		this.sourceObjectChannel=sourceObjectChannel;
		
	}
	
	private ValueType aggregationFunction(List<IEvent> events){
		List<ValueType> valueTypes = new ArrayList<ValueType>();
		for(IEvent event : events){
			valueTypes.add(event.getValue());
		}
		value=SmartFunction.FUNCTIONS(valueTypes,SUMMARIZEDBYFUNC.AVARAGE);
		return value;
	}
	
	@Override
	public IEvent propagate(IThing toThing,String eventName) {
		if (isPropogated()) {
			List<IThing> things = toThing.getRelationships(getSourceObjectChannel());
			System.out.println("Poragating Event "+eventName + " To  "+ toThing+ " From "+things);
			List<IEvent> aggEvents = new ArrayList<IEvent>();
			for (IThing thing : things) {
				for (IEvent ievent : thing.getEvents()) {
					if (ievent.getEventName().equals(eventName)){
						IEvent pevent = ievent.propagate(thing, ievent.getEventName());
						aggEvents.add(pevent);
						break;
					}
				}
			}
			this.value=aggregationFunction(aggEvents);
		}
		return this;
	}

	
	@Override
	public IEvent push(IThing toThing,String eventName) {
		if (isPropogated()) {
			List<IThing> things = toThing.getRelationships(getSourceObjectChannel(),DIRECTIONS.REVERSE);
			System.out.println("Pushing Event in Reverse"+eventName + " To  "+ toThing+ " From "+things);
			for (IThing thing : things) {
				for (IEvent ievent : thing.getEvents()) {
					if (ievent.getEventName().equals(eventName)){
						IEvent pevent = ievent.push(thing, ievent.getEventName());
						System.out.println("Event Pushed "+pevent.getEventName() + " To  "+ thing+ " From "+toThing);
						break;
					}
				}
			}
		}
		return this;
	}
	
	
	@Override
	public String toString() {
		return eventName+"::"+value.toString() +"::"+isActive;
	}

	
	public static void main(String[] args) {
		ThingEvent test = new ThingEvent("eventName",DTYPES.INTEGER.name(),"eventName Value");
		System.out.println(" ThingEventName " + test.toString());
	}










}
