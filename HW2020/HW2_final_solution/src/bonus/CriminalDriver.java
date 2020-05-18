/**
 * 
 */
package bonus;

import components.Junction;
import components.LightedJunction;
import components.Road;
import components.RouteParts;
import components.Vehicle;

/**Represents a criminal driver 
 * @author Sophie Krimberg
 *
 */
public class CriminalDriver extends Driver {
	
	
	/**
	 *for criminal driver the method treats both junctions and roads
	 *and replaces the checkAvailability method also.
	 *@param vehicle 
	 */
	@Override
	public boolean canLeave(Vehicle vehicle) {
		RouteParts part=vehicle.getCurrentRoutePart();
		if (part instanceof Junction) {
			//check if there are exiting roads
			if (((Junction)part).getExitingRoads().size()==0) {
				vehicle.setStatus(new String(" - no exiting roads"));
				return false;
			}
		
			if (part instanceof LightedJunction) {//if there are traffic lights
				LightedJunction junc=(LightedJunction)part;
					if(junc.getLights().getTrafficLightsOn())//if traffic lights are working
						if (!vehicle.getLastRoad().getGreenLight()) {//if there is red light now
							vehicle.setStatus(new String(" for green light"));
							return false;
						}
			}
			return true;//all other cases of junction
		}
		else {//in case of a road
			Road road=(Road)part;
			if (road.calcLength()/vehicle.getVehicleType().getAverageSpeed()-vehicle.getTimeOnCurrentPart()>0){
				vehicle.setStatus(new String("is still moving on "));
				return false;
			}
			return true;
		}
			
		
		
		
			
	}
	
	
	@Override
	public void stayOnCurrentPart(Vehicle vehicle) {
		if (vehicle.getCurrentRoutePart() instanceof Road) {
			Road road=(Road)vehicle.getCurrentRoutePart();
			System.out.println("- " + vehicle.getStatus() + road + ", time to arrive: "+ (road.calcLength()/vehicle.getVehicleType().getAverageSpeed()-vehicle.getTimeOnCurrentPart()));
		}
		else vehicle.getCurrentRoutePart().stayOnCurrentPart(vehicle);
	}

	
	@Override
	public String toString() {
		return "Criminal driver";
		}
}
