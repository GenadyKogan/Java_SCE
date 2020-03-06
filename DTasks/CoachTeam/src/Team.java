
public class Team {
	private String name;
	private int numOfChampionships;
	private Coach theCoach;

//============================================================================	
	public Team (String name, int numOfChampionships) {
		this.setName(name);
		this.numOfChampionships =numOfChampionships;
		setCoach(null);
	}
//============================================================================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfChampionships() {
		return numOfChampionships;
	}

	//public void setNumOfChampionships(int numOfChampionships) {
		//this.numOfChampionships = numOfChampionships;
	//}

	public Coach getCoach() {
		return theCoach;
	}

	public void setCoach(Coach newCoach) {
		if(theCoach!=newCoach) {
			if(theCoach!=null) {
				theCoach.setTeam(null);
			}
		theCoach=newCoach;
		if(theCoach!=null) {
			theCoach.setTeam(this);
		}
		}
	}
//============================================================================
	public void addChampionships() {
		numOfChampionships++;
	}
	public void show() {
		System.out.print("The team "+name+ " won "+ numOfChampionships + " championships");
		if(theCoach!=null)
			System.out.print(", coach is "+theCoach.getName());
		System.out.println();
	}
}
