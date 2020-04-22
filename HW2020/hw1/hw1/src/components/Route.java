package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Route {
	private ArrayList<Junction> junctions; // list of junctions on the route by the order of movement.
	private ArrayList<Road> roads; // list of roads on the route by the order of movement
	private double delay; //time that will take the vehicle to make this route.
	private VehicleType vehicleType;
	/*******************************************************/
	/**
	 * Ctor for a Route
	 * @param junctions - Type ArrayList<Junction>
	 * @param roads - Type ArrayList<Road>
	 * @param vehicleType - Type VehicleType
	 */
	
	public Route(ArrayList<Junction> junctions, ArrayList<Road> roads, VehicleType vehicleType) {

		this.junctions = junctions;
		this.roads = roads;
		this.vehicleType = vehicleType;
	}
	/**
	 * Ctor for a Route
	 * @param start - Type Junction
	 * @param end - TypeJunction
	 * @param vehicleType - Type VehicleType
	 */
	public Route(Junction start, Junction end, VehicleType vehType) {} // no implemented in this task
	
	/*******************************************************/
	/**
	 * @param No parameters
	 * @return junctions - Type ArrayList<Junction>
	 */
	public ArrayList<Junction> getJunctions() {
		return junctions;
	}
	/**
	 * @param junctions - Type ArrayList<Junction>
	 * @return nothing - Initializes an junctions
	 */
	public void setJunctions(ArrayList<Junction> junctions){
		this.junctions =junctions;
	}
	

	/**
	 * @param No parameters
	 * @return roads - Type ArrayList<Road>
	 */
	public ArrayList<Road> getRoads() {
		return roads;
	}
	/**
	 * @param roads - Type ArrayList<Road>
	 * @return nothing - Initializes an roads
	 */
	public void setRoads(ArrayList<Road> roads){
		this.roads = roads;
	}

	/**
	 * @param No parameters
	 * @return delay - Type double
	 */
	public double getDelay() {
		return delay;
	}
	/**
	 * @param delay - Type double
	 * @return nothing - Initializes an delay
	 */
	public void setDelay(double delay) {
		this.delay = delay;
	}
	/**
	 * @param No parameters
	 * @return vehicleType - Type VehicleType
	 */
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	/**
	 * @param vehicleType - Type VehicleType
	 * @return nothing - Initializes an vehicleType
	 */
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	/*******************************************************/
	/**
	 * @param other - Object type
	 * @return Boolean value - true or false
	 */	

	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Route) {
			ans=( this.junctions==((Route)other).junctions   &&  this.roads==((Route)other).roads && this.delay ==((Route)other).delay &&  this.vehicleType ==((Route)other).vehicleType);
		}
		return ans;
	}	

	
	/******************************************************/
	/**
	 * @param No parameters
	 * @return Junction - Returns the first value in Junction 
	 */
	public Junction getStart() {
		if (junctions.size() > 0) {
			return junctions.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * @param No parameters
	 * @return Junction - Returns the  last value in Junction 
	 */
	public Junction getEnd() {
		if (junctions.size() > 0) {
			return junctions.get(this.junctions.size()-1);
		}else{
			return null;
		}
	}
	/**
	 * @param No parameters
	 * @return nothing - set length to be a sum of delay values and the time that will take this type of vehicle to pass all the roads and calculate delay.
	 */
	public void calcDelay() {
		double length=0;
		double speed=0;
		double delay2=0;
		int count=0;
		double res = 0;
		for( int i=0; i< this.roads.size();i++)
		{
			length= this.roads.get(i).countLength();
			speed=Math.min(this.vehicleType.getSpeed(),this.roads.get(i).getMaxSpeed());

			for (int j = 0; j < this.junctions.get(j).getEnteringRoads().size() ; j++)
					count+=1;
			for (int j = 0; j < this.junctions.size() ; j++) 
				delay2=this.junctions.get(j).getDelay()*count;
		}
		for( int i=0; i< this.junctions.size();i++)
		{
			if(this.junctions.get(i).isHasLights()==true)
			{
				res= (length/speed)+delay2;
			}
			else
				res= (length/speed)*this.junctions.get(i).getDelay();
			
		}
		this.delay = res;
		
	}

	
}

