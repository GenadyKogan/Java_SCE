/**
 * 
 */
package Test;

import components.Junction;
import components.LightedJunction;
import components.Road;
import components.Vehicle;

/**
 * @author krsof
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Junction a=new Junction();
		Junction b=new Junction();
//		Junction 1 (196,16 , 225,33) has been created.
//		Junction 2 (426,37 , 513,44) has been created.
		Road ab=new Road(a,b);
//		Road from Junction 1 to Junction 2, length: 115, max speed 70 has been created.
		a=new Junction("a",12,8);
		b=new Junction("b", 2,3);
		ab=new Road(a,b);
//		Junction a (12,00 , 8,00) has been created.
//		Junction null has been created.
//		Junction b (2,00 , 3,00) has been created.
//		Road from Junction a to Junction b, length: 11, max speed 55 has been created.
		Junction c=new Junction();
		Road cb=new Road(c,b);
//		Junction 5 (434,58 , 18,27) has been created.
//		Road from Junction 5 to Junction b, length: 432, max speed 30 has been created.
		c=new Junction("c", 215, 45);
		cb=new Road(c,b);
		Road bc=new Road(b,c);
//		Junction c (215,00 , 45,00) has been created.
//		Road from Junction c to Junction b, length: 217, max speed 40 has been created.
//		Road from Junction b to Junction c, length: 217, max speed 50 has been created.
		System.out.println(b.getEnteringRoads());
//		[Road from Junction a to Junction b, length: 11, max speed 50, Road from Junction 5 to Junction b, length: 351, max speed 30, Road from Junction c to Junction b, length: 217, max speed 50]
		System.out.println(b.getExitingRoads());
//		[Road from Junction b to Junction c, length: 217, max speed 80]
		System.out.println(b.calcDistance(b));
//		0.0
		System.out.println(b.calcDistance(a));
//		11.180339887498949
		Vehicle car=new Vehicle(ab);
//		Vehicle 1: semitrailer, average speed: 85 has been created.
//		- is starting a new Route from Road from Junction a to Junction b, length: 11, max speed 80 to Junction b, estimated time for route: 0.0.
//		- is starting to move on Road from Junction a to Junction b, length: 11, max speed 80, time to finish: 0.0.
		b.checkIn(car);
//		- has arrived to Junction b
//		- has finished the Route from Road from Junction a to Junction b, length: 11, max speed 70 to Junction b, estimated time for route: 1.0. Time spent on the route: 0
//		- is starting a new Route from Road from Junction a to Junction b, length: 11, max speed 70 to Junction b, estimated time for route: 1.0.
//		- is starting to move on Road from Junction a to Junction b, length: 11, max speed 70, time to finish: 0.0.
		Vehicle vehicle=new Vehicle(ab);
//		Vehicle 2: truck, average speed: 80 has been created.
//		- is starting a new Route from Road from Junction a to Junction b, length: 11, max speed 80 to Junction c, estimated time for route: 3.0.
//		- is starting to move on Road from Junction a to Junction b, length: 11, max speed 80, time to finish: 0.0.
		b.checkOut(car);
//		- has left the Junction b.
		System.out.println(b.calcEstimatedTime(car));
//		1.0
		System.out.println(ab.calcEstimatedTime(car));
//		0.0
		Junction d=new Junction("d",805,800);
//		The value 805.0 is illegal forX, therefore has been replaced with 427.83565488745563
//		The value 800.0 is illegal forY, therefore has been replaced with 494.64410189932477
//		Junction d (427,84 , 494,64) has been created.
		System.out.println(b.checkAvailability(car));
		System.out.println(b.canLeave(car));
		System.out.println(b.equals(c));
		d=new Junction("b",2,3);
		System.out.println(b.equals(d));
//		true
//		true
//		false
//		Junction b (2,00 , 3,00) has been created.
//		true	
		d=new LightedJunction ("b",2,3, true, true);
//		Sequential traffic lights 1Lights can not be turned on at junction with no entering roads
//		Junction b  (2,00 , 3,00), Lighted has been created.
		System.out.println(b.equals(d));
		System.out.println(d.equals(b));
		LightedJunction e=(LightedJunction)d;
		System.out.println(b.equals(e));
		System.out.println(e.equals(b));
//		true
//		true
//		true
//		true
		Road cd=new Road(c,d);
		Road bd=new Road(b,d);
		e.getLights().setTrafficLightsOn(true);
//		Road from Junction c to Junction b (Lighted), length: 217, max speed 40 has been created.
//		Road from Junction b to Junction b (Lighted), length: 0, max speed 70 has been created.
//		Sequential traffic lights 1 turned ON, delay time: 5
//		- Road from Junction c to Junction b (Lighted), length: 217, max speed 40: green light.
		e.getLights().changeLights();
//		- Road from Junction b to Junction b (Lighted), length: 0, max speed 55: green light.
		e.getLights().changeLights();
//		- Road from Junction c to Junction b (Lighted), length: 217, max speed 40: green light.
		System.out.println(c.findNextPart(vehicle));
//		Road from Junction c to Junction b, length: 217, max speed 70
		
	}
	
	

}
