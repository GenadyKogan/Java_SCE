/**
 * 
 */
package bonus;

import components.Driving;
import components.Road;

/**
 * @author Sophie Krimberg
 *
 */
public class BonusDriving extends Driving {
		
	/**Constructor
	 * @param numOfJuncs quantity of junctions in the game
	 * @param numOfVehicles quantity of vehicles
	 */
	public BonusDriving(int numOfJuncs, int numOfVehicles) {
		super(numOfJuncs, 0);
		this.addVehicles(numOfVehicles);
		
		
	}

	
	/**Creates given quantity of vehicles and add them to the game
	 * @param numOfVehicles quantity of vehicles
	 */
	public void addVehicles(int numOfVehicles) {
		while(getVehicles().size()<numOfVehicles) {
			Road temp=getMap().getRoads().get(getRandomInt(0,getMap().getRoads().size()));//random road from the map
			if( temp.getEnabled())
				this.getVehicles().add(new DrivedVehicle(temp));
		
		}
		getAllTimedElements().addAll(0,getVehicles());		
	}
	
}
