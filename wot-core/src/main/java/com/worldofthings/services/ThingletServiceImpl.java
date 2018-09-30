package com.worldofthings.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldofthings.dao.ThingletOceanDao;
import com.worldofthings.vo.ThingletVO;

@Service("thingletService")
public class ThingletServiceImpl implements ThingletService{

	
	@Autowired
	ThingletOceanDao thingletOceanDao;
	@Override
	public String deployThinglet(ThingletVO thinglet) {
		return thingletOceanDao.persist(thinglet);
	}
	@Override
	public ThingletVO getThingletDescription(String guid) {
		return thingletOceanDao.getById(guid);
		
	}
	
	

}
