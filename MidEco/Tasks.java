public class Tasks {

	public void barter(Serf petitioner, Resource petitionerResource, int petitionerAmount, Serf respondent,
			Resource respondentResource, int respondentAmount) {
		int petitionerAmountOfResourceInInventory = petitioner.getInventory()
				.getAmountFromInventory(petitionerResource);
		int respondentAmountOfResourceInInventory = respondent.getInventory()
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

	public Serf reproduce(Serf mother, Serf father) {
		Serf child = new Serf();
		if (mother.isFertile() && father.isFertile()) {
			SerfGenerator serfGenerator = new SerfGenerator();
			child = serfGenerator.newSerf(mother);
			mother.addChildren(child);
		}

		return child;
	}

}
