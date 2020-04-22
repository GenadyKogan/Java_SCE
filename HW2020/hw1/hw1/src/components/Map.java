package components;
import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Map {
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private Random random = new Random();
	
	/**
	 * Default Ctor for a Map
	 * @param  No parameters
	 *Creates a map with 20 random junctions and connects all of them one to another with roads. 
	 */
	public Map() {
		this(20);
	}
	
	/**
	 * Ctor for a Map
	 * @param junctions - Type int
	 * @param roads - Type int
	 */
	
	public Map (int junctions, int roads) {
		this.junctions=new ArrayList<Junction>();
		this.roads=new ArrayList<Road>();
		for (int i = 0; i < junctions; i++) {
			int sizeX=(new Random().nextInt(999999) + 0 );
			int sizeY=(new Random().nextInt(799) + 0 );
			this.junctions.add(new Junction("Junction " + i , new Point(sizeX, sizeY)));
		}
		Junction s=this.junctions.get(0);
		this.junctions.remove(0);
		this.junctions.add(s);
		
		int junctionIndexTo;
		int junctionIndexFrom;
		ArrayList<Junction> finaljunctions = new ArrayList<>();
		ArrayList<Integer> usedJunction = new ArrayList<>();
		for (int i = 0; i < roads; i++) {
			if(usedJunction.size()>= this.junctions.size()){
				usedJunction = new ArrayList<>();
			}
			junctionIndexTo = random.nextInt(this.junctions.size());
			while (usedJunction.contains(junctionIndexTo)){
				junctionIndexTo = random.nextInt(this.junctions.size());
			}
			usedJunction.add(junctionIndexTo);
			Junction fromJunction = this.junctions.get(junctionIndexTo);
			usedJunction = new ArrayList<>();
			junctionIndexFrom = random.nextInt(this.junctions.size());
			while (usedJunction.contains(junctionIndexFrom)){
				junctionIndexFrom = random.nextInt(this.junctions.size());
			}
			usedJunction.add(junctionIndexFrom);
			Junction toJunction = this.junctions.get(junctionIndexFrom);

			this.roads.add(new Road(fromJunction,toJunction));
			// To -> enter , from - > exit
			fromJunction.addExitRoad(this.roads.get(i));
			toJunction.addEnterRoad(this.roads.get(i));
			
		}
		init();

	}
	/**
	 * @param No parameters
	 * @return nothing - Sending to function setLightsOn
	 */
	private void init() {
		for (int i = 0; i < this.junctions.size(); i++) {
			this.junctions.get(i).setLightsOn();
		}
		
	}
	/**
	 * Ctor for a Map
	 * @param value - Type int
	 */
	public Map (int value) {
		this(value,180);
	}
	
	/**
	 * Ctor for a Map
	 * @param juncs - Type ArrayList<Junction>
	 * @param roads - Type ArrayList<Road> roads
	 */
	public Map(ArrayList<Junction> juncs, ArrayList<Road> roads) {
		this(juncs);
		this.setRoads(roads);
	}
	
	/**
	 * Ctor for a Map
	 * @param juncs - Type ArrayList<Junction>
	 */
	public Map (ArrayList<Junction> juncs) {
		this.setJunctions(juncs);
	}
	

	/*******************************************************/
	/**
	 * @param No parameters
	 * @return junctions - Type ArrayList<Junction>
	 */
	public ArrayList<Junction> getJunctions() {
		return junctions;
	}

	/**
	 * @param junctions - Type ArrayList<Junction>
	 * @return nothing - Initializes an junctions 
	 */	
	public void setJunctions(ArrayList<Junction> junctions) {
		this.junctions=new ArrayList<Junction>(junctions);
	}

	/**
	 * @param No parameters
	 * @return roads - Type ArrayList<Road>
	 */
	public ArrayList<Road> getRoads() {
		return roads;
	}

	/**
	 * @param junctions - Type ArrayList<Junction>
	 * @return nothing - Initializes an junctions 
	 */	
	public void setRoads(ArrayList<Road> roads) {
		this.roads=new ArrayList<Road>(roads);
	}
	/*******************************************************/
	/**
	 * @param r - Type Road
	 * @return ans - Type boolean
	 * function add Road
	 */
	public boolean addRoad(Road r) {
		boolean ans=false;
		if(r!=null) {
	        for (Road element : getRoads()) { 
	            if (element.equals(r)) { 
	            	ans = true; 
	                break; 
	            } 
	        } 			
			if(ans==false)
			{
				this.roads.add(r);
				System.out.println("Junction "+r +" nas been added to the map");
			}
		}
		return ans;

	}
	
	/**
	 * @param r - Type Road
	 * @return nothing - remove Road
	 */
	public void removeRoad(Road r) {
		boolean ans=false;
		if(r!=null) {
	        for (Road element : getRoads()) { 
	            if (element.equals(r)) { 
	            	ans = true; 
	                break; 
	            } 
	        } 
			if(ans==true)
				this.roads.remove(r);		
		}

	}

	/**
	 * @param junc - Type Junction
	 * @return ans - Type boolean
	 * function add junc
	 */
	public boolean addJunction(Junction junc) {
		boolean ans=false;
		if(junc!=null) {
	        for (Junction element : getJunctions()) { 
	            if (element.equals(junc)) { 
	            	ans = true; 
	                break; 
	            } 
	        } 			
			if(ans==false)
			{
				this.junctions.add(junc);
				System.out.println("Junction "+junc.getJunctionName() +" nas been added to the map");
			}
			
		}
		return ans;

	}
	
	/**
	 * @param junc - Type Junction
	 * @return nothing - removes the junction and all connected to it roads from the map.
	 */
	public void removeJunction(Junction junc) {		
		if(junc!=null) {
	        for (Junction element : getJunctions()) { 
	            if (element.equals(junc)) { 
	            	for(Road road : element.getEnteringRoads()) {
	            		if(road.getToJunc().equals(element))
	            			road.setToJunc(null);
	            		else if(road.getFromJunc().equals(element))
	            			road.setFromJunc(null);
	            	}
	            	for(Road road : element.getEnteringRoads()) {
	            		if(road.getToJunc().equals(element))
	            			road.setToJunc(null);
	            		else if(road.getFromJunc().equals(element))
	            			road.setFromJunc(null);
	            	}
	            	this.junctions.remove(element);
					System.out.println("Junction "+junc.getJunctionName() +" has been removed to the map");
	            	return;
	            } 
	        } 
		}
	}
	

}

