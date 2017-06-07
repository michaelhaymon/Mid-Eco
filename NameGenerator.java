import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class NameGenerator {

	final static String								FEMALE_FIRST_NAMES	= "English Female First Names.txt";
	final static String								MALE_FIRST_NAMES	= "English Male First Names.txt";
	final static String								LAST_NAMES			= "English Last Names.txt";

	final protected static HashMap<Integer, String>	firstNameHashMap	= new HashMap<Integer, String>();
	final protected static HashMap<Integer, String>	lastNameHashMap		= new HashMap<Integer, String>();

	public void nameTest() {
		populateNameHashMap(firstNameHashMap, FEMALE_FIRST_NAMES);

	}

	public void generateName(Serf serf) {
		Get sex of Serf
		populateNameHashMap()
	}

	// Populates nameHashMap<iterated int,toString()> based on nameHashMap and
	// Name txt file.
	protected void populateNameHashMap(HashMap<Integer, String> nameHashMap, String fileName) {
		String line = null;
		// iterator
		int i = 0;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				nameHashMap.put(i, line);
				i++;
			}
			bufferedReader.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}

	protected void formatLastNameList(String fileName) {

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedWriter writer = null;
			String line = null;

			while ((line = bufferedReader.readLine()) != null) {
				try {
					// create a temporary file
					String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
					File logFile = new File(timeLog);

					// This will output the full path where the file will be
					// written
					// to...
					System.out.println(logFile.getCanonicalPath());

					writer = new BufferedWriter(new FileWriter(logFile));
					writer.write(line);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						// Close the writer regardless of what happens...
						writer.close();
					} catch (Exception e) {
					}
				}
			}
			bufferedReader.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}

}