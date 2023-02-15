package com.github.colingrime.vehicles.manager;

import com.github.colingrime.company.DeliveryCompany;
import com.github.colingrime.config.Settings;
import com.github.colingrime.events.implementation.truck.TruckCrossEvent;
import com.github.colingrime.vehicles.Vehicle;
import com.github.colingrime.vehicles.VehicleType;
import com.github.colingrime.vehicles.cache.VehicleCache;
import com.github.colingrime.vehicles.implementation.DeliveryVehicle;
import com.github.colingrime.vehicles.implementation.Truck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages the various vehicles.
 */
public class VehicleManager {

	private final DeliveryCompany company;
	private final Map<VehicleType, VehicleCache> cache = new HashMap<>();
	private final List<Truck> trucks = new ArrayList<>();

	public VehicleManager(DeliveryCompany company) {
		this.company = company;
		this.cache.put(VehicleType.DRONE, new VehicleCache(Settings.DRONE_PACKAGES));
		this.cache.put(VehicleType.TRUCK, new VehicleCache(Settings.TRUCK_PACKAGES));
	}

	public void handleDeparture(VehicleType type, int time) {
		// Start the delivery.
		Vehicle vehicle = Vehicle.create(company, type);
		vehicle.start(time);

		// Update the vehicle type data if it's a delivery vehicle.
		if (vehicle instanceof DeliveryVehicle deliveryVehicle) {
			VehicleCache vehicleCache = cache.get(type);
			vehicleCache.deliverPackages(deliveryVehicle.getLoadCapacity());
			vehicleCache.setTimeToNextDeparture(time + deliveryVehicle.getDepartInterval());
		}
	}

	public void handleTruckRelease(int time) {
		for (Truck truck : trucks) {
			new TruckCrossEvent(company, truck, time++);
		}

		trucks.clear();
	}

	public VehicleCache getCache(VehicleType type) {
		return cache.get(type);
	}

	public List<Truck> getTrucks() {
		return trucks;
	}
}
