package com.worldofthings.model.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;



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





public class SmartWorldOfThing {
	
	//private SmartTopologyStore topologyStore= SmartTopologyStore.getInstance();
	
	public SmartWorldOfThing(){
		
	}

	
	
	public IThing buildSmartCarWorld() throws SmartThingException{
		
		IThing car1 = new SmartThing("ManojCar","ManojWorld","Car");
		
		ThingProperty carProperty = new ThingProperty("Power",DTYPES.INTEGER.name(),"1400");
		car1.addProperty(carProperty);
		carProperty = new ThingProperty("Color",DTYPES.STRING.name(),"Platinum");
		car1.addProperty(carProperty);

		ThingMetadata carMetadata = new ThingMetadata("Owner",DTYPES.STRING.name(),"Manoj");
		car1.addMetadata(carMetadata);
		carMetadata = new ThingMetadata("Location",DTYPES.STRING.name(),"Banglore");
		car1.addMetadata(carMetadata);		

		

		//ThingEvent carStrearingUnstable = new ThingEvent("StrearingUnstable",DTYPES.STRING.name(),"Unstable");
		ThingEvent carStrearingUnstable = new ThingEvent("StrearingUnstable","Unstable");
		car1.addEvent(carStrearingUnstable);
		
		ThingEvent carNeedService = new ThingEvent("NeedService",DTYPES.BOOLEAN.name(),"true");
		car1.addEvent(carNeedService);
		
		ThingEvent carLowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.INTEGER.name(),"0000");
		carLowTyrePressure.setPropogation(true, "Wheel", "ComposedOf",SmartFunction.Aggregate);
		car1.addEvent(carLowTyrePressure);	
		
		
		SmartThing car1wheel1 = new SmartThing("Car1Wheel1","ManojWorld","Wheel");
		
		ThingEvent wheel1lowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.INTEGER.name(),"0001");
		wheel1lowTyrePressure.setPropogation(true, "WheelSensor", "InstrumentedBy",SmartFunction.Aggregate);
		car1wheel1.addEvent(wheel1lowTyrePressure);

		SmartThing car1wheel1Sensor = new SmartThing("Car1Wheel1Sensor","ManojWorld","WheelSensor");
		SensorMetrics sensorMetrics = new SensorMetrics("TyrePressure",new ValueType<Double>(0.0));
		SensorEndpointAccessor accessor = new SensorEndpointAccessor(sensorMetrics);


		
		ThingEvent wheel1SensorlowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.INTEGER.name(),"7301");
		car1wheel1Sensor.addEvent(wheel1SensorlowTyrePressure);
		
//		ThingChangeEvent thingChangeEvent = new ThingChangeEvent(car1wheel1Sensor);
//		car1wheel1Sensor.detectAndPropogateChangeEventToUpstream(thingChangeEvent);
		
		car1wheel1.addRelationships("InstrumentedBy",car1wheel1Sensor); 
		car1wheel1.addRelationships("PartOf",car1,DIRECTIONS.REVERSE);

		
		
		SmartThing car1wheel2 = new SmartThing("Car1Wheel2","ManojWorld","Wheel");
		ThingEvent wheel2lowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.INTEGER.name(),"0002");
		wheel2lowTyrePressure.setPropogation(true, "WheelSensor", "InstrumentedBy",SmartFunction.Aggregate);
		car1wheel2.addEvent(wheel2lowTyrePressure);
		
		SmartThing car1wheel2Sensor = new SmartThing("Car1Wheel2Sensor","ManojWorld","WheelSensor");
		ThingEvent wheel2SensorlowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.INTEGER.name(),"7302");
		car1wheel2Sensor.addEvent(wheel2SensorlowTyrePressure);
		
		car1wheel2.addRelationships("InstrumentedBy",car1wheel2Sensor); 
		car1wheel2.addRelationships("PartOf",car1,DIRECTIONS.REVERSE);
		
		SmartThing car1wheel3 = new SmartThing("Car1Wheel3","ManojWorld","Wheel");
		ThingEvent wheel3lowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.INTEGER.name(),"0003");
		wheel3lowTyrePressure.setPropogation(true, "WheelSensor", "InstrumentedBy",SmartFunction.Aggregate);
		car1wheel3.addEvent(wheel3lowTyrePressure);
		
		SmartThing car1wheel3Sensor = new SmartThing("Car1Wheel3Sensor","ManojWorld","WheelSensor");
		ThingEvent wheel3SensorlowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.INTEGER.name(),"7303");
		car1wheel3Sensor.addEvent(wheel3SensorlowTyrePressure);
		
		car1wheel3.addRelationships("InstrumentedBy",car1wheel3Sensor); 
		car1wheel3.addRelationships("PartOf",car1,DIRECTIONS.REVERSE);

		
		SmartThing car1wheel4 = new SmartThing("Car1Wheel4","ManojWorld","Wheel");
		ThingEvent wheel4lowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.INTEGER.name(),"0004");
		wheel4lowTyrePressure.setPropogation(true, "WheelSensor", "InstrumentedBy",SmartFunction.Aggregate);
		car1wheel4.addEvent(wheel4lowTyrePressure);
		
		SmartThing car1wheel4Sensor = new SmartThing("Car1Wheel4Sensor","ManojWorld","WheelSensor");
		ThingEvent wheel4SensorlowTyrePressure = new ThingEvent("LowTyrePressure",DTYPES.INTEGER.name(),"7304");
		car1wheel4Sensor.addEvent(wheel4SensorlowTyrePressure);
		
		car1wheel4.addRelationships("InstrumentedBy",car1wheel4Sensor); 
		car1wheel4.addRelationships("PartOf",car1,DIRECTIONS.REVERSE);
		
		
		car1.addRelationships("ComposedOf",new ArrayList<IThing> (  Arrays.asList(car1wheel1,car1wheel2,car1wheel3,car1wheel4) ) );

		IThing car1sensor = new SmartThing("VehicleSensor1","ManojWorld","VehicleSensor");
		car1.addRelationships("InstrumentedBy",new ArrayList<IThing> (Arrays.asList(car1sensor)));
		


		IAction carAction = new ThingAction("Accelerate",new ValueType(new Integer(100)), new ValueType(new Boolean(false) ));
		car1.addAction(carAction);
		carAction = new ThingAction("MoveTo", new ValueType(new Double(19328L)), new ValueType(new Boolean(false) ));
		car1.addAction(carAction);
		carAction = new ThingAction("SearchServiceCenter", new ValueType(new Float(19.3)), new ValueType(new Boolean(false) ));
		car1.addAction(carAction);
		carAction = new ThingAction("RegisterServiceCenter",new ValueType(new String("")), new ValueType(new Boolean(false) ));
		car1.addAction(carAction);		
		carAction = new ThingAction("NeedService",new ValueType(new String("")), new ValueType(new Boolean(false) ));
		car1.addAction(carAction);			
		
		IAction action1=car1.getAction("SearchServiceCenter");
		action1.doExecute();
		IAction action2=car1.getAction("RegisterServiceCenter");
