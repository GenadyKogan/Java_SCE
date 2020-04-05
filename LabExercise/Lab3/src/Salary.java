
public class Salary {
	 public static void main(String[] args) { 
		 Employee e=new Employee(4000);
//		 System.out.print("Compute pay for " + e.getName() + ": " + e.ComputeSalary()+"\n");
		 e = new SalesEmployee(5000,10);
//		 System.out.print("Compute pay for " + e.getName() + ": " + e.ComputeSalary());
		 Manager m=new Manager(3000, (float)3.3);
//		 System.out.println("Compute pay for " + m.getName() +": "+ m.ComputeSalary());
		 SalesEmployee sE= new SalesEmployee((float) 9000.00 ,(float) 4.5);
//		 System.out.print("Compute pay for " + sE.getName() + ": " + sE.ComputeSalary());
		 SalesManager sM= new SalesManager((float) 4343.30 ,(float) 3,(float) 3);
//		 System.out.print("Compute pay for " + sM.getSaleName() + ": " + sM.ComputeSalary());
	 }
}
