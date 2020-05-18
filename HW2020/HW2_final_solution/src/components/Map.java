/**
 * 
 */
package components;

import java.util.ArrayList;
import utilities.Utilities;

/**Represents the map 
 * @author Sophie Krimberg
 *
 */
public class Map implements Utilities {
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private ArrayList<TrafficLights> lights;
	
	/**Constructor 
	 * @param junctionsNum represents the quantity of junctions
	 */
	public Map(int junctionsNum) {
		junctions=new ArrayList<Junction>();
		roads=new ArrayList<Road>();
		lights=new ArrayList<TrafficLights>();
		System.out.println("\n================= CREATING JUNCTIONS=================");
		//create lighted and non-lighted junctions
		for (int i=0; i<junctionsNum; i++) {
			if (getRandomBoolean()) {
				junctions.add(new Junction());
			}
			else {
				LightedJunction junc=new LightedJunction();
				junctions.add(junc);
				lights.add(junc.getLights());
			}
		}
		
		setAllRoads();
		turnLightsOn();
		System.out.println("\n================= GAME MAP HAS BEEN CREATED =================\n");
	
		
	}
	
	/**turns on random traffic lights 
	 * 
	 */
	public void turnLightsOn() {
		System.out.println("\n================= TRAFFIC LIGHTS TURN ON =================");

		for (TrafficLights light: lights) {
			light.setTrafficLightsOn(getRandomBoolean());
		}
	}
	
	/**creates roads between all the junctions on the map
	 * 
	 */
	public void setAllRoads() {
		System.out.println("\n================= CREATING ROADS=================");

		for (int i=0; i<junctions.size();i++) {
			for (int j=0; j<junctions.size();j++) {
				if(i==j) {
					
					continue;
				}
				roads.add(new Road(junctions.get(i), junctions.get(j)));
				
					
			}
		}
	}
	
//	
	@Override
	public String toString() {
		return new String("Map: " +this.getJunctions().size()+" junctions, "+this.getRoads().size()+" roads." );
	}
	
	/**
	 * @return the junctions
	 */
	public ArrayList<Junction> getJunctions() {
		return junctions;
	}

	/**
	 * @return the roads
	 */
	public ArrayList<Road> getRoads() {
		return roads;
	}

	/**
	 * @return the lights
	 */
	public ArrayList<TrafficLights> getLights() {
		return lights;
	}

	/**
	 * @param junctions the junctions to set
	 */
	public void setJunctions(ArrayList<Junction> junctions) {
		this.junctions = junctions;
	}

	/**
	 * @param roads the roads to set
	 */
	public void setRoads(ArrayList<Road> roads) {
		this.roads = roads;
	}
	/**
	 * @param lights the lights to set
	 */
	public void setLights(ArrayList<TrafficLights> lights) {
		this.lights = lights;
	}
}
