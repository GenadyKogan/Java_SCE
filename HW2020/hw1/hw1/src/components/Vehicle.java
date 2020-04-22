package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Vehicle {
	private int id;
	private  VehicleType type;
	private int speed; //average speed for this type of vehicle.
	private Route currentRoute;
	private Junction lastJunction; //current junction or last junction where the vehicle visited
	private Road lastRoad;
	private boolean movesNow; //True if the vehicle is on the road between the junctions.
	private double spentTime; //time passed from the beginning of movement on the route. 
	
	
	
	/*******************************************************/
	/**
	 * Ctor for a Vehicle
	 * @param id - Type int
	 * @param type - Type VehicleType
	 * @param lastJunction - Type Junction
	 */
	public Vehicle(int id, VehicleType type, Junction lastJunction) {
		this.setId(id);
		this.setType(type);
		this.setLastJunction(lastJunction);
	}
	/*******************************************************/
	/**
	 * @param No parameters
	 * @return id - Type int
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id - Type int
	 * @return nothing - Initializes an id 
	 */	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @param No parameters
	 * @return type - Type VehicleType
	 */
	public VehicleType getType() {
		return type;
	}
	/**
	 * @param type - Type VehicleType
	 * @return nothing - Initializes an type 
	 */		
	public void setType(VehicleType type) {
		this.type = type;
	}
	/**
	 * @param No parameters
	 * @return speed - Type int
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * @param speed - Type int
	 * @return nothing - Initializes an speed 
	 */	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * @param No parameters
	 * @return currentRoute - Type Route
	 */
	public Route getCurrentRoute() {
		return currentRoute;
	}
	/**
	 * @param currentRoute - Type Route
	 * @return nothing - Initializes an currentRoute 
	 */	
	public void setCurrentRoute(Route currentRoute) {
		this.currentRoute =currentRoute;
	}
	/**
	 * @param No parameters
	 * @return lastJunction - Type Junction
	 */
	public Junction getLastJunction() {
		return lastJunction;
	}
	/**
	 * @param lastJunction - Type Junction
	 * @return nothing - Initializes an lastJunction 
	 */	
	public void setLastJunction(Junction lastJunction) {
		this.lastJunction =lastJunction;
	}
	/**
	 * @param No parameters
	 * @return lastRoad - Type Road
	 */
	public Road getLastRoad() {
		return lastRoad;
	}
	/**
	 * @param lastRoad - Type Road
	 * @return nothing - Initializes an lastRoad 
	 */	
	public void setLastRoad(Road lastRoad) { 
		this.lastRoad =lastRoad;
	}

	/**
	 * @param No parameters
	 * @return movesNow - Type boolean
	 */
	public boolean isMovesNow() {
		return movesNow;
	}
	/**
	 * @param movesNow - Type boolean
	 * @return nothing - Initializes an movesNow 
	 */	
	public void setMovesNow(boolean movesNow) {
		this.movesNow = movesNow;
	}
	/**
	 * @param No parameters
	 * @return spentTime - Type double
	 */
	public double getSpentTime() {
		return spentTime;
	}
	/**
	 * @param spentTime - Type double
	 * @return nothing - Initializes an spentTime 
	 */	
	public void setSpentTime(double spentTime) {

		this.spentTime = spentTime;
	}
	/*******************************************************/
	/**
	 * @param No parameters
	 * @return nothing - prints the details about the vehicle including current position, time spent on the route and the first and last junctions on the route
	 */
	public void status() {
		this.setSpentTime(new Random().nextInt(13) + 1 );
		if(this.currentRoute.getRoads().size()>=0) {
			System.out.println(this.currentRoute.getVehicleType()+". Position: "+this.getCurrentRoute().getJunctions().get(0)+" .Current Route:  " + this.currentRoute.getRoads().get(0) + " spentTime=" +this.spentTime);
		}
	}
	
	/**
	 * @param No parameters
	 * @return String - Print the data for a type and id
	 */
	@Override
	public String toString() {
		return type + ", id=" + id ;
	}
	
	/**
	 * @param No parameters
	 * @return nothing - wait for the current point delay time and move to the next point of the route. 
	 */
	public void move() {
		checkIn();
	}
	/**
	 * @param No parameters
	 * @return nothing - if arrived to a junction, update the junction waiting list and calculate the delay time before the next move.
	 */
	public void checkIn() {
		this.setSpentTime(new Random().nextInt(3456) + 1008 );
		Junction start=this.currentRoute.getJunctions().get(0);
		this.setLastJunction(this.currentRoute.getJunctions().get(this.currentRoute.getJunctions().size()-1));
		int lastIndex = this.currentRoute.getJunctions().indexOf(start);
		if(!this.movesNow && this.currentRoute!=null) {
			if(this.lastJunction == null) {
				this.lastJunction = this.currentRoute.getJunctions().get(0);
			}
			else {
				if(this.lastJunction != start ) {
					start = currentRoute.getJunctions().get(lastIndex + 1);
					System.out.println(this.type +", ID "+ this.id + " is moving on from "+start+" to "+lastJunction );
				}
				else
				{
					System.out.println(this.type +", ID "+ this.id +  " stays at " +start+" - no exiting roads. ");
					this.lastJunction.changeLight();
				}
				
			}
			if(this.lastJunction==this.currentRoute.getJunctions().get(this.currentRoute.getJunctions().size()-1))
				System.out.println(this.type +", ID "+ this.id + " has finished the route. Total time: "+ this.getSpentTime());
			if(this.lastJunction == this.currentRoute.getJunctions().get(0))
				System.out.println(this.type +", ID "+ this.id + "  is starting route from "+start+" to "+lastJunction );
			this.spentTime = this.lastJunction.getDelay();

		}

	}



}
