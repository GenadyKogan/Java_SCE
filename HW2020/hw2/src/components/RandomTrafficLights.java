package components;

import java.util.ArrayList;
import java.util.Random;

public class RandomTrafficLights extends TrafficLights{
	/**Constructor
	 * @param from represents the ArrayList<Road> roads
	 * Class for random traffic light. A random traffic light shines green to a random way out of the intersection of the junction.
	 */
	public RandomTrafficLights (ArrayList<Road> roads){
		super(roads);
	}
	//================================
	/**
	 * A method returns an index for a green light (overrides a traffic light method).
	 */
	public void changeIndex(){
		this.setGreenLightIndex(getRandomInt(0, this.getRoads().size()));
	}


}