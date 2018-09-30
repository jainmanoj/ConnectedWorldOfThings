package com.worldofthings.model.core.poller;

import com.worldofthings.model.core.ValueType;

public class SensorPollerListener<T> implements ISensor<T> {

	SensorPoller sensorPoller;
	String sensorPollerThingName;
	MetricChangeDetector<T> changeDectector;

	public SensorPollerListener(String thingName, SensorPoller sensorPoller, MetricChangeDetector<T> changeDectector) {
		this.sensorPollerThingName = thingName;
		this.sensorPoller = sensorPoller;
		this.changeDectector = changeDectector;
		attachSensorToThing(this.sensorPoller);
	}

	@Override
	public void attachSensorToThing(SensorPoller sensorPoller) {
		this.sensorPoller = sensorPoller;
		sensorPoller.setPollerLisener(this);

	}

	@Override
	public void startPolling() {
		sensorPoller.startPolling();

	}

	@Override
	public void notifyChange(String change) {
		// if(this.changeDectector.evaluateConditionFunction(null, new ValueType(70.0)))
		// {
		// System.out.println(sensorPollerThingName+" evaluateConditionFunction "+
		// change);
		// } else {
		// System.out.println(sensorPollerThingName+" notifyChange local "+ change);
		// }

	}

	@Override
	public void notifyChange(ValueType<T> valueType) {
		if (this.changeDectector.evaluateConditionFunction(valueType)) {
			System.out.println(sensorPollerThingName + "  evaluateConditionFunction " + valueType.toString());
		} else {
			// System.out.println(sensorPollerThingName+" notifyChange local "+
			// valueType.toString());
		}

	}

}
