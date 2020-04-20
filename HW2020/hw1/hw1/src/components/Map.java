package components;
import java.util.ArrayList;
import java.util.Random;

import game.Driving;
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
			int sizeX=(new Random().nextInt(9000) + 1 );
			int sizeY=(new Random().nextInt(799) + 1 );
			this.junctions.add(new Junction("Junction " + i , new Point(sizeX, sizeY)));
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
			System.out.println("Road from "+ this.roads.get(i).getFromJunc()+ " to "+ this.roads.get(i).getToJunc()+" has been created");
			initJunc(junctions);
			initRoads(roads,junctions);
			init();
		}
	}
	


	private void initRoads(int roads2,int junctions2) {
		this.roads =new ArrayList<Road>();
		for (int j = 0; j < roads2; j++) {
		int i=(new Random().nextInt(junctions2) + 1 );
			this.roads.add(new Road(new Junction(""+i , new Point(1.2*i,  1.4*i)),new Junction(""+j , new Point(1.1*i, 3.2*i))));
		}	
	//	System.out.println(this.roads);
	}

	private void initJunc(int junctions2) {
		this.junctions =new ArrayList<Junction>();
		for (int j = 0; j < junctions2; j++) {
			int i=(new Random().nextInt(800) + 1 );
			this.junctions.add(new Junction(""+j , new Point(1.2*i,  1.3*i)));
		}
	//	System.out.println(this.junctions);
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
