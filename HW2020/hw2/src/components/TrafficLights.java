package components;

import java.util.ArrayList;
import java.util.Random;

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
		this.greenLightIndex=-1;
		this.setDelay(this.getRandomInt(0, 10));
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

	@Override
	public String toString() {
		return "Random traffic lights" ;
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
		if (this.roads.size()==0) {
			System.out.println(this.toString() + ": No entering roads, can not change lights");
			return;
		}
		this.greenLightIndex=++this.greenLightIndex % this.roads.size();
		this.setGreenLight(this.greenLightIndex);
	
			
	}
	
	public void setGreenLight(int index) {
		if(!this.trafficLightsOn) {
			System.out.println(this.toString() +" traffic lights are OFF");
		}
		if(greenLightIndex>=0) {
			
			roads.get(greenLightIndex).setGreenlight(false);
			greenLightIndex=index;
			roads.get(greenLightIndex).setGreenlight(true);
			System.out.println(roads.get(greenLightIndex).toString() + ": green light");
			
		}
	}

	public void incrementDrivingTime() {
		
	}
	public void setLightsOn() {
		if (this.roads.size()>0) {
			//for (Road road: this.roads) {road.setIsOpen(false);}//reset all entering roads to red first
			greenLightIndex=new Random().nextInt(this.roads.size());
			this.setTrafficLightsOn(true);
			setDelay(new Random().nextInt(maxDelay));
			System.out.println(this.toString() +" "+this.roads.get(greenLightIndex).getEndJunction()+" turned ON. Delay time: " + delay);
			setGreenLight(greenLightIndex);
		}
		else System.out.println(this.toString() + ": No entering roads, traffic lights can't be turned on.");
		
	}



	
}
