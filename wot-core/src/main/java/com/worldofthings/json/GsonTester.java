package com.worldofthings.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.worldofthings.model.core.IThing;
import com.worldofthings.model.core.SmartThing;
import com.worldofthings.model.core.SmartThingException;
import com.worldofthings.model.core.SmartWorldOfThing;
import com.worldofthings.protocol.binding.AbstractThingEndpoint;
import com.worldofthings.protocol.binding.CoAPEndpoint;
import com.worldofthings.protocol.binding.IEndpoint;
import com.worldofthings.protocol.binding.RequestPayload;
import com.worldofthings.protocol.binding.RestEndpoint;
import com.worldofthings.vo.ThingletVO;

public class GsonTester {
	
	Gson gson= GsonFactory.createGson();
	public void abstractSerDeserTester() throws SmartThingException{
		
		List<IEndpoint> endpoints = new ArrayList<IEndpoint>();
		IEndpoint thingletEndpoint1 = new RestEndpoint("http","localhost",8080,"");
		IEndpoint thingletEndpoint2 = new RestEndpoint("http","localhost",8080,"");
		IEndpoint thingletEndpoint3 = new RestEndpoint("coap","localhost",8080,"");
		
		endpoints.addAll(Arrays.asList(thingletEndpoint1,thingletEndpoint2,thingletEndpoint3));
		
		String json = gson.toJson(endpoints);
		Type listType = new TypeToken<List<AbstractThingEndpoint>>() {}.getType();
		List<AbstractThingEndpoint> fromJson = gson.fromJson(json, listType);
		for (AbstractThingEndpoint endpoint : fromJson) {
			if (endpoint instanceof RestEndpoint) {
				System.out.println(endpoint + " REST");
			} else if (endpoint instanceof CoAPEndpoint) {
				System.out.println(endpoint + " COAP");
			} else {
				System.out.println("Class not found");
			}
		}
		
		SmartWorldOfThing smartWorldOfThing= new SmartWorldOfThing();
		IThing smartCarWorld=smartWorldOfThing.buildSmartCarWorld();
		AbstractThingEndpoint thingletEndpoint = new RestEndpoint("http","localhost",8080,"");
		//Arrays.asList(thingletEndpoint)
		ThingletVO thingletVO = new ThingletVO(Arrays.asList(thingletEndpoint),smartCarWorld,null);		

	
		String thingletVOJsonSer = gson.toJson(thingletVO);
		System.out.println("ThingletVO Serialized "+thingletVOJsonSer);
		
		ThingletVO thingletVOJsonDeSer = gson.fromJson(thingletVOJsonSer, ThingletVO.class); 
		
		System.out.println("ThingletVO DeSerialized "+thingletVOJsonDeSer.toString());
		
		
		RequestPayload payload = new RequestPayload();
		
		payload.setThinglet(thingletVOJsonDeSer);
		
		
		String payloadJsonSer = gson.toJson(payload);
		System.out.println("Payload Serialized "+payloadJsonSer);
		
		RequestPayload payloadJsonDeSer = gson.fromJson(payloadJsonSer, RequestPayload.class); 
		
		System.out.println("Payload DeSerialized "+payloadJsonDeSer.toString());
		

		
//		SmartWorldOfThing smartWorldOfThing = new SmartWorldOfThing();
//		IThing smartCarWorld=smartWorldOfThing.buildSmartCarWorld();
//		IEndpoint thingletEndpoint = new RestEndpoint("http","localhost",8080,"");
//		ThingletVO thingletVO = new ThingletVO(Arrays.asList(thingletEndpoint),smartCarWorld,null);
//
//		Payload payload = new Payload(thingletVO);
//		
//		String payloadJsonSer = gson.toJson(payload);
//		
//		Payload payloadJsonDeser = gson.fromJson(payloadJsonSer, Payload.class); 
//		
//		if (payloadJsonSer.equals(payloadJsonDeser)){
//			System.out.println("abstractSerDeserTester Passed");
//		} else {
//			System.out.println("abstractSerDeserTester Failed");
//		}

	}
	
	public static void main(String[] args) throws SmartThingException {
		new GsonTester().abstractSerDeserTester();
	}

}
