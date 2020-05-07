package components;

import java.util.ArrayList;
import java.util.Random;

public class Route  implements RouteParts{


	private ArrayList<RouteParts> RouteParts;


	private Vehicle vehicle;
	/**Constructor
	 * creates an object with all given parameters
	 * @param route parts represents the route parts of the route in the order they appear 
	 * @param vehType represents the vehicle type the route is constructed for.
	 */
	public Route(RouteParts start, Vehicle vehicle) {
		this.RouteParts =new ArrayList<RouteParts>();
		this.setVehicle(vehicle);
		initRouteParts(start,vehicle); 
		calcEstimatedTime(vehicle);
		
	} 
	/**
	 * Auxiliary Method- initializ route parts
	 * @param start
	 * @param vehicle
	 */
	private void initRouteParts(RouteParts start,Vehicle vehicle) {
		this.RouteParts.add(start);
		this.checkIn(vehicle);
		System.out.println("-is starting a new Route "+start+ " to "+ this.RouteParts.get(1)+ " estimated time for route:"+this.calcEstimatedTime(vehicle) );
		stayOnCurrentPart(vehicle);
	}
	/**Returns a string representation of the object
	 * @return a String represents the object
	 */
	@Override
	public String toString() {
		return "Route [RouteParts=" + RouteParts + ", vehicle=" + vehicle + "]";
	}

	//================================
	//get and set
	/**Gets the ArrayList<RouteParts> route parts 
	 * 
	 * @return route parts holds the list of route parts vehicle
	 */
	public ArrayList<RouteParts> getRouteParts() {
		return RouteParts;
	}
	/**Sets the Vehicle 
	 * @param an ArrayList<RouteParts> route parts
	 */
	public void setRouteParts(ArrayList<RouteParts> routeParts) {
		RouteParts =new ArrayList<RouteParts>(routeParts);
	}
	/**Adds an ArrayList<RouteParts> route parts
	 * @param route parts - type ArrayList<RouteParts>
	 */
	public void addRouteParts(ArrayList<RouteParts> routeParts) {
		for(int i=0;i<routeParts.size();i++)
			this.RouteParts.add(i, routeParts.get(i));
	}
	
	/**Gets the vehicle of the route
	 * 
	 * @return Vehicle holds the list of route vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}
	/**Sets the Vehicle 
	 * @param vehicle Vehicle
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle=vehicle;
	}

	//================================
	//metods


	/**
	 * @param vehicle - type Vehicle 
	 * @return true if a vehicle has reached the last component of the route
	 */
	public boolean canLeave(Vehicle vehicle){
		for(int i=0;i<this.RouteParts.size();i++)
			if(this.RouteParts.get(i).equals(vehicle.getLastRoad().getStartJunction())) {
				return false;
			}
		return true;
	}
	/**
	 * @param Accepts a vehicle as an argument
	 * @return index - type double
	 * Method calculates the estimated time to perform the route for this vehicle.
	 */
	public double calcEstimatedTime(Object obj) {
		int index=0;
		for (int i=0;i<this.RouteParts.size();i++) 
			index+=((Vehicle)obj).getTimeOnCurrentPart();
		return index;
	}
	/**
	 * @param vehicle - type Vehicle 
	 * The vehicle registers on the route (as soon as the vehicle receives the route), updates the relevant fields.
	 */
	public void checkIn(Vehicle vehicle){
		for(int i=0;i<9;i++) {
			if(vehicle.getLastRoad().getStartJunction().getEnteringRoads()!=null) {
				this.RouteParts.add(vehicle.getLastRoad().getStartJunction().getEnteringRoads().get(i).getStartJunction());
				this.RouteParts.add(vehicle.getLastRoad().getStartJunction().getEnteringRoads().get(i));
				this.RouteParts.add(vehicle.getLastRoad().getStartJunction().getEnteringRoads().get(i).getEndJunction());
			}
		}
	}
	/**
	 *  @param vehicle - type Vehicle 
	 *  Method "releases" the vehicle from the track.
	 */
	public void checkout(Vehicle vehicle){
		if(canLeave(vehicle)) {
			for(int i=0;i< this.RouteParts.size();i++)
				this.RouteParts.remove(i);
		}
	}
	/**
	 * @param vehicle - type Vehicle
	 * Method create a new route for a vehicle
	 */
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
	/**
	 * @param vehicle - type Vehicle
	 * Prints a message that the vehicle continues on the current track.
	 */
	public void stayOnCurrentPart(Vehicle vehicle){
		if(!canLeave(vehicle)) {
			System.out.println("-is still moving on   "+vehicle.getCurrentRoutePart()+ ", time to finish: "+vehicle.getTimeFromRouteStart());

		}
	}
	
}
