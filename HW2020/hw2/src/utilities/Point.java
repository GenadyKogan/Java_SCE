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
		System.out.print("Point (" + getX()+","+getY()+") has been created\n");
	}
	
	public Point() {
		setX(new Random().nextInt(799) + 0 );
		setY(new Random().nextInt(599) + 0);
	}
	
	//============================================
	
	
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

	
	public double getY() {
		return y;
	}
	
	public double getX() {
		return x;
	}

	//============================================
	
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
