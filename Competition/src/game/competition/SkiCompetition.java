package game.competition;

import game.arena.WinterArena;
import game.entities.sportsman.Skier;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

/**
 * Created by itzhak on 25-Mar-19.
 */
public class SkiCompetition extends WinterCompetition {
    public SkiCompetition(WinterArena arena, int maxCompetitors, Discipline discipline, League league, Gender gender) {
        super(arena, maxCompetitors, discipline, league, gender);
    }

    @Override
    protected boolean isValidCompetitor(Competitor competitor) {
        return competitor instanceof Skier && super.isValidCompetitor(competitor);
    }
}
