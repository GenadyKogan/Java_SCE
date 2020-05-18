package components;
import java.util.ArrayList;
import java.util.Random;

import utilities.*;

////
public class Driving  implements Utilities, Timer {
	private Map map;
	private  ArrayList<Vehicle> vehicles; 
	private int drivingTime;
	private ArrayList<Timer> allTimedElements;
	
	/**Constructor
	 * 
	 * @param juncs quantity of junctions in the system
	 * @param vehicles quantity of vehicles in the system
	 * Random builder, gets the number of nodes and the number of vehicles you want.Creates a map with a given number of nodes, creates the required amount of vehicles, and initializes all fields
	 */
	public Driving (int numOfJunctions, int numOfVehicles) {
		System.out.println("================= CREATING JUNCTIONS=================");
		this.map= new Map(numOfJunctions);
		System.out.println("================= GAME MAP HAS BEEN CREATED =================");
		System.out.println("================= CREATING VEHICLES =================");
		this.vehicles=new ArrayList<Vehicle>();

		for (int i = 0; i < numOfVehicles ; i++) {
			Vehicle temp=new Vehicle(map.getRoads().get(new Random().nextInt(map.getRoads().size())));
			this.vehicles.add(temp);
		}
		
	}
	/**
	 * @param numOfTurns - type int ,the number of beats
	 *  @return nothing
	 */
	public void  drive(int numOfTurns) {
		System.out.println("================= START DRIVING=================");
		for(int i=0;i<numOfTurns+1 ;i++) {
			System.out.println("*************** TURN "+i +" ***************");
			this.incrementDrivingTime();
		}
	}
	/**
	 * @param nothing
	 *  A method that advances time (beats) for all the affected objects (vehicles and traffic lights).
	 */
	public void incrementDrivingTime() {
			for(int j=0; j<this.vehicles.size();j++) {
				System.out.println(this.vehicles.get(j).toString());
				this.vehicles.get(j).incrementDrivingTime();
				
		}
		this.map.printLight();
	}
	

	//========================================
	//get & set
	
	/**
	 * @param nothing
	 * @return drivingTime - type int 
	 */	
	public int getDrivingTime() {
		return drivingTime;
	}
	/**
	 * @param nothing
	 * @return vehicles - type ArrayList<Vehicle>
	 */	
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
	
	/**
	 * @param vehicles - type ArrayList<Vehicle>
	 * @return nothing
	 */	
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	/**
	 * @param drivingTime - type int
	 * @return nothing
	 */	
	public void setDrivingTime(int drivingTime) {
		this.drivingTime = drivingTime;
	}
	/**
	 * @param nothing
	 * @return ArrayList<Timer> -A variable that keeps all elements affected by beats (vehicles and traffic lights) together
	 */	
	public ArrayList<Timer> getAllTimedElements() {
		return allTimedElements;
	}
	/**
	 * @param allTimedElements - type ArrayList<Timer>
	 * @return nothing 
	 */
	public void setAllTimedElements(ArrayList<Timer> allTimedElements) {
		this.allTimedElements = new ArrayList<Timer>(allTimedElements);
	}
	//========================================
	
	
}
