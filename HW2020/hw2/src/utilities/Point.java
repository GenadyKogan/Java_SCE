package utilities;
import java.util.Random;
public abstract class Point implements Utilities {
	public static final int maxX = 800;
	//public static final int MIN_X = 0;
	public static final int maxY = 600;
	//public static final int MIN_Y = 0;
	public static final int minVal=0;
	
	private double x;
	private double y;
	
	/**Constructor
	 * creates point with given values
	 * if given values are illegal replaces them with random generated values
	 * @param xVal
	 * @param yVal
	 */

	public Point(double x, double y) {
		if(x<minVal||x>maxX) {
			this.x=Math.random()*maxX;
			System.out.print("The value "+x+" is illegal for X, therefore has been replaced with "+this.x+"\n");
		}
		if(y<minVal||y>maxY) {
			this.y=Math.random()*maxY;
			System.out.print("The value "+y+" is illegal for Y, therefore has been replaced with "+this.y+"\n");
		}
			else{
			setX(x);
			setY(y);
		}

	}
	/**Constructor
	 * creates random Point object
	 */

	public Point() {
		setX(new Random().nextInt(799) + 0 );
		setY(new Random().nextInt(599) + 0);
	}
	
	//============================================
	
	/**Sets given value to x
	 * 
	 * @param xVal given value
	 * @return true if value is legal and has been set successfully
	 */

	boolean setX(double x) {
		if(x<minVal||x>maxX) {
			System.out.print("The value "+x+" is illegal for X\n");
			return false;
		}
		else {
			this.x = x;
			return true;
		}
		
	}
	
	/**Sets given value to y
	 * 
	 * @param yVal given value
	 * @return true if value is legal and has been set successfully
	 */

	boolean setY(double y) {
		if(y<minVal||y>maxX) {
			System.out.print("The value "+y+" is illegal for Y\n");
			return false;
		}
		else {
		this.y = y;
		return true;
		}
	}

	/**Get x value
	 * 
	 * @return double x
	 */

	public double getY() {
		return y;
	}
	  
	/**Get x value
	 * 
	 * @return double x
	 */

	public double getX() {
		return x;
	}

	//============================================
	/**
	 * 
	 * @param other - type Point
	 * @return a distance between the current point and the point obtained as an argument
	 */
	public double calcDistance(Point other) {
		if (other instanceof Point) {
			double xPoint=this.getX()-other.getX() ;
			double yPoint=this.getY()-other.getY();
			double dist =Math.sqrt(xPoint*xPoint + yPoint*yPoint);
			return dist;
		}
		return 0;
	}
	
}
