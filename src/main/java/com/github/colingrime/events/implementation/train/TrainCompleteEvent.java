package com.github.colingrime.events.implementation.train;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.events.implementation.TimedEvent;
import com.github.colingrime.vehicles.implementation.Train;

public class TrainCompleteEvent extends TimedEvent {

	public TrainCompleteEvent(DeliveryCompany company, Train vehicle, int time) {
		super(company, vehicle, time);
	}

	@Override
	protected void executeEvent(int time) {
		company.setBlocked(false);
		company.getVehicleManager().handleTruckRelease(time);
	}

	@Override
	public String getDescription() {
		return "No longer blocking -- past the crossing.";
	}
}
