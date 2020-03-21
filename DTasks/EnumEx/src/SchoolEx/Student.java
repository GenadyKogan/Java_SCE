package SchoolEx;

public class Student {
	public enum eDegree{Bachleor,Master,Ph};
	private String name;
	private eDegree degree;
	public Student(String name,eDegree degree) {
		this.degree=degree;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String toString() {
		return name+" ("+degree+")";
	}
	

}
