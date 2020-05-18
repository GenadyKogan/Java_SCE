package components;

import utilities.Utilities;
/**
 *  Interface RouteParts extends Utilities
 *
 */
public interface RouteParts extends Utilities{
	double calcEstimatedTime(Object obj);
	boolean canLeave(Vehicle vehicle);
	void checkIn(Vehicle vehicle);
	void checkout(Vehicle vehicle);
	RouteParts findNextPart(Vehicle vehicle);
	void stayOnCurrentPart(Vehicle vehicle); 
}
