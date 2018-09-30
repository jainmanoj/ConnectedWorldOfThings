package com.worldofthings.model.core.poller;

import com.worldofthings.model.core.ValueType;

public class SensorMetrics {

	String metricName;
	ValueType valueType;

	public SensorMetrics() {
		
	}

	
	public SensorMetrics(String metricName,ValueType valueType) {
		this.metricName=metricName;
		this.valueType = valueType;
	}

    
    public ValueType getValueType() {
		return valueType;
	}

	public void setValueType(ValueType valueType) {
		this.valueType = valueType;
	}
	

	@Override
    public String toString() {
		//System.out.println(String.format("{ Sensor SensorMetrics =%s }", valueType.toString()));
        return String.format("{ Sensor SensorMetrics =%s %s}", this.metricName, valueType.toString());
    }
}