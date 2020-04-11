/**
 * 
 */
package utilities;

import java.util.ArrayList;

import components.VehicleType;

/**
 * @author krsof
 *
 */
public class VehicleTypeTest {

	/**
	 * @param args
	 */
	
	public static ArrayList <VehicleType> vehicleTypes= new ArrayList<VehicleType>();
	
	
	public static void main(String[] args) {
		setVehicleTypes();
		testTypes();

	}
	
private static void setVehicleTypes() {
		
		vehicleTypes.add( new VehicleType("car",90));
		vehicleTypes.add( new VehicleType("bus",60));
		vehicleTypes.add( new VehicleType("bicycle",40));
		vehicleTypes.add( new VehicleType("motorcycle",120));
		vehicleTypes.add( new VehicleType("truck",80));
		vehicleTypes.add( new VehicleType("tram",50));
		vehicleTypes.add( new VehicleType("semitrailer",80));
			
	}
	
	public static void testTypes() {
		VehicleType[] arr= new VehicleType[7];
	
		arr[0]=new VehicleType("car",90);
		arr[1]=new VehicleType("bus",60);
		arr[2]=new VehicleType("bicycle",40);
		arr[3]=new VehicleType("motorcycle",120);
		arr[4]=new VehicleType("truck",80);
		arr[5]=new VehicleType("tram",50);
		arr[6]=new VehicleType("car",90);
	
		for (int i=0; i<7;i++) {
		
		System.out.println(arr[i].toString() + " equals to " + arr[0].toString() + ": " + arr[i].equals(arr[0]));
		
		}
		
		System.out.println(arr[6].getName());
		System.out.println(arr[5].getSpeed());
		System.out.println(arr[0].getRandomVehicleTypes());
		System.out.println(arr[0].getRandomVehicleTypes());
		System.out.println(VehicleType.getRandomVehicleTypes());
		
		
} 


}
