package components;

import java.util.Arrays;
import java.util.Random;

public class VehicleType {
	private String typeName;
	private int speed; //average speed of vehicle type
	static VehicleType[] randomVehicle;  

	

	/*******************************************************/
	/**
	 * Ctor for a VehicleType
	 * @param typeName - Type String
	 * @param speed - Type int
	 */
	public VehicleType(String typeName, int speed) {
		this.setName(typeName);
		this.setSpeed(speed);
	
	}
	/**
	 * Default Ctor for a VehicleType
	 * @param  No parameters
	 */
	public VehicleType() {
		VehicleType temp = getRandomVehicleTypes();
		this.setName(temp.getName());
		this.setSpeed(temp.getSpeed());
	}

	/*******************************************************/
	/**
	 * @param No parameters
	 * @return typeName - Type String
	 */
	public String getName() {
		return typeName;
	}
	/**
	 * @param typeName - Type String
	 * @return nothing - Initializes an typeName 
	 */	
	public void setName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * @param No parameters
	 * @return speed - Type int
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * @param speed - Type int
	 * @return nothing - Initializes an speed 
	 */	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/*******************************************************/
	/**
	 * @param No parameters
	 * @return String - Print the data for a typeName and average speed
	 */
	@Override
	public String toString() {
		return typeName +","+ " average speed: "+speed;
	}
	
	/**
	 * @param other - Object type
	 * @return Boolean value - true or false
	 */	

	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof VehicleType) {
			ans=( this.typeName==((VehicleType)other).typeName   &&  this.speed==((VehicleType)other).speed );
		}
		return ans;
		
	}
	/**
	 * @param No parameters
	 * @return randomVehicle - Type VehicleType
	 */
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
	
	
}

