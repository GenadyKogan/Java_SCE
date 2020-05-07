package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import utilities.Point;
import utilities.Utilities;

public class Map implements Utilities {
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private ArrayList<TrafficLights> lights;
	
	private Random random = new Random();
	//================================
	/** Constructor 
	 * Creates a full random map with given quantity of junctions
	 * @param numOfJuncs represents the given quantity of junctions
	 */
	public Map (int numOfJunctions) {
		this.junctions=new ArrayList<Junction>();
		this.lights=new ArrayList<TrafficLights>();
		this.roads=new ArrayList<Road>();
		for (int i = 1; i < numOfJunctions+1; i++) {
			boolean isLightedJunction=this.getRandomBoolean();
			if(!isLightedJunction)
				this.junctions.add(new Junction(i+"" , getRandomInt(0,800), getRandomInt(0,600)));
			else
			{
				boolean isSequential=this.getRandomBoolean();
				LightedJunction temp=new LightedJunction();
				this.junctions.add(temp);
				this.lights.add(temp.getTrafficLights());
			}
			
		}

		for(Junction junc:this.junctions)
			System.out.print(""+junc.toString() + " has been created\n");
	
		SetAllRoads();
		turnLightsOn();
	}
	/**
	 * Auxiliary method - print 
	 */
	public void  printLight() {
		for(Junction junc : this.junctions) {
			String className = junc.getClass().getSimpleName();
			if(className.equals("LightedJunction")) {
				if(((LightedJunction)junc).getTrafficLights().getTrafficLightsOn()==true) {
					System.out.println(((LightedJunction)junc).getTrafficLights().getClass().getSimpleName()+" traffic lights "+junc.getJunctionName());
					System.out.println("- on delay");
				}
			}
		}
	}

	//================================
	/**Gets current junctions list
	 * 
	 * @return ArrayList<Junction> 
	 */
	public ArrayList<Junction> getJunctions() {
		return junctions;
	}
	/**Gets current junctions list
	 * 
	 * @return ArrayList<Road> 
	 */
	public ArrayList<Road> getRoads() {
		return roads;
	}
	/**Sets the ArrayList<Road> roads
	 * @param roads - type ArrayList<Road>
	 */
	public void setRoads(ArrayList<Road> roads) {
		this.roads =new ArrayList<Road>(roads);
	}
	/**Gets current junctions list
	 * 
	 * @return ArrayList<TrafficLights>
	 */
	public ArrayList<TrafficLights> getLights() {
		return lights;
	}
	/**Sets the ArrayList<TrafficLights> lights
	 * @param lights - type ArrayList<TrafficLights>
	 */
	public void setLights(ArrayList<TrafficLights> lights) {
		this.lights = lights;
	}
	/**Sets the ArrayList<Junction> junctions
	 * @param junctions - type ArrayList<Junction>
	 */
	public void setJunctions(ArrayList<Junction> junctions) {
		this.junctions = new ArrayList<Junction>(junctions);
	}
	//================================
	/** Connects all the existing junctions one to another with random roads (completes the full map creation) 
	 */
	public void SetAllRoads() {
		System.out.println("================= CREATING ROADS=================");
		for(Junction start :this.junctions) {
			for(Junction end:this.junctions ) 
				if(start!=end) {
					this.roads.add(new Road(start,end));
				}		
		}
	}
	
	/**
	 * A method that lights the traffic lights for the ctor.
	 */
	public void turnLightsOn(){
		System.out.println("================= TRAFFIC LIGHTS TURN ON =================");
		int j=0;
		for(int i=0;i<this.junctions.size();i++) {
			String className = this.junctions.get(i).getClass().getSimpleName();
			if(className.equals("LightedJunction")) {
					this.lights.get(j).setLightsOn();
					j+=1;
					
			}
		}

			

	}
	
}
