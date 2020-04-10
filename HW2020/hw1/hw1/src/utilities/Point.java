package utilities;

/**
 * A representation of a cartesian point
 */
public class Point {

	public static final int MAX_X = 1000000;
	public static final int MIN_X = 0;
	public static final int MAX_Y = 800;
	public static final int MIN_Y = 0;

	private double x;
	private double y;

	/**
	 * Default Ctor for a point sets x and y to be 0.
	 */
	

	/**
	 * Ctor for a point
	 * @param x x position
	 * @param y y position
	 */
	public Point(double x, double y) {
		if(x<MIN_X||x>MAX_X) {
			this.x=Math.random()*MAX_X;
			System.out.print("The value "+x+" is illegal for X, therefore has been replaced with "+this.x+"\n");
		}
		if(y<MIN_Y||y>MAX_Y) {
			this.y=Math.random()*MAX_Y;
			System.out.print("The value "+y+" is illegal for Y, therefore has been replaced with "+this.y+"\n");
		}
			else{
			setX(x);
			setY(y);
		}
		System.out.print("Point (" + getX()+","+getY()+") has been created\n");
	}

	/**
	 * Copy Ctor
	 * @param other other instance
	 * @throws IllegalArgumentException if other instance is null
	 */
	public Point(Point other){
		this.setX(other.x);
		this.setY(other.y);
	}

	//region Setters

	/**
	 * @param x the x position of the point
	 * @throws IllegalArgumentException if x is out of range [{@value MIN_X},{@value MAX_X}]
	 */
	boolean setX(double x) {
		if(x<MIN_X||x>MAX_X) {
			System.out.print("The value "+x+" is illegal for X\n");
			return false;
		}
		else {
			this.x = x;
			return true;
		}
		
	}
	/**
	 * @param y the y position of the point
	 * @throws IllegalArgumentException if y is out of range [{@value MIN_Y},{@value MAX_Y}]
	 */
	boolean setY(double y) {
		if(y<MIN_Y||y>MAX_Y) {
			System.out.print("The value "+y+" is illegal for Y\n");
			return false;
		}
		else {
		this.y = y;
		return true;
		}
	}
	//endregion

	//region Getters

	/**
	 * @return the x value of the point
	 */
	public double getX() {
		return x;
	}

	/*
	  @return the y value of the point
	 */
	public double getY() {
		return y;
	}
	//endregion
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")\n";
	}
	public boolean equals(Object other) {
		boolean ans=false;
		if(other instanceof Point) {
			ans=( getX() ==((Point)other).getX() &&  getY() ==((Point)other).getY());
			return ans;
		}
		return false;
		
	}
	/**
	 * offset from the current point
	 * @param xOffset offset at the x axis
	 * @param yOffset offset at the y axis
	 * @return a new clone of the current point with an x and y offset
	 */
	public Point offset(double xOffset, double yOffset){
		return new Point(this.x+xOffset, this.y+yOffset);
	}

	
}
