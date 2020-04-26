package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Junction  extends Point /*implements RouteParts*/  {
	private int objectsCount=1;
	
	private ArrayList<Road> enteringRoads;
	private ArrayList<Road> exitingRoads;
	private String junctionName;
	//================================
	//
	public Junction() {

		//this();
		//this.setJunctionName(String.valueOf(junctionName));
		//setX(new Random().nextInt(799) + 0 );
		//setY(new Random().nextInt(599) + 0);
		

		super(new Random().nextInt(799) + 0,new Random().nextInt(599) + 0);
		this.setJunctionName(String.valueOf(junctionName));		

	}
	
	public Junction(String junctionName, double x, double y) {
		super(x,y);
		this.setJunctionName(junctionName);
		
	}
	
	//================================
	
	public void addExitingRoad(Road roadExitRoad) { //using for a road
		this.exitingRoads.add (roadExitRoad);
	
	}
	
	public void addEnteringRoad(Road roadEnterRoad) { 
		this.enteringRoads.add (roadEnterRoad);
	}
	
	
	
	//================================

	
	public int getObjectsCount() {
		return objectsCount;
	}

	public String getJunctionName() {
		return junctionName;
	}
	
	public void setJunctionName(String junctionName) {
		this.junctionName = junctionName;
	}
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
	
	
}
