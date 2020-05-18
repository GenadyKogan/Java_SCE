/**
 * 
 */
package utilities;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author Sophie Krimberg
 *
 */
public interface Utilities {
	public default void errorMessage(double wrongVal, String variable) {
		
		System.out.print("The value " + wrongVal + " is illegal for" +variable );
	}
	
	public default void correctingMessage(double wrongVal, double correct, String variable) {
		errorMessage(wrongVal, variable);
		System.out.println(", therefore has been replaced with " + correct);
	}
	
	public default void successMessage(String objName) {
		System.out.println(objName + " has been created.");
	}
	
	public default double getRandomDouble(double minimum, double maximum){
		return  Math.random()*((maximum-minimum)+1)-minimum;
		
	}
	
	public default boolean getRandomBoolean() {
		return new Random().nextBoolean();
	}
	
	
	public default int getRandomInt(int minimum, int maximum) {
		return new Random().nextInt(maximum-minimum)+minimum;
		
	}
	public default boolean checkValue(double val, double min, double max) {
		if (val<min || val>max) 
			return false;
		else
			return true;
	}
	
	public default ArrayList<Integer> getRandomIntArray(int minimum, int maximum, int maxSize){
		ArrayList<Integer> arr=new ArrayList<Integer>();
		while (arr.size()<maxSize) {
			Integer i=getRandomInt(minimum, maximum);
			if (!arr.contains(i)) {
				arr.add(i);
			}
		}
		return arr;
	}

}
