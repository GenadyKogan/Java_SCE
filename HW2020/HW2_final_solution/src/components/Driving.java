/**
 * 
 */
package components;

import java.util.ArrayList;

import utilities.Timer;
import utilities.Utilities;

/**Traffic control game
 * @author Sophie Krimberg
 *
 */
public class Driving implements Utilities, Timer{
	private Map map;
	private ArrayList<Vehicle> vehicles;
	private int drivingTime;
	private ArrayList<Timer> allTimedElements;
	
	/**Constructor
	 * @param junctionsNum quantity of junctions
	 * @param numOfVehicles quantity of vehicles
	 */
	public Driving(int junctionsNum, int numOfVehicles) {
		
		vehicles=new ArrayList<Vehicle>();
		allTimedElements=new ArrayList<Timer>();
		drivingTime=0;
		map=new Map(junctionsNum);
		
		System.out.println("\n================= CREATING VEHICLES =================");
		
		while(vehicles.size()<numOfVehicles) {
			Road temp=map.getRoads().get(getRandomInt(0,map.getRoads().size()));//random road from the map
			if( temp.getEnabled())
				vehicles.add(new Vehicle(temp));
		}
		
		allTimedElements.addAll(vehicles);
		
		for (TrafficLights light: map.getLights()) {
			if (light.getTrafficLightsOn()) {
				allTimedElements.add(light);
			}
		}
	}
	
	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map map) {
		this.map = map;
	}

	/**
	 * @return the vehicles
	 */
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * @return the drivingTime
	 */
	public int getDrivingTime() {
		return drivingTime;
	}

	/**
	 * @param drivingTime the drivingTime to set
	 */
	public void setDrivingTime(int drivingTime) {
		this.drivingTime = drivingTime;
	}

	/**
	 * @return the allTimedElements
	 */
	public ArrayList<Timer> getAllTimedElements() {
		return allTimedElements;
	}

	/**
	 * @param allTimedElements the allTimedElements to set
	 */
	public void setAllTimedElements(ArrayList<Timer> allTimedElements) {
		this.allTimedElements = allTimedElements;
	}

	/**method runs the game for given quantity of turns
	 * @param turns
	 */
	public void drive(int turns) {
		System.out.println("\n================= START DRIVING=================");

		drivingTime=0;
		for (int i=0; i<turns;i++) {
			incrementDrivingTime();
		}
	}

	@Override
	public void incrementDrivingTime() {
		System.out.println("\n***************TURN "+drivingTime++ +"***************");
		for(Timer element: allTimedElements) {
			System.out.println(element);
			element.incrementDrivingTime();
			System.out.println();
		}
		
	}

	@Override
	public String toString() {
		return "Driving [map=" + map + ", vehicles=" + vehicles + ", drivingTime=" + drivingTime + ", allTimedElements="
				+ allTimedElements + "]";
	}

}
