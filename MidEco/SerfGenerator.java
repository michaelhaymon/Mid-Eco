import java.util.Random;

public class SerfGenerator {

	protected Serf newSerf(String motherLastName) {
		NameGenerator nameGenerator = new NameGenerator();
		Serf newSerf = new Serf();
		newSerf.setSex(generateSex());
		newSerf.setMotherLastName(motherLastName);
		nameGenerator.generateName(newSerf);

		return newSerf;
	}

	protected String generateSex() {
		String sex = "F";
		int randomNumber;
		Random random = new Random();
		randomNumber = random.nextInt(20) + 1;
		if (randomNumber % 2 == 0) {
			sex = "M";
		}
		return sex;
	}

	protected void serfTest10() {
		SerfGenerator serfGenerator = new SerfGenerator();
		for (int i = 0; i < 10; i++) {
			Serf serf = serfGenerator.newSerf(null);
			System.out.println(
					serf.getFirstName() + " " + serf.getLastName() + ": " + serf.getAge() + " " + serf.getSex());
		}
	}
}
