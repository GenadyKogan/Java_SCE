package game.entities.sportsman;

import game.arena.IArena;
import game.competition.Competitor;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import utilities.Point;


public class WinterSportsman extends Sportsman implements Competitor {
    private final Discipline discipline;
    private Point finish;
    private IArena arena;

    public WinterSportsman(String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline discipline) {
        super(name, age, gender, acceleration, maxSpeed);
        this.discipline = discipline;
    }
    @Override
    public void initRace() {
        this.setLocation(new Point(0,this.getLocation().getY()));
    }
    
    @Override
    public void initRace(Point p, Point f, IArena arena) {
        this.setLocation(p); 
        this.finish = f;
        this.arena = arena;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getName();
    }

    //region Getters & setters
    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    protected double getAcceleration() {
        return super.getAcceleration()+ League.calcAccelerationBonus(this.getAge());
    }
    //endregion
    
	private boolean competitionInProgress() {
		boolean res = getLocation().getX() < finish.getX();
		Point p = getLocation();
		if (!res) setLocation(new Point(finish.getX(),p.getY()));
		return res;
	}
    
	
	@Override
	public void run() {
		while (competitionInProgress()) {
			move(arena.getFriction());
            try { 
                   Thread.sleep(100);
            } catch (InterruptedException ex) {
                   ex.printStackTrace();
            }
		}
		setChanged();
		notifyObservers();
	}
}
