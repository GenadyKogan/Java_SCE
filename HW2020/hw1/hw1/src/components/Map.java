package components;
import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Map {
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private Random random = new Random();
	
	public Map() {
		this(20);
	}
	
	public Map (int junctions, int roads) {
		this.junctions=new ArrayList<Junction>();
		this.roads=new ArrayList<Road>();
		for (int i = 0; i < junctions; i++) {
			this.junctions.add(new Junction("Junction #" + i , new Point(i*1.2, i* 1.5)));
		}
		int junctionIndexTo;
		int junctionIndexFrom;
		for (int i = 0; i < roads; i++) {
			junctionIndexTo = random.nextInt(junctions);
			junctionIndexFrom = random.nextInt(junctions);
			while(junctionIndexTo == junctionIndexFrom) 
			{
				junctionIndexFrom = random.nextInt(junctions);
			}
			this.roads.add(new Road(this.junctions.get(junctionIndexFrom),this.junctions.get(junctionIndexTo)));
			// To -> enter , from - > exit
			this.junctions.get(junctionIndexFrom).addEnterRoad(this.roads.get(i));
			this.junctions.get(junctionIndexTo).addExitRoad(this.roads.get(i));
			
		}
	}
	
	public Map (int value) {
		this(value,5);
	}
	public Map(ArrayList<Junction> juncs, ArrayList<Road> roads) {
		this.setJunctions(juncs);
		this.setRoads(roads);
	}
	
	public Map (ArrayList<Junction> juncs) {
		this.setJunctions(juncs);
	}
	
	public Map(Map other) {
		if(other!=null) {
			this.setJunctions(other.junctions);
			this.setRoads(other.roads);

		}
	}

	/*******************************************************/

	public ArrayList<Junction> getJunctions() {
		return junctions;
	}

	public boolean setJunctions(ArrayList<Junction> junctions) {
		boolean ans=false;
		if(junctions instanceof ArrayList) {
			junctions=new ArrayList<Junction>();
			this.junctions = junctions;
			ans=true;
		}
		return ans;
	}

	public ArrayList<Road> getRoads() {
		return roads;
	}

	public boolean setRoads(ArrayList<Road> roads) {
		boolean ans=false;
		if(roads instanceof ArrayList) {
			roads=new ArrayList<Road>();
			this.roads =roads;
			ans=true;
		}
		return ans;
	}
	/*******************************************************/
	public boolean addRoad(Road r) {
		boolean ans=false;
		if(this.getJunctions()!=null)
		{
			if(r!=null) {
		        for (Road element : getRoads()) { 
		            if (element == r) { 
		            	ans = true; 
		                break; 
		            } 
		        } 			
				if(ans==false)
					this.roads.add(r);
			}
		}
		else
			this.roads.add(r);
		return ans;

	}
	
	public void removeRoad(Road r) {
		boolean ans=false;
		if(r!=null) {
	        for (Road element : getRoads()) { 
	            if (element == r) { 
	            	ans = true; 
	                break; 
	            } 
	        } 
			if(ans==true)
				this.roads.remove(r);		
		}
		
	}

	
	public boolean addJunction(Junction junc) {
		boolean ans=false;
		if(this.getJunctions()!=null)
		{
			if(junc!=null) {
		        for (Junction element : getJunctions()) { 
		            if (element == junc) { 
		            	ans = true; 
		                break; 
		            } 
		        } 			
				if(ans==false)
					this.junctions.add(junc);
			}
		}
		else
			this.junctions.add(junc);
		return ans;

	}
	
	//removes the junction and all connected to it roads from the map.
	public void removeJunction(Junction junc) {		
		if(junc!=null) {
	        for (Junction element : getJunctions()) { 
	            if (element.equals(junc)) { 
	            	for(Road road : element.getExitingRoads()) {
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
	            	return;
	            } 
	        } 
		}
	}
	

}
