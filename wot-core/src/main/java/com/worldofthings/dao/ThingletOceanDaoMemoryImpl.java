package com.worldofthings.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.worldofthings.dao.memory.InMemoryTemplate;
import com.worldofthings.vo.ThingletVO;

@Repository
@Qualifier("memory")
public class ThingletOceanDaoMemoryImpl implements ThingletOceanDao {
	
	@Autowired
	protected InMemoryTemplate template;

	@Override
	public ThingletVO getById(String id) {
		return template.getThingletById(id);
	}

	@Override
	public int deleteById(String id) {
		return template.deleteThingletById(id);
	}

	@Override
	public String persist(ThingletVO thingletVO) {
		return template.addThinglet(thingletVO);
		
	}

	@Override
	public ThingletVO merge(ThingletVO thingletVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
