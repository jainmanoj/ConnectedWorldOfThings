package com.worldofthings.protocol.binding;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponsePayload {

	
	@Expose @SerializedName("response")
	String  respose;
	
	
	public String getRespose() {
		return respose;
	}


	public void setRespose(String respose) {
		this.respose = respose;
	}



}
