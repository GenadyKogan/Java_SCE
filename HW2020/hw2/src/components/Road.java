package components;

import java.util.ArrayList;

import utilities.Utilities;
import utilities.VehicleType;

public class Road  implements RouteParts, Utilities{
	private int [] allowedSpeedOptions;
	private boolean enable;
	private Junction startJunction;
	private Junction endJunction;
	private boolean greenlight;
	private double length;
	private int maxSpeed;
	private VehicleType[] vehicleTypes;
	private ArrayList<Vehicle> waitingVehicles;
	//================================

	public Road (Junction start, Junction end){
	
		
	}
	//================================

	public void addVehicleToWaitingVehicles(Vehicle vehicle){
		
	}
	public double calcEstimatedTime(Object obj){
		//to do
		return length;
		
	}
	public double calcLength(){
		//to do
		return length;
		
	}
	public boolean canLeave(Vehicle vehicle){
		//to do
		return enable;
		
	}
	public void checkIn(Vehicle vehicle){
		
	}
	public void checkout(Vehicle vehicle){
		
	}
	public RouteParts findNextPart(Vehicle vehicle){
		//to do
		return null;
		
	}
	public void removeVehicleFromWaitingVehicles(Vehicle vehicle){
		
	}
	public void stayOnCurrentPart(Vehicle vehicle){
		
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
}
