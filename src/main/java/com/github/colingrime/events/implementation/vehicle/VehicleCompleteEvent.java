package com.github.colingrime.events.implementation.vehicle;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.events.implementation.TimedEvent;
import com.github.colingrime.vehicles.implementation.DeliveryVehicle;

public class VehicleCompleteEvent extends TimedEvent {

	public VehicleCompleteEvent(DeliveryCompany company, DeliveryVehicle vehicle, int time) {
		super(company, vehicle, time);
	}

	@Override
	protected void executeEvent(int time) {
		company.setDeliveryFinished(time);
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
