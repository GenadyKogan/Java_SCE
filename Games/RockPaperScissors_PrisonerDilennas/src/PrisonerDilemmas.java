
public class PrisonerDilemmas extends Game{
	public PrisonerDilemmas(Player p1, Player p2) { 
		super(p1, p2, "Prisoner's Dilemma");
		}  
	protected void initActions(){   
		 actions=new Action[2];
		 actions[0]=new Action("To be silent");
		 actions[1]=new Action("To witness");
		}   
	
	 protected void rewardPlayers(Action a1, Action a2) { 
		 
		 
	 } 
	}

	
