package com.worldofthings.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.worldofthings.json.AnnotatedStrategy;
import com.worldofthings.json.JsonPolicyDef.Policy;
import com.worldofthings.model.core.AbstractThingProperty;
import com.worldofthings.model.core.IAction;
import com.worldofthings.model.core.IEvent;
import com.worldofthings.model.core.IMetadata;
import com.worldofthings.model.core.IProperty;
import com.worldofthings.model.core.IThing;
import com.worldofthings.model.core.SmartThing;
import com.worldofthings.model.core.ThingAction;
import com.worldofthings.model.core.ThingEvent;
import com.worldofthings.model.core.ThingMetadata;
import com.worldofthings.model.core.ThingProperty;
import com.worldofthings.protocol.binding.RestEndpoint;
import com.worldofthings.protocol.binding.CoAPEndpoint;
import com.worldofthings.protocol.binding.AbstractThingEndpoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class GsonFactory {

    private static Map<Policy, Gson> cache = new ConcurrentHashMap<>();
    private static Gson gson = createGsonBuilder().create();

    public static Gson createGson() {
        return gson;
    }

    public static Gson createGson(Policy policy) {
        Gson gson = cache.get(policy);
        if (gson != null) {
            return gson;
        }
        gson = createGsonBuilder()
                .addDeserializationExclusionStrategy(new AnnotatedStrategy(policy))
                .addSerializationExclusionStrategy(new AnnotatedStrategy(policy))
                .create();
        cache.put(policy, gson);
        return gson;
    }

		
    private static GsonBuilder createGsonBuilder() {

    	 final RuntimeTypeAdapterFactory<AbstractThingEndpoint> bindingSchemeTypeFactory = RuntimeTypeAdapterFactory
                 .of(AbstractThingEndpoint.class, "bindingScheme")
                 .registerSubtype(RestEndpoint.class,"http")
                 .registerSubtype(CoAPEndpoint.class,"coap");

    	 final RuntimeTypeAdapterFactory<AbstractThingProperty> propertyTypeFactory = RuntimeTypeAdapterFactory
                 .of(AbstractThingProperty.class, "propertyClassType")
                 .registerSubtype(ThingProperty.class,"base");
//                 .registerSubtype(CoAPEndpoint.class,"coap");  	 
  
    	 
    	
        return new GsonBuilder()
        		.registerTypeAdapterFactory(bindingSchemeTypeFactory)
        		.registerTypeAdapterFactory(propertyTypeFactory)
        		.registerTypeAdapter(IThing.class, InterfaceSerializer.interfaceSerializer((SmartThing.class)))
        		.registerTypeAdapter(IProperty.class, InterfaceSerializer.interfaceSerializer((ThingProperty.class)))
        		.registerTypeAdapter(IEvent.class, InterfaceSerializer.interfaceSerializer((ThingEvent.class)))
        		.registerTypeAdapter(IAction.class, InterfaceSerializer.interfaceSerializer((ThingAction.class)))
        		.registerTypeAdapter(IMetadata.class, InterfaceSerializer.interfaceSerializer((ThingMetadata.class)))
                .disableHtmlEscaping()
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls();
    }

    
}
