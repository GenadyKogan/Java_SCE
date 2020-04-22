package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Road {
	private Junction fromJunc;
	private Junction toJunc;
	private ArrayList<VehicleType> allowedVehicles; //// holds the list of vehicle types that are allowed to move on the road.
	private boolean isOpen; // True when the light is green.
	private boolean isEnabled; //appears on the map
	private double length; // the distance between the two junctions.
	private int maxSpeed;
	private VehicleType allowed;
	/*******************************************************/
	/**
	 * Ctor for a Road
	 * @param from - Type Junction
	 * @param to - Type Junction
	 */
	
	public Road (Junction from, Junction to) {
		this.setFromJunc(from);
		this.setToJunc(to);

	}
	/**
	 * Ctor for a Road
	 * @param from - Type Junction
	 * @param to - Type Junction
	 * @param allowed - Type ArrayList<VehicleType>
	 * @param isOpen - Type boolean
	 */
	
	public Road(Junction from, Junction to, ArrayList<VehicleType> allowed, boolean isOpen,
			boolean isEnabled) {
		this.setFromJunc(from);
		this.setToJunc(to);
		this.setAllowedVehicle(allowed);
		this.setOpen(isOpen);
		this.setEnabled(isEnabled);

	}

	/**
	 * Ctor for a Road
	 * @param from - Type Junction
	 * @param to - Type Junction
	 * @param vehicleType - Type VehicleType
	 * @param isOpen - Type boolean
	 */
	
	public Road(Junction from, Junction to, VehicleType vehicleType, boolean isOpen,
			boolean isEnabled) {
		this.setFromJunc(from);
		this.setToJunc(to);
		this.setAllowed(vehicleType);
		this.setOpen(isOpen);
		this.setEnabled(isEnabled);		
		this.setLength(new Random().nextInt(990000) + 3000 );
		this.setMaxSpeed(new Random().nextInt(160) + 30 );
		this.fromJunc.addEnterRoad(new Road(to,from));
		this.toJunc.addExitRoad(new Road(to,from));
		this.allowedVehicles=new ArrayList<VehicleType>();
		this.initVehicles();


	}
	
	
	/*******************************************************/

	/**
	 * @param No parameters
	 * @return fromJunc - Type Junction
	 */
	public Junction getFromJunc() {
		return fromJunc;
	}

	/**
	 * @param fromJunc - Type Junction
	 * @return nothing - Initializes an fromJunc
	 */
	public void setFromJunc(Junction fromJunc) { 
		this.fromJunc=fromJunc;
	}
	
	
	/**
	 * @param No parameters
	 * @return toJunc - Type Junction
	 */
	public Junction getToJunc() {
		return toJunc;
	}
	
	/**
	 * @param toJunc - Type Junction
	 * @return nothing - Initializes an toJunc
	 */
	public void setToJunc(Junction toJunc) {
		this.toJunc=toJunc; 
	}
	
	
	/**
	 * @param No parameters
	 * @return allowedVehicles - Type ArrayList<VehicleType>
	 */
	public ArrayList<VehicleType> getAllowedVehicle() {
		return allowedVehicles;
	}
	
	/**
	 * @param allowedVehicles - Type ArrayList<VehicleType>
	 * @return nothing - Initializes an allowedVehicles 
	 */	
	public void setAllowedVehicle(ArrayList<VehicleType> allowedVehicles){
		this.allowedVehicles =allowedVehicles;
	}
	
	/**
	 * @param No parameters
	 * @return isOpen - Type boolean
	 */
	public boolean isOpen() {
		return isOpen;
	}
	/**
	 * @param isOpen - Type boolean
	 * @return nothing - Initializes an isOpen
	 */
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	/**
	 * @param No parameters
	 * @return isEnabled - Type boolean
	 */
	public boolean isEnabled() {
		return isEnabled;
	}
	/**
	 * @param isEnabled - Type boolean
	 * @return nothing - Initializes an isEnabled
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;

	}
	
	/**
	 * @param No parameters
	 * @return length - Type double
	 */
	public double getLength() {
		return length;
	}
	/**
	 * @param length - Type double
	 * @return nothing - Initializes an length
	 */
	public void setLength(double length) {
		this.length = length;

	}
	/**
	 * @param No parameters
	 * @return maxSpeed - Type int
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}
	/**
	 * @param maxSpeed - Type int
	 * @return nothing - Initializes an maxSpeed
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	/**
	 * @param No parameters
	 * @return allowed - Type VehicleType
	 */
	public VehicleType getAllowed() {
		return allowed;
	}
	/**
	 * @param vehicleType - Type VehicleType
	 * @return nothing - Initializes an vehicleType
	 */
	public void setAllowed(VehicleType vehicleType) {
		this.allowed = vehicleType;
	}

	/*******************************************************/
	/**
	 * @param No parameters
	 * @return String - Print the data for a fromJunc and toJunc
	 */
	@Override
	public String toString() {
		return "Road from "+ fromJunc+ " to "+ toJunc;
	}
	
	/**
	 * @param other - Object type
	 * @return Boolean value - true or false
	 */	
	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Junction) {
			ans=( this.fromJunc==((Road)other).fromJunc   &&  this.toJunc==((Road)other).toJunc && this.allowedVehicles ==((Road)other).allowedVehicles &&  this.isOpen ==((Road)other).isOpen && this.isEnabled ==((Road)other).isEnabled && this.length ==((Road)other).length && this.maxSpeed ==((Road)other).maxSpeed);
			return ans;
		}
		return ans;
	}	
	
	/*******************************************************/
	/**
	 * @param type - Type VehicleType
	 * @return ans - Type boolean
	 * function add type
	 */
	public boolean addVehicleType(VehicleType type) {
		boolean ans=false;
		if(type!=null) {
			for(int i=0;i<this.allowedVehicles.size();i++) {
				if(this.allowedVehicles.get(i).equals(type)) {
					ans=true;
					break;
				}
			}			
			if(ans==false) {
				this.allowedVehicles.add(type);
			}
		}
		return ans;
	}
	
	/*******************************************************/
	/**
	 * @param No parameters
	 * @return dist - Type double
	 * calculates the length of the road using the coordinates of its junctions.
	 */
	public double countLength() {
		double xPoint=fromJunc.getLocation().getX()-fromJunc.getLocation().getX() ;
		double yPoint=toJunc.getLocation().getY()-toJunc.getLocation().getY() ;
		double dist =Math.sqrt(xPoint*xPoint + yPoint*yPoint);
		return dist;
		
	}
	/**
	 * @param No parameters
	  @return nothing - add Vehicle
	 */	
	public void initVehicles() {
		int size=(new Random().nextInt(5) + 1 );
		for (int i = 0; i < size; i++) {
			this.allowedVehicles.add(allowed.getRandomVehicleTypes());

		}
		
	}

	
}
