package com.github.colingrime.events.implementation.truck;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.events.implementation.TimedEvent;
import com.github.colingrime.vehicles.implementation.Truck;

public class TruckWaitEvent extends TimedEvent {

	public TruckWaitEvent(DeliveryCompany company, Truck vehicle, int time) {
		super(company, vehicle, time);
	}

	@Override
	protected void executeEvent(int time) {
		company.getVehicleManager().getTrucks().add((Truck) vehicle);
	}

	@Override
	public String getDescription() {
		return "Delivery is blocked -- waiting.";
	}
}
