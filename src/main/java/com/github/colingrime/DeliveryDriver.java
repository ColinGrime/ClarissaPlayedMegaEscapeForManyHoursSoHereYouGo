package com.github.colingrime;

import com.github.colingrime.company.ClarissaDeliveryCompany;
import com.github.colingrime.vehicles.reader.TrainReader;

/*
 * Clarissa's project's idea thing:
 * - A delivery company wants to achieve an optimal ratio of drones vs. trucks.
 * - Why? To achieve the shortest possible delivery time (optimization, let's go~).
 *
 * Let's talk business:
 * - The company delivery 1,500 packages a day (wow!).
 * - However, an unidentified terrorist planted a railroad crossing to sabotage the delivery company.
 * - The distance to this railroad crossing is 3,000 units.
 * - From there, you go an additional 27,000 units to reach your constant destination.
 *
 * Relevant:
 * - Truck{speed=30, capacity=10, departInterval=15}
 * - Drone{speed=500, capacity=1, departInterval=3}
 * - TrainSchedule{times=[]} -- provided in train_schedule.txt
 * - PERCENT_BY_DRONE constant -- required ig.
 *
 * Events{time=?, vehicleType=Truck|Train, vehicleUniqueID=?, eventDescription=?}:
 * - TruckStartEvent -- called when a truck starts its ascent.
 * - TruckCrossEvent -- called when a truck is crossing the railroad.
 * - TruckWaitEvent (lol imagine waiting) -- called when a truck is blocked by some object.
 * - TruckCompleteEvent -- called when a truck has completed its delivery.
 * - TrainBlockEvent -- called when a train is blocking the railroad.
 * - TrainCompleteEvent -- called when a train has completed its blockage of the railroad.
 *
 * Statistics:
 * - startTime/endTime -- for each train.
 * - truckWaitTime/truckTripTime -- for each truck.
 * - truckAvgWaitTime/truckAvgTripTime/truckTotalTripTime -- altogether stuffs.
 * - droneTime, droneTotalTripTime -- drones!
 * - totalTripTime -- conclusion.
 */
public class DeliveryDriver {

	private static final String INPUT_FILE = "train_schedule";

	public static void main(String[] args) {
		TrainReader trainReader = new TrainReader(INPUT_FILE);
		if (trainReader.getInputStream() == null) {
			System.out.println("Delivery Simulator has now been terminated.");
			return;
		}

		LogWriter logger = new LogWriter(INPUT_FILE);
		ClarissaDeliveryCompany delivery = new ClarissaDeliveryCompany(logger, trainReader);

		// The daily delivery service begins!! 😎
		delivery.startService();
		logger.log("");
		logger.log("Input file used: " + INPUT_FILE + ".txt");
		delivery.endService();
	}
}
