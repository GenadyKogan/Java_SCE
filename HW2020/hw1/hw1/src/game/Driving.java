package game;

import java.util.ArrayList;
import java.util.Random;

import components.Junction;
import components.Map;
import components.Road;
import components.Vehicle;
import components.VehicleType;

public class Driving {

	private int numOfJuncs;
	private int numOfVehicles;
	private Map currentMap;
	private ArrayList<Vehicle> currentVehicles;
	private double drivingTime; // time passed from the beginning of driving session
	private int maxTime; // total round time
	/*******************************************************/
	public Driving(int juncs, int vehicles, int maxTime) {
		this.setNumOfJuncs(juncs);
		this.setNumOfVehicles(vehicles);
		this.setMaxTime(maxTime);
	}
	/*******************************************************/
	public int getNumOfJuncs() {
		return numOfJuncs;
	}
	
	public void setNumOfJuncs(int numOfJuncs) {
		this.numOfJuncs = numOfJuncs;
	}
	
	public int getNumOfVehicles() {
		return numOfVehicles;
	}
	
	public void setNumOfVehicles(int numOfVehicles) {
		this.numOfVehicles = numOfVehicles;
	}
	
	public Map getCurrentMap() {
		return currentMap;
	}
	
	public boolean setCurrentMap(Map currentMap) {
		boolean ans=false;
		if(currentMap instanceof Map) {
			this.currentMap = currentMap;
			ans=true;
		}
		return ans;	
		
	}
	public ArrayList<Vehicle> getCurrentVehicles() {
		return currentVehicles;
	}
	
	public boolean setCurrentVehicles(ArrayList<Vehicle> currentVehicles) {
		boolean ans=false;
		if(currentVehicles instanceof ArrayList) {
			currentVehicles =new ArrayList<Vehicle>();
			this.currentVehicles=currentVehicles;
			ans=true;
		}
		return ans;	
	}
	
	public double getDrivingTime() {
		return drivingTime;
	}
	
	public void setDrivingTime(double drivingTime) {
			this.drivingTime = drivingTime;
	}
	
	public int getMaxTime() {
		return maxTime;
	}
	
	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
	/*******************************************************/
	@Override
	public String toString() {
		return "Driving [numOfJuncs=" + numOfJuncs + ", numOfVehicles=" + numOfVehicles + ", currentMap=" + currentMap
				+ ", currentVehicles=" + currentVehicles + ", drivingTime=" + drivingTime + ", maxTime=" + maxTime
				+ "]";
	}
	
	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Driving) {
			ans=( this.numOfJuncs==((Driving)other).numOfJuncs   &&  this.numOfVehicles==((Driving)other).numOfVehicles && this.currentMap ==((Driving)other).currentMap &&  this.currentVehicles ==((Driving)other).currentVehicles && this.drivingTime ==((Driving)other).drivingTime && this.maxTime ==((Driving)other).maxTime);
		}
		return ans;
	}	
	
	public ArrayList<Vehicle> getVehicles() {
		return this.currentVehicles;
	}
	
	//creates random number (2-8) of vehicles of different types.
	public  boolean addVehicles() {
		this.setNumOfVehicles(new Random().nextInt(7) + 2 );
		this.currentVehicles = new ArrayList<Vehicle>();
		for (int i = 0; i < this.numOfVehicles ; i++) {
			this.currentVehicles.add(new Vehicle(i, new VehicleType(), null));
		}
		return true;
	}
	
	
	 /* addMap() //creates a map with random (10-25) junctions quantity.
• startDrive(int maxTime): void

	 */

}
