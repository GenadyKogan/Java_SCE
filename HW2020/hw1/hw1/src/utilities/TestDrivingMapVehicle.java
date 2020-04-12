/**
 * 
 */
package utilities;

import components.Junction;
import components.Map;
import game.Driving;

/**
 * @author krsof
 *
 */
public class TestDrivingMapVehicle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*jjj*/
		Map map=new Map(5);
		map.addJunction(new Junction("Test", new Point(-1,-1)));
		System.out.println(map.getJunctions());
		map.removeJunction(map.getJunctions().get(5));
		System.out.println(map.getJunctions());
		
	/*	Driving d=new Driving(5,4,20);
		System.out.println(d.getVehicles());*/
	/*	d.addVehicles();
		System.out.println(d.getVehicles());
		System.out.println();
		
		for(int i=0;i<d.getVehicles().size();i++) {
			d.getVehicles().get(i).move();
		}*/
	}

}
