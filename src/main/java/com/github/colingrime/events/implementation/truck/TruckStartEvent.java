package com.github.colingrime.events.implementation.truck;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.config.Settings;
import com.github.colingrime.events.implementation.TimedEvent;
import com.github.colingrime.vehicles.implementation.DeliveryVehicle;
import com.github.colingrime.vehicles.implementation.Truck;

public class TruckStartEvent extends TimedEvent {

	public TruckStartEvent(DeliveryCompany company, Truck vehicle, int time) {
		super(company, vehicle, time);
	}

	@Override
	protected void executeEvent(int time) {
		DeliveryVehicle deliveryVehicle = (DeliveryVehicle) vehicle;
		int crossTime = time + (Settings.DISTANCE_TO_CROSSING / deliveryVehicle.getTravelSpeed());
		new TruckCrossEvent(company, (Truck) vehicle, crossTime);
	}

	@Override
	public String getDescription() {
		return "Delivery has begun.";
	}
}
