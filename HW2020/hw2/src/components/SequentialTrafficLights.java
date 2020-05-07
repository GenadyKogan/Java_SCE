package components;

import java.util.ArrayList;
import java.util.Random;

public class SequentialTrafficLights  extends TrafficLights {

	private int increment;
	
	/**Constructor
	 * @param from represents the ArrayList<Road> roads
	 * Constructor for consistent traffic light. 
	 */
	public SequentialTrafficLights(ArrayList<Road> roads) {
		super(roads);
	}
	//================================
	/**
	 * A method returns an index for a green light (overrides a traffic light method).
	 */
	public void changeIndex() {
		this.setGreenLightIndex(getRandomInt(0, this.getRoads().size()));
	}
	

}
