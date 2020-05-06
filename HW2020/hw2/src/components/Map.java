package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import utilities.Point;
import utilities.Utilities;

public class Map implements Utilities {
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private ArrayList<TrafficLights> lights;
	
	private Random random = new Random();
	//================================

	public Map (int numOfJunctions) {
		this.junctions=new ArrayList<Junction>();
		this.lights=new ArrayList<TrafficLights>();
		this.roads=new ArrayList<Road>();
		for (int i = 1; i < numOfJunctions+1; i++) {
			boolean isLightedJunction=this.getRandomBoolean();
			if(!isLightedJunction)
				this.junctions.add(new Junction(i+"" , getRandomInt(0,800), getRandomInt(0,600)));
			else
			{
				boolean isSequential=this.getRandomBoolean();
				LightedJunction temp=new LightedJunction();
				this.junctions.add(temp);
				this.lights.add(temp.getTrafficLights());
			}
			
		}

		for(Junction junc:this.junctions)
			System.out.print(""+junc.toString() + " has been created\n");
	
		SetAllRoads();
		init();
	}

	public void  printLight() {
		for(Junction junc : this.junctions) {
			String className = junc.getClass().getSimpleName();
			if(className.equals("LightedJunction")) {
				if(((LightedJunction)junc).getTrafficLights().getTrafficLightsOn()==true) {
					System.out.println(((LightedJunction)junc).getTrafficLights().getClass().getSimpleName()+" traffic lights");
					System.out.println("- on delay");
				}
			}

			
		}
	}
	
	public void init() {

		System.out.println("================= TRAFFIC LIGHTS TURN ON =================");
		int j=0;
		for(int i=0;i<this.junctions.size();i++) {
			String className = this.junctions.get(i).getClass().getSimpleName();
			if(className.equals("LightedJunction")) {
					this.lights.get(j).setLightsOn();
					j+=1;
					
			}
		}
	}
	//================================

	public ArrayList<Junction> getJunctions() {
		return junctions;
	}

	public ArrayList<Road> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<Road> roads) {
		this.roads =new ArrayList<Road>(roads);
	}

	public ArrayList<TrafficLights> getLights() {
		return lights;
	}

	public void setLights(ArrayList<TrafficLights> lights) {
		this.lights = lights;
	}

	public void setJunctions(ArrayList<Junction> junctions) {
		this.junctions = new ArrayList<Junction>(junctions);
	}
	//================================

	public void SetAllRoads() {
		System.out.println("================= CREATING ROADS=================");
		for(Junction start :this.junctions) {
			for(Junction end:this.junctions ) 
				if(start!=end) {
					this.roads.add(new Road(start,end));
				}		
		}
	}
	

	public void turnLightsOn(){
		boolean [] booleanElem={true,false};

		for(Junction junc:this.junctions) {
			boolean lightsOn=booleanElem[ new Random().nextInt(booleanElem.length)];
			String className = junc.getClass().getSimpleName();
			if(className.equals("LightedJunction")) 
				((LightedJunction)junc).getTrafficLights().setTrafficLightsOn(lightsOn);
			System.out.print(""+junc.toString() + " has been created\n");


		}

			

	}
	
}
