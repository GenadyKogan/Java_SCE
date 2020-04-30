package components;

public class LightedJunction extends Junction{
	private TrafficLights light;

	public LightedJunction(String name, double x, double y, boolean sequential, boolean lightsOn) {
		super(name, x, y);
		this.light=new SequentialTrafficLights(null);
		this.light.setTrafficLightsOn(lightsOn);
		if(this.light.getTrafficLightsOn())
			System.out.print(""+super.toString()+ " (Lighted) " + "has been created\n");
		else
			System.out.print(""+super.toString()+ " has been created\n");

	}
	
	public TrafficLights getLights() {
		return this.light;
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

	@Override
	public String toString() {
		if(this.light.getTrafficLightsOn())
			return ""+super.toString()+" (Lighted)";
		else
			return ""+super.toString();

	}
	
	//================================

}
