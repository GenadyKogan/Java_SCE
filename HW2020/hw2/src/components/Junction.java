package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Junction  extends Point implements RouteParts {
	private static int objectsCount=1;
	
	private ArrayList<Road> enteringRoads;
	private ArrayList<Road> exitingRoads;
	private String junctionName;
	//================================

	public Junction() {
		super(new Random().nextInt(799) + 0,new Random().nextInt(599) + 0);
		this.setJunctionName(String.valueOf(objectsCount));	
		System.out.print("Junction "+this.getObjectsCount()+ " (" + getX()+","+getY()+") has been created\n");
		this.setObjectsCount(objectsCount+1);
		this.setExitingRoads(new ArrayList<Road>());
		this.setEnteringRoads(new ArrayList<Road>());
	}
	
	public Junction(String junctionName, double x, double y) {
		super(x,y);
		this.setJunctionName(junctionName);
		
		System.out.print("Junction "+this.getJunctionName()+ " (" + getX()+","+getY()+") has been created\n");
		if(this.objectsCount%2==1)
			System.out.println("Junction null has been created.");
		
		this.setObjectsCount(objectsCount+1);	
		this.setExitingRoads(new ArrayList<Road>());
		this.setEnteringRoads(new ArrayList<Road>());

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
	
	
	@Override
	public String toString() {
		return "junction "+this.getJunctionName();
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
		return this.getEnteringRoads().indexOf(((Vehicle)obj).getLastRoad())+1;
		
	}
	public boolean canLeave(Vehicle vehicle){
		System.out.println(vehicle);
		if(!checkAvailability(vehicle)) {
			if(!this.getExitingRoads().contains(vehicle.getLastRoad()))
				vehicle.setStatus("vehicle can't cross the junction and leave because there are no ways out of the junction");
			else
				vehicle.setStatus("vehicle can't cross the junction and leave because it is not on the waiting list");
			return false;
		}
		return true;

	}
	public boolean checkAvailability(Vehicle vehicle) {
	//	System.out.println(this.getExitingRoads());
		System.out.println("khkjj "+this.getEnteringRoads().contains(vehicle.getLastRoad()));
	//	System.out.println(vehicle.getLastRoad().getWaitingVehicles());
		if(this.getExitingRoads().contains(vehicle.getLastRoad()) && this.getExitingRoads().indexOf(vehicle.getLastRoad().getWaitingVehicles())!=-1) {
//			if(this.getExitingRoads().indexOf(vehicle.getLastRoad().getWaitingVehicles())!=0){
//				for(int i=0;i< this.getExitingRoads().indexOf(vehicle.getLastRoad().getWaitingVehicles());i++) {
//				}
//				
//			}
			System.out.println("asdasdddaddafsdf");
			return true;
		}
		return false;
		
	}
	
	public void checkIn(Vehicle vehicle){
		if(vehicle.getLastRoad().getWaitingVehicles().contains(vehicle))
			vehicle.getLastRoad().getWaitingVehicles().remove(vehicle);
		
	}
	public void checkOut(Vehicle vehicle){
		if(vehicle !=null)
			vehicle.getLastRoad().getWaitingVehicles().add(vehicle);
		System.out.println(vehicle);
	}

	public RouteParts findNextPart(Vehicle vehicle){
		//to do
		return null;
		
	}
	public void stayOnCurrentPart(Vehicle vehicle){
		System.out.println(vehicle.getStatus());
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
