package com.github.colingrime.vehicles.implementation;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.events.implementation.truck.TruckStartEvent;
import com.github.colingrime.vehicles.VehicleType;

public class Truck extends DeliveryVehicle {

	public Truck(DeliveryCompany deliveryCompany) {
		super(deliveryCompany);
	}

	@Override
	public void start(int time) {
		new TruckStartEvent(deliveryCompany, this, time);
	}

	@Override
	public VehicleType getType() {
		return VehicleType.TRUCK;
	}

	@Override
	public int getTravelSpeed() {
		return 30;
	}

	@Override
	public int getLoadCapacity() {
		return 10;
	}

	@Override
	public int getDepartInterval() {
		return 15;
	}
}
