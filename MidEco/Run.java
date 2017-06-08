import java.io.IOException;
import java.math.BigDecimal;

public class Run {

	public static void main(String[] args) throws IOException {

		// SQL sql = new SQL();
		// System.out.println("Connection: " + sql.connect());
		// newSerfAndTradeTest();
		reproduceTest();

	}

	public static void reproduceTest() {
		Serf mother = new Serf();
		mother.setFirstName("Mom");
		mother.setLastName("Hunt");
		mother.setAge(20);
		mother.setSex("F");

		Serf father = new Serf();
		father.setFirstName("Dad");
		father.setLastName("Haymon");
		father.setAge(20);
		father.setSex("M");

		mother.tasks.reproduce(mother, father);
		System.out.println(mother.getChildren().get(0).getFirstName() + " " + mother.getChildren().get(0).getLastName()
				+ ": " + mother.getChildren().get(0).getAge() + mother.getChildren().get(0).getSex());
	}

	public static void newSerfAndTradeTest() {
		Serf mike = new Serf();
		mike.setFirstName("Mike");
		mike.setLastName("Haymon");
		mike.setAge(31);
		mike.setSex("M");

		Serf cade = new Serf();
		cade.setFirstName("Cade");
		cade.setLastName("Calcote");
		cade.setAge(27);
		cade.setSex("M");

		Resource wood = new Resource();
		wood.setName("Wood");
		wood.setWeight(BigDecimal.valueOf(5));
		wood.setAmount(1);

		mike.insertIntoInventory(wood, 1);

		Resource chicken = new Resource();
		chicken.setName("Chicken");
		chicken.setAmount(1);
		chicken.setWeight(BigDecimal.valueOf(1));

		cade.insertIntoInventory(chicken, 5);
		cade.insertIntoInventory(chicken, 3);
		cade.removeFromInventory(chicken, 6);

		mike.displaySerf();
		mike.displayInventory();
		cade.displaySerf();
		cade.displayInventory();

		mike.barter(mike, wood, 1, cade, chicken, 100);
		cade.barter(mike, wood, 1, cade, chicken, 2);

		mike.displaySerf();
		mike.displayInventory();
		cade.displaySerf();
		cade.displayInventory();

	}

	public static void log(Object println) {
		System.out.println(String.valueOf(println));

	}
}
