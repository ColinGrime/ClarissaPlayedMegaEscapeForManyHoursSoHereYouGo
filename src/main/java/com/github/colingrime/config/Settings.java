package com.github.colingrime.config;

// Way too lazy to not make these public static lol
public class Settings {

	public static final double PERCENT_BY_DRONE = 0.35;      // Percent of packages that will be delivered by drones.

	public static final int TOTAL_PACKAGES = 1_500;          // Total packages the company will deliver.
	public static final int DRONE_PACKAGES;                  // Total packages the drones will deliver.
	public static final int TRUCK_PACKAGES;                  // Total packages the trucks will deliver.

	public static final int TOTAL_DISTANCE;					 // Total distance to complete the delivery.
	public static final int DISTANCE_TO_CROSSING = 3_000;    // Distance to the train crossing.
	public static final int DISTANCE_FROM_CROSSING = 27_000; // Distance from the train crossing to the destination.

	static {
		DRONE_PACKAGES = (int) Math.ceil(TOTAL_PACKAGES * PERCENT_BY_DRONE);
		TRUCK_PACKAGES = (int) Math.ceil(TOTAL_PACKAGES * (1 - PERCENT_BY_DRONE));

		TOTAL_DISTANCE = DISTANCE_TO_CROSSING + DISTANCE_FROM_CROSSING;
	}
}
