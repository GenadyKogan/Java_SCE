/**
 * 
 */
package components;


/**Represents a Junction with traffic lights
 * @author Sophie Krimberg
 *
 */
public class LightedJunction extends Junction {
	
	TrafficLights lights;
	
	
	/**Constructor
	 * @param name junction name
	 * @param x coordinate
	 * @param y coordinate
	 * @param sequential represents the type of traffic lights: random or sequential
	 * @param lightsOn represents the state of traffic lights: turned on/off 
	 */
	public LightedJunction(String name, double x, double y,boolean sequential, boolean lightsOn) {
		super(name, x,y);
		
		if(sequential) {
			lights=new SequentialTrafficLights(this.getEnteringRoads());
		}
		else {
			lights=new RandomTrafficLights(this.getEnteringRoads());
		}
		if (lightsOn) {
			lights.setTrafficLightsOn(true);
		}
		successMessage(String.format("Junction %s  (%.2f , %.2f), Lighted", getJunctionName(), getX(),getY()));
	}
	
	/**Random Constructor
	 * creates random traffic lights for the junction. 
	 */
	public LightedJunction() {
		super();
		

		if (this.getRandomBoolean()){
			lights=new SequentialTrafficLights(this.getEnteringRoads());
		}
		else {
			lights=new RandomTrafficLights(this.getEnteringRoads());
		}
		
		successMessage(String.format("Junction %s (%.2f , %.2f), Lighted", getJunctionName(), getX(),getY()));
	}
	
	/**
	 * @return the lights
	 */
	public TrafficLights getLights() {
		return lights;
	}

	/**
	 * @param lights the lights to set
	 */
	public void setLights(TrafficLights lights) {
		this.lights = lights;
	}

	@Override
	public double calcEstimatedTime(Object obj) {
		if (!lights.getTrafficLightsOn())
			return super.calcEstimatedTime(obj);
		else return (getEnteringRoads().size()-1)*lights.getDelay()+1;
	}
	@Override
	public String toString() {
		
		return new String(super.toString()+ " (Lighted)");
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) return false; 
	    if (getClass() != other.getClass()) return false; 
	    if (! super.equals(other)) return false;
	    if (!lights.equals(((LightedJunction)other).getLights())) return false;
	    return true;
	}
	
	@Override
	public boolean canLeave(Vehicle vehicle) {
		if (!lights.getTrafficLightsOn()) {
			return super.canLeave(vehicle);
		}
		if(!checkAvailability(vehicle)) {
			return false;
		}
		if (!vehicle.getLastRoad().getGreenLight()) {
			vehicle.setStatus(new String(" for green light"));
			return false;
		}
		return true;
	}
}
