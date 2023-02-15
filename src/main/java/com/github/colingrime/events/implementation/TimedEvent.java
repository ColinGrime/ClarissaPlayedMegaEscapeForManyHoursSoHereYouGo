package com.github.colingrime.events.implementation;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.events.Event;
import com.github.colingrime.vehicles.Vehicle;

/**
 * Represents an event that can occur in the simulation.
 */
public abstract class TimedEvent implements Event, Comparable<TimedEvent> {

	protected final DeliveryCompany company;
	protected final Vehicle vehicle;
	protected final int time;

	public TimedEvent(DeliveryCompany company, Vehicle vehicle, int time) {
		this.company = company;
		this.vehicle = vehicle;
		this.time = time;
		company.getTimedEvents().add(this);
	}

	@Override
	public void execute() {
		company.getLogger().log(toString() == null ? null : toString());
		executeEvent(time);
	}

	@Override
	public int compareTo(TimedEvent o) {
		return Double.compare(time, o.time);
	}

	@Override
	public String toString() {
		return String.format("[%d] " + vehicle + " -- " + getDescription(), time);
	}

	/**
	 * Executes a specific event for the delivery company.
	 */
	protected abstract void executeEvent(int time);
}
