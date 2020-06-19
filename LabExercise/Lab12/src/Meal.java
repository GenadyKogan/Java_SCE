import java.util.ArrayList;
import java.util.List;

public class Meal {
	private List<Item> items =new ArrayList<Item>();
	public void addItem(Item item) {
		items.add(item);
	}
	public float getCost() {
		return CostBridge.getCost(items);
	}
	 public void showItems(){
	      for (Item item : items) {
	         System.out.print("\tItem : "+item.name());
	         System.out.println(", Price : "+item.price());
	      }		
	   }	
}
