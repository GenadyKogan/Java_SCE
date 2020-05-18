/**
 *
 */
package utilities;

import game.GameEngine;
import game.arena.WinterArena;
import game.competition.Competition;
import game.competition.SkiCompetition;
import game.competition.WinterCompetition;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.entities.sportsman.WinterSportsman;
import game.enums.*;

import java.lang.reflect.Constructor;

/**
 * @author Itzhak Eretz Kdosha
 *
 */
public class Program {

	public static void main(String[] args) {
		Skier skier1 = new Skier("sk1",23, Gender.MALE, 4.5,60, Discipline.DOWNHILL);
		Skier skier2 = new Skier("sk2",25, Gender.MALE, 5.0,50, Discipline.DOWNHILL);
		Skier skier3 = new Skier("sk3",23, Gender.FEMALE, 3.5,45, Discipline.GIANT_SLALOM);
		Snowboarder snowboarder1 = new Snowboarder("sb1",25, Gender.FEMALE, 6.5,50, Discipline.DOWNHILL);
		Skier skier4 = new Skier("sk4",29, Gender.MALE, 4.6,75, Discipline.DOWNHILL);
		Skier skier5 = new Skier("sk5",50, Gender.MALE, 3.3,80, Discipline.DOWNHILL);

		WinterArena arena = new WinterArena(1000,SnowSurface.CRUD,WeatherCondition.SUNNY);

		SkiCompetition competition = new SkiCompetition(arena,3,Discipline.DOWNHILL, League.ADULT,Gender.MALE);
		competition.addCompetitor(skier1);
		competition.addCompetitor(skier2);
		System.out.println("--------------- Exception example 1 ---------------");
		try{
			competition.addCompetitor(skier3);
		}
		catch (IllegalArgumentException e){
			e.printStackTrace(System.out);
		}
		System.out.println("--------------- Exception example 2 ---------------");
		try{
			competition.addCompetitor(snowboarder1);
		}
		catch (IllegalArgumentException e){
			e.printStackTrace(System.out);
		}
		System.out.println("--------------- Exception example 3 ---------------");
		competition.addCompetitor(skier4);
		try{
			competition.addCompetitor(skier5);
		}
		catch (IllegalStateException e){
			e.printStackTrace(System.out);
		}
		System.out.println("--------------- COMPETE ---------------");
		GameEngine.getInstance().startRace(competition);



	}

}
