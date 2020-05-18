package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import utilities.Utilities;
import utilities.VehicleType;

public class Road  implements RouteParts, Utilities{
	private int [] allowedSpeedOptions;
	private boolean enable;
	private Junction startJunction;
	private Junction endJunction;
	private boolean greenlight;
	private double length;
	private int maxSpeed;
	private  VehicleType[] vehicleTypes;
	private ArrayList<Vehicle> waitingVehicles;
	//================================

	/**Constructor
	 * 	creates a new Road between 2 given junctions
	 *  sets random max allowed speed and vehicle types.
	 * @param from represents the start junction
	 * @param to represents the end junction
	 */
	public Road (Junction start, Junction end){

		this.allowedSpeedOptions= new int[]{20,40,50,55,60,70,80,90};
		
		VehicleType[] vehicleTypesList= {VehicleType.car,VehicleType.bus,VehicleType.bicycle, VehicleType.motorcycle, VehicleType.truck, VehicleType.tram, VehicleType.semitrailer};
		this.setVehicleTypes(vehicleTypesList);
		
		this.setStartJunction(start);
		this.setEndJunction(end);
		this.setWaitingVehicles(new ArrayList<Vehicle>());
		this.setGreenlight(false);
		this.setMaxSpeed(this.allowedSpeedOptions[ new Random().nextInt(this.allowedSpeedOptions.length)]);
		this.setLength(this.calcLength());
		this.setEnable(enable);
		this.endJunction.addEnteringRoad(this);
		this.startJunction.addExitingRoad(this);
		System.out.println("Road from "+this.startJunction.toString()+" to "+this.getEndJunction().toString()+" length: "+this.length+ ", max speed: "+this.maxSpeed+ " has been created");


	}

	//================================
	// set/get
	/**Sets vehicleTypes field
	 * 
	 * @param vehicleTypes - type VehicleType[] 
	 */
	private void setVehicleTypes(VehicleType[] vehicleTypes) {
		this.vehicleTypes=new VehicleType[7];
		for(int i=0;i<vehicleTypes.length;i++)
			this.vehicleTypes[i]=vehicleTypes[i];

	
	}
	/**Gets the allowedSpeedOptions value
	 * 
	 * @return int[]  for the road allowedSpeedOptions
	 */
	public int[] getAllowedSpeedOptions() {
		return allowedSpeedOptions;
	}
	/**Gets the enable value
	 * 
	 * @return boolean for the road enable
	 */
	public boolean isEnable() {
		return enable;
	}
	/**Sets enable field
	 * 
	 * @param enable - type boolean 
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	/**Gets the green light value
	 * 
	 * @return boolean for the road green light
	 */
	public boolean getGreenlight() {
		return greenlight;
	}
	/**Sets greenlight field
	 * 
	 * @param greenlight - type boolean 
	 */
	public void setGreenlight(boolean greenlight) {
		this.greenlight = greenlight;
	}
	/**Gets the road lenth value
	 * 
	 * @return double for the road length
	 */
	public double getLength() {
		return length;
	}
	/**Sets length field
	 * 
	 * @param length - type double 
	 */
	public void setLength(double length) {
		this.length = length;
	}
	/**Gets the road max speed
	 * 
	 * @return int for the road max speed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}
	/**Sets max speed field
	 * 
	 * @param maxSpeed - type int 
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	/**Gets the VehicleType  array
	 * 
	 * @return vehicleTypes - type VehicleType[]
	 */
	public VehicleType[] getVehicleTypes() {
		return vehicleTypes;
	}
	/**Sets vehicleType field
	 * 
	 * @param VehicleType represents the vehicleTypes. 
	 * @param index - type int 
	 */
	public void setVehicleTypes(VehicleType vehicleTypes,int index) {
		this.vehicleTypes[index] = vehicleTypes;
	}
	/**Gets the  ArrayList<Vehicle>  waitingVehicles
	 * 
	 * @return waitingVehicles - type ArrayList<Vehicle>
	 */
	public ArrayList<Vehicle> getWaitingVehicles() {
		return waitingVehicles;
	}
	/**Sets waitingVehicles field
	 * 
	 * @param ArrayList<Vehicle> represents the waitingVehicles. 
	 */
	public void setWaitingVehicles(ArrayList<Vehicle> waitingVehicles) {
		this.waitingVehicles =new ArrayList<Vehicle>(waitingVehicles);
	}
	/**Gets the  Junction  start Junction
	 * 
	 * @return startJunction - type Junction
	 */
	public Junction getStartJunction() {
		return startJunction;
	}
	/**Sets startJunction field
	 * 
	 * @param Junction represents the start junction. 
	 */
	public void setStartJunction(Junction startJunction) {
		this.startJunction = startJunction;
	}
	/**Gets the  Junction  end Junction
	 * 
	 * @return endJunction - type Junction
	 */
	public Junction getEndJunction() {
		return endJunction;
	}
	/**Sets endJunction field
	 * 
	 * @param Junction represents the end junction. 
	 */
	public void setEndJunction(Junction endJunction) {
			this.endJunction = endJunction;

	}


