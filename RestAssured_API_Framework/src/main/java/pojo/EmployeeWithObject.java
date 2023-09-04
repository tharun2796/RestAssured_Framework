package pojo;

public class EmployeeWithObject {
	String name;
	String id;
	long[] mob;
	EmployeeSpouse spouse;

	public EmployeeWithObject() {

	}

	public EmployeeWithObject(String name, String id, long[] mob, EmployeeSpouse spouse) {
		super();
		this.name = name;
		this.id = id;
		this.mob = mob;
		this.spouse = spouse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long[] getMob() {
		return mob;
	}

	public void setMob(long[] mob) {
		this.mob = mob;
	}

	public EmployeeSpouse getSpouse() {
		return spouse;
	}

	public void setSpouse(EmployeeSpouse spouse) {
		this.spouse = spouse;
	}


}
