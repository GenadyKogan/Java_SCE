package components;

import java.util.ArrayList;

public class Junction  /*extends Point*/ /*implements RouteParts*/  {
	private int objectsCount=1;
	
	private ArrayList<Road> enteringRoads;
	private ArrayList<Road> exitingRoads;
	private String junctionName;
	//================================
	
	public Junction() {
		this.setJunctionName(String.valueOf(junctionName));
		
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
