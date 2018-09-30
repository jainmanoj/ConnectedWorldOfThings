package com.worldofthings.model.core.poller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SensorPoller {

	/** If invocations might overlap, you can specify more than a single thread. */
	private static final int NUM_THREADS = 1;
	// private static final boolean DONT_INTERRUPT_IF_RUNNING = false;

	private final ScheduledExecutorService fScheduler;
	private final long fInitialDelay;
	private final long pollingFreq;
	// private final long fShutdownAfter;
	ISensor sensorPollerListener;
	SensorEndpointAccessor accessor;

	public SensorPoller(SensorEndpointAccessor accessor, long aInitialDelay, long pollingFreq,
			long aStopAfter) {
		this.fInitialDelay = aInitialDelay;
		this.pollingFreq = pollingFreq;
		// this.fShutdownAfter = aStopAfter;
		fScheduler = Executors.newScheduledThreadPool(NUM_THREADS);
		this.accessor=accessor;
	}

	public void setPollerLisener(ISensor sensorListner) {
		this.sensorPollerListener = sensorListner;
	}

	// private void notifyLastPollValue(String aMsg) {
	// System.out.println(aMsg);
	// }

	/** Sound the alarm for a few seconds, then stop. */
	void startPolling() {
		Runnable pollingTask = new PollerTaskStart(accessor,sensorPollerListener);
		// ScheduledFuture<?> soundAlarmFuture =
		fScheduler.scheduleWithFixedDelay(pollingTask, fInitialDelay, pollingFreq, TimeUnit.SECONDS);
	}

}
