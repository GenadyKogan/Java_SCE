
public class Number {
	private int num;

	public Number(int num) {
		this.num=num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	public void Digits() 
	{ 
	    int largest = 0; 
	    int smallest = 9; 
	  
	    while(num != 0)  
	    { 
	        int r = num % 10; 
	        largest = Math.max(r, largest); 
	        smallest = Math.min(r, smallest); 
	        num = num / 10; 
	    } 
	    System.out.println("Largest number: "+largest + "\nSmallest number: " + smallest); 
	} 

	
	
	
	
}
