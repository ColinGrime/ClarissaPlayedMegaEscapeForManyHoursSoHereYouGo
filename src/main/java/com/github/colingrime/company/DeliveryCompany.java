package com.github.colingrime.company;

import com.github.colingrime.LogWriter;
import com.github.colingrime.events.implementation.TimedEvent;
import com.github.colingrime.vehicles.manager.VehicleManager;

import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Represents a delivery company that can delivery packages. 📦📦
 */
public interface DeliveryCompany {

	/**
	 * Starts the delivery service.
	 * This means delivering 1,500 total packages.
	 */
	void startService();

	/**
	 * Ends the delivery service.
	 * This is run when all the packages are delivered.
	 * Final statistics are calculated and logged.
	 */
	void endService();

	/**
	 * @return gets the event logger
	 */
	LogWriter getLogger();

	/**
	 * @return gets a Map of start/end times for the trains
	 */
	Map<Integer, Integer> getTrainTimes();

	/**
	 * @return gets the queue of events
	 */
	Queue<TimedEvent> getTimedEvents();

	/**
	 * @return the vehicle manager
	 */
	VehicleManager getVehicleManager();

	/**
	 * @return whether a train is currently blocking all truck movement
	 */
	boolean isBlocked();

	/**
	 * @param isBlocked true if a train is blocking, false if it isn't
	 */
	void setBlocked(boolean isBlocked);

	/**
	 * @return time that the delivery was finished
	 */
	int getDeliveryFinished();

	/**
	 * @param time time that the delivery was finished
	 */
	void setDeliveryFinished(int time);
}
