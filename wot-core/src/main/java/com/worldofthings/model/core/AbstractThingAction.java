package com.worldofthings.model.core;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public abstract class AbstractThingAction implements IAction {
	
	@Expose @SerializedName("actionOnThing")
	IThing actionOnThing;
	
	@Expose @SerializedName("actionName")
	String actionName;
	@Expose @SerializedName("inputParams")
	ValueType<?> inputParams;					//InputParams It could be complex Json Object
	
	@Expose @SerializedName("outputParams")
	ValueType<?> outputParams;					//InputParams It could be complex Json Object	
	
	String accessorType = "REST"; 	//Could be Rest, WebSocket, SNMP, CLI etc.... //Action payload will be encapsulated in Accessor Payload
									//Each type of accessor will implement "abstract doEexecute method"
									//Accessor is the real interface to device.
	
	
	
//	Runnable r1 = () -> System.out.println("My Runnable");
	
	
	//BinaryOperator<Function<ValueType,ValueType>> compose = (f,g) -> x -> g.apply(f.apply(x));
	
//	public static Function<ValueType, ValueType> invoke(ValueType input) {
//		
//		System.out.println("Invoke input "+input.toString());
//		ValueType output =new ValueType(new String("Return"));
//		System.out.println("Invke output "+output.toString());
//		return ;
//	 }
	
	

	@Override
	public void doExecute() {
		System.out.println("Execuring action  on Thing "+ "::" +actionName );
		SMSSender smsSender = new SMSSender();
		String resp="";
//		try {
//			resp = smsSender.sendMessage("xxxx", "This is message from WoT Group of connected world."+"\nExecuring action  on Thing "+ "::" +actionName);
//			resp = smsSender.sendMessage("xxxx", "This is message from WoT Group of connected world."+"\nExecuring action  on Thing "+ "::" +actionName);
//			resp = smsSender.sendMessage("xxxx", "This is message from WoT Group of connected world."+"\nExecuring action  on Thing "+ "::" +actionName);
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(resp);
		
		
//		if(accessorType.equals("REST")){
//			System.out.println("Execuring action "+actionName +":inputParams:"+inputParams+":outputParams:"+outputParams );
//		}


        
    }

	
	AbstractThingAction(String actionName, ValueType<?> inputParams, ValueType<?> outputParams){
		this.actionName=actionName;
		this.inputParams = inputParams;
		this.outputParams = outputParams;
		
		
	}




	private Class<?>[] getParameterClasses(Object... parameters) {
	        Class<?>[] classes = new Class[parameters.length];
	        for (int i=0; i < classes.length; i++) {
	            classes[i] = parameters[i].getClass();
	        }
	        return classes;
	}
	public IAction  getAction(String actionName){
		if (this.actionName.equals(actionName))
			return this;
		else
			return null;
	}
	
	@Override
	public ValueType<?> getValue() {
		return inputParams;
	}

	@Override
	public void setValue(ValueType<?> value) {
		this.inputParams=value;
	}

	
	
	@Override
	public List<IThing>  invokeAction(IThing toThing,String actionName) {
		return null;
	}

	
	@Override
	public String toString() {
		return actionName+"::"+inputParams.toString();
	}


}
