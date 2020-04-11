package components;

import java.util.ArrayList;
import java.util.Random;

public class Vehicle {
	private int id;
	/*sapir aluf*/
	private  VehicleType type;
	private int speed; //average speed for this type of vehicle.
	private Route currentRoute;
	private Junction lastJunction; //current junction or last junction where the vehicle visited
	private Road lastRoad;
	private boolean movesNow; //True if the vehicle is on the road between the junctions.
	private double spentTime; //time passed from the beginning of movement on the route. 

	
	
	/*******************************************************/
	public Vehicle(int id, VehicleType type, Junction lastJunction) {
		this.setId(id);
		this.setType(type);
		this.setLastJunction(lastJunction);
	}
	/*******************************************************/
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public VehicleType getType() {
		return type;
	}
	
	public void setType(VehicleType type) {
		this.type = type;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public Route getCurrentRoute() {
		return currentRoute;
	}
	
	public boolean setCurrentRoute(Route currentRoute) {
		boolean ans=false;
		if(currentRoute instanceof Route) {
			this.currentRoute =currentRoute;
			ans=true;
		}
		return ans;	
	}
	
	public Junction getLastJunction() {
		return lastJunction;
	}
	
	public boolean setLastJunction(Junction lastJunction) {
		boolean ans=false;
		if(lastJunction instanceof Junction) {
			this.lastJunction =lastJunction;
			ans=true;
		}
		return ans;	
	}
	
	public Road getLastRoad() {
		return lastRoad;
	}
	
	public boolean setLastRoad(Road lastRoad) {
		boolean ans=false;
		if(lastRoad instanceof Road) {
			this.lastRoad =lastRoad;
			ans=true;
		}
		return ans;	
	}
	
	public boolean isMovesNow() {
		return movesNow;
	}
	
	public void setMovesNow(boolean movesNow) {
		this.movesNow = movesNow;
	}
	
	public double getSpentTime() {
		return spentTime;
	}
	
	public void setSpentTime(double spentTime) {
		this.spentTime = spentTime;
	}
	/*******************************************************/
	
	public void status() {
		System.out.println("currentRoute=" + currentRoute + ", lastJunction=" + lastJunction + ", lastRoad=" + lastRoad	+ ", spentTime=" + spentTime);
	}
/*
 * • move() // wait for the current point delay time and move to the next
//point of the route.
• checkIn() //if arrived to a junction, update the junction waiting list
//and calculate the delay time before the next move. 
 */

}
