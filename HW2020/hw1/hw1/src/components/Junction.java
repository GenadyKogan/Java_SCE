package components;
import java.util.ArrayList;
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
	public Junction (String name, Point loc) {
		this.setJunctionName(name);
		this.setLocation(loc);
		id=++counter;
		System.out.print("Junction "+id+" has been created\n");
		this.setEnteringRoads(new ArrayList<Road>());
		this.setVehicles(new ArrayList<Road>());
		this.setExitingRoads(new ArrayList<Road>());
	}

	/*******************************************************/
	/*****geters and seters ****/
	public String getJunctionName() {
		return junctionName;
	}
	
	public void setJunctionName(String junctionName) {
		this.junctionName = junctionName;
	}
	
	public Point getLocation() {
		return location;
	}
	
	public boolean setLocation(Point location) {
		boolean ans=false;
		if(location instanceof Point) {
			this.location=new Point(location);
			ans=true;
		}
		return ans;
	}
	
	public boolean isHasLights() {
		return hasLights;
	}
	
	public void setHasLights(boolean hasLights) {
		this.hasLights = hasLights;
	}
	
	public int getDelay() {
		return delay;
	}
	
	public void setDelay(int delay) {
			this.delay = delay;
	}
	
	public ArrayList<Road> getEnteringRoads() {
		return enteringRoads;
	}
	
	public boolean setEnteringRoads(ArrayList<Road> enteringRoads) {
		boolean ans=false;
		if(enteringRoads instanceof ArrayList) {
			enteringRoads=new ArrayList<Road>();
			this.enteringRoads =enteringRoads;
			ans=true;
		}
		return ans;	
	}
	
	public void addEnterRoad(Road roadEnterRoad) { // using for a road
		this.enteringRoads.add (roadEnterRoad);
	}
	
	public ArrayList<Road> getVehicles() {
		return vehicles;
	}
	
	public boolean setVehicles(ArrayList<Road> vehicles) {
		boolean ans=false;
		if(vehicles instanceof ArrayList) {
			vehicles =new ArrayList<Road>();
			this.vehicles=vehicles;
			ans=true;
		}
		return ans;	
	}
	
	public ArrayList<Road> getExitingRoads() {
		return exitingRoads;
	}
	
	public boolean setExitingRoads(ArrayList<Road> exitingRoads) {
		
		boolean ans=false;
		if(exitingRoads instanceof ArrayList) {
			exitingRoads =new ArrayList<Road>();
			this.exitingRoads=exitingRoads;
			ans=true;
		}
		return ans;
	}
	
	
	public void addExitRoad(Road roadExitRoad) { //using for a road
		this.exitingRoads.add (roadExitRoad);
	}
	/*******************************************************/

	@Override
	public String toString() {
		return  junctionName ;
	}

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
	public void changeLight() {
			int flag=0;
			if (isHasLights()==true) {
			for(int i=0;i<this.enteringRoads.size();i++) {
				//for (Road element : getEnteringRoads()) { 
				if (this.enteringRoads.get(i).isOpen()) { 
					    flag+=1;
					    break; 
					}  
		        } 
		        for (Road element : getEnteringRoads()) 
		            element.setOpen(false);
			} 
			flag+=1;
			getEnteringRoads().get(flag).setOpen(true);
	}
	

	public boolean checkAvailability (Road r) {
		if (this.vehicles.get(0).equals(r)) {
			return true;
		}
		return false;
	}

}

