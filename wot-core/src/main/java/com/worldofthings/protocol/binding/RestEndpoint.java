package com.worldofthings.protocol.binding;

import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.worldofthings.json.GsonFactory;
import com.worldofthings.model.core.IThing;
import com.worldofthings.model.core.SmartThingException;
import com.worldofthings.model.core.SmartWorldOfThing;
import com.worldofthings.vo.ThingletVO;



public class RestEndpoint extends AbstractThingEndpoint{
	
	private RestTemplate restTemplate = new RestTemplate();



	public RestEndpoint(String bindingScheme, String hostname, int port, String rootPath) {
		super(bindingScheme, hostname, port,rootPath);
		restTemplate.getMessageConverters().add(0,createGsonHttpMessageConverter());
	}

    private GsonHttpMessageConverter createGsonHttpMessageConverter() {
        GsonHttpMessageConverter gsonConverter = new GsonHttpMessageConverter();
        gsonConverter.setGson(GsonFactory.createGson());
        
        System.out.println("MANOJ Configuring HttpMessageConverters");

        return gsonConverter;
    }
    
	@Override
	public String validate(String method, String uri, String jwt) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//onGet will return json string body in response
	@Override
	public ResponseEntity<?> onGet(String resourcePath) throws UnknownHostException, SocketException, URISyntaxException { 
		URI bindingUri=resourceURIBuilder(resourcePath);
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		Map<String, String> params = new HashMap<String, String>();
//		params.put("applicationName", applicationName);

		HttpEntity<?> entity = new HttpEntity(headers);

		ResponseEntity<ResponsePayload> response = restTemplate.exchange(bindingUri, HttpMethod.GET, entity, ResponsePayload.class);
		
		System.out.println(" onGet "+response.getBody());
		//return response.getBody();
		return response;
	}

	@Override
	public void onPut(String resourcePath,RequestPayload payload) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		
	}

	@Override
	public ResponseEntity<?> onPost(String resourcePath,RequestPayload payload) throws UnknownHostException, SocketException, URISyntaxException {
		URI bindingUri=resourceURIBuilder(resourcePath);
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    //headers.set("Authorization", "Basic " + "xxxxxxxxxxxx");
	    HttpEntity<RequestPayload> entity = new HttpEntity<RequestPayload>(payload, headers);
	    
	   // restTemplate.exchange(bindingUri, HttpMethod.POST, entity, Payload.class);


	    // send request and parse result
	    ResponseEntity<?> response = restTemplate.exchange(bindingUri, HttpMethod.POST, entity, ResponsePayload.class);

	    System.out.println(((ResponsePayload)response.getBody()).getRespose() );
	    
	    //return response.getBody();
	    return response;
	}

	@Override
	public void onDelete(String resourcePath) {
		// TODO Auto-generated method stub
		
	}
	

	
	public static void main(String[] args) throws SmartThingException, UnknownHostException, SocketException, URISyntaxException {

		IEndpoint universeOfthingletsWorldEndpoint = new RestEndpoint("http","localhost",8080,"");
		
		SmartWorldOfThing smartWorldOfThing = new SmartWorldOfThing();
		IThing smartCarWorld=smartWorldOfThing.buildSmartCarWorld();
		AbstractThingEndpoint thingletEndpoint = new RestEndpoint("http","localhost",8080,"");
		ThingletVO thingletVO = new ThingletVO(Arrays.asList(thingletEndpoint),smartCarWorld,null);
		

		RequestPayload payload = new RequestPayload(thingletVO);
		
		String resourcePath = "/api/deployThinglet";
		ResponseEntity<?> response=universeOfthingletsWorldEndpoint.onPost(resourcePath,payload);
		URI location = response.getHeaders().getLocation();
		String carGuid=(String)response.getBody();
	}
	

}
