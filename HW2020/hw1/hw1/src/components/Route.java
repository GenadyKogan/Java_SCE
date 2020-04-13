package components;

import java.util.ArrayList;

public class Route {
	private ArrayList<Junction> junctions; // list of junctions on the route by the order of movement.
	private ArrayList<Road> roads; // list of roads on the route by the order of movement
	private double delay; //time that will take the vehicle to make this route.
	private VehicleType vehicleType;
	/*******************************************************/
	public Route(ArrayList<Junction> junctions, ArrayList<Road> roads, VehicleType vehicleType) {
		this.setJunctions(junctions);
		this.setRoads(roads);
		this.setVehicleType(vehicleType);
	}
	
	
	public Route(Junction start, Junction end, VehicleType vehType) {} // no implemented in this task
	
	/*******************************************************/

	public ArrayList<Junction> getJunctions() {
		return junctions;
	}
	

	public boolean setJunctions(ArrayList<Junction> junctions) {
		boolean ans=false;
		if(junctions instanceof ArrayList) {
			junctions=new ArrayList<Junction>();
			this.junctions =junctions;
			ans=true;
		}
		return ans;	
	}
	
	public ArrayList<Road> getRoads() {
		return roads;
	}
	
	public void setRoads(ArrayList<Road> roads) {
		boolean ans=false;
		if(roads instanceof ArrayList) {
			roads=new ArrayList<Road>();
			this.roads =roads;
			ans=true;
		}
	}
	public double getDelay() {
		return delay;
	}
	public void setDelay(double delay) {
		this.delay = delay;
	}
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	/*******************************************************/

	/*@Override
	public String toString() {
		return "Route [junctions=" + junctions + ", roads=" + roads + ", delay=" + delay + ", vehicleType="
				+ vehicleType + "]";
	}*/

	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Route) {
			ans=( this.junctions==((Route)other).junctions   &&  this.roads==((Route)other).roads && this.delay ==((Route)other).delay &&  this.vehicleType ==((Route)other).vehicleType);
		}
		return ans;
	}	

	
	/*******************************************************/
	
/*	public junctions getStart() {
	}
	
	public junctions getEnd() {
		
	}
	calcDelay()
	*/ 
}
