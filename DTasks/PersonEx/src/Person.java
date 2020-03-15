
public class Person {
	private static int licenseAge;
	private String name;
	private int age;
	public Person (String name,int age) {
		this.name=name;
		this.age=age;
	}
	public void setLicenseAge(int licenseAge) {
		this.licenseAge=licenseAge;
	}
	public String toString() {
		return ("Name:  " + name + "\tAge:  " 
				+ age + " (can" +
				(age < licenseAge ? " NOT" : "") 
				+ " drive)");

	}
}
