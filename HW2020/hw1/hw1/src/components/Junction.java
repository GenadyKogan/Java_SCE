package components;
import java.util.ArrayList;
import java.util.Random;

import utilities.Point;
/**/
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
		System.out.println("Point ("+ loc.getX()+","+loc.getY() +") has been created");
		System.out.print("Junction "+id+" has been created\n");
		enteringRoads = new ArrayList<Road>();
		exitingRoads = new ArrayList<Road>();
		this.setVehicles(new ArrayList<Road>());

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
			this.enteringRoads=new ArrayList<Road>(enteringRoads);
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
			this.vehicles=new ArrayList<Road>(vehicles);
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
			this.exitingRoads=new ArrayList<Road>(exitingRoads);
			ans=true;
		}
		return ans;
	}


	
	public void initvehicles() {
		int i=(new Random().nextInt(200) + 1 );
		this.vehicles =new ArrayList<Road>();
		this.vehicles.add(new Road(new Junction(""+i , new Point(1.2*i,  1.3*1)),new Junction(""+i*1.4 , new Point(1.2*i, 3.2*i))));
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
	public boolean checkAvailability (Road r) {
		for(Road road: vehicles) {
			if(road.equals(r)) {
				return true;
			}
		}
		return false;
	}
	public void setLightsOn() {
		this.setDelay(this.enteringRoads.size());
		System.out.println("Junction "+junctionName+" : traffic lights ON. Delay time: "+this.delay);
		this.setHasLights(true);
		this.changeLight();

	}

	


}


