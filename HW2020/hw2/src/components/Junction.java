package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Junction  extends Point implements RouteParts {
	private static int objectsCount=1;
	private ArrayList<Road> enteringRoads;
	private ArrayList<Road> exitingRoads;
	private String junctionName;
	//================================
	/**
	 * Default Ctor for a Junction
	 * @param  No parameters
	 * Random constructor, creates a random point node, initializes all fields, sets the object name by number his serial in the department.
	 */
	public Junction() {
		super(new Random().nextInt(799) + 0,new Random().nextInt(599) + 0);
		this.setJunctionName(String.valueOf(objectsCount));	
		this.setExitingRoads(new ArrayList<Road>());
		this.setEnteringRoads(new ArrayList<Road>());
		setObjectsCount(objectsCount+1);

	}
	/**Constructor
	 * @param name String contains name of junction
	 * @param x and y value - Point object contains the junction location
	 */
	public Junction(String junctionName, double x, double y) {
		super(x,y);
		this.setJunctionName(junctionName);
		this.setExitingRoads(new ArrayList<Road>());
		this.setEnteringRoads(new ArrayList<Road>());
		setObjectsCount(objectsCount+1);	

	}
	
	//================================
	// set and get
	/** Name field getter
	 * @return int contains objects count
	 */
	public  static int getObjectsCount() {
		return objectsCount;
	}
	/** Name field getter
	 * @return String contains junction name
	 */
	public String getJunctionName() {
		return junctionName;
	}
	/**Sets the junction name
	 * @param name A String represents junction name
	 */
	public void setJunctionName(String junctionName) {
		this.junctionName = junctionName;
	}
	/**Entering roads getter
	 * @return ArrayList<Road> holds the entering roads of the junction
	 */
	public ArrayList<Road> getEnteringRoads() {
		return enteringRoads;
	}
	/**Sets the entering roads array for junction
	 * @param ArrayList<Road> holds the list of entering roads of the junction.
	 */
	public void setEnteringRoads(ArrayList<Road> enteringRoads) {
		this.enteringRoads =new ArrayList<Road>(enteringRoads);
	}
	/** Exiting roads getter
	 * @return ArrayList<Road> holds the exiting roads of the junction
	 */
	public ArrayList<Road> getExitingRoads() {
		return exitingRoads;
	}
	/**Sets the exiting roads array for junction
	 * @param roads ArrayList<Road> holds the list of exiting roads of the junction.
	 */
	public void setExitingRoads(ArrayList<Road> exitingRoads) {
		this.exitingRoads = new ArrayList<Road>(exitingRoads);
	}
	/**Sets the objects count for junction
	 * @param objects count - type int
	 */
	public static void setObjectsCount(int objectsCount2) {
		objectsCount = objectsCount2;
	}
	
	//================================
	//methods
	/**Returns a string representation of the object
	 * @return a String represents the object
	 */
	@Override
	public String toString() {
		return "junction "+this.getJunctionName();
	}
	/**Adds an exiting road to the exetingRoads array
	 * @param road Road representing the added exiting road.
	 */
	public void addExitingRoad(Road roadExitRoad) { //using for a road
		
		if(!this.exitingRoads.contains(roadExitRoad))
			this.exitingRoads.add (roadExitRoad);
	
	}
	/**Adds an entering road to the enteringRoads array
	 * @param road Road representing the added entering road.
	 */
	public void addEnteringRoad(Road roadEnterRoad) { 
		if(!this.enteringRoads.contains(roadEnterRoad))
			this.enteringRoads.add (roadEnterRoad);
	}
	
	/**
	 *  @param obj - type Object, A method that accepts as a show instance of a vehicle
	 *   @return  maximum time the vehicle will have to wait Before passing the node
	 */
	public double calcEstimatedTime(Object obj){
		return this.getEnteringRoads().indexOf(((Vehicle)obj).getLastRoad())+1;
		
	}
	/**
	 *  @param vehicle - type Vehicle
	 *   @return  Boolean value that reflects the possibility of checkout from a component. In case of the method node will return an answer as to whether the vehicle can cross the junction and leave it
	 */
	public boolean canLeave(Vehicle vehicle){
		if(!checkAvailability(vehicle)) {
			if(!this.getExitingRoads().contains(vehicle.getLastRoad()))
				vehicle.setStatus("vehicle can't cross the junction and leave because there are no ways out of the junction");
			else
				vehicle.setStatus("vehicle can't cross the junction and leave because it is not on the waiting list");
			return false;
		}
		return true;

	}
	/**Checks for vehicle the ability to cross the junction.
	 * @param r Road represents the road that led the checking vehicle to the junction.
	 * @return a boolean representing the availability of the junction.
	 */
	public boolean checkAvailability(Vehicle vehicle) {
		if(this.getEnteringRoads().contains(vehicle.getLastRoad()) && vehicle.getLastRoad().getWaitingVehicles().indexOf(vehicle)!=-1) {
			for(int i=0 ;i<vehicle.getLastRoad().getWaitingVehicles().size();i++)
			{

				if(i<vehicle.getLastRoad().getWaitingVehicles().indexOf(vehicle)+1) {

						double time=calcEstimatedTime(this.enteringRoads.get(i).getWaitingVehicles().get(i));
						time-=1;
				}
			}

			return true;
		}

		return false;
		
	}
	/**
	 *  @param vehicle - type Vehicle
	 *  A method that "registers" the vehicle at a node, updates all relevant fields of the node and the vehicle.
	 *  @return nothing
	 */
	public void checkIn(Vehicle vehicle){
		if(vehicle.getLastRoad().getWaitingVehicles().contains(vehicle))
			vehicle.getLastRoad().getWaitingVehicles().remove(vehicle);
	}
	/**
	 *  @param vehicle - type Vehicle
	 * The "exit" method makes up a road that belongs to the interface of your components. Operated on condition that the vehicle is "authorized" to cross and leave The node, updates all the relevant fields, and prints a message.
	 *  @return nothing
	 */
	public void checkout(Vehicle vehicle){
		if(vehicle !=null)
			vehicle.getLastRoad().getWaitingVehicles().add(vehicle);
		System.out.println(this.toString()+ " has left  " +this.toString()+ ".");
		
	}
	/**
	 *  @param vehicle - type Vehicle
	 * Looking for the next component in the track (for the sake of building a random track for example) that fits a given vehicle, Checks whether there are active (outbound) ways that allow travel in the given vehicle type
	 *  @return  one Roads found (random). If no suitable path returns null.
	 */
	public RouteParts findNextPart(Vehicle vehicle){
		ArrayList<Road> temp= new ArrayList<Road>();
		for(int i=0;i<this.enteringRoads.size();i++) {
			if(this.exitingRoads.get(i).isEnable())
				temp.add(this.exitingRoads.get(i));
		}
		if(!temp.isEmpty()) 
			return temp.get(this.getRandomInt(0, temp.size()-1));
		return null;
		
	}
	/**
	 *  @param vehicle - type Vehicle
	 * Enabled when the given vehicle cannot move to the next through component in the current pulse. ) Problem priority, Previous Vehicles (. Prints appropriate message.
	 *  @return nothing
	 */
	public void stayOnCurrentPart(Vehicle vehicle){
		System.out.println(vehicle.getStatus());
		
	}

	//================================
	/**Indicates whether some other object is "equal to" this one.
	 * @param obj Object that is compared to this one.
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	@Override		
	public boolean equals(Object other) {

		boolean ans =false;
		if(other instanceof Junction) {
			ans=( this.junctionName==((Junction)other).junctionName   
					&& this.getX() ==((Junction)other).getX() 
					&& this.getY() ==((Junction)other).getY());
			return ans;
		}
		return ans;
	}

	
}
