package com.worldofthings.dao.memory;

import com.worldofthings.vo.ThingletVO;




public interface InMemoryTemplate {

	ThingletVO getThingletById(String guid);

	int deleteThingletById(String guid);

	String addThinglet(ThingletVO thingletVO);





}
