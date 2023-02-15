package com.github.colingrime.events.implementation.vehicle;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.events.implementation.TimedEvent;
import com.github.colingrime.vehicles.VehicleType;
import com.github.colingrime.vehicles.cache.VehicleCache;

public class VehicleReadyEvent extends TimedEvent {

	private final VehicleType type;

	public VehicleReadyEvent(DeliveryCompany company, VehicleType type, int time) {
		super(company, null, time);
		this.type = type;
	}

	@Override
	protected void executeEvent(int time) {
		VehicleCache cache = company.getVehicleManager().getCache(type);

		// If the type of vehicle still has packages to deliver, try to depart another one.
		if (cache.getPackagesLeft() > 0) {
			company.getVehicleManager().handleDeparture(type, time);
			new VehicleReadyEvent(company, type, cache.getTimeToNextDeparture());
		}
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public String toString() {
		return null;
	}
}
