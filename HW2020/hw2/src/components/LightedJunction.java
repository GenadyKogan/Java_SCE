package components;

public class LightedJunction extends Junction{
	private TrafficLights lights=new SequentialTrafficLights(null);

	public LightedJunction(String name, double x, double y, boolean sequential, boolean lightsOn) {
		super(name, x, y);
		lights.setTrafficLightsOn(lightsOn);
		
	}
	
	//================================
	public LightedJunction(){
		
	}
	public double calcEstimatedTime(Object obj){
		//to do
		return 0;
		
	}
	public boolean canLeave(Vehicle vehicle){
		//to do
		return false;
		
	}
	//================================
	
}
