/**
 * 
 */
package bonus;

import components.Vehicle;

/**Represents a vehicle driver
 * @author Sophie Krimberg
 *
 */
public class Driver implements utilities.Utilities{
	
 /**Constructor
 * 
 */
public Driver() {
	  System.out.println(this + " is driving this Vehicle");
  }
	
  public boolean canLeave(Vehicle vehicle) {
	  return vehicle.getCurrentRoutePart().canLeave(vehicle);
	  

  }
  
  public void stayOnCurrentPart(Vehicle vehicle) {
	 vehicle.getCurrentRoutePart().stayOnCurrentPart(vehicle);
  }
  
  @Override
  public String toString() {
	  return "Regular Driver";
  }
}
