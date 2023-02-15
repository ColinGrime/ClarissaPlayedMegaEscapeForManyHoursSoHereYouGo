package com.github.colingrime.vehicles;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.vehicles.implementation.Drone;
import com.github.colingrime.vehicles.implementation.Train;
import com.github.colingrime.vehicles.implementation.Truck;

/**
 * Represents a vehicle in the delivery company. 🚗🚗
 */
public interface Vehicle {

	/**
	 * Creates a new vehicle corresponding to the specified type.
	 * @param type type of vehicle to create
	 * @return Vehicle associated with the type
	 */
	static Vehicle create(DeliveryCompany deliveryCompany, VehicleType type) {
		return switch (type) {
			case TRUCK -> new Truck(deliveryCompany);
			case DRONE -> new Drone(deliveryCompany);
			case TRAIN -> new Train(deliveryCompany);
		};
	}

	/**
	 * Starts the vehicle.
	 * @param time the time the vehicle was started at
	 */
	void start(int time);

	/**
	 * @return the type of vehicle
	 */
	VehicleType getType();
}
