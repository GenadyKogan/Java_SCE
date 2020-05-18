package game.arena;

import game.entities.IMobileEntity;

/**
 * Created by itzhak on 25-Mar-19.
 */
public interface IArena {
    double getFriction();
    boolean isFinished(IMobileEntity mobileEntity);
    double getLength();
}
