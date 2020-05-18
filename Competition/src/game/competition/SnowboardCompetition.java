package game.competition;

import game.arena.WinterArena;
import game.entities.sportsman.Snowboarder;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

/**
 * Created by itzhak on 25-Mar-19.
 */
public class SnowboardCompetition extends WinterCompetition{
    public SnowboardCompetition(WinterArena arena, int maxCompetitors, Discipline discipline, League league, Gender gender) {
        super(arena, maxCompetitors, discipline, league, gender);
    }
    @Override
    protected boolean isValidCompetitor(Competitor competitor) {
        return competitor instanceof Snowboarder && super.isValidCompetitor(competitor);
    }
}
