package components;

public class VehicleType {
	private String typeName;
	private int speed; //average speed of vehicle type
	
	/*******************************************************/
	
	public VehicleType(String typeName, int speed) {
		this.setTypeName(typeName);
		this.setSpeed(speed);
	}

	/*******************************************************/

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
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
		return "VehicleType [typeName=" + typeName + ", speed=" + speed + "]";
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
