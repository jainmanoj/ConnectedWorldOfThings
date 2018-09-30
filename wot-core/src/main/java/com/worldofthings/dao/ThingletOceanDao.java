package com.worldofthings.dao;

import com.worldofthings.vo.ThingletVO;

public interface ThingletOceanDao {
	

    ThingletVO getById(String id);

    int deleteById(String id);

    String persist(ThingletVO thingletVO);

    ThingletVO merge(ThingletVO thingletVO);

}
