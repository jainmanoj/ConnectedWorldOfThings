package com.worldofthings.protocol.binding;

import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.worldofthings.json.GsonFactory;
import com.worldofthings.common.DIRECTIONS;
import com.worldofthings.model.core.IThing;
import com.worldofthings.model.core.SmartThingException;
import com.worldofthings.model.core.SmartWorldOfThing;
import com.worldofthings.vo.ThingletVO;

public class WoTTester {
	
	public ResponseEntity<?> testEndpoint() throws UnknownHostException, SocketException, URISyntaxException, SmartThingException {
		
		IEndpoint universeOfthingletsWorldEndpoint = new RestEndpoint("http","localhost",8080,"");
		
		Map<String, ThingletVO> myWorldStoryMapUUID = new HashMap<String, ThingletVO>();
		Map<String, String> myWorldStoryMapInstance = new HashMap<String, String>();
		
		SmartWorldOfThing smartWorldOfThing = new SmartWorldOfThing();
		IThing smartCarWorld=smartWorldOfThing.buildSmartCarWorld();
		AbstractThingEndpoint thingletEndpoint = new RestEndpoint("http","localhost",8080,"");
		ThingletVO thingletVO = new ThingletVO(Arrays.asList(thingletEndpoint),smartCarWorld,null);
		

		RequestPayload payload = new RequestPayload(thingletVO);
		
		String resourcePath = "/api/deployThinglet";
		ResponseEntity<?> response=universeOfthingletsWorldEndpoint.onPost(resourcePath,payload);
		URI location = response.getHeaders().getLocation();
		ResponsePayload respBody=(ResponsePayload)response.getBody();
		String carGuid = respBody.getRespose();
		System.out.println("deployThinglet guid "+ carGuid);
		
		resourcePath = location.toString();

		ResponseEntity<?> response1=universeOfthingletsWorldEndpoint.onGet(resourcePath);		//"/getThingletDescription/{guid}"
		
		ResponsePayload respBody1=(ResponsePayload)response1.getBody();
		System.out.println("deployThinglet descriptor "+ respBody1.getRespose());

		
		ThingletVO carThing= GsonFactory.createGson().fromJson(respBody1.getRespose(), ThingletVO.class);
		
		System.out.println("Deployed thing descriptor " +carThing.toString());
		

		myWorldStoryMapUUID.put(carGuid, carThing);
		myWorldStoryMapInstance.put(carThing.getInstanceName(),carGuid);
		

		IThing smartServiceCenterWorld=smartWorldOfThing.buildSmartServiceCenterWorld();
		AbstractThingEndpoint smartServiceCenterWorldEndpoint = new RestEndpoint("http","localhost",8080,"");
		ThingletVO smartServiceCenterWorldThingletVO = new ThingletVO(Arrays.asList(smartServiceCenterWorldEndpoint),smartServiceCenterWorld,null);
		
		
		payload = new RequestPayload(smartServiceCenterWorldThingletVO);

		
		resourcePath = "/api/deployThinglet";
		response=universeOfthingletsWorldEndpoint.onPost(resourcePath,payload);
		
		location = response.getHeaders().getLocation();
		respBody=(ResponsePayload)response.getBody();
		String serviceCenterGuid = respBody.getRespose();
		System.out.println("deployThinglet guid "+ serviceCenterGuid);
		
		resourcePath = "/api/deployThinglet";
		resourcePath = location.toString();

		response1=universeOfthingletsWorldEndpoint.onGet(resourcePath);		//"/getThingletDescription/{guid}"
		
		respBody1=(ResponsePayload)response1.getBody();
		System.out.println("deployThinglet descriptor "+ respBody1.getRespose());

		
		ThingletVO serviceCenterThing= GsonFactory.createGson().fromJson(respBody1.getRespose(), ThingletVO.class);
		
		System.out.println("Deployed thing descriptor " +serviceCenterThing.toString());
		
		myWorldStoryMapUUID.put(serviceCenterGuid, serviceCenterThing);
		myWorldStoryMapInstance.put(serviceCenterThing.getInstanceName(),carGuid);
		
		
//		resourcePath = "/api/addRelationships";
//		response=universeOfthingletsWorldEndpoint.onPost(resourcePath,payload);
//		
//		carThing.addRelationships("ServiceBy",serviceCenterGuid,DIRECTIONS.FORWARD);
		
//
//		mycar.addRelationships("ServiceBy",new ArrayList<IThing> (Arrays.asList(serviceCenter)));
//		serviceCenter.addRelationships("ProvideServiceTo",new ArrayList<IThing> (Arrays.asList(mycar)),DIRECTIONS.REVERSE  );
		
		
		
		
		ResponsePayload respPayload = new ResponsePayload();
		respPayload.setRespose(serviceCenterThing.toJson());
		return new ResponseEntity<ResponsePayload>(respPayload,HttpStatus.OK);

		
		
//		SmartWorldOfThing smartWorldOfThing = new SmartWorldOfThing();
//		IThing mycar=smartWorldOfThing.buildSmartCarWorld();
//		System.out.println(mycar.toJson());
//		IThing serviceCenter=smartWorldOfThing.buildSmartServiceCenterWorld();
//		System.out.println(serviceCenter.toJson());
//		
//		smartWorldOfThing.activate(mycar, serviceCenter);
//		System.out.println(mycar.toJson());
//		System.out.println(serviceCenter.toJson());
		
		
	}

}
