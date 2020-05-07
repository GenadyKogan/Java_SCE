package utilities;

import java.util.ArrayList;
import java.util.Random;

public interface Utilities {
	/**
	 * Checks integrity for values ​​that must be at minimum and maximum data limits.
	 * @param Val
	 * @param min
	 * @param max
	 * @return boolean type
	 */
	default boolean checkValue(double Val, double min, double max) {
		if(Val<max && Val>min)
			return true;
		return false;
	}

	/**
	 * Prints a bad value replacement message with a good value. You can see the sample run attached
	 * @param wrongVal
	 * @param correctVal
	 * @param varName
	 */
	default void correctingMessage(double wrongVal, double correctVal, String varName) {
		if(correctVal !=wrongVal)
			System.out.println(varName);
		
	}

	/**
	 * Prints a bad value message
	 * @param wrongVal
	 * @param varName
	 */
	default void errorMessage(double wrongVal, String varName) {
		System.out.println(wrongVal+" is incorrect in "+varName);
		
	}

	/**
	 * Returns a random boolean value
	 * @return  boolean type
	 */
	default boolean getRandomBoolean() {
		boolean [] booleanElem={true,false};
		return booleanElem[ new Random().nextInt(booleanElem.length)];
	}

	/**
	 * 
	 * @param min
	 * @param max
	 * @return random double at the limit of max, m
	 */
	default double getRandomDouble(double min, double max) {
		 double random_double = Math.random() * (max - min + 1) + min; 
		 return random_double;
	}

	/**
	 * 
	 * @param min
	 * @param max
	 * @return random integer at the minimum and maximum limits
	 */
	default int getRandomInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max-min+1) + min;
	}
	/**
	 * 
	 * @param min
	 * @param max
	 * @param arraySize
	 * @return requested list of random integers ranging from minimum to maximum
	 */
	default ArrayList<Integer> getRandomIntArray(int min, int max, int arraySize) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <arraySize; i++) {
            list.add(getRandomInt(min,max));
        }
        return list;
	}
	/**
	 * Prints a message about the successful creation of an object
	 * @param objName
	 */
	default void successMessage(String objName) {
		System.out.println(objName+" as been create");
		
	}
}
