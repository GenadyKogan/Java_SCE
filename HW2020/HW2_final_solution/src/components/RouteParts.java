/**
 * 
 */
package components;

import utilities.Utilities;


/**
 * @author krsof
 *
 */
public interface RouteParts extends Utilities {

	/**Calculates the estimated time that will take for a car to pass a route part
	 * @param obj
	 * @return
	 */
	public double calcEstimatedTime(Object obj);
	
	/**finds the next possible route part
	 * @param vehicle
	 * @return
	 */
	public RouteParts findNextPart(Vehicle vehicle);
	
	
	/**
	 * @param vehicle
	 */
	public void checkIn (Vehicle vehicle);
	
	/**
	 * @param vehicle
	 */
	public void checkOut (Vehicle vehicle);
	
	/**
	 * @param other
	 * @return
	 */
	public boolean equals(Object other);
	
	/**
	 * @param vehicle
	 */
	public void stayOnCurrentPart(Vehicle vehicle);
	
	/**
	 * @param vehicle
	 * @return
	 */
	public boolean canLeave(Vehicle vehicle);
	
}


