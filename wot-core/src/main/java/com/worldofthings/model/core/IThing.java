package com.worldofthings.model.core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import com.google.gson.Gson;
import com.worldofthings.common.DIRECTIONS;
import com.worldofthings.json.GsonFactory;


public abstract class IThing  implements IThingObserverable,IThingChangeListner {
	Gson gson = GsonFactory.createGson();
	abstract String getModel();
	public abstract String getName();
	abstract String getNameSpace();
	abstract String getThingClassType();
    
    //Not all things are Living ie Car is living while Tire is non Living
    //Living things will have heartbeat & heartbeat Task, every "T" Seconds task will do routine action on thing
    //Also  living things will have a state to rejuvenated. It means it can do specific actions on that thing.
    //The state can be updated as stale by its related Things. e.g. Type(Non-Living) pressure changed. It has to be updated into Car (Living thing).
    //So Tire using reverse relationship can inform Car that it has stale information, based on that Car will update its state

	abstract void infuseLife(int heartbeat);
	abstract void hertbeatTask();
	abstract boolean isLivingThing(); 
    

	abstract AbstractThingProperty getProperty(String propertyName);
	abstract List<AbstractThingProperty> getProperties();
	abstract void addProperty(AbstractThingProperty property);
	abstract void addAllProperty(List<AbstractThingProperty> properties);
 
    
	abstract IMetadata getMetadata(String metadataName);
	abstract List<IMetadata> getMetadatas();
	abstract void addMetadata(IMetadata metadata);
	abstract void addAllMetadata(List<IMetadata> metadatas);
    
	abstract IAction getAction(String actionName);
	abstract List<IAction> getActions();
	abstract void addAction(IAction action);
	abstract void addAllAction(List<IAction> actions);
	abstract Object invokeAction(String actionName, Object parameter);


	public abstract IEvent getEvent(String eventName);
	public abstract List<IEvent> getEvents();

	abstract void addEvent(IEvent event);
	abstract void addAllEvent(List<IEvent> Events);
	abstract String toJson();
	abstract void addRelationships(String string, ArrayList<IThing> things);
	abstract public void addRelationships(String relationshipName, ArrayList<IThing> things,DIRECTIONS direction);
	abstract void setIsLiving(Boolean b);
	abstract void updateEvent(IEvent updatedEvent);
	abstract List<IThing> getRelationships(String sourceObjectChannel);
	abstract List<IThing> getRelationships(String sourceObjectChannel,DIRECTIONS direction);
	abstract void doAction(IAction action);
	abstract void addRelationShip(String relationship, IThing thing);
	abstract String getKey();
	abstract public String getInstanceName();
	abstract public void analyzeBehavior(ThingChangeEvent thingChangeEvent);

	
	abstract IBehavior getBehavior(String behaviorName);
	abstract List<IBehavior> getBehaviors();
	abstract void addBehavior(IBehavior behavior);
	abstract void addAllBehavior(List<IBehavior> behaviors);



    //void onActionInvoke(String actionName, Function<?, ?> callback);
    //void onPropertyUpdate(String propertyName, Consumer<Object> callback);
    //void onPropertyRead(Consumer<Object> callback);
	//public void getBehavior();
	//public void getAnalytics();
	//public void getRefs();


}
