
public class SingleObject {
	private static SingleObject instance=new SingleObject();
	private SingleObject() {}
	public static SingleObject getIstanse() {
		return instance;
	}
	public void showMessage() {
		System.out.println("Singlton");
	}
}
