package threads.priority;


public class PriThr
{
	public static void main(String args[])
	{
		MyPriThread t1 = new MyPriThread ("t1");
		MyPriThread t2 = new MyPriThread ("t2");

		Thread t11 = new Thread(t1);
		Thread t22 = new Thread(t2);

		t11.setPriority(Thread.MAX_PRIORITY);
		t22.setPriority(Thread.MIN_PRIORITY);

		t11.start();
		t22.start();
	}
}

