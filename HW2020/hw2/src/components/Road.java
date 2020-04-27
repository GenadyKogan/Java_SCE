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

		this.allowedSpeedOptions= new int[]{20,40,50,55,60,70,80,90};
		this.vehicleTypes=new VehicleType[7];
		this.setStartJunction(start);
		this.setEndJunction(end);
		this.setWaitingVehicles(new ArrayList<Vehicle>());
		//this.setGreenlight();
		//this.setMaxSpeed();
		//this.setLength();
		//this.setEnable();

	}
	//================================
	// set/get
	
	public int[] getAllowedSpeedOptions() {
		return allowedSpeedOptions;
	}
	
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean isGreenlight() {
		return greenlight;
	}

	public void setGreenlight(boolean greenlight) {
		this.greenlight = greenlight;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public VehicleType[] getVehicleTypes() {
		return vehicleTypes;
	}

	public void setVehicleTypes(VehicleType vehicleTypes,int index) {
		this.vehicleTypes[index] = vehicleTypes;
	}

	public ArrayList<Vehicle> getWaitingVehicles() {
		return waitingVehicles;
	}

	public void setWaitingVehicles(ArrayList<Vehicle> waitingVehicles) {
		this.waitingVehicles =new ArrayList<Vehicle>(waitingVehicles);
	}

	public Junction getStartJunction() {
		return startJunction;
	}

	public void setStartJunction(Junction startJunction) {
		this.startJunction = startJunction;
	}
	
	
	
	
	
	
	//================================
	//methods
	public void addVehicleToWaitingVehicles(Vehicle vehicle){
		this.waitingVehicles.add(vehicle);
		}
	public double calcEstimatedTime(Object obj){
		if(obj instanceof Vehicle) {
			return this.length/Math.min(this.maxSpeed,((Vehicle) obj).getVehicleType().getAverageSpeed());
		}
		return 0;
	}
	public double calcLength(){
		double xPoint=this.startJunction.getX()-this.endJunction.getX();
		double yPoint=this.startJunction.getY()-this.endJunction.getY();
		return Math.sqrt(xPoint*xPoint + yPoint*yPoint);
		
	}
	public boolean canLeave(Vehicle vehicle){
		return vehicle.getTimeOnCurrentPart()<=vehicle.getTimeFromRouteStart();
		
	}
	public void checkIn(Vehicle vehicle){

	}
	public void checkout(Vehicle vehicle){
		// to do
	}
	public RouteParts findNextPart(Vehicle vehicle){
		return vehicle.getCurrentRoutePart();
		
	}
	///
	public void removeVehicleFromWaitingVehicles(Vehicle vehicle){
		this.waitingVehicles.remove(vehicle);
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

	public Junction getEndJunction() {
		return endJunction;
	}

	public void setEndJunction(Junction endJunction) {
		this.endJunction = endJunction;
	}

	
}
