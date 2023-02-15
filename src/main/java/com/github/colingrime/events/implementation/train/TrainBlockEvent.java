package com.github.colingrime.events.implementation.train;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.events.implementation.TimedEvent;
import com.github.colingrime.vehicles.implementation.Train;

public class TrainBlockEvent extends TimedEvent {

	private final int endTime;

	public TrainBlockEvent(DeliveryCompany company, Train vehicle, int startTime, int endTime) {
		super(company, vehicle, startTime);
		this.endTime = endTime;
	}

	@Override
	protected void executeEvent(int time) {
		company.setBlocked(true);
		new TrainCompleteEvent(company, (Train) vehicle, endTime);
	}

	@Override
	public String getDescription() {
		return "Entered the crossing -- now blocking.";
	}
}
