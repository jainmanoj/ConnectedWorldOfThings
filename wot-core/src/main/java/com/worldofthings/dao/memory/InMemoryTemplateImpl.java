package com.worldofthings.dao.memory;


import org.springframework.stereotype.Service;

import com.worldofthings.vo.ThingletVO;



@Service("InMemoryTemplate")
public class InMemoryTemplateImpl implements InMemoryTemplate {
	
	ThingletOceanInMemoryRepository repo = ThingletOceanInMemoryRepository.getInstance();

	@Override
	public String addThinglet(ThingletVO thingletVO) {
		return repo.addThinglet(thingletVO);
		
	}
	
	@Override
	public ThingletVO getThingletById(String id) {
		return repo.findThingletById(id);
	}

	@Override
	public int deleteThingletById(String id) {
		return repo.deleteById(id);

	}


	
 
}
