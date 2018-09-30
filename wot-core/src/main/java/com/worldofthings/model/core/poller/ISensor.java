package com.worldofthings.model.core.poller;

import com.worldofthings.model.core.ValueType;

public interface ISensor<T> {
	
	public void attachSensorToThing(SensorPoller sensorPoller);
	void startPolling();
	void notifyChange(String string);
	void notifyChange(ValueType<T> valueType);

}
