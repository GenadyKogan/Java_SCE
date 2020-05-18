package game.competition;

import java.util.Observer;

import game.arena.IArena;
import game.entities.IMobileEntity;
import utilities.Point;


public interface Competitor extends IMobileEntity, Runnable {
    void initRace();
    void initRace(Point p, Point f, IArena arena); 
    void addObserver(Observer o);
}
