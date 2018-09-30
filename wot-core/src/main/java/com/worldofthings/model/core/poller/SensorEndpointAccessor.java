package com.worldofthings.model.core.poller;

public class SensorEndpointAccessor {
	
	SensorMetrics sensorMetrics;
	
	SensorEndpointAccessor(){
		this.sensorMetrics = new SensorMetrics();
	}
	
	public SensorEndpointAccessor(SensorMetrics sensorMetrics){
		this.sensorMetrics = sensorMetrics;
	}

    

	public SensorMetrics getSensorMetrics() {
		return sensorMetrics;
	}

}