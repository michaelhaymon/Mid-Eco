import java.util.ArrayList;

public class Serf {

	protected int				age			= 0;
	protected String			firstName;
	protected String			lastName;
	protected String			sex;
	protected boolean			isFertile;
	protected String			motherLastName;
	protected ArrayList<Serf>	parents		= new ArrayList<>();
	protected ArrayList<Serf>	children	= new ArrayList<>();

	protected Inventory			inventory	= new Inventory();
	protected Tasks				tasks		= new Tasks();

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

	public String getMotherLastName() {
		return motherLastName;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}

	public ArrayList<Serf> getParents() {
		return parents;
	}

	public void setParents(Serf mother, Serf father) {
		parents.add(mother);
		parents.add(father);
	}

	public ArrayList<Serf> getChildren() {
		return children;
	}

	public void addChildren(Serf child) {
		children.add(child);
	}

}
