package game.enums;

/**
 * Created by itzhak on 24-Mar-19.
 */
public enum League {
    JUNIOR(12d,16d,1d),ADULT(17d,30d,2d),SENIOR(30d,Double.MAX_VALUE,3d);
    private final double lowerAge;
    private final double upperAge;
    private final double accelerationBonus;

    League(double lowerAge, double upperAge, double accelerationBonus) {
        this.lowerAge = lowerAge;
        this.upperAge = upperAge;
        this.accelerationBonus = accelerationBonus;
    }

    public boolean isInLeague(double age){
        return lowerAge <= age && age < upperAge;
    }

    public static double calcAccelerationBonus(double age){
        for(League league: League.values()){
            if(league.isInLeague(age))
                return league.accelerationBonus;
        }
        return 0d;
    }

}
