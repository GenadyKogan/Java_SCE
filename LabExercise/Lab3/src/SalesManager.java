
public class SalesManager extends Manager implements Sale  { 
	private float commis; 
	public SalesManager(float salary, float kmult, float commis){  
		super(salary,kmult);
		this.commis=commis;
		}    
	public float ComputeSalary() {      
		return super.ComputeSalary()* getKmult() * (1+commis/100);  
		}
	@Override
	public float getCom() {
		// TODO Auto-generated method stub
		return commis;
	}
	@Override
	public String getSaleName() {
		return "Sales Manager";
	}     



}
 