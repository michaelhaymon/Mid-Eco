public class Serf {

	protected int		age;
	protected String	firstName;
	protected String	lastName;
	protected String	sex;
	// 14
	protected boolean	isBreedingAge;
	protected String	motherLastName;

	Inventory			inventory	= new Inventory();
	Tasks				tasks		= new Tasks();

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

	public boolean isBreedingAge() {
		return isBreedingAge;
	}

	public void setBreedingAge(boolean isBreedingAge) {
		this.isBreedingAge = isBreedingAge;
	}

	public String getMotherLastName() {
		return motherLastName;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}

}
