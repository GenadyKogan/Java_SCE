package components;

import java.util.ArrayList;
import java.util.Random;

public class Junction  /*extends Point*/ /*implements RouteParts*/  {
	private int objectsCount=1;
	
	private ArrayList<Road> enteringRoads;
	private ArrayList<Road> exitingRoads;
	private String junctionName;
	//================================
	
	public Junction() {
		//this();
		//this.setJunctionName(String.valueOf(junctionName));
		//setX(new Random().nextInt(799) + 0 );
		//setY(new Random().nextInt(599) + 0);
		
	}
	
	public Junction(String junctionName, double x, double y) {
		this.setJunctionName(junctionName);
		
	}
	
	//================================
	
	public int getObjectsCount() {
		return objectsCount;
	}



	public String getJunctionName() {
		return junctionName;
	}
	public void setJunctionName(String junctionName) {
		this.junctionName = junctionName;
	}
	
	
}
