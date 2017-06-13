package com.haywire_gaming.mid_eco;

import java.util.ArrayList;
import java.util.Random;

public class Person {

	protected int				age			= 0;
	protected String			firstName;
	protected String			lastName;
	protected String			sex;
	protected boolean			isFertile;
	protected Person			mother;
	protected ArrayList<Person>	parents		= new ArrayList<Person>();
	protected ArrayList<Person>	siblings	= new ArrayList<Person>();
	protected ArrayList<Person>	children	= new ArrayList<Person>();

	protected Inventory			inventory	= new Inventory();
	protected Tasks				tasks		= new Tasks();

	protected Person newPerson(Person mother) {
		final NameGenerator nameGenerator = new NameGenerator();
		final Person newPerson = new Person();
		newPerson.setSex(generateSex());
		newPerson.setMother(mother);
		nameGenerator.generateName(newPerson);

		return newPerson;
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
		inventory.insertIntoInventory(resource, amount);
	}

	public void removeFromInventory(Resource resource, int amount) {
		inventory.removeFromInventory(resource, amount);
	}

	public void barter(Person petitioner, Resource petitionerResource, int petitionerAmount, Person respondent,
			Resource respondentResource, int respondentAmount) {
		tasks.barter(petitioner, petitionerResource, petitionerAmount, respondent, respondentResource,
				respondentAmount);
	}

	public void displayPerson() {
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

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public ArrayList<Person> getParents() {
		return parents;
	}

	public void setParents(Person mother, Person father) {
		parents.add(mother);
		parents.add(father);
	}

	public ArrayList<Person> getSiblings() {
		return siblings;
	}

	public void setSiblings(Person mother, Person father) {
		for (int i = 0; i < mother.getChildren().size(); i++) {
			siblings.add(mother.getChildren().get(i));
		}
		for (int i = 0; i < father.getChildren().size(); i++) {
			siblings.add(father.getChildren().get(i));
		}
	}

	public void addSibling(Person sibling) {
		siblings.add(sibling);
	}

	public ArrayList<Person> getChildren() {
		return children;
	}

	public void addChildren(Person child) {
		children.add(child);
	}

}
