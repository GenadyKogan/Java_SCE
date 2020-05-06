package components;

import java.util.ArrayList;
import java.util.Random;

public class SequentialTrafficLights  extends TrafficLights {

	private int increment;
	
	
	public SequentialTrafficLights(ArrayList<Road> roads) {
		super(roads);
	}
	//================================

	public void changeIndex() {
		this.setGreenLightIndex(getRandomInt(0, this.getRoads().size()));
	}
	

}
