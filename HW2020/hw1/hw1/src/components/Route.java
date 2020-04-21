package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Point;

public class Route {
	private ArrayList<Junction> junctions; // list of junctions on the route by the order of movement.
	private ArrayList<Road> roads; // list of roads on the route by the order of movement
	private double delay; //time that will take the vehicle to make this route.
	private VehicleType vehicleType;
	/*******************************************************/
	public Route(ArrayList<Junction> junctions, ArrayList<Road> roads, VehicleType vehicleType) {

		this.junctions = junctions;
		this.roads = roads;
		this.vehicleType = vehicleType;
	}
	



	public Route(Junction start, Junction end, VehicleType vehType) {} // no implemented in this task
	
	/*******************************************************/

	public ArrayList<Junction> getJunctions() {
		return junctions;
	}
	public void setJunctions(ArrayList<Junction> junctions){this.junctions =junctions;}
	

	
	public ArrayList<Road> getRoads() {
		return roads;
	}
	public void setRoads(ArrayList<Road> roads){this.roads = roads;}


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

	@Override		
	public boolean equals(Object other) {
		boolean ans =false;
		if(other instanceof Route) {
			ans=( this.junctions==((Route)other).junctions   &&  this.roads==((Route)other).roads && this.delay ==((Route)other).delay &&  this.vehicleType ==((Route)other).vehicleType);
		}
		return ans;
	}	

	
	/**
	 * @return *****************************************************/
	
	public Junction getStart() {
		if (junctions.size() > 0) {
			return junctions.get(0);
		}else{
			return null;
		}
	}
	
	public Junction getEnd() {
		if (junctions.size() > 0) {
			return junctions.get(this.junctions.size()-1);
		}else{
			return null;
		}
	}
	public void calcDelay() {
		double length=0;
		double speed=0;
		double delay2=0;
		int count=0;
		double res = 0;
		for( int i=0; i< this.roads.size();i++)
		{
			length= this.roads.get(i).countLength();
			speed=Math.min(this.vehicleType.getSpeed(),this.roads.get(i).getMaxSpeed());

			for (int j = 0; j < this.junctions.get(j).getEnteringRoads().size() ; j++)
					count+=1;
			for (int j = 0; j < this.junctions.size() ; j++) 
				delay2=this.junctions.get(j).getDelay()*count;
		}
		for( int i=0; i< this.junctions.size();i++)
		{
			if(this.junctions.get(i).isHasLights()==true)
			{
				res= (length/speed)+delay2;
			}
			else
				res= (length/speed)*this.junctions.get(i).getDelay();
			
		}
		this.delay = res;
		
	}

	
}

