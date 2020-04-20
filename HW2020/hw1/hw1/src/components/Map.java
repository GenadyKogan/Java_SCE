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
			int sizeX=(new Random().nextInt(1000000) + 0 );
			int sizeY=(new Random().nextInt(800) + 0 );
			this.junctions.add(new Junction("Junction " + i , new Point(sizeX, sizeY)));
		}
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

			if(usedJunction.size()>= this.junctions.size()){
				usedJunction = new ArrayList<>();
			}
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
			System.out.println("Road from "+ this.roads.get(i).getFromJunc()+ " to "+ this.roads.get(i).getToJunc()+" has been created");
			init();
		}

	}
	
	private void init() {
		for (int i = 0; i < this.roads.size(); i++) {
			System.out.println("Road from "+ this.roads.get(i).getFromJunc()+ " to "+ this.roads.get(i).getToJunc()+" has been created");
			this.junctions.get(i).setLightsOn();
			this.junctions.get(i).changeLight();
		}
		
	}

	public Map (int value) {
		this(value,10);
	}
	public Map(ArrayList<Junction> juncs, ArrayList<Road> roads) {
		this(juncs);
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
			this.junctions=new ArrayList<Junction>(junctions);
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
			this.roads=new ArrayList<Road>(roads);
			ans=true;
		}
		return ans;
	}
	/*******************************************************/
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
	
	//removes the junction and all connected to it roads from the map.
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
					System.out.println("Junction "+junc.getJunctionName() +" nas been removed to the map");
	            	return;
	            } 
	        } 
		}
	}
	

}

