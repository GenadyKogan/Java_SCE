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

	/**Constructor
	 * @param from represents the ArrayList<Road> roads
	 * Class for random traffic light. A traffic light shines green to a random way out of the intersection of the junction.
	 */
	public TrafficLights(ArrayList<Road> roads) {
		this.setRoads(roads);
		this.setId(this.getObjectsCount());
		this.setObjectsCount(objectsCount+1);	
		this.greenLightIndex=-1;
		this.workingTime=0;
		this.setDelay(this.getRandomInt(minDelay, maxDelay));
	}
	//================================
	/** Name field getter
	 * @return int contains objects count
	 */
	public int getObjectsCount() {
		return objectsCount;
	}
	/**Sets the objects count for TrafficLights
	 * @param objects count - type int
	 */
	public void setObjectsCount(int objectsCount) {
		this.objectsCount = objectsCount;
	}
	/**Gets estimated time 
	 * 
	 * @return delay - type double
	 */
	public int getDelay() {
		return delay;
	}
	/**Sets the delay 
	 * @param delay - type int
	 */
	public void setDelay(int delay) {
		this.delay = delay;
	}
	/**Gets estimated greenLightIndex 
	 * 
	 * @return greenLightIndex - type int
	 */
	public int getGreenLightIndex() {
		return greenLightIndex;
	}
	/**Sets the greenLightIndex 
	 * @param greenLightIndex - type int
	 */
	public void setGreenLightIndex(int greenLightIndex) {
		this.greenLightIndex = greenLightIndex;
	}
	/**Gets estimated id 
	 * 
	 * @return id - type int
	 */
	public int getId() {
		return id;
	}
	/**Sets the id 
	 * @param id - type int
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**Gets estimated roads 
	 * 
	 * @return roads - type ArrayList<Road>
	 */
	public ArrayList<Road> getRoads() {
		return roads;
	}
	/**Sets the ArrayList<Road> roads 
	 * @param roads - type ArrayList<Road>
	 */
	public void setRoads(ArrayList<Road> roads) {
		this.roads=new ArrayList<Road>();
		this.roads = roads;
	}
	/**Gets trafficLightsOn roads 
	 * 
	 * @return trafficLightsOn - type boolean
	 */
	public boolean getTrafficLightsOn() {
		return trafficLightsOn;
	}
	/**Sets the boolean trafficLightsOn 
	 * @param trafficLightsOn - boolean
	 */
	public void setTrafficLightsOn(boolean trafficLightsOn) {
		this.trafficLightsOn = trafficLightsOn;
		
	}
	/**
	 * @return a String represents the object
	 */
	@Override
	public String toString() {
		return ""+ this.trafficLightsOn ;
	}
	/**Gets workingTime roads 
	 * 
	 * @return workingTime - type int
	 */
	public int getWorkingTime() {
		return workingTime;
	}
	/**Sets the  workingTime 
	 * @param workingTime - int
	 */
	public void setWorkingTime(int workingTime) {
		this.workingTime = workingTime;
	}


	//================================
	/**
	 * abstract nethod - changeIndex()
	 */
	public abstract void changeIndex();
	/**Change the traffic lights to the ON mode
	 */
	public void changeLights(){
		if (this.roads.size()==0) {
			System.out.println(this.toString() + ": No entering roads, can not change lights");
			return;
		}
		this.greenLightIndex=++this.greenLightIndex % this.roads.size();
		this.setGreenLight(this.greenLightIndex);
	
			
	}
	/**Sets the traffic lights to green light for an entering road
	 * @param index integer for the index of the road in the enteringRoads array
	 */
	public void setGreenLight(int index) {
		if(!this.trafficLightsOn) {
			System.out.println("Random traffic lights traffic lights are OFF");
		}
		if(greenLightIndex>=0) {
			
			roads.get(greenLightIndex).setGreenlight(false);
			greenLightIndex=index;
			roads.get(greenLightIndex).setGreenlight(true);
			System.out.println(roads.get(greenLightIndex).toString() + ": green light");
			
		}
	}
	/**
	 * A method that advances the traffic light's operation time and also checks whether it's time to switch lights
	 */
	public void incrementDrivingTime() {
		this.setWorkingTime(this.workingTime+1);
		changeLights();
	}
	/**Sets the traffic lights to the on mode
	 */
	public void setLightsOn() {
		if (this.roads.size()>0) {
			greenLightIndex=new Random().nextInt(this.roads.size());
			this.setTrafficLightsOn(true);
			setDelay(new Random().nextInt(maxDelay));
			System.out.println(super.getClass().getSimpleName()+" traffic lights "+this.roads.get(greenLightIndex).getEndJunction().getJunctionName()+" turned ON. Delay time: " + delay);
			setGreenLight(greenLightIndex);
		}
		else System.out.println(this.toString() + ": No entering roads, traffic lights can't be turned on.");
		
	}



	
}
