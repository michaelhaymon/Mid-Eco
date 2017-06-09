package com.haywire_gaming.mid_eco;

public class Tasks {

	Validation validation = new Validation();

	public void barter(Serf petitioner, Resource petitionerResource, int petitionerAmount, Serf respondent,
			Resource respondentResource, int respondentAmount) {
		final int petitionerAmountOfResourceInInventory = petitioner.getInventory()
				.getAmountFromInventory(petitionerResource);
		final int respondentAmountOfResourceInInventory = respondent.getInventory()
				.getAmountFromInventory(respondentResource);
		// This ensures both serfs have at least enough resources in their
		// inventory to trade.
		if ((petitionerAmountOfResourceInInventory - petitionerAmount >= 0)
				&& (respondentAmountOfResourceInInventory - respondentAmount >= 0)) {
			petitioner.getInventory().insertIntoInvertory(respondentResource, respondentAmount);
			respondent.getInventory().insertIntoInvertory(petitionerResource, petitionerAmount);
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
	public Serf reproduce(Serf mother, Serf father) {
		Serf child = new Serf();
		if (!validation.isCoupleInbreeding(mother, father) && validation.isCoupleFertile(mother, father)) {
			child = child.newSerf(mother);
			mother.addChildren(child);
			father.addChildren(child);
			child.setParents(mother, father);
		}

		return child;
	}

}
