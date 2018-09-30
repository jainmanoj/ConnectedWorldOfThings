package com.worldofthings.services;

import com.worldofthings.vo.ThingletVO;

public interface ThingletService {
	
	String deployThinglet(ThingletVO thinglet);

	ThingletVO getThingletDescription(String guid);

}
