package components;
import java.util.ArrayList;
import java.util.Random;

import utilities.Timer;
import utilities.Utilities;
import utilities.VehicleType;

public class Vehicle implements Utilities, Timer {
	private int id;
	private VehicleType vehicleType;
	private Route currentRoute ;
	private RouteParts currentRoutePart;
	private int timeFromRouteStart;
	private int timeOnCurrentPart;
	private static int objectsCount=1;
	private Road lastRoad;
	private String status;
	/**Constructor
	 * creates an object with given parameters, sets random route.
	 * @param road - type Road

	 */
	public Vehicle(Road road) {
		this.setId(this.getObjectsCount());
		this.setStatus(null);
		this.setVehicleType(road.getVehicleTypes()[ new Random().nextInt(road.getVehicleTypes().length)]);
		this.setLastRoad(road);
		System.out.println("Vehicle "+ this.objectsCount +": "+ this.vehicleType.name()+", average speed: "+ this.vehicleType.getAverageSpeed()+"  has been created");
		this.setCurrentRoutePart(lastRoad);
		this.setTimeFromRouteStart(getRandomInt(1, 15));
		this.setTimeOnCurrentPart(getRandomInt(1, 13));
		this.currentRoute=new Route(currentRoutePart,this);
		this.setObjectsCount(objectsCount+1);
		
	}
	//================================
	/**moves the vehicle from current junction to the next one on its route
	 * 
	 */
	public void move(){
		if(this.currentRoute.getRouteParts().get(1).equals(this.getLastRoad().getEndJunction() )) {
			this.lastRoad.getStartJunction().checkout(this);
			checkIn();
		}
		if(!this.currentRoutePart.equals(this.getLastRoad().getEndJunction())) {
			//System.out.println("-is still moving on "+this.currentRoutePart+", time to finish: "+this.getTimeFromRouteStart());
			this.currentRoute.stayOnCurrentPart(this);
		}
		else {
			this.lastRoad.getStartJunction().checkout(this);
		}
	}
	/**
	 * Promotes track time and time in current component and operation move()
	 */
	@Override
	public void incrementDrivingTime() {
		this.setTimeFromRouteStart(this.timeFromRouteStart+1);
		this.setTimeOnCurrentPart(timeOnCurrentPart+1);
		move();
		
		
		
	}
	/**Check in procedure for vehicle that just arrived to a junction
	 * 
	 */
	public void checkIn() {
		this.lastRoad.getWaitingVehicles().add(this);
		this.setTimeOnCurrentPart(timeOnCurrentPart+1);

		if (this.lastRoad.getStartJunction().equals(currentRoute.getRouteParts().get(currentRoute.getRouteParts().size()-1))) {
			
			System.out.println(this.toString() + " has finished the route. Total time: " + this.getTimeOnCurrentPart());
			this.currentRoute=new Route(currentRoutePart,this);
		}
		
	}
	/**Check out procedure for vehicle that is leaving a junction
	 * 
	 */
	public void checkOutJunc(Junction junc, Road road) {
		System.out.println(this.toString()+ " has left  " +junc.toString()+ ".");
		this.lastRoad.getWaitingVehicles().remove(this);
		lastRoad=road;
		
		
		
	}
	//================================

	/**
	 * @return a String represents the object
	 */
	@Override
	public String toString() {
		return "Vehicle "+this.id +" "+this.vehicleType +", average speed: " + this.vehicleType.getAverageSpeed();
	}

	//get and set
	/**Gets vehicle Id
	 * 
	 * @return int vehicle id
	 */
	public int getId() {
		return id;
	}

	/**Sets vehicle id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**Gets vehicle type
	 * 
	 * @return VehicleType object represents vehicle type
	 */
	public VehicleType getVehicleType() {
		return vehicleType;
	}


	/**Sets vehicle type to given type
	 * 
	 * @param type given vehicle type
	 */
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	/**Gets current route part
	 * 
	 * @return Route current route part
	 */
	public RouteParts getCurrentRoutePart() {
		return currentRoutePart;
	}
	/**Sets given route part to vehicle
	 * 
	 * @param route represents given route part
	 */
	public void setCurrentRoutePart(RouteParts currentRoutePart) {
		this.currentRoutePart = currentRoutePart;
	}
	/**Gets ctimeFromRouteStart
	 * 
	 * @return timeFromRouteStart - type int
	 */
	public int getTimeFromRouteStart() {
		return timeFromRouteStart;
	}

	public void setTimeFromRouteStart(int timeFromRouteStart) {
		this.timeFromRouteStart = timeFromRouteStart;
	}
	/**Gets timeOnCurrentPart
	 * 
	 * @return timeOnCurrentPart - type int
	 */
	public int getTimeOnCurrentPart() {
		return timeOnCurrentPart;
	}
	/**Sets given time on current part to vehicle
	 * 
	 * @param timeOnCurrentPart
	 */
	public void setTimeOnCurrentPart(int timeOnCurrentPart) {
		this.timeOnCurrentPart = timeOnCurrentPart;
	}
	/**Gets objectsCount
	 * 
	 * @return objectsCount - type int
	 */
	public int getObjectsCount() {
		return objectsCount;
	}

	/**Sets given objects count to vehicle
	 * 
	 * @param objectsCount
	 */
	public void setObjectsCount(int objectsCount) {
		this.objectsCount = objectsCount;
	}
	/**Gets status
	 * 
	 * @return status - type String
	 */
	public String getStatus() {
		return status;
	}
	/**Sets given status to vehicle
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**Gets last road
	 * 
	 * @return Road last road
	 */
	public Road getLastRoad() {
		return lastRoad;
	}
	/**Sets last road
	 * 
	 * @param road Road object
	 */
	public void setLastRoad(Road lastRoad) {
		this.lastRoad = lastRoad;
	}
	/**Gets current route
	 * 
	 * @return Route current route
	 */
	public Route getCurrentRoute() {
		return currentRoute;
	}
	/**Sets given route to vehicle
	 * 
	 * @param route represents given route
	 */
	public void setCurrentRoute(Route currentRoute) {
		this.currentRoute = currentRoute;
	}

///
}
