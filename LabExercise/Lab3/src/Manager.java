
public class Manager extends Employee {
	 private float kmult;   
	 public Manager(float salary, float kmult) {  
		 super(salary); 
		 this.setKmult(kmult);
		 }   
	 public float ComputeSalary() {    
		  
		 return super.ComputeSalary()*getKmult();
		 }  
	 public String getName() { 
		 return "Manager";
		 }
	public float getKmult() {
		return kmult;
	}
	public void setKmult(float kmult) {
		this.kmult = kmult;
	}
}

