package pojo;

public class CreateUser {

	// declare the Global variables
	String name;
	String job;

	// initialize the Constructors
	public CreateUser(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}

	// generate getters and setters methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
