package components;

import java.util.ArrayList;
import java.util.Random;

public class RandomTrafficLights extends TrafficLights{

	public RandomTrafficLights (ArrayList<Road> roads){
		super(roads);
	}
	//================================
	public void changeIndex(){
		this.setGreenLightIndex(getRandomInt(0, this.getRoads().size()));
	}


}