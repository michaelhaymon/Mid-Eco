package com.haywire_gaming.mid_eco;

public class Tasks {

	Validation validation = new Validation();

	public void acquireResourceFromRAP() {

	}

	public void takeResourceFromInventory(Person person, Resource resource, int amount, Inventory inventory) {
		if (inventory.getAmountFromInventory(resource) >= amount) {
			System.out.println("Removing " + amount + " " + resource.getName());
			inventory.removeFromInventory(resource, amount);
			Resource transferredResource = new Resource();
			transferredResource.setName(resource.getName());
			transferredResource.setType(resource.getType());
			transferredResource.setWeight(resource.getWeight());
			System.out.println("Inserting " + amount + " " + resource.getName());
			person.inventory.insertIntoInventory(transferredResource, amount);
		} else {
			Run.log(person.getFirstName() + " tried to remove " + resource.getName() + "(" + amount
					+ ") but there was only " + inventory.getAmountFromInventory(resource) + " available.");
		}
	}

	public void putResourceIntoInventory(Person person, Resource resource, int amount, Inventory inventory) {
		if (person.inventory.getAmountFromInventory(resource) >= amount) {
			person.inventory.removeFromInventory(resource, amount);
			Resource transferredResource = new Resource();
			transferredResource.setName(resource.getName());
			transferredResource.setType(resource.getType());
			transferredResource.setWeight(resource.getWeight());
			inventory.insertIntoInventory(transferredResource, amount);
		} else {
			Run.log(person.getFirstName() + " tried to insert " + resource.getName() + "(" + amount
					+ ") but there was only " + person.inventory.getAmountFromInventory(resource) + "available.");
		}
	}

	public void barter(Person petitioner, Resource petitionerResource, int petitionerAmount, Person respondent,
			Resource respondentResource, int respondentAmount) {
		final int petitionerAmountOfResourceInInventory = petitioner.getInventory()
				.getAmountFromInventory(petitionerResource);
		final int respondentAmountOfResourceInInventory = respondent.getInventory()
				.getAmountFromInventory(respondentResource);
		// This ensures both serfs have at least enough resources in their
		// inventory to trade.
		if ((petitionerAmountOfResourceInInventory - petitionerAmount >= 0)
				&& (respondentAmountOfResourceInInventory - respondentAmount >= 0)) {
			petitioner.getInventory().insertIntoInventory(respondentResource, respondentAmount);
			respondent.getInventory().insertIntoInventory(petitionerResource, petitionerAmount);
			petitioner.getInventory().removeFromInventory(petitionerResource, petitionerAmount);
			respondent.getInventory().removeFromInventory(respondentResource, respondentAmount);
			Run.log("Trade successful.");
		} else {
			Run.log("INVENTORY INSUFFICIENT FOR TRADE: " + petitioner.getFirstName() + " requested to trade "
					+ petitionerAmount + "(" + petitionerAmountOfResourceInInventory + ") "
					+ petitionerResource.getName() + " for " + respondentAmount + "("
					+ respondentAmountOfResourceInInventory + ") " + respondentResource.getName() + " with "
					+ respondent.getFirstName());
		}
	}

	// Allows two Fertile, Non-related Serfs to reproduce.
	public Person reproduce(Person mother, Person father) {
		Person child = new Person();
		if (!validation.isCoupleInbreeding(mother, father) && validation.isCoupleFertile(mother, father)) {
			child = child.newPerson(mother);
			mother.addChildren(child);
			father.addChildren(child);
			child.setParents(mother, father);
		}

		return child;
	}

}
