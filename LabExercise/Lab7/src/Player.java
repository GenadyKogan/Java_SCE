
public class Player {
	private String name;
	private int totalScore;
	private int tournamentScore;
	public Player(String name, int total) {
		// TODO
	}
	public int getTotalScore() {
		return totalScore;
		// TODO
	}

	public void updateTotalScore() {
		// TODO
	}

	public void updateGameWin() {
		 tournamentScore += 10;
	}
	
	public String toString() {
		return name;
		// TODO
	}
	
	public String getName() {
		return name;
	}
}
