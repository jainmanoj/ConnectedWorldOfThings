package com.worldofthings.model.core.poller;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.worldofthings.common.DTYPES;
import com.worldofthings.model.core.ValueType;

public class PollerTaskStart implements Runnable {
	SensorEndpointAccessor accessor;
	private ISensor sensorPollerListener;

	public PollerTaskStart(ISensor sensorPollerListener) {
		this.sensorPollerListener = sensorPollerListener;
	}

	public PollerTaskStart(SensorEndpointAccessor accessor, ISensor sensorPollerListener) {
		this.sensorPollerListener = sensorPollerListener;
		this.accessor = accessor;
		//System.out.println("Creating PollerTaskStart instance ");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		CompletableFuture<SensorEndpointAccessor> lsensorAccessor = CompletableFuture.supplyAsync(() -> {
			// System.out.println("Creating summary object");
			 //return new SensorEndpointAccessor();
			return this.accessor;
		}).thenCompose((SensorEndpointAccessor metricInstance) -> CompletableFuture.supplyAsync(() -> {
			 //System.out.println("Populating summary object");
			Random randomGenerator = new Random();
			double randomPressure = randomGenerator.nextDouble() * 100.00;
			//metricInstance.getSensorMetrics().setSensorMetrics(randomPressure);
			metricInstance.getSensorMetrics().setValueType(new ValueType(randomPressure));
			return metricInstance;
		}));

		// .thenCompose((SensorEndpointAccessor summaryInstance) ->
		// CompletableFuture.supplyAsync(() -> {
		// return summaryInstance;
		// }));
		
		//System.out.println("Populating summary object 2" +lsensorAccessor );

		try {
			SensorEndpointAccessor accessorr = lsensorAccessor.get();
			// CompletableFuture<String> f = CompletableFuture.supplyAsync(svc::work);
			// sensorAccessor.thenAccept(sensorPollerListener::notify);
			// System.out.println("Done!");
			//System.out.println(accessorr.getSensorMetrics().toString());
			//this.sensorPollerListener.notifyChange(accessorr.getSensorMetrics().toString());
			this.sensorPollerListener.notifyChange(accessorr.getSensorMetrics().getValueType());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
