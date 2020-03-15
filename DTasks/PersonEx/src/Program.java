
public class Program {
	public static void main(String[] args)  {

		Person p1=new Person("Gogo", 14);
		Person p2=new Person("Momo", 13);
		Person p3=new Person("Yoyo", 19);
		p1.setLicenseAge(18);
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		p2.setLicenseAge(21);
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
	}
}
