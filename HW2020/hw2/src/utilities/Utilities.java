package utilities;

public interface Utilities {
	public boolean checkValue(double Val, double min, double max);
	public void correctingMessage(double wrongVal, double correctVal, String varName);
	public void errorMessage(double wrongVal, String varName);
	public boolean getRandomBoolean();
	public boolean getRandomDouble(double min, double max);
}
