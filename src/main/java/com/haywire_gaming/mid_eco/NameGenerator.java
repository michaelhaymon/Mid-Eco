package com.haywire_gaming.mid_eco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class NameGenerator {

	final static String							FEMALE_FIRST_NAMES	= "English Female First Names.txt";
	final static String							MALE_FIRST_NAMES	= "English Male First Names.txt";
	final static String							LAST_NAMES			= "English Last Names.txt";

	final protected static ArrayList<String>	firstNameArrayList	= new ArrayList<String>();
	final protected static ArrayList<String>	lastNameArrayList	= new ArrayList<String>();

	public void generateName(Person serf) {
		// Get sex of Serf
		if (serf.getSex().equals("F")) {
			// Populates with Female names
			populateNameArrayList(firstNameArrayList, FEMALE_FIRST_NAMES);
		} else {
			// Populates with Male names
			populateNameArrayList(firstNameArrayList, MALE_FIRST_NAMES);
		}
		if (serf.getMother() != null) {
			// If the Serf is born, use the mother's last name.
			lastNameArrayList.add(serf.getMother().getLastName());
		} else {
			// If the Serf is not born, then randomly generate a last name,
			populateNameArrayList(lastNameArrayList, LAST_NAMES);
		}

		int rng = new Random().nextInt(firstNameArrayList.size());
		serf.setFirstName(firstNameArrayList.get(rng).trim());
		rng = new Random().nextInt(lastNameArrayList.size());
		serf.setLastName(lastNameArrayList.get(rng).trim());
	}

	// Populates nameArrayList<> based on nameArrayList and Name text file.
	protected void populateNameArrayList(ArrayList<String> nameArrayList, String fileName) {

		try {
			// FileReader fileReader = new FileReader(fileName);
			final BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(fileName), "UTF8"));

			String line = null;

			while ((line = bufferedReader.readLine()) != null) {
				nameArrayList.add(line);
			}
			bufferedReader.close();

		} catch (final FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (final IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}

}