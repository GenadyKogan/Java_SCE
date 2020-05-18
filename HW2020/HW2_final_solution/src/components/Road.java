package components;
import java.util.ArrayList;

import utilities.VehicleType;

/**Represents a road 
 * @author Sophie Krimberg
 *
 */
public class Road implements RouteParts{
	private final static int[] allowedSpeedOptions= {30,40,50,55,60,70,80,90};
	Junction startJunction;
	Junction endJunction;
	private ArrayList<Vehicle> waitingVehicles;
	private boolean greenLight;
	private int maxSpeed;
	VehicleType [] vehicleTypes;
	double length;
	boolean enable;
	
	/**Constructor
	 * @param start
	 * @param end
	 */
	public Road(Junction start, Junction end) {
		startJunction=start;
		endJunction=end;
		waitingVehicles=new ArrayList<Vehicle>();
		greenLight=false;
		maxSpeed=allowedSpeedOptions[getRandomInt(0,7)];
		
		int numOfTypes=getRandomInt(3,VehicleType.values().length);
		
		vehicleTypes=new VehicleType[numOfTypes];
		VehicleType[] types=VehicleType.values();
		ArrayList <Integer> arr=getRandomIntArray(0,6,numOfTypes);
		
		
		for (int i=0;i<numOfTypes;i++) {
			vehicleTypes[i]=types[arr.get(i)];
		}
		this.getStartJunction().getExitingRoads().add(this);
		this.getEndJunction().getEnteringRoads().add(this);
		
		setLength();
		enable=!(getRandomBoolean()&&getRandomBoolean()&&getRandomBoolean());
		successMessage(this.toString());
	}
	
	
	/**
	 * @return the startJunction
	 */
	public Junction getStartJunction() {
		return startJunction;
	}


	/**
	 * @param startJunction the startJunction to set
	 */
	public void setStartJunction(Junction startJunction) {
		this.startJunction = startJunction;
	}


	/**
	 * @return the endJunction
	 */
	public Junction getEndJunction() {
		return endJunction;
	}


	/**
	 * @param endJunction the endJunction to set
	 */
	public void setEndJunction(Junction endJunction) {
		this.endJunction = endJunction;
	}


	/**
	 * @return the waitingVehicles
	 */
	public ArrayList<Vehicle> getWaitingVehicles() {
		return waitingVehicles;
	}


	/**
	 * @param waitingVehicles the waitingVehicles to set
	 */
	public void setWaitingVehicles(ArrayList<Vehicle> waitingVehicles) {
		this.waitingVehicles = waitingVehicles;
	}


	/**
	 * @return the greenLight
	 */
	public boolean getGreenLight() {
		return greenLight;
	}


	/**
	 * @param greenLight the greenLight to set
	 */
	public void setGreenLight(boolean greenLight) {
		this.greenLight = greenLight;
	}


	/**
	 * @return the maxSpeed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}


	/**
	 * @param maxSpeed the maxSpeed to set
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	/**
	 * @return the vehicleTypes
	 */
	public VehicleType[] getVehicleTypes() {
		return vehicleTypes;
	}


	/**
	 * @param vehicleTypes the vehicleTypes to set
	 */
	public void setVehicleTypes(VehicleType[] vehicleTypes) {
		this.vehicleTypes = vehicleTypes;
	}

	public void addVehicleToWaitingVehicles(Vehicle vehicle) {
		waitingVehicles.add(vehicle);
	}
	public void removeVehicleFromWaitingVehicles(Vehicle vehicle) {
		waitingVehicles.remove(vehicle);
	}
	
	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}


	/**set length to the calculated value
	 * 
	 */
	public void setLength() {
		this.length = calcLength();
	}


	/**
	 * @return the enable
	 */
	public boolean getEnabled() {
		return enable;
	}


	/**
	 * @param enable the enable to set
	 */
	public void setEnabled(boolean enable) {
		this.enable = enable;
	}


	/**
	 * @return the allowedspeedoptions
	 */
	public static int[] getAllowedspeedoptions() {
		return allowedSpeedOptions;
	}


	public double calcLength() {
		return startJunction.calcDistance(endJunction);
	}


	@Override
	public double calcEstimatedTime(Object obj) {
		Vehicle v=(Vehicle)obj;
		int speed=Math.min(maxSpeed, v.getVehicleType().getAverageSpeed());
		return (int)length/speed;
	}

	
	@Override
	public RouteParts findNextPart(Vehicle vehicle) {
		return endJunction;
	}
	
	@Override
	public void checkIn(Vehicle vehicle) {
		vehicle.setCurrentRoutePart(this);
		vehicle.setTimeOnCurrentPart(0);
		vehicle.setLastRoad(this);
		System.out.println("- is starting to move on "+ this + ", time to finish: " + calcEstimatedTime(vehicle)+ ".");
	}
	@Override
	public void stayOnCurrentPart(Vehicle vehicle) {
		System.out.println("- " + vehicle.getStatus() + this + ", time to arrive: "+ (calcEstimatedTime(vehicle)-vehicle.getTimeOnCurrentPart()));
	}

	@Override
	public void checkOut(Vehicle vehicle) {
		System.out.println("- has finished "+ this+ ", time spent on the road: "+vehicle.getTimeOnCurrentPart()+".");
		addVehicleToWaitingVehicles(vehicle);
		
	}

	@Override
	public String toString() {
		return new String("Road from "+getStartJunction()+" to "+getEndJunction()+ ", length: "+ (int)length+ ", max speed "+this.maxSpeed);
	}

	@Override
	public boolean equals(Object other) {
		
		if (other == null) return false; 
	    if (getClass() != other.getClass()) return false; 
	    if (! super.equals(other)) return false;
	    Road otherRoad=(Road)other;
	    if (this.enable!=otherRoad.enable || 
	    	!this.endJunction.equals(otherRoad.endJunction) ||
	    	this.length!=otherRoad.length ||
	    	this.maxSpeed!=otherRoad.maxSpeed||
	    	!this.startJunction.equals(otherRoad.startJunction)||
	    	this.vehicleTypes!=otherRoad.vehicleTypes  //compare by reference
	    	) return false;
	    return true;
		}


	@Override
	public boolean canLeave(Vehicle vehicle) {
		if (calcEstimatedTime(vehicle)-vehicle.getTimeOnCurrentPart()>0){
			vehicle.setStatus(new String("is still moving on "));
			return false;
		}
		return true;
	}


	
	
}
