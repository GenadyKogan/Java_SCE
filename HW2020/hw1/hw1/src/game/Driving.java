package game;

import java.util.ArrayList;
import java.util.Random;

import components.Junction;
import components.Map;
import components.Road;
import components.Route;
import components.Vehicle;
import components.VehicleType;
import utilities.Point;

public class Driving {

	private int numOfJuncs;
	private int numOfVehicles;
	private Map currentMap;
	private ArrayList<Vehicle> currentVehicles;
	private double drivingTime; // time passed from the beginning of driving session
	private int maxTime; // total round time
	private Random random;
	/*******************************************************/
	/**
	 * Ctor for a Driving
	 * @param juncs - Type int
	 * @param vehicles - Type int
	 * @param maxTime - Type int
	 */
	public Driving(int juncs, int vehicles, int maxTime) {
		random= new Random();
		this.setNumOfJuncs(juncs);
		this.setNumOfVehicles(vehicles);
		this.setMaxTime(maxTime);
		this.currentVehicles = new ArrayList<Vehicle>();
		this.initVehicles();
	}
	/*******************************************************/
	/**
	 * @param No parameters
	 * @return numOfJuncs - Type int
	 */
	public int getNumOfJuncs() {
		return numOfJuncs;
	}
	/**
	 * @param numOfJuncs - Type int 
	 * @return nothing - Initializes an numOfJuncs 
	 */	
	public void setNumOfJuncs(int numOfJuncs) {
		this.numOfJuncs = numOfJuncs;
		this.currentMap= new Map(numOfJuncs);
	}
	/**
	 * @param No parameters
	 * @return numOfVehicles - Type int
	 */
	public int getNumOfVehicles() {
		return numOfVehicles;
	}
	/**
	 * @param numOfVehicles - Type int 
	 * @return nothing - Initializes an numOfVehicles 
	 */		
	public void setNumOfVehicles(int numOfVehicles) {
		this.numOfVehicles = numOfVehicles;
	}
	/**
	 * @param No parameters
	 * @return currentMap - Type Map
	 */
	public Map getCurrentMap() {
		return currentMap;
	}
	/**
	 * @param currentMap - Type Map 
	 * @return nothing - Initializes an currentMap 
	 */		
	public void setCurrentMap(Map currentMap) {
		this.currentMap = currentMap;
	}
	/**
	 * @param No parameters
	 * @return currentVehicles - Type ArrayList<Vehicle>
	 */
	public ArrayList<Vehicle> getCurrentVehicles() {
		return currentVehicles;
	}
	/**
	 * @param currentVehicles - Type ArrayList<Vehicle> 
	 * @return nothing - Initializes an currentVehicles 
	 */	
	public void setCurrentVehicles(ArrayList<Vehicle> currentVehicles) { 
		currentVehicles =new ArrayList<Vehicle>(); 
	}

	/**
	 * @param No parameters
	 * @return drivingTime - Type double
	 */
	public double getDrivingTime() {
		return drivingTime;
	}
	/**
	 * @param drivingTime - Type double 
	 * @return nothing - Initializes an drivingTime 
	 */	
	public void setDrivingTime(double drivingTime) {
			this.drivingTime = drivingTime;
	}
	/**
	 * @param No parameters
	 * @return maxTime - Type int
	 */
	public int getMaxTime() {
		return maxTime;
	}
	/**
	 * @param maxTime - Type int 
	 * @return nothing - Initializes an maxTime 
	 */	
	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
	/**
	 * @param No parameters
	 * @return currentVehicles - Type ArrayList<Vehicle>
	 */
	public ArrayList<Vehicle> getVehicles() {
		return this.currentVehicles;
	}
	
	/**
	 * @param No parameters
	 * @return nothing - add Vehicle
	 */	
	public void initVehicles() {
		for (int i = 0; i < this.numOfVehicles ; i++) {
			int valueJuncs=this.random.nextInt(this.numOfJuncs);
			Vehicle tempVehicle  = new Vehicle(i, new VehicleType(), this.currentMap.getJunctions().get(valueJuncs));
			this.currentVehicles.add(tempVehicle);
			System.out.println(this.currentVehicles.get(i).toString()+" has been created and placed at junction " +valueJuncs);
			tempVehicle.setCurrentRoute(getRandomRouteFromJunction(tempVehicle.getLastJunction(), tempVehicle.getType()));
			
		}
	}
	
	/*******************************************************/
	/**
	 * @param other - Object type
	 * @return Boolean value - true or false
	 */	
	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Driving) {
			ans=( this.numOfJuncs==((Driving)other).numOfJuncs   &&  this.numOfVehicles==((Driving)other).numOfVehicles && this.currentMap ==((Driving)other).currentMap &&  this.currentVehicles ==((Driving)other).currentVehicles && this.drivingTime ==((Driving)other).drivingTime && this.maxTime ==((Driving)other).maxTime);
		}
		return ans;
	}	
	
	/**
	 * @param No parameters
	 * @return nothing
	 * function add Vehicle - creates random number (2-8) of vehicles of different types.
	 */

	public void addVehicles() {
		this.setNumOfVehicles(new Random().nextInt(7) + 2 );
		this.currentVehicles = new ArrayList<Vehicle>();
		initVehicles();
	}
	/**
	 * @param start - Type Junction
	 * @param vehicleType - Type VehicleType
	 * @return Route - Auxiliary function to create route
	 */
	public Route getRandomRouteFromJunction(Junction start, VehicleType vehicleType) {
		ArrayList<Junction> junctions = new ArrayList<Junction>(); 
		ArrayList<Road> roads = new ArrayList<Road>();
		System.out.println("sss"+start);
		junctions.add(start);
		System.out.println("ll"+junctions);
		Junction currJunctions = start;
		Road currRoad;
		for (int i = 0; i <=5; i++) {
			if(currJunctions.getEnteringRoads().size() >0 &&  currJunctions.getExitingRoads().size()>0) {
				currRoad = currJunctions.getExitingRoads().get(0);
				roads.add(currRoad);
			}
			else {
				break;
			}
			
			if(currRoad.getToJunc() != null) {
				currJunctions=currRoad.getToJunc();
				junctions.add(currJunctions);
			}else {
				break;
			}
		}
		System.out.println("//"+junctions);
		return new Route(junctions, roads,vehicleType );
	}
	
	/**
	 * @param No parameters
	 * @return nothing
	 * function add Map - creates a map with random (10-25) junctions quantity.
	 */
	public  boolean addMap() {
		this.setNumOfJuncs(new Random().nextInt(16) + 10 );
		this.currentMap= new Map();
		for (int i = 0; i < this.numOfJuncs ; i++) {
			this.currentMap.addJunction(new Junction("Junct #" + i , new Point(i*1.2, i* 1.5)));
		}
		return true;
	}
	/**
	 * @param maxTime - Type int 
	 * @return nothing - A function that receives a maxTime and defines the number of times a vehicle turns
	 */	
	public void startDrive(int maxTime) {
		for(int i=1; i<maxTime+1;i++ ) {
			System.out.println("TURN "+i);
			System.out.println(this.currentVehicles.get(i).toString() + "  is starting route "+this.currentMap.getRoads().get(i).toString() );
			for(int j=0; j<this.currentVehicles.size();j++) {
				this.currentVehicles.get(j).move();
				
			}
		}
		
		System.out.println("STATUS");
		for(Vehicle vehicle: this.currentVehicles) {
			vehicle.status();	
		}
		

	}


}

