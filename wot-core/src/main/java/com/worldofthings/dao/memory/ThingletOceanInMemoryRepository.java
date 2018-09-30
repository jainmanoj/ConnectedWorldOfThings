package com.worldofthings.dao.memory;

import com.worldofthings.vo.ThingletVO;




import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class ThingletOceanInMemoryRepository {
	
	
	private static ThingletOceanInMemoryRepository instance;
	ConcurrentHashMap<String, ThingletVO> thingletsOcean;

    
    private ThingletOceanInMemoryRepository(){
    	thingletsOcean = new ConcurrentHashMap<String, ThingletVO>();
    }
    
    public static synchronized ThingletOceanInMemoryRepository getInstance(){
        if(instance == null){
            instance = new ThingletOceanInMemoryRepository();
        }
        return instance;
    }
    
	
    public ThingletVO findThingletById(String thingletGuid){
    	return thingletsOcean.get(thingletGuid);
    }

	public int deleteById(String id) {
		thingletsOcean.remove(id);
		return 0;
	}

	public String addThinglet(ThingletVO thinglet) {
    	String thingletGuid = UUID.randomUUID().toString();
    	thingletsOcean.put(thingletGuid, thinglet);
    	return thingletGuid;
	}


}
