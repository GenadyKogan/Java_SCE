package components;

import java.util.ArrayList;
import java.util.Random;

public class LightedJunction extends Junction{
	private TrafficLights light;

	public LightedJunction() {
		super(String.valueOf(getObjectsCount()),new Random().nextInt(799) + 0 ,new Random().nextInt(599) + 0);
		boolean [] booleanElem={true,false};
		boolean isSequential=booleanElem[ new Random().nextInt(booleanElem.length)];
		boolean lightsOn=booleanElem[ new Random().nextInt(booleanElem.length)];
		isSequential (isSequential);
		this.light.setTrafficLightsOn(lightsOn);
	}
	public LightedJunction(String name, double x, double y, boolean sequential, boolean lightsOn) {
		super(name, x, y);
		isSequential (sequential);
		this.light.setTrafficLightsOn(lightsOn);
	}
	


	//================================

	public double calcEstimatedTime(Object obj){
		return this.light.getDelay()*(this.getEnteringRoads().size()-this.getEnteringRoads().indexOf(((Vehicle)obj).getLastRoad()))+1;
	
		
	}
	public boolean canLeave(Vehicle vehicle){
		return false;
		
	}

	@Override
	public String toString() {
		return "junction "+this.getJunctionName()+" (lighted)" ;
	}
	public TrafficLights getTrafficLights() {
		return this.light;
	}
	
	public void isSequential (boolean isSequential) {
		if(isSequential)
			this.light=new SequentialTrafficLights(this.getEnteringRoads());
		else
			this.light=new RandomTrafficLights(this.getEnteringRoads());
	}
	//================================

}
