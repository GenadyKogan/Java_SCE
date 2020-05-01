package components;

import java.util.ArrayList;

import utilities.Timer;
import utilities.Utilities;

public abstract class TrafficLights  implements Timer, Utilities{
	private static int objectsCount=1;
	private int delay;
	private int greenLightIndex;
	private int id;
	private static final int minDelay=2;
	private static final int maxDelay=6;
	private ArrayList<Road> roads;
	private boolean trafficLightsOn;
	private int workingTime;

	public TrafficLights(ArrayList<Road> roads) {
		this.setRoads(roads);
		this.setId(this.getObjectsCount());
		this.setObjectsCount(objectsCount+1);	
	}
	//================================
	public int getObjectsCount() {
		return objectsCount;
	}

	public void setObjectsCount(int objectsCount) {
		this.objectsCount = objectsCount;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getGreenLightIndex() {
		return greenLightIndex;
	}

	public void setGreenLightIndex(int greenLightIndex) {
		this.greenLightIndex = greenLightIndex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Road> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<Road> roads) {
		this.roads=new ArrayList<Road>();
		this.roads = roads;
	}

	public boolean getTrafficLightsOn() {
		return trafficLightsOn;
	}

	public void setTrafficLightsOn(boolean trafficLightsOn) {
		this.trafficLightsOn = trafficLightsOn;
	}

	public int getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(int workingTime) {
		this.workingTime = workingTime;
	}


	//================================

	public abstract void changeIndex();
	
	public void changeLights(){

			
	}
	public void incrementDrivingTime() {
		
	}


	
}
