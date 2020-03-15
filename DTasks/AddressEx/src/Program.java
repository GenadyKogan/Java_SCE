
public class Program {
	public static void main(String[] args) {
		Address school=new Address("Balfur",10,"Tel-Aviv");
		Address home=new Address("Geula",20,"Tel-Aviv");
		Student stud1=new Student("gogo",home,school);
		home.setHouseNember(8);
		Student stud2=new Student("momo",home,school);
		school.setHouseNember(90);
		stud2.getHomeAddress().setHouseNember(30);
		
		
	}
}
