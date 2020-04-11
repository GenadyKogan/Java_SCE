package components;

import java.util.ArrayList;
import utilities.Point;

public class Road {
	private Junction fromJunc;
	private Junction toJunc;
	private ArrayList<VehicleType> allowedVehicles; //// holds the list of vehicle types that are allowed to move on the road.
	private boolean isOpen; // True when the light is green.
	private boolean isEnabled; //appears on the map
	private double length; // the distance between the two junctions.
	private int maxSpeed;
	/*******************************************************/
	
	public Road (Junction from, Junction to) {
		this.setFromJunc(from);
		this.setToJunc(to);
	}
	public Road(Junction from, Junction to, ArrayList<VehicleType> allowed, boolean isOpen,
			boolean isEnabled) {
		this.setFromJunc(from);
		this.setToJunc(to);
		this.setAllowedVehicles(allowed);
		this.setOpen(isOpen);
		this.setEnabled(isEnabled);
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
	
	public ArrayList<VehicleType> getAllowedVehicles() {
		return allowedVehicles;
	}
	
	public boolean setAllowedVehicles(ArrayList<VehicleType> allowedVehicles) {		
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

	/*******************************************************/
	@Override
	public String toString() {
		return "Road [fromJunc=" + fromJunc + ", toJunc=" + toJunc + ", allowedVehicles=" + allowedVehicles
				+ ", isOpen=" + isOpen + ", isEnabled=" + isEnabled + ", length=" + length + ", maxSpeed=" + maxSpeed
				+ "]";
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
	        for (VehicleType element : getAllowedVehicles()) { 
	            if (element == type) { 
	            	ans = true; 
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
	public int countLength() {
		// TODO Auto-generated method stub
		return 0;
		
	}
}
