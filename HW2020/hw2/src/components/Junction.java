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
		this.setExitingRoads(new ArrayList<Road>());
		this.setEnteringRoads(new ArrayList<Road>());
		setObjectsCount(objectsCount+1);

	}
	
	public Junction(String junctionName, double x, double y) {
		super(x,y);
		this.setJunctionName(junctionName);
		this.setExitingRoads(new ArrayList<Road>());
		this.setEnteringRoads(new ArrayList<Road>());
		setObjectsCount(objectsCount+1);	

	}
	
	//================================
	// set/get
	public  static int getObjectsCount() {
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
	public static void setObjectsCount(int objectsCount2) {
		objectsCount = objectsCount2;
	}
	
	//================================
	//methods
	
	@Override
	public String toString() {
		return "junction "+this.getJunctionName();
	}

	public void addExitingRoad(Road roadExitRoad) { //using for a road
		
		if(!this.exitingRoads.contains(roadExitRoad))
			this.exitingRoads.add (roadExitRoad);
	
	}
	
	public void addEnteringRoad(Road roadEnterRoad) { 
		if(!this.enteringRoads.contains(roadEnterRoad))
			this.enteringRoads.add (roadEnterRoad);
	}
	
	
	public double calcEstimatedTime(Object obj){
		return this.getEnteringRoads().indexOf(((Vehicle)obj).getLastRoad())+1;
		
	}
	public boolean canLeave(Vehicle vehicle){
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
		if(this.getEnteringRoads().contains(vehicle.getLastRoad()) && vehicle.getLastRoad().getWaitingVehicles().indexOf(vehicle)!=-1) {
			for(int i=0 ;i<vehicle.getLastRoad().getWaitingVehicles().size();i++)
			{

				if(i<vehicle.getLastRoad().getWaitingVehicles().indexOf(vehicle)+1) {

						double time=calcEstimatedTime(this.enteringRoads.get(i).getWaitingVehicles().get(i));
						time-=1;
				}
			}

			return true;
		}

		return false;
		
	}
	
	public void checkIn(Vehicle vehicle){
		if(vehicle.getLastRoad().getWaitingVehicles().contains(vehicle))
			vehicle.getLastRoad().getWaitingVehicles().remove(vehicle);
	}
	
	public void checkout(Vehicle vehicle){
		if(vehicle !=null)
			vehicle.getLastRoad().getWaitingVehicles().add(vehicle);
		System.out.println(this.toString()+ " has left  " +this.toString()+ ".");
		
	}

	public RouteParts findNextPart(Vehicle vehicle){
		ArrayList<Road> temp= new ArrayList<Road>();
		for(int i=0;i<this.enteringRoads.size();i++) {
			if(this.exitingRoads.get(i).isEnable())
				temp.add(this.exitingRoads.get(i));
		}
		if(!temp.isEmpty()) 
			return temp.get(this.getRandomInt(0, temp.size()-1));
		return null;
		
	}
	public void stayOnCurrentPart(Vehicle vehicle){
		System.out.println(vehicle.getStatus());
		
	}

	//================================
	@Override		
	public boolean equals(Object other) {

		boolean ans =false;
		if(other instanceof Junction) {
			ans=( this.junctionName==((Junction)other).junctionName   
					&& this.getX() ==((Junction)other).getX() 
					&& this.getY() ==((Junction)other).getY());
			return ans;
		}
		return ans;
	}
	//================================

	@Override
	public boolean checkValue(double Val, double min, double max) {
		if(Val<max && Val>min)
			return true;
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
		boolean [] booleanElem={true,false};
		return booleanElem[ new Random().nextInt(booleanElem.length)];
	}

	@Override
	public double getRandomDouble(double min, double max) {
		 double random_double = Math.random() * (max - min + 1) + min; 
		 return random_double;
	}


	@Override
	public int getRandomInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max-min+1) + min;
	}

	@Override
	public ArrayList<Integer> getRandomIntArray(int min, int max, int arraySize) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <arraySize; i++) {
            list.add(getRandomInt(min,max));
        }
        return list;
	}

	@Override
	public void successMessage(String objName) {
		System.out.print("Junction "+objName+ " (" + getX()+","+getY()+") "+ "has been created\n");
		
	}


	
	
	

	
	
	
	
	
	
	




	
}
