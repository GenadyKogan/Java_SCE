package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
	private  VehicleType[] vehicleTypes;
	private ArrayList<Vehicle> waitingVehicles;
	//================================

	
	public Road (Junction start, Junction end){

		this.allowedSpeedOptions= new int[]{20,40,50,55,60,70,80,90};
		
		VehicleType[] vehicleTypesList= {VehicleType.car,VehicleType.bus,VehicleType.bicycle, VehicleType.motorcycle, VehicleType.truck, VehicleType.tram, VehicleType.semitrailer};
		this.setVehicleTypes(vehicleTypesList);
		
		this.setStartJunction(start);
		this.setEndJunction(end);
		this.setWaitingVehicles(new ArrayList<Vehicle>());
		//this.setGreenlight();
		this.setMaxSpeed(this.allowedSpeedOptions[ new Random().nextInt(this.allowedSpeedOptions.length)]);
		this.setLength(this.calcLength());
		this.setEnable(enable);
		this.endJunction.addEnteringRoad(this);
		this.startJunction.addExitingRoad(this);
		System.out.println("Road from "+this.startJunction.toString()+" to "+this.getEndJunction().toString()+" length: "+this.length+ ", max speed: "+this.maxSpeed+ " has been created");


	}

	//================================
	// set/get

	private void setVehicleTypes(VehicleType[] vehicleTypes) {
		this.vehicleTypes=new VehicleType[7];
		for(int i=0;i<vehicleTypes.length;i++)
			this.vehicleTypes[i]=vehicleTypes[i];

	
	}
	public int[] getAllowedSpeedOptions() {
		return allowedSpeedOptions;
	}
	
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean getGreenlight() {
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

	public Junction getEndJunction() {
		return endJunction;
	}

	public void setEndJunction(Junction endJunction) {
			this.endJunction = endJunction;

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
		for(Vehicle i: waitingVehicles) {
			
			if (!i.equals(vehicle)) {
				this.waitingVehicles.add(i);
				System.out.println(" vehicle "+vehicle+" on the road ");
				break;
			}
		}
	}
	public void checkout(Vehicle vehicle){
		for(Vehicle i: waitingVehicles) {
			
			if (i.equals(vehicle)) {
				this.waitingVehicles.remove(i);
				System.out.println(" vehicle "+vehicle+" delete on the road ");
				break;
			}
		}
	}
	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Road) {
			ans=( this.allowedSpeedOptions==((Road)other).allowedSpeedOptions   &&  this.enable==((Road)other).enable 
					&& this.startJunction ==((Road)other).startJunction &&  this.endJunction ==((Road)other).endJunction
					&& this.greenlight ==((Road)other).greenlight && this.length ==((Road)other).length
					&& this.maxSpeed ==((Road)other).maxSpeed) && this.vehicleTypes ==((Road)other).vehicleTypes
					&& this.waitingVehicles ==((Road)other).waitingVehicles;
			return ans;
		}
		return ans;
	}
	

	public RouteParts findNextPart(Vehicle vehicle){
		return vehicle.getCurrentRoutePart();
		
	}
	///
	public void removeVehicleFromWaitingVehicles(Vehicle vehicle){
		this.waitingVehicles.remove(vehicle);
	}
	public void stayOnCurrentPart(Vehicle vehicle){
		// TO DO
	}
	
	
	@Override
	public String toString() {
		return 	"Road from "+this.startJunction+" to "+this.endJunction+" length: "+this.length+ ", max speed: "+this.maxSpeed;

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
		// TODO Auto-generated method stub
		
	}




	
}
