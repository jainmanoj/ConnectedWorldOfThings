package com.worldofthings.model.core;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This example demonstrates the use of {@link HttpPost} request method. And
 * sending HTML Form request parameters
 */
public class SMSSender {
	
	String gatewayUrl="http://smsgateway.me/api/v3/messages/send";
	String email = "xxxx@gmail.com";
	String secret ="xxxx";
	String deviceId="xxxx";
//	String recepient="xxxxx";
//	String message="This is message from WoT Group of connected world";
	CloseableHttpClient httpclient;
	
	public SMSSender(){
//		this.recepient=recepient;
//		this.message=msg;
		this.httpclient=createClient();
	}
	
	CloseableHttpClient createClient(){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		return httpclient;
		
	}
	
	public String sendMessage(String recepient,String msg) throws ClientProtocolException, IOException {
		List<NameValuePair> form = new ArrayList<>();
		form.add(new BasicNameValuePair("email", email));
		form.add(new BasicNameValuePair("password", secret));
		form.add(new BasicNameValuePair("device", deviceId));
		form.add(new BasicNameValuePair("number", recepient));
		form.add(new BasicNameValuePair("message", msg));
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(form, Consts.UTF_8);

		HttpPost httpPost = new HttpPost(gatewayUrl);
		httpPost.setEntity(entity);
		System.out.println("Executing request " + httpPost.getRequestLine());

		// Create a custom response handler
		ResponseHandler<String> responseHandler = response -> {
			int status = response.getStatusLine().getStatusCode();
			if (status >= 200 && status < 300) {
				HttpEntity responseEntity = response.getEntity();
				return responseEntity != null ? EntityUtils.toString(responseEntity) : null;
			} else {
				throw new ClientProtocolException("Unexpected response status: " + status);
			}
		};
		String responseBody = this.httpclient.execute(httpPost, responseHandler);
		System.out.println("----------------------------------------");
		System.out.println(responseBody);
		return responseBody;
		
	}
	

	public static void main(String... args) throws IOException {
		SMSSender smsSender = new SMSSender();
		String resp=smsSender.sendMessage("xxxx", "This is message from WoT Group of connected world");
		System.out.println(resp);
				

	
	}
}

	