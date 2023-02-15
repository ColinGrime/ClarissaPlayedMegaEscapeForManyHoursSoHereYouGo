package com.github.colingrime.events.implementation.truck;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.events.implementation.TimedEvent;
import com.github.colingrime.vehicles.implementation.Truck;

public class TruckCompleteEvent extends TimedEvent {

	public TruckCompleteEvent(DeliveryCompany company, Truck vehicle, int time) {
		super(company, vehicle, time);
	}

	@Override
	protected void executeEvent(int time) {
		company.setDeliveryFinished(time);
	}

	@Override
	public String getDescription() {
		return "Delivery is complete.";
	}
}
