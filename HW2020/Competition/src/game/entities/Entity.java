package game.entities;

import java.util.Observable;

import utilities.Point;
import utilities.ValidationUtils;


public abstract class Entity extends Observable{
    private Point location;

    public Entity(){
        this(new Point());
    }

    public Entity(Point location) {
        this.location = location;
    }

    //region Getters & setters
    /**
     * @return the current location of the entity
     */
    public Point getLocation() {
        return location;
    }
    /**
     * @param location the new location of the entity
     * @throws IllegalArgumentException if argument is null
     */
    public void setLocation(Point location) {
        ValidationUtils.assertNotNull(location);
        this.location = location;
    }
    //endregion
}
