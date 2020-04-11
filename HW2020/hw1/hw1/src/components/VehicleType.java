package components;

import java.util.Arrays;
import java.util.Random;

public class VehicleType {
	private String typeName;
	private int speed; //average speed of vehicle type
	static VehicleType[] randomVehicle;  

	public static VehicleType getRandomVehicleTypes() {
		randomVehicle =new VehicleType[5];
		randomVehicle[0]= new VehicleType("car",90);
		randomVehicle[1]= new VehicleType("bicycle",40);
		randomVehicle[2]= new VehicleType("motorcycle",120);
		randomVehicle[3]= new VehicleType("truck",80);
		randomVehicle[4]= new VehicleType("truck",80);
		Random Dice = new Random();
		int n = Dice.nextInt(5);
		return  randomVehicle[n];
		
	}

	/*******************************************************/
	
	public VehicleType(String typeName, int speed) {
		this.setName(typeName);
		this.setSpeed(speed);
	
	}
	public VehicleType() {
		VehicleType temp = getRandomVehicleTypes();
		this.setName(temp.getName());
		this.setSpeed(temp.getSpeed());
	}

	/*******************************************************/

	public String getName() {
		return typeName;
	}

	public void setName(String typeName) {
		this.typeName = typeName;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/*******************************************************/
	@Override
	public String toString() {
		return typeName +","+ " average speed: " +speed;
	}
	
	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof VehicleType) {
			ans=( this.typeName==((VehicleType)other).typeName   &&  this.speed==((VehicleType)other).speed );
		}
		return ans;
		
	}

	
	
}
