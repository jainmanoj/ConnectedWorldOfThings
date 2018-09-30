package com.worldofthings.restapi;

import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;



import com.worldofthings.model.core.SmartThingException;
import com.worldofthings.protocol.binding.RequestPayload;
import com.worldofthings.protocol.binding.ResponsePayload;
import com.worldofthings.protocol.binding.WoTTester;
import com.worldofthings.services.ThingletService;
import com.worldofthings.vo.ThingletVO;

@RestController
@RequestMapping("/api")
public class WorldOfThingsApiController {

	public static final Logger logger = LoggerFactory.getLogger(WorldOfThingsApiController.class);

	@Autowired
	ThingletService thingletService;
	
	@RequestMapping(value = "/deployThinglet", method = RequestMethod.POST)
	public ResponseEntity<?> deployThinglet(@RequestBody RequestPayload payload,UriComponentsBuilder ucBuilder) throws UnknownHostException, SocketException, URISyntaxException, SmartThingException {
		logger.info("deployThinglet {}", payload.getThinglet().getThing().getName());
		
		ThingletVO thingletVO = payload.getThinglet();
		
		String guid=thingletService.deployThinglet(thingletVO);
		HttpHeaders headers = new HttpHeaders();
		
		//URI uri=ucBuilder.path("/api/getThingletDescription/"+guid).build().toUri();
		//headers.setLocation(ucBuilder.path("/api/getThingletDescription/{guid}").buildAndExpand(guid).toUri());
		headers.setLocation(new URI("/api/getThingletDescription/"+guid));
		//String body=guid;
		
		ResponsePayload respPayload = new ResponsePayload();
		respPayload.setRespose(guid);
		return new ResponseEntity<ResponsePayload>(respPayload,headers, HttpStatus.CREATED);
		//return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	

	
	@RequestMapping(value = "/getThingletDescription/{guid}", method = RequestMethod.GET)
	public ResponseEntity<?> getThingletDescription(@PathVariable("guid") String guid) throws UnknownHostException, SocketException, URISyntaxException, SmartThingException {
		logger.info("getThingDescription with guid {}", guid);
		
		
//		SmartWorldOfThing smartWorldOfThing = new SmartWorldOfThing();
//		IThing smartCarWorld=smartWorldOfThing.buildSmartCarWorld();
//		AbstractThingEndpoint thingletEndpoint = new RestEndpoint("http","localhost",8080,"");
//		ThingletVO thingletVO = new ThingletVO(Arrays.asList(thingletEndpoint),smartCarWorld,null);
//		guid=thingletService.deployThinglet(thingletVO);
		ThingletVO thinglet = thingletService.getThingletDescription(guid);
		ResponsePayload respPayload = new ResponsePayload();
		respPayload.setRespose(thinglet.toJson());
		
		//return new ResponseEntity<ThingletVO>(thinglet,HttpStatus.OK);
		return new ResponseEntity<ResponsePayload>(respPayload,HttpStatus.OK);

	}

//	@RequestMapping(value = "/addRelationships/", method = RequestMethod.POST)
//	public ResponseEntity<?> deployThinglet(@RequestBody RequestPayload payload,UriComponentsBuilder ucBuilder) throws UnknownHostException, SocketException, URISyntaxException, SmartThingException {
//		logger.info("deployThinglet {}", payload.getThinglet().getThing().getName());
//		
//		ThingletVO thingletVO = payload.getThinglet();
//		
//		String guid=thingletService.deployThinglet(thingletVO);
//		HttpHeaders headers = new HttpHeaders();
//		
//		//URI uri=ucBuilder.path("/api/getThingletDescription/"+guid).build().toUri();
//		//headers.setLocation(ucBuilder.path("/api/getThingletDescription/{guid}").buildAndExpand(guid).toUri());
//		headers.setLocation(new URI("/api/getThingletDescription/"+guid));
//		//String body=guid;
//		
//		ResponsePayload respPayload = new ResponsePayload();
//		respPayload.setRespose(guid);
//		return new ResponseEntity<ResponsePayload>(respPayload,headers, HttpStatus.CREATED);
//		//return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//	}
//	


	@RequestMapping(value = "/testWot/", method = RequestMethod.GET)
	public ResponseEntity<?> testWoT() throws UnknownHostException, SocketException, URISyntaxException, SmartThingException {
		WoTTester wotTester = new WoTTester();
		ResponseEntity<?> response = wotTester.testEndpoint();
		return response;

	}
}
