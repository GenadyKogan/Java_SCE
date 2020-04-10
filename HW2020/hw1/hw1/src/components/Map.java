package components;
import java.util.ArrayList;

public class Map {
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	
	
	/*public Map() {
		super();
	}
	
	public Map (int junctions, int roads) {
		
	}
	*/
	public Map(ArrayList<Junction> juncs, ArrayList<Road> roads) {
		this.setJunctions(juncs);
		this.setRoads(roads);
	}
	
	public Map (ArrayList<Junction> juncs) {
		this.setJunctions(juncs);
	}
	
	public Map(Map other) {
		if(other!=null) {
			this.setJunctions(other.junctions);
			this.setRoads(other.roads);

		}
	}

	/*******************************************************/

	public ArrayList<Junction> getJunctions() {
		return junctions;
	}

	public boolean setJunctions(ArrayList<Junction> junctions) {
		boolean ans=false;
		if(junctions instanceof ArrayList) {
			junctions=new ArrayList<Junction>();
			this.junctions = junctions;
			ans=true;
		}
		return ans;
	}

	public ArrayList<Road> getRoads() {
		return roads;
	}

	public boolean setRoads(ArrayList<Road> roads) {
		boolean ans=false;
		if(roads instanceof ArrayList) {
			roads=new ArrayList<Road>();
			this.roads =roads;
			ans=true;
		}
		return ans;
	}
	/*******************************************************/
	public boolean addRoad(Road r) {
		boolean ans=false;
		if(r!=null) {
	        for (Road element : getRoads()) { 
	            if (element == r) { 
	            	ans = true; 
	                break; 
	            } 
	        } 			
			if(ans==false) {
				this.roads.add(r);
			}
		}
		return ans;
	}
	
	public void removeRoad(Road r) {
		boolean ans=false;
		if(r!=null) {
	        for (Road element : getRoads()) { 
	            if (element == r) { 
	            	ans = true; 
	                break; 
	            } 
	        } 
			if(ans==true)
				this.junctions.remove(r);
			
		}
		
	}

	
	public boolean addJunction(Junction junc) {
		boolean ans=false;
		if(junc!=null) {
	        for (Junction element : getJunctions()) { 
	            if (element == junc) { 
	            	ans = true; 
	                break; 
	            } 
	        } 			
			if(ans==false) {
				this.junctions.add(junc);
			}
		}
		return ans;
	}
	
	//removes the junction and all connected to it roads from the map.
	public void removeJunction(Junction junc) {
		
	}
	

}
