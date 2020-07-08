public class Driver {
	public static void main(String[] args) {
		Student s1 = new Student("David");
		
		Student s2 = s1.getGradStudent();
		
		Student s3 = s2.getStudent();
		
		((GraduateStudent)s3).changeName("Dudu");
		
//		System.out.println("s1.name=" + s1.name);
//		System.out.println("s1.degree=" + s1.degree);
//		System.out.println("s2.getName()=" + s2.getName());
//		System.out.println("((GraduateStudent)s2).getDegree()=" + ((GraduateStudent)s2).getDegree());
//		System.out.println("s2.getDegree()=" + s2.getDegree());
//		System.out.println("((GraduateStudent)s2).name=" + ((GraduateStudent)s2).name);
//		System.out.println("s3.name=" + s3.name);
		System.out.println("s3 is Student: " + (s3.getClass() == Student.class));
//		System.out.println("s3 is GraduateStudent: " + (s3 instanceof GraduateStudent));
		System.out.println("s3==s2: " + (s3 == s2));
 }
}
