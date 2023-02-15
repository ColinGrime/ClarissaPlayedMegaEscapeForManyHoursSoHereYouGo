package com.github.colingrime.events.implementation.truck;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.config.Settings;
import com.github.colingrime.events.implementation.TimedEvent;
import com.github.colingrime.vehicles.implementation.DeliveryVehicle;
import com.github.colingrime.vehicles.implementation.Truck;

public class TruckCrossEvent extends TimedEvent {

	public TruckCrossEvent(DeliveryCompany company, Truck vehicle, int time) {
		super(company, vehicle, time);
	}

	@Override
	protected void executeEvent(int time) {
		if (company.isBlocked()) {
			new TruckWaitEvent(company, (Truck) vehicle, time);
		} else {
			DeliveryVehicle deliveryVehicle = (DeliveryVehicle) vehicle;
			int endTime = time + (Settings.DISTANCE_FROM_CROSSING / deliveryVehicle.getTravelSpeed());
			new TruckCompleteEvent(company, (Truck) vehicle, endTime);
		}
	}

	@Override
	public String getDescription() {
		return "Crossing the railroad.";
	}

	@Override
	public String toString() {
		return company.isBlocked() ? null : super.toString();
	}
}
