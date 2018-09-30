package com.worldofthings.model.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;
import java.util.function.BiFunction;

import javax.xml.bind.JAXBException;

import com.google.common.base.Functions;
import com.worldofthings.common.DIRECTIONS;
import com.worldofthings.common.DTYPES;
import com.worldofthings.model.core.poller.ChangePropogator;
import com.worldofthings.model.core.poller.ICallback;
import com.worldofthings.model.core.poller.MetricChangeDetector;
import com.worldofthings.model.core.poller.SensorEndpointAccessor;
import com.worldofthings.model.core.poller.SensorMetrics;
import com.worldofthings.model.core.poller.SensorPoller;
import com.worldofthings.model.core.poller.SensorPollerListener;





public class SimpleSmartThing {
	
	//private SmartTopologyStore topologyStore= SmartTopologyStore.getInstance();
	
	public SimpleSmartThing(){
		
	}
	
	public IThing buildSmartCarSkelton() throws SmartThingException{
		IThing car1 = new SmartThing("ManojCar","ManojWorld","Car");
		
		ThingProperty carProperty = new ThingProperty("Power",DTYPES.INTEGER.name(),"1400");
		car1.addProperty(carProperty);
		carProperty = new ThingProperty("Color",DTYPES.STRING.name(),"Platinum");
		car1.addProperty(carProperty);

		ThingMetadata carMetadata = new ThingMetadata("Owner",DTYPES.STRING.name(),"Manoj");
		car1.addMetadata(carMetadata);
		carMetadata = new ThingMetadata("Location",DTYPES.STRING.name(),"Banglore");
		car1.addMetadata(carMetadata);	
		
		
		SmartThing car1wheel1 = new SmartThing("Car1Wheel1","ManojWorld","Wheel");
		
		ThingEvent wheel1lowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.DOUBLE.name(),"0000.00");
		wheel1lowTyrePressure.setPropogation(true, "WheelSensor", "InstrumentedBy",SmartFunction.Aggregate);
		car1wheel1.addEvent(wheel1lowTyrePressure);

		SmartThing car1wheel1Sensor = new SmartThing("Car1Wheel1Sensor","ManojWorld","WheelSensor");
		ThingEvent wheel1SensorlowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.DOUBLE.name(),"0000.00");
		car1wheel1Sensor.addEvent(wheel1SensorlowTyrePressure);
		
		
		car1wheel1.addRelationships("InstrumentedBy",car1wheel1Sensor); 
		car1wheel1.addRelationships("PartOf",car1,DIRECTIONS.REVERSE);
		
		IThing car1sensor = new SmartThing("VehicleSensor1","ManojWorld","VehicleSensor");
		car1.addRelationships("InstrumentedBy",new ArrayList<IThing> (Arrays.asList(car1sensor)));
		
		
		//ThingEvent(String eventName, String type, String value, Boolean isPropogated, String sourceClassType, String sourceObjectChannel )
		ThingEvent car1AggregatedlowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.DOUBLE.name(),"0000.00");
		car1AggregatedlowTyrePressure.setPropogation(true, "Wheel", "ComposedOf", WOTFunctions.AGGREGATEEVENT());
		car1.addEvent(car1AggregatedlowTyrePressure);
		
		
		IAction carAction  = new ThingAction("CALLSERVICECENTER", new ValueType<Float>(new Float(19.3)), new ValueType<Boolean>(new Boolean(false) ));
		car1.addAction(carAction);
		
		//ThingBehavior car1StearingWobbling = ThingBehavior("StearingWobbling", WOTFunctions.LOGICALANDEVENT("LowTyrePressure","LowTyrePressure","CALLSERVICECENTER"));
		ThingBehavior car1StearingWobbling = new ThingBehavior("StearingWobbling", Arrays.asList("LowTyrePressure","LowTyrePressure"), "LOGICALANDEVENTS","CALLSERVICECENTER");
		car1.addBehavior(car1StearingWobbling);
		
		car1.addRelationships("InstrumentedBy",new ArrayList<IThing> (Arrays.asList(car1sensor)));
		
		car1.addRelationships("ComposedOf",new ArrayList<IThing> (  Arrays.asList(car1wheel1) ) );

		

		
//		car1.setIsLiving(true);
//		car1.infuseLife(1000);//beats every 1000 minutes
//		
//		car1.hertbeatTask();

		SensorMetrics sensorMetrics = new SensorMetrics("TyrePressure",new ValueType<Double>(0.0));
		SensorEndpointAccessor accessor = new SensorEndpointAccessor(sensorMetrics);
		
		ICallback changePropogatorFn=new ChangePropogator(car1wheel1Sensor,"LowTyrePressure");
		WOTFunctions.LESSTHANEQUALTO(new ValueType<Double>(5.0));WOTFunctions.GRETERTHANEQUALTO(new ValueType<Double>(98.0));
		MetricChangeDetector<ValueType> changeDectector = new MetricChangeDetector<ValueType>(
				WOTFunctions.LESSTHANEQUALTO(new ValueType(5.0)), WOTFunctions.GRETERTHANEQUALTO(new ValueType(98.0)),
				changePropogatorFn);
		//(WOTFunctions.LESSTHANEQUALTO(new ValueType<Double>(5.0)), WOTFunctions.GRETERTHANEQUALTO(new ValueType<Double>(98.0)) ,changePropogatorFn);
		SensorPollerListener spl = new SensorPollerListener(car1wheel1Sensor.getName(),new SensorPoller(accessor,0, 1, 20),changeDectector);
		car1wheel1Sensor.attachSensorToThing(spl);
		car1wheel1Sensor.startPolling();
		
		return car1;
		
	}
	

	
	public static void main( String[] args ) throws  SmartThingException, JAXBException, IOException{
		
		SimpleSmartThing smartWorldOfThing = new SimpleSmartThing();
		IThing mycar=smartWorldOfThing.buildSmartCarSkelton();
		System.out.println(mycar.toJson());
		
		
	}



}
