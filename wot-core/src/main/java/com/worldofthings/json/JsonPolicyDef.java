package com.worldofthings.json;

public @interface JsonPolicyDef {
    Policy[] value();

    public enum Policy {
    	COMMAND_TO_CLIENT,
    	COMMAND_TO_DEVICE,
    	COMMAND_UPDATE_TO_CLIENT

    }
}
