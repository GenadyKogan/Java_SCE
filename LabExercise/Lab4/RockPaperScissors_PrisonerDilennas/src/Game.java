public abstract class Game {

	private Player p1, p2;
	private String name;     //game name
	protected Action[] actions; // the set of actions

	public Game(Player p1, Player p2, String name){
		this.p1 = p1;
		this.p2 = p2;
		this.name = new String(name);
	}

	protected abstract void initActions();

	public void play(int turnCount) {
		 for(int i=0; i<turnCount; i++) 
			 playSingleTurn();
	}

	private void playSingleTurn() {
		rewardPlayers(p1.selectAction(actions),p2.selectAction(actions));
	}
	// There is no real scoring strategy in a general game 
	protected abstract void rewardPlayers(Action a1, Action a2);

	public Player getWinner () {
		 if(p1.isWinner(p2))
			 return p1;
		 return p2;
	}

	public Player getLoser () {
		 if(p1.isWinner(p2))
			 return p2;
		 return p1;
	}

	protected Player getFirstPlayer() {
		return this.p1;
	}

	protected Player getSecondPlayer() {
		return this.p2;
	}
	
	public String getName()
	{
		return name;
	}

}
