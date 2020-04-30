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
		// TO DO
	}
	public void incrementDrivingTime() {
		// TO DO
	}
	//========================================
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
