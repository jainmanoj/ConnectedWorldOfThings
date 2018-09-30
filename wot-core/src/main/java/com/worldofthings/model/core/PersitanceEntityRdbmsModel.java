package com.worldofthings.model.core;

import com.google.gson.annotations.SerializedName;
import com.worldofthings.vo.VirtualObjectVO;

public class PersitanceEntityRdbmsModel {

	  private static final long serialVersionUID = 4140545193474112756L;
		/*Persistance Model for Object
		 * This will be Peristance Layer Specific
		 * Each will do its own implementation.
		 * But it will provide converter functions  for 
		 * EntityObject to VirtualObject mapping  or
		 * VirtualObject  to EntityObject mapping
		 * */
	    @SerializedName("id")
	    private Long id;

	    @SerializedName("command")
	    private String command;


	    
	    public static VirtualObjectVO convert(PersitanceEntityRdbmsModel vo) {
	    	return null;
	    	
	    }

}
