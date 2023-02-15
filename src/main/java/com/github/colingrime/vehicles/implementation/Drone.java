package com.github.colingrime.vehicles.implementation;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.events.implementation.vehicle.VehicleStartEvent;
import com.github.colingrime.vehicles.VehicleType;

public class Drone extends DeliveryVehicle {

	public Drone(DeliveryCompany deliveryCompany) {
		super(deliveryCompany);
	}

	@Override
	public void start(int time) {
		new VehicleStartEvent(deliveryCompany, this, time);
	}

	@Override
	public VehicleType getType() {
		return VehicleType.DRONE;
	}

	@Override
	public int getTravelSpeed() {
		return 500;
	}

	@Override
	public int getLoadCapacity() {
		return 1;
	}

	@Override
	public int getDepartInterval() {
		return 3;
	}
}
