package components;

import java.util.ArrayList;

import utilities.Timer;
import utilities.Utilities;

public abstract class TrafficLights  implements Timer, Utilities{
	private int objectsCount;
	private int delay;
	private int greenLightIndex;
	private int id;
	private int minDelay;
	private int maxDelay;
	private ArrayList<Road> roads;
	private boolean trafficLightsOn;
	private int workingTime;
	
	public TrafficLights(ArrayList<Road> roads) {
		
	}
	public abstract void changeIndex();
	public void changeLights(){
		
	}
	public void incrementDrivingTime() {
		
	}

}
