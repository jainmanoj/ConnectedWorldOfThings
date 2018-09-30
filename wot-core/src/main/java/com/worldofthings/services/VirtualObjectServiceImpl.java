package com.worldofthings.services;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.worldofthings.dao.PersistanceObjectDao;
import com.worldofthings.vo.VirtualObjectVO;



@Service("virtualObjectService")
public class VirtualObjectServiceImpl implements VirtualObjectService {
	
	static final Logger logger = Logger.getLogger(VirtualObjectServiceImpl.class);
	
	@Autowired
	@Qualifier("cassandra")
	PersistanceObjectDao persistanceObjectDao;
	


	@Override
	public void addVirtualObjectVO(VirtualObjectVO virtualObjectVO) {
		
		
	}


	@Override
	public List<VirtualObjectVO> getAllVirtualObjectVO() {
		return null;
	}


	@Override
	public VirtualObjectVO getVirtualObjectVOBySource(String name) {
		return persistanceObjectDao.getByName(name);
	}


	@Override
	public VirtualObjectVO getVirtualObjectVOByTimestamp(Date timestamp) {
		return null;
	}


	@Override
	public List<VirtualObjectVO> getVirtualObjectVOWithTimeRange(
			String timeStamp, int range) {
		return null;
	}
}
