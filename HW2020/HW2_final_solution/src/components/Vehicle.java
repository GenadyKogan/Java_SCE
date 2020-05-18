/**
 * 
 */
package components;


import utilities.Timer;
import utilities.Utilities;
import utilities.VehicleType;
/**
 * @author Sophie Krimberg
 *
 */
/**
 * @author krsof
 *
 */
public class Vehicle implements Utilities, Timer {
	private int id;
	private VehicleType vehicleType;
	private Route currentRoute;
	private RouteParts currentRoutePart;
	private int timeFromRouteStart;
	private static int objectsCount=1;
	private int timeOnCurrentPart;
	private Road lastRoad;
	private String status;
	
	/**Random Constructor
	 * @param currentLocation
	 */
	public Vehicle (Road currentLocation) {

		id=objectsCount++;
		vehicleType=currentLocation.getVehicleTypes()[getRandomInt(0,currentLocation.getVehicleTypes().length-1)];
		System.out.println();
		successMessage(this.toString());
		currentRoute=new Route(currentLocation, this); //creates a new route for the vehicle and checks it in
		lastRoad=currentLocation;
		status=null;
		
	}
	
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}




	/**
	 * @return the vehicleType
	 */
	public VehicleType getVehicleType() {
		return vehicleType;
	}




	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}




	/**
	 * @return the currentRoute
	 */
	public Route getCurrentRoute() {
		return currentRoute;
	}




	/**
	 * @param currentRoute the currentRoute to set
	 */
	public void setCurrentRoute(Route currentRoute) {
		this.currentRoute = currentRoute;
	}




	/**
	 * @return the currentRoutePart
	 */
	public RouteParts getCurrentRoutePart() {
		return currentRoutePart;
	}




	/**
	 * @param currentRoutePart the currentRoutePart to set
	 */
	public void setCurrentRoutePart(RouteParts currentRoutePart) {
		this.currentRoutePart = currentRoutePart;
	}




	/**
	 * @return the timeFromRouteStart
	 */
	public int getTimeFromRouteStart() {
		return timeFromRouteStart;
	}




	/**
	 * @param timeFromRouteStart the timeFromRouteStart to set
	 */
	public void setTimeFromRouteStart(int timeFromRouteStart) {
		this.timeFromRouteStart = timeFromRouteStart;
	}




	/**
	 * @return the timeOnCurrentPart
	 */
	public int getTimeOnCurrentPart() {
		return timeOnCurrentPart;
	}




	/**
	 * @param timeOnCurrentPart the timeOnCurrentPart to set
	 */
	public void setTimeOnCurrentPart(int timeOnCurrentPart) {
		this.timeOnCurrentPart = timeOnCurrentPart;
	}




	/**
	 * @return the lastRoad
	 */
	public Road getLastRoad() {
		return lastRoad;
	}




	/**
	 * @param lastRoad the lastRoad to set
	 */
	public void setLastRoad(Road lastRoad) {
		this.lastRoad = lastRoad;
	}




	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}




	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}




	/**
	 * @return the objectsCount
	 */
	public static int getObjectsCount() {
		return objectsCount;
	}




	@Override
	public void incrementDrivingTime() {
		timeFromRouteStart++;
		timeOnCurrentPart++;
		move();
	}
	
	/**controls the vehicle moving from one route part to the next one
	 * 
	 */
	public void move() {
		if (currentRoutePart.canLeave(this)) {
			currentRoutePart.checkOut(this);
			currentRoute.findNextPart(this).checkIn(this);
		}
		else {
			currentRoutePart.stayOnCurrentPart(this);
		}
	}
	
	
	@Override
	public String toString() {
		return new String("Vehicle "+id+": "+ getVehicleType().name()+", average speed: "+getVehicleType().getAverageSpeed());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false; 
	    if (getClass() != obj.getClass()) return false; 
	    if (! super.equals(obj)) return false;
		Vehicle other=(Vehicle)obj;
		if (this.currentRoute!=other.currentRoute||
			this.currentRoutePart!=other.currentRoutePart||
			this.id!=other.id||
			this.lastRoad!=other.lastRoad||
			this.status!=other.status||
			this.timeFromRouteStart!=other.timeFromRouteStart||
			this.timeOnCurrentPart!=other.timeOnCurrentPart||
			this.vehicleType!=other.vehicleType)
				return false;
		return true;
	}

	/**
	 * @param objectsCount the objectsCount to set
	 */
	public static void setObjectsCount(int objectsCount) {
		Vehicle.objectsCount = objectsCount;
	}
	
	
}
