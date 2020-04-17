
public class GameDriver {
	public static void main(String[] args) { 
		Player p1 = new ConsecutivePlayer("Gena");
		Player p2 = new RandomPlayer("Lital");
		Game g1 = new RockPaperScissors(p1,p2);
		System.out.println("GAME \""+g1.getName()+"\" is starting");
		System.out.println("==========================================");
		g1.play(25);
		Player winner = g1.getWinner();
		Player loser = g1.getLoser();
		if(winner.getScore() != loser.getScore())
		{
			System.out.println("The winner of game \""+g1.getName()+"\" is "+winner.getName()+", his score is "+winner.getScore());
			System.out.println("The player "+loser.getName()+" lost this game, his score is "+loser.getScore());
		}
		else
		{
			System.out.println("No winner of game \""+g1.getName()+"\", both "+winner.getName()+" and "+loser.getName()+" score "+winner.getScore());
		}
	}
}
