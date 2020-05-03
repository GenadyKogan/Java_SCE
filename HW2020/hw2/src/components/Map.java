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
		//init();
	}

	
	
	private void init() {

	/*	for(Junction junc : this.junctions) {
			String className = junc.getClass().getSimpleName();
			if(className.equals("Junction")) {
				System.out.println("true");
			}

			System.out.println(className);
		}*/

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
		this.lights=new ArrayList<TrafficLights>();
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
	
	//================================




	@Override
	public boolean checkValue(double Val, double min, double max) {
		if(Val<max && Val>min)
			return true;
		return false;
	}
	@Override
	public void correctingMessage(double wrongVal, double correctVal, String varName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void errorMessage(double wrongVal, String varName) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean getRandomBoolean() {
		boolean [] booleanElem={true,false};
		return booleanElem[ new Random().nextInt(booleanElem.length)];
	}
	@Override
	public double getRandomDouble(double min, double max) {
		 double random_double = Math.random() * (max - min + 1) + min; 
		 return random_double;
	}


	@Override
	public int getRandomInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max-min+1) + min;
	}
	@Override
	public ArrayList<Integer> getRandomIntArray(int min, int max, int arraySize) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <arraySize; i++) {
            list.add(getRandomInt(min,max));
        }
        return list;
	}
	@Override
	public void successMessage(String objName) {
		// TODO Auto-generated method stub
		
	}
	public void setTrafficLightsOn(boolean trafficLightsOn) {
	}
}
