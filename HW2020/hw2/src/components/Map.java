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
		for (int i = 0; i < numOfJunctions; i++) {
			int sizeX=(new Random().nextInt(799) + 0 );
			int sizeY=(new Random().nextInt(599) + 0 );
			this.junctions.add(new Junction("Junction " + i , sizeX, sizeY));
		}
		SetAllRoads();
		this.lights=new ArrayList<TrafficLights>();
		
	}
	//aa//
	//================================

	public void SetAllRoads() {
		this.roads=new ArrayList<Road>();
		for(Junction start :this.junctions) {
			for(Junction end:this.junctions ) {
				if(start!=end) {
					this.roads.add(new Road(start,end));
				}
			}
		}
	}
	public void turnLightsOn(){
		
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
