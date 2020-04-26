package utilities;

import java.util.ArrayList;

public interface Utilities {
	 boolean checkValue(double Val, double min, double max);
	 void correctingMessage(double wrongVal, double correctVal, String varName);
	 void errorMessage(double wrongVal, String varName);
	 boolean getRandomBoolean();
	 boolean getRandomDouble(double min, double max);
	 double  getRandomInt(int min, int max);
	 ArrayList<Integer> getRandomIntArray(int min, int max, int arraySize);
	 void successMessage(String  objName); 
	
	
}
