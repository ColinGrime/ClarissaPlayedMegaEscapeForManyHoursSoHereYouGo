package com.github.colingrime.events;

public interface Event {

	/**
	 * Executes an event for the delivery company.
	 */
	void execute();

	/**
	 * @return String description describing the event
	 */
	String getDescription();
}
