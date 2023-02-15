package com.github.colingrime.vehicles.implementation;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.vehicles.Vehicle;
import com.github.colingrime.vehicles.VehicleType;

import java.util.HashMap;
import java.util.Map;

public abstract class DeliveryVehicle implements Vehicle {

	private static final Map<VehicleType, Integer> count = new HashMap<>();
	private final int uniqueID;
	final DeliveryCompany deliveryCompany;

	DeliveryVehicle(DeliveryCompany deliveryCompany) {
		count.put(getType(), count.getOrDefault(getType(), 0) + 1);
		this.uniqueID = count.get(getType());
		this.deliveryCompany = deliveryCompany;
	}

	@Override
	public String toString() {
		return getType().getName() + " #" + uniqueID;
	}

	/**
	 * @return int representing the vehicle's travel speed
	 */
	public abstract int getTravelSpeed();

	/**
	 * @return int representing the vehicle's package load capacity
	 */
	public abstract int getLoadCapacity();

	/**
	 * @return int representing the vehicle's cooldown after each departure
	 */
	public abstract int getDepartInterval();
}
