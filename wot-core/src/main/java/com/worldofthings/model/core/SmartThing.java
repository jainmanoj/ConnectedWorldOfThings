package com.worldofthings.model.core;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class SmartThing extends AbstractSmartThing {

	public SmartThing(String name, String nameSpace, String thingClassType) {
		super(name, nameSpace, thingClassType);
	}

//
//	@Expose @SerializedName("model")
//    String thingModelDef;
//    
//	@Expose @SerializedName("name")
//	String thingName;
// 
//	@Expose @SerializedName("classType")
//	String thingClassType;
//	
//	@Expose @SerializedName("isLiving")
//	Boolean isLiving;
//
//	@Expose @SerializedName("heartbeat")
//	Integer heartbeat;
//	
//	@Expose @SerializedName("namespace")
//	String thingWorldNameSpace;
//    
//	@Expose @SerializedName("properties")
//	List<IProperty> properties;
//    
//	@Expose @SerializedName("events")
//	List<IEvent> events;
//    
//	@Expose @SerializedName("actions")
//	List<IAction> actions;
//    
//	@Expose @SerializedName("metadatas")
//	List<IMetadata> metadatas;
//
//    
//	@Expose @SerializedName("forwardRelationships")
//	Map<String,List<IThing>> fwdRelationships;
//    
//	@Expose (serialize = false, deserialize = false)
//	@SerializedName("reverseRelationships")
//	Map<String,List<IThing>> revRelationships;
//    
//	public SmartThing(String name, String nameSpace, String thingClassType) {
//		this.thingName = name;
//		this.thingWorldNameSpace = nameSpace;
//		this.thingClassType=thingClassType;
//		this.isLiving=false;
//		this.heartbeat=-1;
//		properties = new ArrayList<IProperty>();
//		events = new ArrayList<IEvent>();
//		actions = new ArrayList<IAction>();
//		metadatas = new ArrayList<IMetadata>();
//		fwdRelationships = new HashMap<String,List<IThing>>();
//		revRelationships = new HashMap<String,List<IThing>>();
//	}
//
//	public void addRelationships(String relationshipName, ArrayList<IThing> things) {
//		addRelationships(relationshipName, things,DIRECTIONS.FORWARD);
//	}
//
//
//	public void addRelationships(String relationshipName, ArrayList<IThing> things,DIRECTIONS direction) {
//		List<IThing> smartthings=getRelationships(relationshipName);
//		if (smartthings !=null){
//			smartthings.addAll(things);
//		} else {
//			smartthings= new ArrayList<IThing>();
//			smartthings.addAll(things);
//		}
//		if(direction.equals(DIRECTIONS.FORWARD)){
//			fwdRelationships.put(relationshipName,smartthings);
//		} else {
//			revRelationships.put(relationshipName,smartthings);
//		}
//	}
//	
//	public void addRelationships(String relationshipName, IThing thing) {
//		addRelationships(relationshipName, thing,DIRECTIONS.FORWARD);
//	}
//	public void addRelationships(String relationshipName, IThing thing,DIRECTIONS direction) {
//		List<IThing> smartthings=getRelationships(relationshipName,direction);
//		if (smartthings !=null){
//			smartthings.add(thing);
//		} else {
//			smartthings= new ArrayList<IThing>();
//			smartthings.add(thing);
//		}
//		if(direction.equals(DIRECTIONS.FORWARD)){
//			fwdRelationships.put(relationshipName,smartthings);
//		} else {
//			revRelationships.put(relationshipName,smartthings);
//		}
//
//	}
//	
//	public List<IThing> getRelationships(String relationshipName) {
//
//		return getRelationships(relationshipName,DIRECTIONS.FORWARD);
//	}
//	
//	
//	public List<IThing> getRelationships(String relationshipName,DIRECTIONS direction) {
//		if(direction.equals(DIRECTIONS.FORWARD)){
//			return fwdRelationships.get(relationshipName);
//		} else {
//			return revRelationships.get(relationshipName);
//		}
//	}
//
//	
//
//	@Override
//	public String getModel() {
//		thingModelDef = toJson();
//		return thingModelDef;
//	}
//
//	@Override
//	public String getName() {
//		return thingName;
//	}
//	
//	@Override
//	public String getNameSpace() {
//		return thingWorldNameSpace;
//	}
//	
//	@Override
//	public String getThingClassType() {
//		return thingClassType;
//	}
//
//
//	public Boolean getIsLiving() {
//		return isLiving;
//	}
//
//	@Override
//	public void setIsLiving(Boolean isLiving) {
//		this.isLiving = isLiving;
//	}
//	
//	@Override
//	public IProperty getProperty(String propertyName) {
//		for (IProperty property : properties){
//			if (property.getProperty(propertyName) !=null)
//				return property;
//		}
//		return null;
//	}
//
//	@Override
//	public List<IProperty> getProperties() {
//		return properties;
//	}
//
//	@Override
//	public void addProperty(IProperty property) {
//		//IProperty thingProperty = new ThingProperty("Power",DTYPES.INTEGER.name(),"1400");
//		properties.add(property);
//
//	}
//
//	@Override
//	public void addAllProperty(List<IProperty> properties) {
//		this.properties.addAll(properties);
//
//	}
//
//	@Override
//	public IMetadata getMetadata(String metadataName) {
//		for (IMetadata metadata : metadatas){
//			if (metadata.getMetadata(metadataName) !=null)
//				return metadata;
//		}
//		return null;
//	}
//
//	@Override
//	public List<IMetadata> getMetadatas() {
//		return metadatas;
//	}
//
//	@Override
//	public void addMetadata(IMetadata metadata) {
//		//IMetadata thingMetadata = new ThingMetadata("Power",DTYPES.INTEGER.name(),"1400");
//		metadatas.add(metadata);
//
//	}
//
//	@Override
//	public void addAllMetadata(List<IMetadata> metadatas) {
//		this.metadatas.addAll(metadatas);
//
//	}
//
//	@Override
//	public IAction getAction(String actionName) {
//		for (IAction action : actions){
//			if (action.getAction(actionName) !=null)
//				return action;
//		}
//		return null;
//	}
//
//	@Override
//	public List<IAction> getActions() {
//		return actions;
//	}
//
//	@Override
//	public void addAction(IAction action) {
//		//IAction thingAction = new ThingAction("Power",DTYPES.INTEGER.name(),"1400");
//		actions.add(action);
//	}
//
//	@Override
//	public void addAllAction(List<IAction> actions) {
//		this.actions.addAll(actions);
//
//	}
//
//	@Override
//	public Object invokeAction(String actionName, Object parameter) {
//		return null;
//	}
//
//
//	@Override
//	public void doAction(IAction action) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	
//	//NEED Better way to Propogate the attributes from an Object to another Object
//	
//	@Override
//	public IEvent getEvent(String eventName) {
//		for (IEvent event : events) {
//			if (event.getEventName().equals(eventName)) {
//				if (event.isPropogated()) {
//					List<IEvent> propagatedEvents = new ArrayList<IEvent>();
//					List<IThing> things = getRelationships(event.getSourceObjectChannel());
//					for (IThing thing : things) {
//						IEvent updatedEvent=thing.getEvent(eventName);
//						updateEvent(thing,updatedEvent);
//						propagatedEvents.add(thing.getEvent(eventName));
//						
//					}
//					return propagatedEvents.get(0);
//
//				} else {
//					return event;
//				}
//			}
//		}
//		return null;
//	}
//
//	private void updateEvent(IThing thing, IEvent updatedEvent) {
//		for (IEvent event : thing.getEvents()) {
//			if (event.getEventName().equals(updatedEvent.getEventName())) {
//				thing.updateEvent(updatedEvent);
//			}
//
//		}
//		return;
//		
//	}
//
//	public void updateEvent(IEvent updatedEvent) {
//		for (IEvent event : events) {
//			if (event.getEventName().equals(updatedEvent.getEventName())) {
//				event.setValue(updatedEvent.getValue());
//			}
//
//		}
//		return;
//		
//	}
//	
//	@Override
//	public List<IEvent> getEvents() {
//		return events;
//	}
//
//	
//	@Override
//	public void addEvent(IEvent event) {
//		events.add(event);
//	}
//
//	@Override
//	public void addAllEvent(List<IEvent> Events) {
//		this.events.addAll(events);
//
//	}
//
//	@Override
//	public void infuseLife(int heartbeat) {
//		this.heartbeat=heartbeat;
//	}
//
//	@Override
//	public void hertbeatTask() {
//		List<IEvent> newEvents = new ArrayList<IEvent>();
//		for (IEvent event : events) {
//			IEvent pevent = event.propagate(this, event.getEventName());
//			newEvents.add(pevent);
//		}
//		//events.clear();
//		events = newEvents;
//		return;
//	}
//
//
//
//	@Override
//	public boolean isLivingThing() {
//		return isLiving;
//	}
//
//	
//	public String toString() {
//		return thingClassType+"::"+thingName;
//		
//
//	}
//
//	public String toJson() {
//		
//		String thingModelDef=gson.toJson(this);
//		return thingModelDef;
//	}
//	
//	
//
//	public static void main(String[] args) {
//		
////		SmartThing carThing = new SmartThing("ManojCar","ManojWorld","Car");
////		
////		ThingProperty carProperty = new ThingProperty("Power",DTYPES.INTEGER.name(),"1400");
////		carThing.addProperty(carProperty);
////		carProperty = new ThingProperty("Color",DTYPES.STRING.name(),"Platinum");
////		carThing.addProperty(carProperty);
////
////		ThingMetadata carMetadata = new ThingMetadata("Owner",DTYPES.STRING.name(),"Manoj");
////		carThing.addMetadata(carMetadata);
////		carMetadata = new ThingMetadata("Location",DTYPES.STRING.name(),"Banglore");
////		carThing.addMetadata(carMetadata);		
////		
////
////		ThingAction carAction = new ThingAction("Accelerate",DTYPES.INTEGER.name(),"100");
////		carThing.addAction(carAction);
////		carAction = new ThingAction("MoveTo",DTYPES.STRING.name(),"MG Road");
////		carThing.addAction(carAction);	
////		
////
////		ThingEvent carStrearingUnstable = new ThingEvent("StrearingUnstable",DTYPES.STRING.name(),"Unstable");
////		carThing.addEvent(carStrearingUnstable);
////		ThingEvent carLowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.STRING.name(),"Unstable");
////		carLowTyrePressure.setPropogation(true, "Wheel", "ComposedOf",SmartFunction.Aggregate);
////		carThing.addEvent(carLowTyrePressure);	
////
////		
////		
////		SmartThing car1wheel1 = new SmartThing("Car1Wheel1","ManojWorld","Wheel");
////		ThingEvent wheel1lowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.INTEGER.name(),"1037");
////		wheel1lowTyrePressure.setPropogation(true, "WheelSensor", "InstrumentedBy",SmartFunction.Aggregate);
////		car1wheel1.addEvent(wheel1lowTyrePressure);
////		
////		SmartThing car1wheel1Sensor = new SmartThing("Car1Wheel1Sensor","ManojWorld","WheelSensor");
////		ThingEvent wheelSensorlowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.INTEGER.name(),"7301");
////		car1wheel1Sensor.addEvent(wheelSensorlowTyrePressure);
////		
////		
////		car1wheel1.addRelationships("InstrumentedBy",car1wheel1Sensor); 
////		
////		
////		carThing.addRelationships("ComposedOf",new ArrayList<IThing> (  Arrays.asList(car1wheel1) ) );
////		car1wheel1.addRelationships("PartOf",carThing,DIRECTIONS.REVERSE);
////		
////		System.out.println(carThing.toJson());
//		
//		//System.out.println(car1wheel1.toJson());
//		
//	}
//
//	@Override
//	public void addRelationShip(String relationship, IThing thing) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String getKey() {
//		// TODO Auto-generated method stub
//		return null;
//	}





}
