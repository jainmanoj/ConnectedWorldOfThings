package com.worldofthings.model.core;

import com.google.gson.annotations.SerializedName;



public class PersitanceEntityCassandraModel {

	/*Persistance Model for Object
	 * This will be Peristance Layer Specific
	 * Each will do its own implementation.
	 * But it will provide converter functions  for 
	 * EntityObject to VirtualObject mapping  or
	 * VirtualObject  to EntityObject mapping
	 * */
	  private static final long serialVersionUID = 4140545193474112756L;

	    @SerializedName("id")
	    private Long id;

	    @SerializedName("command")
	    private String command;


}
