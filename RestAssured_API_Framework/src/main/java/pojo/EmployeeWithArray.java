package pojo;

public class EmployeeWithArray {

	String name;
	String mailID;
	long[] mob;
	int age;

	public EmployeeWithArray() {

	}

	public EmployeeWithArray(String name, String mailID, long[] mob, int age) {
		super();
		this.name = name;
		this.mailID = mailID;
		this.mob = mob;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailID() {
		return mailID;
	}

	public void setMailID(String mailID) {
		this.mailID = mailID;
	}

	public long[] getMob() {
		return mob;
	}

	public void setMob(long[] mob) {
		this.mob = mob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
