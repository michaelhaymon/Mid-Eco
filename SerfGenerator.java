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
		String firstName = "";
		return formatName(firstName);
	}

	protected String generateLastName() {
		String lastName = "";
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

	private String formatName(String name) {
		String formattedName = "";
		// ArrayList<String> nameArrayList = NameGenerator.splitString(name);
		// formattedName = formattedName + nameArrayList.get(0).toUpperCase();
		// for (int i = 1; i < nameArrayList.size(); i++) {
		// formattedName = formattedName + (nameArrayList.get(i).toLowerCase());
		// }
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
