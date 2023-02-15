package com.github.colingrime.vehicles.implementation;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.events.implementation.train.TrainBlockEvent;
import com.github.colingrime.vehicles.Vehicle;
import com.github.colingrime.vehicles.VehicleType;

public class Train implements Vehicle {

	private static int count = 1;
	private final int uniqueID;
	private final DeliveryCompany deliveryCompany;

	public Train(DeliveryCompany deliveryCompany) {
		this.uniqueID = count++;
		this.deliveryCompany = deliveryCompany;
	}

	@Override
	public void start(int time) {
		new TrainBlockEvent(deliveryCompany, this, time, deliveryCompany.getTrainTimes().get(time));
	}

	@Override
	public VehicleType getType() {
		return VehicleType.TRAIN;
	}

	@Override
	public String toString() {
		return getType().getName() + " #" + uniqueID;
	}
}
