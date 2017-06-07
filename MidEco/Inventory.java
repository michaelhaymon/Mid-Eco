import java.util.ArrayList;

public class Inventory {

	ArrayList<Resource> inventory = new ArrayList<Resource>();

	protected void insertIntoInvertory(Resource resource, int amount) {
		if (getAmountFromInventory(resource) > 0) {
			setInventoryAmount(resource, amount);
		} else {
			resource.setAmount(amount);
			inventory.add(resource);
		}

	}

	protected int getAmountFromInventory(Resource resource) {
		for (int i = 0; i < inventory.size(); i++) {
			if (resource.getName().equals(inventory.get(i).getName())) {
				return inventory.get(i).getAmount();
			}
		}
		return 0;
	}

	protected void setInventoryAmount(Resource resource, int amount) {
		for (int i = 0; i < inventory.size(); i++) {
			if (resource.getName().equals(inventory.get(i).getName())) {
				inventory.get(i).setAmount(inventory.get(i).getAmount() + amount);
			}
		}
	}

	protected void removeFromInventory(Resource resource, int amount) {
		if (amount <= getAmountFromInventory(resource)) {
			// If amount removed is equal to total amount in inventory, remove
			// entire resource.
			if (amount == resource.getAmount()) {
				inventory.remove(resource);
			} else {
				// If amount remove is less than total amount in inventory, then
				// set amount in inventory to the difference.
				removeAmountFromInventory(resource, amount);
			}
		} else {
			System.out.println("There's not enough " + resource.getName() + "(s) to take.");
		}
	}

	protected void removeAmountFromInventory(Resource resource, int amount) {
		for (int i = 0; i < inventory.size(); i++) {
			if (resource.getName().equals(inventory.get(i).getName())) {
				inventory.get(i).setAmount(inventory.get(i).getAmount() - amount);
			}
		}
	}

	protected void displayInventory() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println(inventory.get(i).getName() + ": " + inventory.get(i).getAmount());
		}
	}

	public ArrayList<Resource> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Resource> inventory) {
		this.inventory = inventory;
	}

}
