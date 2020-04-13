package utilities;

import java.util.Random;

import components.Junction;
import components.Road;
import components.VehicleType;
//***//
public class JunctionTest {

	public static void main(String[] args) {
		testJunction();

	}

public static void testJunction() {
		
		
		Junction arr[]=new Junction[10];
		for (int i=0;i<10;i++) {
			arr[i]=new Junction(new String("" +i),new Point(-1,-1));
			
		}
		
		Road arrR[]=new Road[30];
		for (int i=0;i<arrR.length;i++){
			
			int j=new Random().nextInt(arr.length);
			int k=new Random().nextInt(arr.length);
			if (!arr[j].equals(arr[k])) {
				arrR[i]=new Road(arr[j],arr[k], VehicleType.getRandomVehicleTypes(), false,true);
				System.out.println(arrR[i].toString() + " has been created");
			}
			else i--;
			
		}
		
		for (int i=0;i<arr.length;i++) {
			
			System.out.println(arr[i].toString() + ": EXITING ROADS:");
			System.out.println(arr[0].getExitingRoads().size());
			for (int j=0; j<arr[i].getExitingRoads().size(); j++) {
				System.out.println(arr[i].getExitingRoads().get(j).toString());
			}
			System.out.println(arr[i].toString() + ": ENTERING ROADS:");
			for (int j=0; j<arr[i].getEnteringRoads().size(); j++) {
				System.out.println(arr[i].getEnteringRoads().get(j).toString());
			}
		}
		
		
//		for (int i=0; i<arr.length; i++) {			
//			System.out.println(arr[i].toString() + " LIGHTS CHECK");
//			arr[i].setLightsOn();
//			for (int j=0; j<5;j++) {
//				arr[i].changeLight();
			}
//		}
//		
//		for (int i=0; i<arrR.length;i++) {
//			System.out.println(arrR[i].toString() + ": " + arrR[i].getAllowedVehicle() + " lenth: " + arrR[i].getLength() + " Max Speed: " + arrR[i].getMaxSpeed());
//		}
		
		
//	}
		

}
