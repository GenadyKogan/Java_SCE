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
		for (int i = 0; i < numOfVehicles ; i++) 
			this.vehicles.add(new Vehicle(map.getRoads().get(i)));
		


	}
//
	public void  drive(int numOfTurns) {
		for(int i=0;i<numOfTurns;i++) {
			incrementDrivingTime();
		}
	}
	public void incrementDrivingTime() {
	/*	for(int i=1; i<drivingTime+1;i++ ) {
			System.out.println("TURN "+i);
			System.out.println(this.vehicles.get(i).toString() + "  is starting route " );
			for(int j=0; j<this.vehicles.size();j++) {
				this.vehicles.get(j).move();
				
			}
		}*/
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
