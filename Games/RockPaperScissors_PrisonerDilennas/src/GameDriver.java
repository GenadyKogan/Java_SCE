public class GameDriver {

	public static void main(String[] args) {
		Player p1 = new ConsecutivePlayer("Shmulik");
		Player p2 = new RandomPlayer("Izik");
		Game g1 = new PrisonerDilemmas(p1,p2);
		System.out.println("GAME \""+g1.getName()+"\" is starting now!");
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
		p1.updateScore(-(p1.getScore()));
		p2.updateScore(-(p2.getScore()));
		System.out.println("***************   RESET    *****************");
		System.out.println("The score of "+p1.getName()+" is "+p1.getScore());
		System.out.println("The score of "+p2.getName()+" is "+p2.getScore());
		Game g2 = new RockPaperScissors(p1,p2);
		System.out.println("GAME \""+g2.getName()+"\" is starting now!");
		System.out.println("==========================================");
		g2.play(25);
		winner = g2.getWinner();
		loser = g2.getLoser();
		if(winner.getScore() != loser.getScore())
		{
			System.out.println("The winner of game \""+g2.getName()+"\" is "+winner.getName()+", his score is "+winner.getScore());
			System.out.println("The player "+loser.getName()+" lost this game, his score is "+loser.getScore());
		}
		else
		{
			System.out.println("No winner of game \""+g2.getName()+"\", both "+winner.getName()+" and "+loser.getName()+" score "+winner.getScore());
		}
		
	}
}
