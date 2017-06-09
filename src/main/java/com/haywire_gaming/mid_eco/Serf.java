package com.haywire_gaming.mid_eco;

import java.util.ArrayList;
import java.util.Random;

public class Serf {

	protected int				age			= 0;
	protected String			firstName;
	protected String			lastName;
	protected String			sex;
	protected boolean			isFertile;
	protected Serf				mother;
	protected ArrayList<Serf>	parents		= new ArrayList<Serf>();
	protected ArrayList<Serf>	siblings	= new ArrayList<Serf>();
	protected ArrayList<Serf>	children	= new ArrayList<Serf>();

	protected Inventory			inventory	= new Inventory();
	protected Tasks				tasks		= new Tasks();

	protected Serf newSerf(Serf mother) {
		final NameGenerator nameGenerator = new NameGenerator();
		final Serf newSerf = new Serf();
		newSerf.setSex(generateSex());
		newSerf.setMother(mother);
		nameGenerator.generateName(newSerf);

		return newSerf;
	}

	protected String generateSex() {
		String sex = "F";
		int randomNumber;
		final Random random = new Random();
		randomNumber = random.nextInt(20) + 1;
		if (randomNumber % 2 == 0) {
			sex = "M";
		}
		return sex;
	}

	public void insertIntoInventory(Resource resource, int amount) {
		inventory.insertIntoInvertory(resource, amount);
	}

	public void removeFromInventory(Resource resource, int amount) {
		inventory.removeFromInventory(resource, amount);
	}

	public void barter(Serf petitioner, Resource petitionerResource, int petitionerAmount, Serf respondent,
			Resource respondentResource, int respondentAmount) {
		tasks.barter(petitioner, petitionerResource, petitionerAmount, respondent, respondentResource,
				respondentAmount);
	}

	public void displaySerf() {
		System.out.println(getFirstName() + " " + getLastName() + ": " + getAge() + getSex());
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void displayInventory() {
		inventory.displayInventory();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isFertile() {
		return (age >= 15 && age <= 45);
	}

	public void setBreedingAge(boolean isBreedingAge) {
		this.isFertile = isBreedingAge;
	}

	public Serf getMother() {
		return mother;
	}

	public void setMother(Serf mother) {
		this.mother = mother;
	}

	public ArrayList<Serf> getParents() {
		return parents;
	}

	public void setParents(Serf mother, Serf father) {
		parents.add(mother);
		parents.add(father);
	}

	public ArrayList<Serf> getSiblings() {
		return siblings;
	}

	public void setSiblings(Serf mother, Serf father) {
		for (int i = 0; i < mother.getChildren().size(); i++) {
			siblings.add(mother.getChildren().get(i));
		}
		for (int i = 0; i < father.getChildren().size(); i++) {
			siblings.add(father.getChildren().get(i));
		}
	}

	public void addSibling(Serf sibling) {
		siblings.add(sibling);
	}

	public ArrayList<Serf> getChildren() {
		return children;
	}

	public void addChildren(Serf child) {
		children.add(child);
	}

}
