package components;

import java.util.ArrayList;
import java.util.Random;

public class Route  implements RouteParts{


	private ArrayList<RouteParts> RouteParts;


	private Vehicle vehicle;

	public Route(RouteParts start, Vehicle vehicle) {
		this.RouteParts =new ArrayList<RouteParts>();
		this.addRouteParts(start);
	} 
	
	//================================
	//get and set
	public ArrayList<RouteParts> getRouteParts() {
		return RouteParts;
	}

	public void setRouteParts(ArrayList<RouteParts> routeParts) {
		RouteParts =new ArrayList<RouteParts>(routeParts);
	}
	
	public void addRouteParts(RouteParts routeParts) {
		this.addRouteParts(routeParts);
	}	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	//================================
	//metods



	public boolean canLeave(Vehicle vehicle){
		return false;
		
	}
	
	public double calcEstimatedTime(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void checkIn(Vehicle vehicle){

	}
	public void checkout(Vehicle vehicle){

	}
	public RouteParts findNextPart(Vehicle vehicle){
		return null;
		
	}
	public void stayOnCurrentPart(Vehicle vehicle){
		
	}
	
	//================================

	
	

	//methods
	@Override
	public boolean checkValue(double Val, double min, double max) {
		if(Val<max && Val>min)
			return true;
		return false;
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
	public void successMessage(String objName) {
		// TODO Auto-generated method stub
		
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
	public ArrayList<Integer> getRandomIntArray(int min, int max, int arraySize) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <arraySize; i++) {
            list.add(getRandomInt(min,max));
        }
        return list;
	}




}
