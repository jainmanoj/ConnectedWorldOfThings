package com.worldofthings.model.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;



public class SmartTopologyStore {
	private static SmartTopologyStore instance = new SmartTopologyStore();
	private final ConcurrentMap<String, IThing> smartTopologyStoreMap;

	private SmartTopologyStore() {
		smartTopologyStoreMap = new ConcurrentHashMap<String, IThing>();
	}

	public static synchronized SmartTopologyStore getInstance() {
		return instance;
	}

	public void addTopologyObject(IThing topoObject) {
		smartTopologyStoreMap.put(topoObject.getNameSpace() + "::"+ topoObject.getName(), topoObject);
	}

	public IThing getTopologyObject(String modelTypeKey) {
		return smartTopologyStoreMap.get(modelTypeKey);
	}
	
	public void addAllTopologyObject(List<IThing> topoObjects) {
		for(IThing topoObject : topoObjects){
			smartTopologyStoreMap.put(topoObject.getNameSpace() + "::"+ topoObject.getName(), topoObject);
		}
	}
	
	public void addAllTopologyObject(Collection<IThing> topoObjects) {
		for(IThing topoObject : topoObjects){
			smartTopologyStoreMap.put(topoObject.getNameSpace() + "::"+ topoObject.getName(), topoObject);
		}
		
	}
	public List<IThing>  getAllTopologyObject() {
		List<IThing> topoObjects = new ArrayList<IThing>();

		for(Entry<String, IThing> entry: smartTopologyStoreMap.entrySet()){
			topoObjects.add(entry.getValue());
		}
		return topoObjects;
	}

	public void dumpTopology() {
		System.out.println("\n\n*********Dumping topology**********\n\n");
		for(IThing topoElement : getAllTopologyObject()){
			System.out.println(topoElement.toJson());
			
		}
		
	}

}
