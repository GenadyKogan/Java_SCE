package components;
import java.util.ArrayList;
import java.util.Random;

import utilities.*;


public class Driving  implements Utilities, Timer {
	private Map map;
	private  ArrayList<Vehicle> vehicles; 
	private int drivingTime;
	private ArrayList<Timer> allTimedElements;
	
	public Driving (int numOfJunctions, int numOfVehicles) {
		System.out.println("================= CREATING JUNCTIONS=================");
		this.map= new Map(numOfJunctions);
	
		this.vehicles=new ArrayList<Vehicle>();
		for (int i = 0; i < numOfVehicles ; i++) {
			Vehicle temp=new Vehicle(map.getRoads().get(i));
			this.vehicles.add(temp);
			temp.setCurrentRoute(getRandomRouteFromJunction(vehicles.get(i).getCurrentRoutePart(),vehicles.get(i).getVehicleType()));
		}
	//	System.out.println(this.vehicles);

	}
//
	public void  drive(int numOfTurns) {
		//System.out.println(numOfTurns);
		for(int i=1;i<numOfTurns+1;i++) {
			System.out.println("TURN "+i);
			this.incrementDrivingTime();
		}
	}
	public void incrementDrivingTime() {
			for(int j=0; j<this.vehicles.size();j++) {
				this.vehicles.get(j).incrementDrivingTime();
		}
	
	}
	
	public Route getRandomRouteFromJunction( RouteParts currentRoutePart, VehicleType vehicleType) {
		
		return null;
	
	}
	//========================================
	//get & set
	

	public int getDrivingTime() {
		return drivingTime;
	}
	public void setDrivingTime(int drivingTime) {
		this.drivingTime = drivingTime;
	}
	public ArrayList<Timer> getAllTimedElements() {
		return allTimedElements;
	}
	public void setAllTimedElements(ArrayList<Timer> allTimedElements) {
		this.allTimedElements = new ArrayList<Timer>(allTimedElements);
	}
	//========================================
	
	
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
		// TODO Auto-generated method stub
		
	}
}
