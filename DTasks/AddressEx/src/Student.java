
public class Student {
	private String name;
	private Address homeAddress;
	private Address schoolAddress;
//============================================================================
	public Student(String name,Address homeAddress,Address schoolAddress) {
		this.name=name;
		setHomeAddress(homeAddress);
		setSchoolAddress(schoolAddress);
	}

//============================================================================
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(Address schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	public String getName() {
		return name;
	}
	
//============================================================================
	public String toString() {
		return name+" details:\n"+"Home address: "+homeAddress.toString()+"\n"
				+"School address: "+schoolAddress.toString();
	}
}
