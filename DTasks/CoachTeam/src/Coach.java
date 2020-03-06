
public class Coach {
	private String name;
	private int yearsOfExperince;
	private Team theTeam;
//============================================================================	
	public Coach(String name,int yearsOfExperince,Team theTeam) {
		this.setName(name);
		this.yearsOfExperince=yearsOfExperince;
		setTeam(theTeam);
	}
	public Coach(String name,int yearsOfExperince) {
		this(name, yearsOfExperince, null);
	}
	
//============================================================================	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTeam(Team newTeam) {
		if(theTeam!=newTeam) {
			theTeam=newTeam;
			if(theTeam!=null) {
				theTeam.setCoach(this);
			}
		}
	}	
//============================================================================		
	public void show() {
		System.out.print(name+"'s experince is " +yearsOfExperince+" years, and he ");
		if(theTeam==null)
			System.out.println(" do not coach any team now.");
		else
			System.out.print(" coaches the team " );
	}
	
}
