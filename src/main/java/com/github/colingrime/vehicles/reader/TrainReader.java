package com.github.colingrime.vehicles.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Responsible for reading the train schedule data. 🚆🚆
 */
public class TrainReader {

	private final String path;

	public TrainReader(String path) {
		this.path = path.endsWith(".txt") ? path : path + ".txt";
	}

	/**
	 * Gets the InputStream of the train data.
	 * @return InputStream of the instance's path field
	 */
	public InputStream getInputStream() {
		InputStream stream = getClass().getResourceAsStream("/input/" + path);
		if (stream == null) {
			System.out.println("The path \"" + path + "\" does not exist.");
			return null;
		}
		return stream;
	}

	/**
	 * Gets all the train blockage times.
	 * @return train blockage times
	 */
	public Map<Integer, Integer> readTrainTimes() {
		Map<Integer, Integer> trainTimes = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(getInputStream()))) {
			reader.lines().map(this::parseTrainTime).filter(Objects::nonNull).forEach(e -> trainTimes.put(e.getKey(), e.getValue()));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		System.out.println(trainTimes.size() + " train times have been read.");
		return trainTimes;
	}

	/**
	 * Parses a train time string into a Map Entry consisting of a startTime key and endTime value.
	 * @param timeString contains the start and end time of the train
	 * @return Map Entry consisting of a startTime key and endTime value
	 */
	private Map.Entry<Integer, Integer> parseTrainTime(String timeString) {
		String[] args = timeString.split(" ");
		if (args.length != 2) {
			return null;
		}

		try {
			int startTime = Integer.parseInt(args[0]);
			int endTime = startTime + Integer.parseInt(args[1]);
			return Map.entry(startTime, endTime);
		} catch (NumberFormatException ex) {
			return null;
		}
	}
}
