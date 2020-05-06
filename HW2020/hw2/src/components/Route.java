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
		this.checkIn(vehicle);
		System.out.println("-is starting a new Route "+start+ " to "+ this.RouteParts.get(1)+ " estimated time for route:"+this.calcEstimatedTime(vehicle) );
		stayOnCurrentPart(vehicle);
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
			if(this.RouteParts.get(i).equals(vehicle.getLastRoad().getStartJunction())) {
				return false;
			}
		return true;
	}
	
	public double calcEstimatedTime(Object obj) {
		int index=0;
		for (int i=0;i<this.RouteParts.size();i++) 
			index+=((Vehicle)obj).getTimeOnCurrentPart();
		return index;
	}
	public void checkIn(Vehicle vehicle){
		for(int i=0;i<9;i++) {
			if(vehicle.getLastRoad().getStartJunction().getEnteringRoads()!=null) {
				this.RouteParts.add(vehicle.getLastRoad().getStartJunction().getEnteringRoads().get(i).getStartJunction());
				this.RouteParts.add(vehicle.getLastRoad().getStartJunction().getEnteringRoads().get(i));
				this.RouteParts.add(vehicle.getLastRoad().getStartJunction().getEnteringRoads().get(i).getEndJunction());
			}
		}
	//	System.out.println("vehicle was added to route parts");
	}
	public void checkout(Vehicle vehicle){
		if(canLeave(vehicle)) {
			for(int i=0;i< this.RouteParts.size();i++)
				this.RouteParts.remove(i);
		}
	//	System.out.println("vehicle was deleted from route parts");
	}
	public RouteParts findNextPart(Vehicle vehicle){
		if(this.canLeave(vehicle)) {
			RouteParts start=this.RouteParts.get(0);
			RouteParts end=this.RouteParts.get(this.RouteParts.indexOf(this.RouteParts.size()-2));
			if(vehicle.getLastRoad().equals(this.RouteParts.get(this.RouteParts.indexOf(this.RouteParts.size()-1)))) {
				if(vehicle.getLastRoad().getEndJunction().getExitingRoads()==null)
					this.RouteParts.add(start);
				else if(vehicle.getLastRoad().getStartJunction().getExitingRoads()!=null)
					this.RouteParts.add(end);
				for(int i=0;i<9;i++) {
					this.RouteParts.add(new Junction(getRandomInt(0,10)+"" , getRandomInt(0,800), getRandomInt(0,600)));
					this.RouteParts.add(new Road (new Junction(getRandomInt(0,10)+"" , getRandomInt(0,800), getRandomInt(0,600)), new Junction(i+"" , getRandomInt(0,800), getRandomInt(0,600))));
				}
			}

			else {
				for(int i=0;i<this.RouteParts.size();i++) {
					if(vehicle.getCurrentRoute().equals(this.RouteParts.get(i)))
						return this.RouteParts.get(i+1);
				}
				
			}
		}
		return null;
		
	}
	public void stayOnCurrentPart(Vehicle vehicle){
		if(!canLeave(vehicle)) {
			System.out.println("-is still moving on   "+vehicle.getCurrentRoutePart()+ ", time to finish: "+vehicle.getTimeFromRouteStart());

		}
	}
	
}
