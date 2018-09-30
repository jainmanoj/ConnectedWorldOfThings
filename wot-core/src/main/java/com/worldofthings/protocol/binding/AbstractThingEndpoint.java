package com.worldofthings.protocol.binding;

import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public abstract class AbstractThingEndpoint implements IEndpoint {
	
	@Expose @SerializedName("bindingScheme")
	String bindingScheme;
	@Expose @SerializedName("hostname")
	String hostname;
	@Expose @SerializedName("port")
	int port;
	@Expose @SerializedName("rootPath")
	String rootPath;
	
	AbstractThingEndpoint(	String bindingScheme,String hostname,int port,String rootPath){
		this.bindingScheme=bindingScheme;
		this.hostname=hostname;
		this.port=port;
		this.rootPath=rootPath;
	}

	public String getBindingScheme() {
		return bindingScheme;
	}

	public String getHostname() {
		return hostname;
	}

	public int getPort() {
		return port;
	}

	public String getRootPath() {
		return rootPath;
	}


	
	@Override
	public String toString() {
		return bindingScheme+"::"+hostname+"::"+port+"::"+rootPath;
	}
	
	public URI resourceURIBuilder(String resourcePath) throws UnknownHostException, SocketException, URISyntaxException{
		//String hostname = BindingTools.getIpAddress();
		String hostname = BindingTools.getIpAddress();
		String baseuri = String.format(bindingScheme+"://%s:%s%s",hostname, port,resourcePath);
		return new URI(baseuri);
	}


}
