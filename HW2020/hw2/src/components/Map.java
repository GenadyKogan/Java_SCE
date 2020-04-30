package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;
import utilities.Utilities;

public class Map implements Utilities {
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private ArrayList<TrafficLights> lights;
	//================================

	public Map (int numOfJunctions) {
		this.junctions=new ArrayList<Junction>();
		for (int i = 1; i < numOfJunctions+1; i++) {
			int valX=(new Random().nextInt(799) + 0 );
			int valY=(new Random().nextInt(599) + 0 );
			this.junctions.add(new Junction(i+"" , valX, valY));
		}
		SetAllRoads();
		this.lights=new ArrayList<TrafficLights>();
		
	}
	//================================

	public ArrayList<Junction> getJunctions() {
		return junctions;
	}

	public ArrayList<Road> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<Road> roads) {
		this.roads =new ArrayList<Road>(roads);
	}

	public ArrayList<TrafficLights> getLights() {
		return lights;
	}

	public void setLights(ArrayList<TrafficLights> lights) {
		this.lights = lights;
	}

	public void setJunctions(ArrayList<Junction> junctions) {
		this.junctions = new ArrayList<Junction>(junctions);
	}
	//================================

	public void SetAllRoads() {
		System.out.println("================= CREATING ROADS=================");
		this.roads=new ArrayList<Road>();
		for(Junction start :this.junctions) {
			for(Junction end:this.junctions ) {
				if(start!=end) {
					this.roads.add(new Road(start,end));
				}
			}
		}
	//	System.out.println("roads"+this.roads);
	}
	//
	public void turnLightsOn(){
		
	}
	
	//================================
	

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
			//	System.out.println("Junction "+junc.getJunctionName() +" nas been added to the map");
			}
			
		}
		return ans;

	}
	
	//================================



	@Override
	public boolean checkValue(double Val, double min, double max) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void correctingMessage(double wrongVal, double correctVal, String varName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void errorMessage(double wrongVal, String varName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean getRandomBoolean() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean getRandomDouble(double min, double max) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public double getRandomInt(int min, int max) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<Integer> getRandomIntArray(int min, int max, int arraySize) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void successMessage(String objName) {
		// TODO Auto-generated method stub
		
	}
	public void setTrafficLightsOn(boolean trafficLightsOn) {
	}
}
