import java.util.Random;

public class SerfGenerator {

	protected Serf newSerf(Serf mother) {
		NameGenerator nameGenerator = new NameGenerator();
		Serf newSerf = new Serf();
		newSerf.setSex(generateSex());
		newSerf.setMotherLastName(mother.getLastName());
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

}
