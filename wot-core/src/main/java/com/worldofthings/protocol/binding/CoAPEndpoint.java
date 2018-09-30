package com.worldofthings.protocol.binding;

import org.springframework.http.ResponseEntity;



public class CoAPEndpoint extends AbstractThingEndpoint{


	CoAPEndpoint(String bindingScheme, String hostname, int port, String rootPath) {
		super(bindingScheme, hostname, port,rootPath);

	}

	@Override
	public String validate(String method, String uri, String jwt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> onGet(String resourcePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onPut(String resourcePath,RequestPayload payload) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<?> onPost(String resourcePath,RequestPayload payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDelete(String resourcePath) {
		// TODO Auto-generated method stub
		
	}
	

	

}
