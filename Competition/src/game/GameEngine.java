package game;

import game.arena.WinterArena;
import game.competition.Competition;
import game.competition.Competitor;
import utilities.ValidationUtils;

public class GameEngine {

	private static GameEngine instance;

	/**.
	 * @return singleton instance of the game engine
	 */
	public static GameEngine getInstance() {
		if (instance == null) {
			instance = new GameEngine();
		}
		return instance;
	}

	/**
	 * private empty Ctor for game engine
	 */
	private GameEngine() {
	}


	public void startRace(Competition competition) {
		ValidationUtils.assertNotNull(competition);
		int step;
		for(step = 0 ; competition.hasActiveCompetitors() ; step++){
			competition.playTurn();
		}
		System.out.println("race finished in " + step + " steps");
		printResults(competition);
	}

	/**
	 * print the game results
	 */
	private void printResults(Competition competition){
		System.out.println("Race results:");
		int place = 1;
		for(Competitor skier : competition.getFinishedCompetitors()){
			System.out.println(place + ". " + skier);
			place++;
		}
	}

}
