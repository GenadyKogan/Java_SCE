
public class Address {
	private String street;
	private int houseNember;
	private String city;
//============================================================================
	public   Address(String street,int houseNember,String city) {
		setCity(city);
		setHouseNember(houseNember);
		setStreet(street);
	}
	public   Address(Address other) {
		this(other.street,other.houseNember,other.city);
	}
//============================================================================
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getHouseNember() {
		return houseNember;
	}
	public void setHouseNember(int houseNember) {
		this.houseNember = houseNember;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
//============================================================================
	public String toString() {
		return street + " "+houseNember +", "+ city;
		}
}
