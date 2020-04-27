package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Junction  extends Point implements RouteParts {
	private int objectsCount=1;
	
	private ArrayList<Road> enteringRoads;
	private ArrayList<Road> exitingRoads;
	private String junctionName;
	//================================
	//
	public Junction() {
		super(new Random().nextInt(799) + 0,new Random().nextInt(599) + 0);
		this.setJunctionName(String.valueOf(junctionName));		

	}
	
	public Junction(String junctionName, double x, double y) {
		super(x,y);
		this.setJunctionName(junctionName);
		
	}
	
	//================================
	// set/get
	public int getObjectsCount() {
		return objectsCount;
	}

	public String getJunctionName() {
		return junctionName;
	}
	
	public void setJunctionName(String junctionName) {
		this.junctionName = junctionName;
	}
	
	public ArrayList<Road> getEnteringRoads() {
		return enteringRoads;
	}
	public void setEnteringRoads(ArrayList<Road> enteringRoads) {
		this.enteringRoads =new ArrayList<Road>(enteringRoads);
	}
	public ArrayList<Road> getExitingRoads() {
		return exitingRoads;
	}
	public void setExitingRoads(ArrayList<Road> exitingRoads) {
		this.exitingRoads = new ArrayList<Road>(exitingRoads);
	}
	public void setObjectsCount(int objectsCount) {
		this.objectsCount = objectsCount;
	}
	
	
	//================================
	//methods
	public void addExitingRoad(Road roadExitRoad) { //using for a road
		this.exitingRoads.add (roadExitRoad);
	
	}
	
	public void addEnteringRoad(Road roadEnterRoad) { 
		this.enteringRoads.add (roadEnterRoad);
	}
	
	
	public double calcEstimatedTime(Object obj){
		double estimateTime;
		//for()
		return -1;
		
	}
	public boolean canLeave(Vehicle vehicle){
		
		
		return false;
	}
	public boolean checkAvailability(Vehicle vehicle) {
		//to do
		return false;
		
	}
	
	public void checkIn(Vehicle vehicle){
		
	}
	public void checkOut(Vehicle vehicle){
		
	}

	public RouteParts findNextPart(Vehicle vehicle){
		//to do
		return null;
		
	}
	public void stayOnCurrentPart(Vehicle vehicle){
		
	}
	//================================

	
	
	
	
	
	
	
	
	
	
	
	
	
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

	@Override
	public void checkout(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}
	
	
}
