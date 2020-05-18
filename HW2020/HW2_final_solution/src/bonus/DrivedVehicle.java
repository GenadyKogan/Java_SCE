/**
 * 
 */
package bonus;

import components.Road;

/**represents a vehicle with driver (pay attention to the move method)
 * @author Sophie Krimberg
 *
 */
public class DrivedVehicle extends components.Vehicle {
	Driver driver;
	
	/**Constructor, creates a vehicle with random type of driver
	 * @param road
	 */
	public DrivedVehicle (Road road) {
		super(road);
		if (getRandomBoolean()) {//half of drivers are regular
			if (getRandomBoolean()) { //half of non regular drivers are criminal and half are new drivers
				this.driver=new CriminalDriver();
			}
			else this.driver=new NewDriver();
		}
		else this.driver=new Driver();
		
	}
	
	@Override 
	public void move() {
			if (driver.canLeave(this)) {
				this.getCurrentRoutePart().checkOut(this);
				this.getCurrentRoute().findNextPart(this).checkIn(this);
			}
			else {
				driver.stayOnCurrentPart(this);
				
			}
	}
	
	@Override
	public String toString() {
		if (driver!=null)
			return  new String(""+ super.toString()+" "+ driver);
		else return super.toString();
	}

	/**
	 * @return the driver
	 */
	public Driver getDriver() {
		return driver;
	}

	/**
	 * @param driver the driver to set
	 */
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}
