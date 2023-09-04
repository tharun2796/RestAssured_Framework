package pojo;

public class EmployeeSpouse {

	String name;
	int age;
	long mob;

	public EmployeeSpouse() {

	}

	public EmployeeSpouse(String name, int age, long mob) {
		super();
		this.name = name;
		this.age = age;
		this.mob = mob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

}