	//================================
	//methods
	/**Adds a vehicle  to the waiting vehicles list
	 * 
	 * @param type for given vehicle type to be added
	 */
	public void addVehicleToWaitingVehicles(Vehicle vehicle){
		this.waitingVehicles.add(vehicle);
	}
	/**
	 *  @param obj - type Object, A method that accepts as a show instance of a vehicle
	 *   @return  Estimated time the vehicle will pass
	 */
	public double calcEstimatedTime(Object obj){
		if(obj instanceof Vehicle) {
			return this.length/Math.min(this.maxSpeed,((Vehicle) obj).getVehicleType().getAverageSpeed());
		}
		return 0;
	}
	/**
	 * 
	 * @return int length of the road.
	 */
	public double calcLength(){
		double xPoint=this.startJunction.getX()-this.endJunction.getX();
		double yPoint=this.startJunction.getY()-this.endJunction.getY();
		return Math.sqrt(xPoint*xPoint + yPoint*yPoint);
		
	}
	/**
	 * A method is examining whether a vehicle could end its journey this way.
	 * @return true when the vehicle is in component time It is equal to or greater than estimated time that should take the vehicle to pass this route.
	 */
	public boolean canLeave(Vehicle vehicle){
		return vehicle.getTimeOnCurrentPart()<=vehicle.getTimeFromRouteStart();
		
	}
	/**
	 *  @param vehicle - type Vehicle
	 *  Method "puts" the vehicle on the road, updates all relevant fields
	 *  @return nothing
	 */
	public void checkIn(Vehicle vehicle){
		for(Vehicle i: waitingVehicles) {
			
			if (!i.equals(vehicle)) {
				this.waitingVehicles.add(i);
				System.out.println(" vehicle "+vehicle+" on the road ");
				break;
			}
		}
	}
	/**
	 *  @param vehicle - type Vehicle
	 * Method "releases" the vehicle out of the way, updating all relevant fields.
	 *  @return nothing
	 */
	public void checkout(Vehicle vehicle){
		for(Vehicle i: waitingVehicles) {
			
			if (i.equals(vehicle)) {
				this.waitingVehicles.remove(i);
				System.out.println(" vehicle "+vehicle+" delete on the road ");
				break;
			}
		}
	}
	/**Indicates whether some other Road object is "equal to" this one.
	 * @param other Road that is compared to this one.
	 * @return true if this object is the same as the other argument; false otherwise.
	 */
	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Road) {
			ans=( this.allowedSpeedOptions==((Road)other).allowedSpeedOptions   &&  this.enable==((Road)other).enable 
					&& this.startJunction ==((Road)other).startJunction &&  this.endJunction ==((Road)other).endJunction
					&& this.greenlight ==((Road)other).greenlight && this.length ==((Road)other).length
					&& this.maxSpeed ==((Road)other).maxSpeed) && this.vehicleTypes ==((Road)other).vehicleTypes
					&& this.waitingVehicles ==((Road)other).waitingVehicles;
			return ans;
		}
		return ans;
	}
	
	/**
	 *  @param vehicle - type Vehicle
	 * Returns the end junction of the road.
	 *  @return  one Roads found (random). If no suitable path returns null.
	 */
	public RouteParts findNextPart(Vehicle vehicle){
		return vehicle.getCurrentRoutePart();
		
	}
	/**
	 * removes waiting vehicles
	 * @param vehicle represents the Vehicle to be removed.
	 */
	public void removeVehicleFromWaitingVehicles(Vehicle vehicle){
		this.waitingVehicles.remove(vehicle);
	}
	/**
	 *  @param vehicle - type Vehicle
	 * Enabled when in the current pulse a vehicle stays that way (did not end the trip for example).
	 *  @return nothing
	 */
	public void stayOnCurrentPart(Vehicle vehicle){
		if(!vehicle.getCurrentRoutePart().equals(vehicle.getLastRoad())) {
			System.out.println("-is still moving on "+vehicle.getCurrentRoutePart()+", time to finish: "+vehicle.getTimeFromRouteStart());
		}
	}
	
	/**Returns a string representation of the object
	 * @return a String represents the object
	 */
	@Override
	public String toString() {
		return 	"Road from "+this.startJunction+" to "+this.endJunction+" length: "+this.length+ ", max speed: "+this.maxSpeed;

	}



	
}
