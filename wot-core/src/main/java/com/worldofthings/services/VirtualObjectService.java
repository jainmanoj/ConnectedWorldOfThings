package com.worldofthings.services;

import java.util.Date;
import java.util.List;

import com.worldofthings.vo.VirtualObjectVO;

public interface VirtualObjectService {
	void addVirtualObjectVO(VirtualObjectVO virtualObjectVO);
	List<VirtualObjectVO> getAllVirtualObjectVO() ;
	VirtualObjectVO getVirtualObjectVOBySource(String source);
	VirtualObjectVO getVirtualObjectVOByTimestamp(Date timestamp);
	List<VirtualObjectVO> getVirtualObjectVOWithTimeRange(String timeStamp, int range);

}
