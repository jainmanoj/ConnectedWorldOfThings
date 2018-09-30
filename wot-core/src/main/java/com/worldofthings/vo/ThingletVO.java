package com.worldofthings.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.worldofthings.common.DIRECTIONS;
import com.worldofthings.json.GsonFactory;
import com.worldofthings.model.core.IBehavior;
import com.worldofthings.model.core.IThing;
import com.worldofthings.model.core.SmartThingException;
import com.worldofthings.model.core.SmartWorldOfThing;
import com.worldofthings.protocol.binding.AbstractThingEndpoint;
import com.worldofthings.protocol.binding.IEndpoint;
import com.worldofthings.protocol.binding.RestEndpoint;

public class ThingletVO {

	Gson gson = GsonFactory.createGson();
	//http://wcftutorial.net/endpoint.aspx - reference
	
	@Expose @SerializedName("endpoints")
	List<AbstractThingEndpoint> endpoints= new ArrayList<AbstractThingEndpoint>();			//Endpoints is with Protocol Bindings
	
	@Expose @SerializedName("thing")
	IThing thing;					//Should be minimized to hold this object in memory // Things should describe its behaviors
	//List<IBehavior> behaviors;

	
	public ThingletVO() {

	}
	

	public String getInstanceName() {
		String instanceName = thing.getInstanceName();
		return instanceName;
	}

	
	
	public ThingletVO(List<AbstractThingEndpoint> endpoints, IThing thing,List<IBehavior> behaviors) {
		this.endpoints = endpoints;
		//this.behaviors=behaviors;
		this.thing = thing;
	}
	

	
	
	
	public List<AbstractThingEndpoint> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(List<AbstractThingEndpoint> endpoints) {
		this.endpoints = endpoints;
	}

	public void setThing(IThing thing) {
		this.thing = thing;
	}

	public IThing getThing() {
		return this.thing;
	}
	
	
	public void addThing(IThing thing) {
		this.thing = thing;
	}
	
	
	public List<AbstractThingEndpoint> gddEndpoints() {
		return endpoints;
	}
	
	public AbstractThingEndpoint getEndpoint(String scheme) {
		for (AbstractThingEndpoint endpoint : endpoints){
			if (endpoint.getBindingScheme().equals(scheme))
				return endpoint;
		}
		return null;
	}


	public void addEndpoints(List<AbstractThingEndpoint> eps) {
		endpoints.addAll(eps);
	}

	private void addEndpoint(AbstractThingEndpoint ep) {
		endpoints.add(ep);
	}
	

	public String toJson() {
		String thingModelDef=gson.toJson(this);
		return thingModelDef;
	}

	public String toString() {
		String thingModelStr = thing.toString();
		return thingModelStr;
	}
	

	public void addRelationships(String string, String serviceCenterGuid, DIRECTIONS forward) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws SmartThingException {
		SmartWorldOfThing smartWorldOfThing = new SmartWorldOfThing();
		IThing carThing=smartWorldOfThing.buildSmartCarWorld();
		ThingletVO myCarThinglet = new ThingletVO();
		myCarThinglet.addThing(carThing);
		AbstractThingEndpoint ep1 = new RestEndpoint("http","localhost",8080,"");
		AbstractThingEndpoint ep2 = new RestEndpoint("http","localhost",8080,"");
		myCarThinglet.addEndpoint(ep1);
		myCarThinglet.addEndpoints(Arrays.asList(ep1,ep2));
	}



	

}
