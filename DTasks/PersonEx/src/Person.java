
public class Person {
	private static int licenseAge;
	private static int counter;
	private String name;
	private int age;
	private int id;
	public Person (String name,int age) {
		this.name=name;
		this.age=age;
		id=++counter;
	}
	public void setLicenseAge(int licenseAge) {
		this.licenseAge=licenseAge;
	}
	public static int getNumOfPersons() {
		    return counter;
	 }

//	public String toString() {
//		return ("Name:  " + name + "\tAge:  " 
//				+ age + " (can" +
//				(age < licenseAge ? " NOT" : "") 
//				+ " drive)");
//
//	}
	public String toString() {
		return "ID: "+id+"\tName: "+name+"\tAge: "+age;
	}
}
