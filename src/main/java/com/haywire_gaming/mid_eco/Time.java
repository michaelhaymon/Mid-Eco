package com.haywire_gaming.mid_eco;

public class Time {

	protected void timePassageTest() throws InterruptedException {

		Serf serf = new Serf();
		serf = serf.newSerf(null);
		System.out.println("The sun has risen.");
		Thread.sleep(3000);
		System.out.println(serf.getFirstName() + " is looking for something to do.");
		Thread.sleep(3000);
		System.out.println(serf.getFirstName() + " wishes there was something to do.");

		// Day starts
		// Serf Sleeps for period
		// Serf Wakes in house
		// Serf Walks to Stockpile in house for period.
		// Serf Takes Food.
		// Serf Eats Food for period.
		// Serf Walks to R.A.P. for period.
		// Serf Acquires Resource for period.
		// Serf Walks back to house for period.
		// Serf Gives Resource to Stockpile.
		// Serf Sleeps for period.
		// Day Ends.

	}

	protected static long getCurrentTime() {
		return System.currentTimeMillis();
	}

	protected void insertEvent() {
		// TODO this should insert an event into the current list of events.
	}
}
