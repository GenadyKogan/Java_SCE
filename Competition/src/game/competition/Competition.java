package game.competition;

import game.arena.IArena;
import utilities.Point;
import utilities.ValidationUtils;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public abstract class Competition implements Observer {
    private IArena arena;
    private final ArrayList<Competitor> activeCompetitors;
    private final ArrayList<Competitor> finishedCompetitors;
    private final int maxCompetitors;
    private double y;

    public Competition(IArena arena, int maxCompetitors) {
        this.maxCompetitors = maxCompetitors;
        this.activeCompetitors = new ArrayList<>();
        this.finishedCompetitors = new ArrayList<>();
        this.arena = arena;
        y=0;
    }

    protected abstract boolean isValidCompetitor(Competitor competitor);

    public void addCompetitor(Competitor competitor){
        ValidationUtils.assertNotNull(competitor);
        if(maxCompetitors <= activeCompetitors.size()){
            throw new IllegalStateException("WinterArena is full max = "+ maxCompetitors);
        }
        if(isValidCompetitor(competitor)){
        	Point s = new Point(0, y);
        	Point f = new Point(arena.getLength(), y);
            competitor.initRace(s,f,arena);
            activeCompetitors.add(competitor);
            competitor.addObserver(this);
            y += 75;
        }
        else{
            throw new IllegalArgumentException("Invalid competitor "+ competitor);
        }
    }
    

    @Deprecated
    public void playTurn(){
        ArrayList<Competitor> tmp = new ArrayList<>(activeCompetitors);
        for(Competitor competitor: tmp){
            if(!arena.isFinished(competitor)){
                competitor.move(arena.getFriction());
                if(arena.isFinished(competitor)){
                    finishedCompetitors.add(competitor);
                    activeCompetitors.remove(competitor);
                }
            }
        }
    }
    
	public void startCompetition() throws InterruptedException {
		ExecutorService e = Executors.newFixedThreadPool(activeCompetitors.size());
		for (Competitor c : activeCompetitors) {
			e.execute(c);
		}
		e.shutdown();
		//e.awaitTermination(10, TimeUnit.MINUTES);
	}

	@Override
	public synchronized void update(Observable o, Object arg) {
		finishedCompetitors.add((Competitor) o);
		activeCompetitors.remove((Competitor) o);
	}

	
    public boolean hasActiveCompetitors(){
        return activeCompetitors.size() > 0;
    }

    public ArrayList<Competitor> getFinishedCompetitors() {
        return new ArrayList<>(finishedCompetitors);
    }
    
    public ArrayList<Competitor> getActiveCompetitors() {
        return new ArrayList<>(activeCompetitors);
    }
    

}
