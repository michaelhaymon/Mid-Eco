import java.util.ArrayList;
import java.util.Random;

public class SerfGenerator {

	protected Serf newSerf() {
		Serf newSerf = new Serf();
		newSerf.setSex(generateSex());
		newSerf.setFirstName(generateFirstName(newSerf.getSex()));
		// TODO this needs to account for lineage. Use Mother's last name
		newSerf.setLastName(generateLastName());

		return newSerf;
	}

	protected Serf bornSerf() {
		Serf bornSerf = new Serf();
		bornSerf.setSex(generateSex());
		bornSerf.setFirstName(generateFirstName(bornSerf.getSex()));
		bornSerf.setLastName("Mother's Last Name");

		return bornSerf;
	}

	protected String generateFirstName(String sex) {
		// TODO this should take in account sex and then choose from appropriate
		// name table.
		String firstName = randomConsonantVowelPair() + randomConsonantVowelPair();
		return formatName(firstName);
	}

	protected String generateLastName() {
		String lastName = randomConsonantVowelPair() + randomConsonantVowelPair() + randomConsonantVowelPair();
		return formatName(lastName);
	}

	protected String generateSex() {
		String sex = "F";
		int randomNumber;
		Random random = new Random();
		randomNumber = random.nextInt(20) + 1;
		System.out.println(randomNumber);
		if (randomNumber % 2 == 0) {
			sex = "M";
		}
		return sex;
	}

	protected String randomConsonantVowelPair() {
		String consonantVowelPair = "";
		int randomNumber;
		String randomLetter;
		Random random = new Random();
		while (consonantVowelPair.length() < 1) {
			randomNumber = random.nextInt(25) + 1;
			randomLetter = getCharForNumber(randomNumber).toString();
			if (!ParseWordList.VOWELS.contains(randomLetter)) {
				consonantVowelPair = consonantVowelPair + randomLetter;
			}
		}
		while (consonantVowelPair.length() < 2) {
			randomNumber = random.nextInt(25) + 1;
			randomLetter = getCharForNumber(randomNumber).toString();
			if (ParseWordList.VOWELS.contains(randomLetter)) {
				consonantVowelPair = consonantVowelPair + randomLetter;
			}
		}

		return consonantVowelPair;
	}

	private String getCharForNumber(int i) {
		return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
	}

	private String formatName(String name) {
		String formattedName = "";
		ArrayList<String> nameArrayList = ParseWordList.splitString(name);
		formattedName = formattedName + nameArrayList.get(0).toUpperCase();
		for (int i = 1; i < nameArrayList.size(); i++) {
			formattedName = formattedName + (nameArrayList.get(i).toLowerCase());
		}
		return formattedName;
	}

	protected void serfTest10() {
		SerfGenerator serfGenerator = new SerfGenerator();
		for (int i = 0; i < 10; i++) {
			Serf serf = serfGenerator.newSerf();
			System.out.println(
					serf.getFirstName() + " " + serf.getLastName() + ": " + serf.getAge() + " " + serf.getSex());
		}
	}
}
