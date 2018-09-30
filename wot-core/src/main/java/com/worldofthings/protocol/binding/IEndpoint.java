package com.worldofthings.protocol.binding;

import java.net.SocketException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Observer;

import org.springframework.http.ResponseEntity;


public interface IEndpoint {

	public String getBindingScheme();

	public String getHostname();

	public int getPort();

	public String getRootPath();
	
	String validate(String method, String uri, String jwt);

	ResponseEntity<?> onGet(String resourcePath) throws UnknownHostException, SocketException, URISyntaxException ;

	void onPut(String resourcePath,RequestPayload payload);
	
	ResponseEntity<?> onPost(String resourcePath,RequestPayload payload) throws UnknownHostException, SocketException, URISyntaxException;
	
	void onDelete(String resourcePath);

}
