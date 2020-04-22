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

	public void setLastRoad(Road lastRoad) { this.lastRoad =lastRoad;}

	
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
		this.setSpentTime(new Random().nextInt(13) + 1 );
		if(this.currentRoute.getRoads().size()>=0) {
			System.out.println(this.currentRoute.getVehicleType()+". Position: "+this.getCurrentRoute().getJunctions().get(0)+" .Current Route:  " + this.currentRoute.getRoads().get(0) + " spentTime=" +this.spentTime);
		}
	}
	@Override
	public String toString() {
		return type + ", id=" + id ;
	}

	// wait for the current point delay time and move to the next point of the route.
	public void move() {
		checkIn();
	}
	
	public void checkIn() {
		Junction start=this.currentRoute.getJunctions().get(0);
		this.setLastJunction(this.currentRoute.getJunctions().get(this.currentRoute.getJunctions().size()-1));
		int lastIndex = this.currentRoute.getJunctions().indexOf(start);
		if(!this.movesNow && this.currentRoute!=null) {
			if(this.lastJunction == null) {
				this.lastJunction = this.currentRoute.getJunctions().get(0);
				System.out.println(this.type +", ID "+ this.id + " is moving on from "+this.currentRoute.getJunctions().get(0)+" to "+lastJunction );

			}
			else {
				if(this.lastJunction != start ) {
					start = currentRoute.getJunctions().get(lastIndex + 1);
					System.out.println(this.type +", ID "+ this.id + " is moving on from "+start+" to "+lastJunction );
				}
				else
				{
					System.out.println(this.type +", ID "+ this.id +  " stays at " +start+" - no exiting roads. ");
					
				}
				
			}
			this.spentTime = this.lastJunction.getDelay();

		}

	}



}
