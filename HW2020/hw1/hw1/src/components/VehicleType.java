package components;



public class VehicleType {
	private String typeName;
	private int speed; //average speed of vehicle type
	
 	
	/*******************************************************/
	
	public VehicleType(String typeName, int speed) {
		this.setName(typeName);
		this.setSpeed(speed);
	
		
	}
	public VehicleType() {
		
		
//		this.setName(typeName);
//		this.setSpeed(speed);
	
		
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
		return typeName+ " average speed: " +speed;
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