//		action2.setValue(new ValueType(car1ServiceCenter));
//		action2.invokeAction();

		
//		IThing serviceCenter1 = new SmartThing(car1ServiceCenter.getName(),car1ServiceCenter.getNameSpace(),car1ServiceCenter.getThingClassType());
//		car1.addRelationships("ServiceBy",new ArrayList<IThing> (Arrays.asList(serviceCenter1)));

		car1.setIsLiving(true);
		car1.infuseLife(1000);//beats every 1000 minutes
		
		car1.hertbeatTask();

		//topologyStore.addAllTopologyObject( Arrays.asList(car1wheel1,car1wheel2,car1wheel3,car1wheel4,car1wheel1Sensor,car1wheel2Sensor,car1wheel3Sensor,car1wheel4Sensor,car1sensor,car1) );
		
		ICallback changePropogatorFn=new ChangePropogator(car1wheel1Sensor,"LowTyrePressure");

		MetricChangeDetector<Double> changeDectector = new MetricChangeDetector<Double>(
				WOTFunctions.LESSTHANEQUALTO(new ValueType<Double>(10.0)),
				WOTFunctions.LESSTHANEQUALTO(new ValueType<Double>(90.0)), changePropogatorFn);
		SensorPollerListener spl = new SensorPollerListener(car1wheel1Sensor.getName(),new SensorPoller(accessor,0, 1, 20),changeDectector);
		car1wheel1Sensor.attachSensorToThing(spl);
		car1wheel1Sensor.startPolling();
	
		return car1;
		

	}
	
	public IThing buildSmartServiceCenterWorld() throws SmartThingException{
		IThing serviceCenter1 = new SmartThing("ServiceCenterFord","ServiceCenterWorld","ServiceCenter");
		IAction serviceCenterAction = new ThingAction("ScheduleService",new ValueType( new Integer(100)), null );
		serviceCenter1.addAction(serviceCenterAction);
		return serviceCenter1;
		//car1.addRelationships("ServiceBy",new ArrayList<IThing> (Arrays.asList(serviceCenter1)));
	}
	private void activate(IThing mycar, IThing serviceCenter) {
		mycar.addRelationships("ServiceBy",new ArrayList<IThing> (Arrays.asList(serviceCenter)));
		serviceCenter.addRelationships("ProvideServiceTo",new ArrayList<IThing> (Arrays.asList(mycar)),DIRECTIONS.REVERSE  );
		ValueType val =mycar.getEvent("NeedService").getValue();
		if ((Boolean)val.getValueObj()){
			IAction action = mycar.getAction("NeedService");
			IThing sc1=mycar.getRelationships("ServiceBy").get(0);
			action.setValue(new ValueType(sc1));
			action.doExecute();
		}
		
		IAction actionScheduleService=serviceCenter.getAction("ScheduleService");
		actionScheduleService.setValue(new ValueType(mycar.getName()));
		actionScheduleService.doExecute();
		
		IAction moveToAction=mycar.getAction("MoveTo");
		moveToAction.setValue(new ValueType("MG ROAD"));
		moveToAction.doExecute();


		
	}
	public static void main( String[] args ) throws  SmartThingException, JAXBException, IOException{
		
		SmartWorldOfThing smartWorldOfThing = new SmartWorldOfThing();
		IThing mycar=smartWorldOfThing.buildSmartCarWorld();
//		System.out.println(mycar.toJson());
		IThing serviceCenter=smartWorldOfThing.buildSmartServiceCenterWorld();
//		System.out.println(serviceCenter.toJson());
		
		smartWorldOfThing.activate(mycar, serviceCenter);
		System.out.println(mycar.toJson());
		System.out.println(serviceCenter.toJson());
		
	}



}
