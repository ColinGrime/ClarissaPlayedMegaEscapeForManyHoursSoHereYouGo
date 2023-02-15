package com.github.colingrime.events.implementation.vehicle;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.config.Settings;
import com.github.colingrime.events.implementation.TimedEvent;
import com.github.colingrime.vehicles.implementation.DeliveryVehicle;

public class VehicleStartEvent extends TimedEvent {

	public VehicleStartEvent(DeliveryCompany company, DeliveryVehicle vehicle, int time) {
		super(company, vehicle, time);
	}

	@Override
	protected void executeEvent(int time) {
		DeliveryVehicle deliveryVehicle = (DeliveryVehicle) vehicle;
		int endTime = time + (Settings.TOTAL_DISTANCE / deliveryVehicle.getTravelSpeed());
		new VehicleCompleteEvent(company, deliveryVehicle, endTime);
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
