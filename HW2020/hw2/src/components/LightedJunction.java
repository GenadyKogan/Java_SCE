package components;

import java.util.ArrayList;
import java.util.Random;

public class LightedJunction extends Junction{
	private TrafficLights light;
	/**
	 * Default Ctor for a LightedJunction
	 * @param  No parameters
	 * Random constructor, creates a random point node, initializes all fields, sets the object name by number his serial in the department.
	 */
	public LightedJunction() {
		super(String.valueOf(getObjectsCount()),new Random().nextInt(799) + 0 ,new Random().nextInt(599) + 0);
		boolean [] booleanElem={true,false};
		boolean isSequential=booleanElem[ new Random().nextInt(booleanElem.length)];
		boolean lightsOn=booleanElem[ new Random().nextInt(booleanElem.length)];
		isSequential (isSequential);
		this.light.setTrafficLightsOn(lightsOn);
	}
	/**
	 *Ctor for a LightedJunction
	 * @param name - type String
	 * @param x - type double
	 * @param y - type double
	 * @param sequential - type boolean
	 * @param lightsOn - type boolean
	 * A concrete constructor, which takes as arguments the details of the node and the traffic light.
	 */
	public LightedJunction(String name, double x, double y, boolean sequential, boolean lightsOn) {
		super(name, x, y);
		isSequential (sequential);
		this.light.setTrafficLightsOn(lightsOn);
	}
	


	//================================
	/**
	 *  @param obj - type Object, A method that accepts as a show instance of a vehicle
	 *   @return  Calculates the estimated tracking time at this node.
	 */
	public double calcEstimatedTime(Object obj){
		return this.light.getDelay()*(this.getEnteringRoads().size()-this.getEnteringRoads().indexOf(((Vehicle)obj).getLastRoad()))+1;
	
		
	}
	/**
	 *  @param vehicle - type Vehicle
	 *   @return  Boolean value that reflects the possibility of checkout from a component. In case of the method node will return an answer as to whether the vehicle can cross the junction and leave it
	 */
	public boolean canLeave(Vehicle vehicle){
		return false;
		
	}
	/**
	 * @return a String represents the object
	 */
	@Override
	public String toString() {
		return "junction "+this.getJunctionName()+" (lighted)" ;
	}

	/**
	 * @param nothing
	 * @return light - type TrafficLights
	 */
	public TrafficLights getTrafficLights() {
		return this.light;
	}
	/**
	 * Auxiliary method creates a constructor suitable for the type of son
	 * @param isSequential - type boolean
	 */
	public void isSequential (boolean isSequential) {
		if(isSequential)
			this.light=new SequentialTrafficLights(this.getEnteringRoads());
		else
			this.light=new RandomTrafficLights(this.getEnteringRoads());
	}
	//================================


}
