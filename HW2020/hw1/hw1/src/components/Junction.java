package components;
import java.util.ArrayList;
import java.util.Random;
import utilities.Point;

public class Junction {
	private String junctionName;
	private Point location; //location of the junction on the map
	private boolean hasLights; // checks if the junction has traffic lights. 
	private int delay; // delay time in seconds
	private ArrayList<Road> enteringRoads; // holds the list of the roads that enter to the junction.
	private ArrayList<Road> vehicles;//list of entering roads with cars waiting on he junction
	private ArrayList<Road> exitingRoads; // holds the list of the roads that exit	the junction.
	private int id=0;
	private static int counter=-1;
	/*******************************************************/
	
	
	/**
	 * Ctor for a Junction
	 * @param name - Type String
	 * @param loc - Type Point
	 */
	
	public Junction (String name, Point loc) {
		this.setJunctionName(name);
		this.setLocation(loc);
		id=++counter;
		System.out.println("Point ("+ loc.getX()+","+loc.getY() +") has been created");
		System.out.print("Junction "+id+" has been created\n");
		enteringRoads = new ArrayList<Road>();
		exitingRoads = new ArrayList<Road>();
		this.setVehicles(new ArrayList<Road>());

	}

	/*******************************************************/
	/*****geters and seters ****/
	
	/**
	 * @param No parameters
	 * @return junctionName - Type Junction
	 */

	public String getJunctionName() {
		return junctionName;
	}
	
	
	/**
	 * @param junctionName - Type String
	 * @return nothing - Initializes an junctionName 
	 */	

	public void setJunctionName(String junctionName) {
		this.junctionName = junctionName;
	}
	
	/**
	 * @param No parameters
	 * @return location - Type Point
	 */
	public Point getLocation() {
		return location;
	}
	
	/**
	 * @param location - Type Point
	 * @return nothing - Initializes an location 
	 */	
	public void setLocation(Point location) {
			this.location=new Point(location);
	}
	
	/**
	 * @param No parameters
	 * @return hasLights - Type boolean
	 */
	public boolean isHasLights() {
		return hasLights;
	}
	
	/**
	 * @param hasLights - Type boolean
	 * @return nothing - Initializes an hasLights 
	 */	
	public void setHasLights(boolean hasLights) {
		this.hasLights = hasLights;
	}
	
	/**
	 * @param No parameters
	 * @return delay - Type int
	 */
	public int getDelay() {
		return delay;
	}
	
	/**
	 * @param delay - Type int
	 * @return nothing - Initializes an delay 
	 */	
	public void setDelay(int delay) {
			this.delay = delay;
	}
	
	/**
	 * @param No parameters
	 * @return enteringRoads - Type ArrayList<Road
	 */
	public ArrayList<Road> getEnteringRoads() {
		return enteringRoads;
	}
	
	/**
	 * @param enteringRoads - Type ArrayList<Road> 
	 * @return nothing - Initializes an enteringRoads 
	 */	
	public void setEnteringRoads(ArrayList<Road> enteringRoads) {
			this.enteringRoads=new ArrayList<Road>(enteringRoads);

	}
	/**
	 * @param roadEnterRoad - Type Road 
	 * @return nothing - add an roadEnterRoad 
	 */	
	public void addEnterRoad(Road roadEnterRoad) { 
		this.enteringRoads.add (roadEnterRoad);
	}
	
	/**
	 * @param No parameters
	 * @return vehicles - Type ArrayList<Road>
	 */
	public ArrayList<Road> getVehicles() {
		return vehicles;
	}
	
	/**
	 * @param vehicles - Type ArrayList<Road> 
	 * @return nothing - Initializes an vehicles 
	 */	
	public boolean setVehicles(ArrayList<Road> vehicles) {
		boolean ans=false;
		if(vehicles instanceof ArrayList) {
			this.vehicles=new ArrayList<Road>(vehicles);
			ans=true;
		}
		return ans;	
	}
	/**
	 * @param No parameters
	 * @return exitingRoads - Type ArrayList<Road
	 */
	public ArrayList<Road> getExitingRoads() {
		return exitingRoads;
	}
	
	/**
	 * @param exitingRoads - Type ArrayList<Road> 
	 * @return nothing - Initializes an exitingRoads 
	 */	
	public boolean setExitingRoads(ArrayList<Road> exitingRoads) {
		boolean ans=false;
		if(exitingRoads instanceof ArrayList) {
			this.exitingRoads=new ArrayList<Road>(exitingRoads);
			ans=true;
		}
		return ans;
	}
	/**
	 * @param roadExitRoad - Type Road 
	 * @return nothing - add an roadExitRoad 
	 */	
	public void addExitRoad(Road roadExitRoad) { //using for a road
		this.exitingRoads.add (roadExitRoad);
	
	}
	


	/*******************************************************/
	/**
	 * @param No parameters
	 * @return String - Print the data for a junctionName
	 */

	@Override
	public String toString() {
		return  junctionName ;
	}

	/**
	 * @param other - Object type
	 * @return Boolean value - true or false
	 */	

	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Junction) {
			ans=( this.junctionName==((Junction)other).junctionName   &&  this.hasLights==((Junction)other).hasLights 
					&& this.hasLights ==((Junction)other).hasLights &&  this.delay ==((Junction)other).delay
					&& this.enteringRoads ==((Junction)other).enteringRoads && this.vehicles ==((Junction)other).vehicles 
					&& this.exitingRoads ==((Junction)other).exitingRoads);
			return ans;
		}
		return ans;
	}	
	
	/*******************************************************/
	/**
	 * @param nothing 
	 * @return nothing - make the next entering road in the list green (open) and all the others (exiting only) red (closed).
	 */	
	public void changeLight() {
		int flag=0;
		if(isHasLights()==true) {
			if(this.enteringRoads.size()>0)
			{
				if(this.delay>=0) {
					for(int i=0;i<this.enteringRoads.size();i++) 
					{
						this.delay-=1;
						System.out.println( this.getEnteringRoads().get(i).toString()+": green light");
					}
				}
				for(int i=0;i<this.enteringRoads.size();i++) {
					if (this.enteringRoads.get(i).isOpen()) { 
							   flag+=1;
							   break; 
					}  
				} 
				for (Road element : getEnteringRoads()) 
				    element.setOpen(false);
				getEnteringRoads().get(flag+1).setOpen(true);
			}
			else
				System.out.println( "No entiring roads in this junction");
		}
		else
			System.out.println( "This junction dos not have lights");
	}
	
	/**
	 * @param r - Road type
	 * @return Boolean value - true or false
	 * for vehicle that arrived to the junction from road r, checks if there are some other vehicles on the roads with a higher traffic priority on the junction. 
	 */	
	public boolean checkAvailability (Road r) {
		for(Road road: vehicles) {
			if(road.equals(r)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param exitingRoads - Type ArrayList<Road> 
	 * @return nothing - Initializes an hasLights 
	 */	
	public void setLightsOn() {
		this.setDelay(this.enteringRoads.size());
		System.out.println("Junction "+junctionName+" : traffic lights ON. Delay time: "+this.delay);
		this.setHasLights(true);
		this.changeLight();

	}

	


}


