package components;

import java.util.ArrayList;
import java.util.Random;

public class Route  implements RouteParts{


	private ArrayList<RouteParts> RouteParts;


	private Vehicle vehicle;

	public Route(RouteParts start, Vehicle vehicle) {
		this.RouteParts =new ArrayList<RouteParts>();
		this.setVehicle(vehicle);
		initRouteParts(start,vehicle); 
		calcEstimatedTime(vehicle);
		
	} 
	
	private void initRouteParts(RouteParts start,Vehicle vehicle) {
		this.RouteParts.add(start);
		for(int i=0;i<9;i++) {
			if(vehicle.getLastRoad().getStartJunction().getEnteringRoads()!=null) {
				this.RouteParts.add(vehicle.getLastRoad().getStartJunction().getEnteringRoads().get(i).getStartJunction());
				this.RouteParts.add(vehicle.getLastRoad().getStartJunction().getEnteringRoads().get(i));
				this.RouteParts.add(vehicle.getLastRoad().getStartJunction().getEnteringRoads().get(i).getEndJunction());
			}
		}
		System.out.println("-is starting a new Route "+start+ " to "+ this.RouteParts.get(1)+ " estimated time for route:"+this.calcEstimatedTime(vehicle) );
		System.out.println("-is still moving on   "+start+ ", time to finish: "+vehicle.getTimeFromRouteStart());
	}

	@Override
	public String toString() {
		return "Route [RouteParts=" + RouteParts + ", vehicle=" + vehicle + "]";
	}

	//================================
	//get and set
	public ArrayList<RouteParts> getRouteParts() {
		return RouteParts;
	}

	public void setRouteParts(ArrayList<RouteParts> routeParts) {
		RouteParts =new ArrayList<RouteParts>(routeParts);
	}
	public void addRouteParts(ArrayList<RouteParts> routeParts) {
		for(int i=0;i<routeParts.size();i++)
			this.RouteParts.add(i, routeParts.get(i));
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle=vehicle;
	}

	//================================
	//metods



	public boolean canLeave(Vehicle vehicle){
		for(int i=0;i<this.RouteParts.size();i++)
			if(this.RouteParts.get(i).equals(vehicle.getLastRoad().getEndJunction())) {
				return true;
			}
		return false;
	}
	
	public double calcEstimatedTime(Object obj) {
		int index=0;
		for (int i=0;i<this.RouteParts.size();i++) 
			index+=((Vehicle)obj).getTimeOnCurrentPart();
		return index;
		
	}
	public void checkIn(Vehicle vehicle){
	}
	public void checkout(Vehicle vehicle){

	}
	public RouteParts findNextPart(Vehicle vehicle){
		return null;
		
	}
	public void stayOnCurrentPart(Vehicle vehicle){
		if(canLeave(vehicle)) {
			
		}
	}
	
	//================================

	
	

	//methods
	@Override
	public boolean checkValue(double Val, double min, double max) {
		if(Val<max && Val>min)
			return true;
		return false;
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
	public void successMessage(String objName) {
		// TODO Auto-generated method stub
		
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
	public ArrayList<Integer> getRandomIntArray(int min, int max, int arraySize) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <arraySize; i++) {
            list.add(getRandomInt(min,max));
        }
        return list;
	}




}
