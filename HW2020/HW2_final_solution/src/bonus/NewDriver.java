/**
 * 
 */
package bonus;

import components.Junction;
import components.LightedJunction;
import components.Road;
import components.RouteParts;
import components.Vehicle;

/**
 * @author krsof
 *
 */
public class NewDriver extends Driver {
	boolean additionalTimeOver=false;
	
	public String toString() {
		return "New driver";
		}

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
						return junc.canLeave(vehicle);
			}
			//for all other cases of junction
			//wait a turn
			if (!additionalTimeOver) {//the additional delay on non-lighted junction is not over
					vehicle.setStatus(" - takes some time to check the traffic");
					additionalTimeOver=true;
					return false;
			}
			else {//additional delay is over
					if (part.canLeave(vehicle))
						additionalTimeOver=true;//reset the variable for use in other juncs
					return part.canLeave(vehicle);
			}
		}// end if_junction
			
		else {//in case of a road
			Road road=(Road)part;
			if (road.calcLength()/(Math.min(vehicle.getVehicleType().getAverageSpeed(), road.getMaxSpeed())-10)-vehicle.getTimeOnCurrentPart()>0){
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
			System.out.println("- " + vehicle.getStatus() + road + ", time to arrive: "+ (road.calcLength()/(Math.min(vehicle.getVehicleType().getAverageSpeed(), road.getMaxSpeed())-10)-vehicle.getTimeOnCurrentPart()));
		}
		else vehicle.getCurrentRoutePart().stayOnCurrentPart(vehicle);
	}

	/**
	 * @return the additionalTimeOver
	 */
	public boolean isAdditionalTimeOver() {
		return additionalTimeOver;
	}

	/**
	 * @param additionalTimeOver the additionalTimeOver to set
	 */
	public void setAdditionalTimeOver(boolean additionalTimeOver) {
		this.additionalTimeOver = additionalTimeOver;
	}
	
	
	
}
