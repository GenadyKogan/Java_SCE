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
	
	public Road (Junction from, Junction to) {
		this.setFromJunc(from);
		this.setToJunc(to);

	}
	public Road(Junction from, Junction to, ArrayList<VehicleType> allowed, boolean isOpen,
			boolean isEnabled) {
		this.setFromJunc(from);
		this.setToJunc(to);
		this.setAllowedVehicle(allowed);
		this.setOpen(isOpen);
		this.setEnabled(isEnabled);

	}
	//**//
	public Road(Junction from, Junction to, VehicleType vehicleType, boolean isOpen,
			boolean isEnabled) {
		this.setFromJunc(from);
		this.setToJunc(to);
		this.setAllowed(vehicleType);
		this.setOpen(isOpen);
		this.setEnabled(isEnabled);		
		this.setLength(new Random().nextInt(990000) + 3000 );
		this.setMaxSpeed(new Random().nextInt(160) + 30 );
		this.fromJunc.addEnterRoad(new Road(from,to));
		this.toJunc.addExitRoad(new Road(to,from));
		this.allowedVehicles=new ArrayList<VehicleType>();
		this.addVehicleType(vehicleType);
	}
	
	
	/*******************************************************/

	
	public Junction getFromJunc() {
		return fromJunc;
	}
	public boolean setFromJunc(Junction fromJunc) {
		boolean ans=false;
		if(fromJunc instanceof Junction) {
			this.fromJunc=fromJunc;
			ans=true;
		}
		return ans;
	}
	
	public Junction getToJunc() {
		return toJunc;
	}
	
	public boolean setToJunc(Junction toJunc) {
		boolean ans=false;
		if(toJunc instanceof Junction) {
			this.toJunc=toJunc;
			ans=true;
		}
		return ans;
	}
	
	public ArrayList<VehicleType> getAllowedVehicle() {
		return allowedVehicles;
	}
	
	public boolean setAllowedVehicle(ArrayList<VehicleType> allowedVehicles) {		
		boolean ans=false;
		if(allowedVehicles instanceof ArrayList) {
			allowedVehicles=new ArrayList<VehicleType>();
			this.allowedVehicles =allowedVehicles;
			ans=true;
		}
		return ans;	
	}
	public boolean isOpen() {
		return isOpen;
	}
	
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}
	
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;

	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;

	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	/*------------------------*/
	public VehicleType getAllowed() {
		return allowed;
	}

	public void setAllowed(VehicleType vehicleType) {
		this.allowed = vehicleType;
	}

	/*******************************************************/

	public String toString() {
		return "Road from "+ fromJunc+ " to "+ toJunc;
	}
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
	public double countLength() {
		double xPoint=fromJunc.getLocation().getX()-fromJunc.getLocation().getX() ;
		double yPoint=toJunc.getLocation().getY()-toJunc.getLocation().getY() ;
		double dist =Math.sqrt(xPoint*xPoint + yPoint*yPoint);
		return dist;
		
	}


	
}
