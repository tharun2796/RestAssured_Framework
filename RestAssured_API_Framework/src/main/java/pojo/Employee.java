package pojo;


public class Employee {

	// declare the global varaiables
	String name;
	String mailID;
	long mobNo;
	int age;

	// initialize the constructors
	public Employee() {

	}

	public Employee(String name, String mailID, long mobNo, int age) {
		super();
		this.name = name;
		this.mailID = mailID;
		this.mobNo = mobNo;
		this.age = age;
	}

	// create getter and setter methods
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

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
