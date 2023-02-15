package com.github.colingrime.vehicles;

/**
 * The different vehicle types offered by Clarissa's delivery company.
 */
public enum VehicleType {

	TRUCK("Truck"),
	DRONE("Drone"),
	TRAIN("Train");

	private final String name;

	VehicleType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
