package com.worldofthings.protocol.binding;

import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.worldofthings.json.GsonFactory;
import com.worldofthings.model.core.IThing;
import com.worldofthings.model.core.SmartThingException;
import com.worldofthings.model.core.SmartWorldOfThing;
import com.worldofthings.vo.ThingletVO;

public class RequestPayload {
	
	@Expose @SerializedName("thinglet")
	ThingletVO  thinglet;
	
	
	public RequestPayload() {

	}
	
	public RequestPayload(ThingletVO thinglet) {
		super();
		this.thinglet = thinglet;
	}

	public ThingletVO getThinglet() {
		return thinglet;
	}

	public void setThinglet(ThingletVO thinglet) {
		this.thinglet = thinglet;
	}


	public static void main(String[] args) throws SmartThingException {
		SmartWorldOfThing smartWorldOfThing = new SmartWorldOfThing();
		IThing carThing=smartWorldOfThing.buildSmartCarWorld();
		ThingletVO myCarThinglet = new ThingletVO();
		myCarThinglet.addThing(carThing);
		AbstractThingEndpoint ep1 = new RestEndpoint("http","localhost",8080,"");
		AbstractThingEndpoint ep2 = new RestEndpoint("http","localhost",8080,"");
		myCarThinglet.addEndpoints(Arrays.asList(ep1,ep2));
		
		RequestPayload payload = new RequestPayload();
		payload.setThinglet(myCarThinglet);
		
		String palloadJosn = GsonFactory.createGson().toJson(payload);
		
		System.out.println(palloadJosn);
		
	}
}
