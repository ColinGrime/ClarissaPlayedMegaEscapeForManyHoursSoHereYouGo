package com.github.colingrime.vehicles.cache;

/**
 * Represents all the data we care about for each vehicle type (not individual vehicle).
 */
public class VehicleCache {

	private int packagesLeft;
	private int timeToNextDeparture = -1;

	public VehicleCache(int packagesLeft) {
		this.packagesLeft = packagesLeft;
	}

	public int getPackagesLeft() {
		return packagesLeft;
	}

	public void deliverPackages(int amount) {
		packagesLeft -= amount;
	}

	public int getTimeToNextDeparture() {
		return timeToNextDeparture;
	}

	public void setTimeToNextDeparture(int timeToNextDeparture) {
		this.timeToNextDeparture = timeToNextDeparture;
	}
}
