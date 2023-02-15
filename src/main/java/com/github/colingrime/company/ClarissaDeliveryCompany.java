package com.github.colingrime.company;

import com.github.colingrime.LogWriter;
import com.github.colingrime.config.Settings;
import com.github.colingrime.events.implementation.TimedEvent;
import com.github.colingrime.events.implementation.vehicle.VehicleReadyEvent;
import com.github.colingrime.vehicles.VehicleType;
import com.github.colingrime.vehicles.manager.VehicleManager;
import com.github.colingrime.vehicles.reader.TrainReader;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ClarissaDeliveryCompany implements DeliveryCompany {

	private final LogWriter logger;
	private final Map<Integer, Integer> trainTimes;
	private final Queue<TimedEvent> timedEvents = new PriorityQueue<>();

	private VehicleManager manager;
	private boolean isBlocked = false;
	private int deliveryFinished = -1;

	public ClarissaDeliveryCompany(LogWriter logger, TrainReader trainReader) {
		this.logger = logger;
		this.trainTimes = trainReader.readTrainTimes();
	}

	@Override
	public void startService() {
		manager = new VehicleManager(this);

		// Load in all the train blockage events.
		for (int startTime : trainTimes.keySet()) {
			manager.handleDeparture(VehicleType.TRAIN, startTime);
		}

		// Load in the vehicle ready events.
		for (VehicleType type : VehicleType.values()) {
			if (type == VehicleType.TRAIN) {
				continue;
			}

			new VehicleReadyEvent(this, type, 0);
		}

		// Begin the simulation!!
		while (timedEvents.size() > 0) {
			timedEvents.poll().execute();
		}
	}

	@Override
	public void endService() {
		logger.log("Delivery took " + deliveryFinished + " seconds using " + (Settings.PERCENT_BY_DRONE * 100) + "% drones!");
	}

	@Override
	public Map<Integer, Integer> getTrainTimes() {
		return trainTimes;
	}

	@Override
	public LogWriter getLogger() {
		return logger;
	}

	@Override
	public Queue<TimedEvent> getTimedEvents() {
		return timedEvents;
	}

	@Override
	public VehicleManager getVehicleManager() {
		return manager;
	}

	@Override
	public boolean isBlocked() {
		return isBlocked;
	}

	@Override
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	@Override
	public int getDeliveryFinished() {
		return deliveryFinished;
	}

	@Override
	public void setDeliveryFinished(int deliveryFinished) {
		this.deliveryFinished = deliveryFinished;
	}
}
