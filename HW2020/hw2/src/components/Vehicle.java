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
	
	public Vehicle(Road road) {
		this.setId(this.getObjectsCount());
		this.setStatus(null);
		this.setVehicleType(road.getVehicleTypes()[ new Random().nextInt(road.getVehicleTypes().length)]);
		this.setLastRoad(road);
		System.out.println("Vehicle "+ this.objectsCount +": "+ this.vehicleType.name()+", average speed: "+ this.vehicleType.getAverageSpeed()+"  has been created");
		this.setObjectsCount(objectsCount+1);
	}
	
	public void move(){
		
	}
	
	public void incrementDrivingTime() {
		
	}
	//================================

	//get and set
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleType=" + vehicleType + ", currentRoute=" + currentRoute
				+ ", currentRoutePart=" + currentRoutePart + ", timeFromRouteStart=" + timeFromRouteStart
				+ ", timeOnCurrentPart=" + timeOnCurrentPart + ", lastRoad=" + lastRoad + ", status=" + status + "]";
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public RouteParts getCurrentRoutePart() {
		return currentRoutePart;
	}

	public void setCurrentRoutePart(RouteParts currentRoutePart) {
		this.currentRoutePart = currentRoutePart;
	}

	public int getTimeFromRouteStart() {
		return timeFromRouteStart;
	}

	public void setTimeFromRouteStart(int timeFromRouteStart) {
		this.timeFromRouteStart = timeFromRouteStart;
	}

	public int getTimeOnCurrentPart() {
		return timeOnCurrentPart;
	}

	public void setTimeOnCurrentPart(int timeOnCurrentPart) {
		this.timeOnCurrentPart = timeOnCurrentPart;
	}

	public int getObjectsCount() {
		return objectsCount;
	}

	public void setObjectsCount(int objectsCount) {
		this.objectsCount = objectsCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Road getLastRoad() {
		return lastRoad;
	}

	public void setLastRoad(Road lastRoad) {
		this.lastRoad = lastRoad;
	}

	public Route getCurrentRoute() {
		return currentRoute;
	}

	public void setCurrentRoute(Route currentRoute) {
		this.currentRoute = currentRoute;
	}

	
	//================================


	
	@Override
	public boolean checkValue(double Val, double min, double max) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void correctingMessage(double wrongVal, double correctVal, String varName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void errorMessage(double wrongVal, String varName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getRandomBoolean() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRandomDouble(double min, double max) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getRandomInt(int min, int max) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Integer> getRandomIntArray(int min, int max, int arraySize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void successMessage(String objName) {
		// TODO Auto-generated method stub
		
	}
	
	
}
