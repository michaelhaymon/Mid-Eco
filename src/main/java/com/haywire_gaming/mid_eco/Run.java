package com.haywire_gaming.mid_eco;

import java.io.IOException;
import java.math.BigDecimal;

public class Run {

	static Time			time			= new Time();
	static final double	MS_PER_FRAME	= 16;

	public static void main(String[] args) throws IOException, InterruptedException {

		// newSerfAndTradeTest();
		// reproduceTest();
		// time.timePassageTest();
		// time.fPSTest();
		int FPS = 0;
		double current = 0.0;
		double lag = 0.0;
		double end = (double) (Time.getCurrentTime() + 1000);
		double lastUpdate = (double) Time.getCurrentTime();
		while (current < end) {
			current = (double) Time.getCurrentTime();
			double elapsed = current - lastUpdate;
			lastUpdate = current;
			lag += elapsed;

			processInput();

			while (lag >= MS_PER_FRAME) {
				update(elapsed);
				lag -= MS_PER_FRAME;
			}

			render(lag / MS_PER_FRAME);

			System.out
					.println("Sleep Duration: " + (current + MS_PER_FRAME - Time.getCurrentTime()) + " milliseconds.");
			Thread.sleep((long) (current + MS_PER_FRAME - Time.getCurrentTime()));
			FPS++;
		}
		System.out.println("FPS: " + FPS);

	}

	private static void processInput() {
		// TODO Auto-generated method stub
		// This is a placeholder for when player input is needed.

	}

	// elapsed marks the time since the last update.
	public static void update(double elapsed) {

	}

	public static void render(double lag) {

	}

	public static void reproduceTest() {
		final Serf mother = new Serf();
		mother.setFirstName("Mom");
		mother.setLastName("Test");
		mother.setAge(20);
		mother.setSex("F");

		final Serf father = new Serf();
		father.setFirstName("Dad");
		father.setLastName("Default");
		father.setAge(20);
		father.setSex("M");

		mother.tasks.reproduce(mother, father);
		mother.tasks.reproduce(mother, father);
		System.out.println(mother.getChildren().get(0).getFirstName() + " " + mother.getChildren().get(0).getLastName()
				+ ": " + mother.getChildren().get(0).getAge() + mother.getChildren().get(0).getSex());
		System.out.println(mother.getChildren().get(1).getFirstName() + " " + mother.getChildren().get(1).getLastName()
				+ ": " + mother.getChildren().get(1).getAge() + mother.getChildren().get(1).getSex());

		final Serf firstChild = mother.getChildren().get(0);
		firstChild.setAge(20);
		firstChild.setSex("F");

		final Serf secondChild = mother.getChildren().get(1);
		secondChild.setAge(20);
		secondChild.setSex("M");

		final Serf fStranger = new Serf();
		fStranger.setFirstName("Stranger");
		fStranger.setLastName("Lady");
		fStranger.setAge(20);
		fStranger.setSex("F");

		firstChild.tasks.reproduce(firstChild, fStranger);
		firstChild.tasks.reproduce(firstChild, secondChild);

	}

	public static void newSerfAndTradeTest() {
		final Serf mike = new Serf();
		mike.setFirstName("Mike");
		mike.setLastName("Haymon");
		mike.setAge(31);
		mike.setSex("M");

		final Serf cade = new Serf();
		cade.setFirstName("Cade");
		cade.setLastName("Calcote");
		cade.setAge(27);
		cade.setSex("M");

		final Resource wood = new Resource();
		wood.setName("Wood");
		wood.setWeight(BigDecimal.valueOf(5));
		wood.setAmount(1);

		mike.insertIntoInventory(wood, 1);

		final Resource chicken = new Resource();
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
