/**
 * 
 */
package components;

import java.util.ArrayList;



/**Represents a route for a vehicle
 * @author Sophie Krimberg
 *
 */
public class Route implements RouteParts {

	ArrayList<RouteParts> routeParts;
	Vehicle vehicle;
	
	
	/**Constructor
	 * @param start
	 * @param vehicle
	 */
	public Route(RouteParts start, Vehicle vehicle) {
		routeParts=new ArrayList<RouteParts>();
		this.vehicle=vehicle;
		routeParts.add(start);
		boolean flag=true;
		//TODO cancel the flag, use break
		while (routeParts.size()<10&&flag) {
			RouteParts part=getLastPart().findNextPart(vehicle);
			if (part!=null) {
				routeParts.add(part);
				
			}
			else {
				flag=false;
			}
		}
		checkIn(vehicle);		
	}

	/**
	 * @return the routeParts
	 */
	public ArrayList<RouteParts> getRouteParts() {
		return routeParts;
	}

	/**
	 * @param routeParts the routeParts to set
	 */
	public void setRouteParts(ArrayList<RouteParts> routeParts) {
		this.routeParts = routeParts;
	}

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public RouteParts getLastPart() {
		if (routeParts.size()>0)
			return routeParts.get(routeParts.size()-1);
		else return null;
	}
	public RouteParts getFirstPart() {
		if (routeParts.size()>0)
			return routeParts.get(0);
		else return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false; 
	    if (getClass() != obj.getClass()) return false; 
	    if (! super.equals(obj)) return false;
	    Route other=(Route)obj;
	    if (this.routeParts!=other.routeParts || !this.vehicle.equals(other.vehicle)) return false;
	    return true;
	}
	
	@Override
	public double calcEstimatedTime(Object obj) {
		int result=0;
		Road lastRoad=vehicle.getLastRoad();
		for (int i=0; i<routeParts.size();i++) {
			result+=routeParts.get(i).calcEstimatedTime(vehicle);
			if (i%2==0) {//calc the junctions from the road that will lead to them
				vehicle.setLastRoad((Road)routeParts.get(i));
			}	
		}
		vehicle.setLastRoad(lastRoad);
		return result;
	}


	@Override
	public RouteParts findNextPart(Vehicle vehicle) {
		
		//if vehicle has arrived to the last part of route 
		if (canLeave(vehicle)) {
			vehicle.getLastRoad().removeVehicleFromWaitingVehicles(vehicle);
			this.checkOut(vehicle);//drop current route
			//if there are no any exiting road from current point
			if (vehicle.getCurrentRoutePart().findNextPart(vehicle)==null) {
				
				new Route(this.getFirstPart(), vehicle);//Receive new route from the first point of the old route
			}
			else {
				new Route(vehicle.getLastRoad(), vehicle);//Receive new route from the last point fo the old route
			}
			return vehicle.getCurrentRoute().findNextPart(vehicle);
		}
		
		//else
		return routeParts.get(routeParts.indexOf(vehicle.getCurrentRoutePart())+1);
		
	}

	@Override
	public void checkIn(Vehicle vehicle) {
		vehicle.setTimeFromRouteStart(0);
		System.out.println("- is starting a new "+this+"." );
		this.getFirstPart().checkIn(vehicle);
		
		
		
	}

	@Override
	public void checkOut(Vehicle vehicle) {
		System.out.println("- has finished the "+this+". Time spent on the route: "+ vehicle.getTimeFromRouteStart());
		
	}
	
	@Override
	public String toString() {
		return new String("Route from "+getFirstPart()+" to "+getLastPart()+", estimated time for route: "+calcEstimatedTime(vehicle));
	}

	@Override
	public void stayOnCurrentPart(Vehicle vehicle) {
		System.out.println("- is still moving on the "+ this +".");
	}


	@Override
	public boolean canLeave(Vehicle vehicle) {
		if (vehicle.getCurrentRoutePart().equals(this.getLastPart()))
			return true;
		return false;
	}

}